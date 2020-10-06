package com.xdj.interfaces.mallinterface.service.impl;


import com.xdj.interfaces.mallinterface.mv.PageQuery;
import com.xdj.interfaces.mallinterface.mv.SeckillModel;
import com.xdj.interfaces.mallinterface.service.GoodsService;
import com.xdj.interfaces.mallinterface.service.LuceneService;
import com.xdj.interfaces.mallinterface.util.LuceneResult;
import com.xdj.interfaces.mallinterface.util.LuceneVo;
import com.xdj.www.core.tools.CommUtil;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Service("luceneService")
public class LuceneServiceImpl implements LuceneService {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private IndexWriter indexWriter;
    @Autowired
    private Analyzer analyzer;
    @Autowired
    private SearcherManager searcherManager;

    private final static Logger log = LoggerFactory.getLogger("lucene");

    private int pageSize = 20;

    @Override
    public void synProductCreatIndex() throws IOException {
        goodsService.synProductCreatIndex();
    }

    @Override
    public void createProductIndex(List<LuceneVo> productList) throws IOException {
        List<Document> docs = new ArrayList<Document>();
        for (LuceneVo  p : productList) {
            Document doc = builderDocument(p);
            docs.add(doc);
        }
        indexWriter.addDocuments(docs);
        indexWriter.commit();
    }

    private Document builderDocument(LuceneVo luceneVo) {
        Document doc = new Document();
        doc.add(new StringField("id",  String.valueOf(luceneVo.getVo_id()), Field.Store.YES));
        doc.add(new TextField("title", luceneVo.getVo_title(), Field.Store.YES));
        doc.add(new TextField("content", luceneVo.getVo_content(), Field.Store.YES));
        doc.add(new TextField("type", luceneVo.getVo_type(), Field.Store.YES));
        // 保存price,
        float price = luceneVo.getVo_store_price();
        // 建立倒排索引
        doc.add(new FloatPoint("store_price", price));
        // 正排索引用于排序、聚合
        doc.add(new StringField("add_time", CommUtil.null2String(Long.valueOf(luceneVo.getVo_add_time())),Field.Store.YES));
        // 存储到索引库
        doc.add(new StringField("goods_salenum", CommUtil.null2String(Integer.valueOf(luceneVo.getVo_goods_salenum())), Field.Store.YES));
        if(luceneVo.getPath() != null){
            doc.add(new StringField("path",luceneVo.getPath(),Field.Store.YES));
        }
        if(luceneVo.getName() != null){
            doc.add(new StringField("name",luceneVo.getName(),Field.Store.YES));
        }
        return doc;
    }

    @Override
    public List<LuceneVo> searchProduct(String keyword, int start, int size, double begin_price, double end_price, Sort sort) throws IOException, ParseException, InvalidTokenOffsetsException {
        List list = new ArrayList();
        searcherManager.maybeRefresh();
        IndexSearcher indexSearcher = searcherManager.acquire();
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        if (keyword.indexOf("title:") < 0) {
            builder.add(new QueryParser("title", analyzer).parse(keyword), BooleanClause.Occur.MUST);
        }
        if ((begin_price >= 0.0D) && (end_price > 0.0D)) {
            builder.add(new QueryParser(keyword+"  AND store_price",analyzer).parse("["+ begin_price + " TO " + end_price +"]"),BooleanClause.Occur.MUST);
        }
        TopDocs topDocs = indexSearcher.search(builder.build(), start + size, sort);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        int end = size + start < scoreDocs.length ? size + start : scoreDocs.length;
        list = getLucenes(scoreDocs,indexSearcher);
        return list;
    }

    @Override
    public void update(String id, LuceneVo vo) throws IOException {
        Document doc = builderDocument(vo);
        indexWriter.updateDocument(new Term("id",String.valueOf(id)), doc);
        indexWriter.close();
    }


    @Override
    public LuceneResult search(String params, int pageNo, double begin_price, double end_price, ScoreDoc after, Sort sort) throws IOException, ParseException {
        LuceneResult pList = new LuceneResult();
        searcherManager.maybeRefresh();
        IndexSearcher indexSearcher = searcherManager.acquire();
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        if (params.indexOf("title:") < 0) {
            builder.add(new QueryParser("title", analyzer).parse(params), BooleanClause.Occur.MUST);
            builder.add(new QueryParser("OR content",analyzer).parse(params),BooleanClause.Occur.MUST);
        }
        if ((begin_price >= 0.0D) && (end_price > 0.0D)) {
            builder.add(new QueryParser(params+"  AND store_price",analyzer).parse("["+ begin_price + " TO " + end_price +"]"),BooleanClause.Occur.MUST);
        }
        int count= 20;
        if(pageNo >1){
            count = pageNo* pageSize;
        }
        TopDocs topDocs = indexSearcher.search(builder.build(), count, sort);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        int pages =(scoreDocs.length + this.pageSize - 1) / this.pageSize;
        int intPageNo = pageNo > pages ? pages : pageNo;
        if (intPageNo < 1) {
            intPageNo = 1;
        }
        int start =(pageNo-1) * this.pageSize;
        int end = start+this.pageSize;
        List<LuceneVo> list =getLucenes(scoreDocs,indexSearcher);
        pList.setPages(pages);
        pList.setRows(scoreDocs.length);
        pList.setCurrentPage(intPageNo);
        pList.setVo_list(list);
        return pList;
    }

    public List<LuceneVo>  getLucenes( ScoreDoc[]  scoreDocs,IndexSearcher indexSearcher) throws IOException {
        List<LuceneVo> list = new ArrayList();
        if(scoreDocs != null ){
            for (int i = 0; i < scoreDocs.length; i++) {
                Document doc = indexSearcher.doc(scoreDocs[i].doc);
                LuceneVo vo = new LuceneVo();
                String content =  doc.get("content");
                String title = doc.get("title");
                vo.setVo_content(content);
                vo.setVo_id(CommUtil.null2Long(doc.get("id")));
                vo.setVo_title(title);
                vo.setVo_url(doc.get("url"));
                vo.setVo_add_time(CommUtil.null2Long(doc.get("add_time")).longValue());
                vo.setVo_store_price(CommUtil.null2Float(doc.get("store_price")));
                list.add(vo);
            }
        }
        return list ;
    }

    @Override
    public void delete_index(String id) throws IOException {
        indexWriter.deleteDocuments(new Term("id",id));
        indexWriter.commit();
    }

    @Override
    public LuceneResult search(PageQuery query, float begin_price, float end_price, Object o, Sort sort) throws IOException, ParseException {
        LuceneResult pList = new LuceneResult();
        searcherManager.maybeRefresh();
        IndexSearcher indexSearcher = searcherManager.acquire();
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        log.info("-------need_looking_string------{}",query.getGoods().getGoodsName());
        builder.add(new QueryParser("title", analyzer).parse(query.getGoods().getGoodsName()), BooleanClause.Occur.MUST);
        if ((begin_price >= 0.0D) && (end_price > 0.0D)) {
            builder.add(FloatPoint.newRangeQuery("store_price", begin_price, end_price), BooleanClause.Occur.MUST);
        }
        int count= 100;
        if(query.getPageNow() >1){
            count = (query.getPageNow()-1) * pageSize;
        }
        TopDocs topDocs = indexSearcher.search(builder.build(),count, sort);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        log.info("查询条数结果------{}",topDocs.totalHits.value);
        int pages = (scoreDocs.length+ this.pageSize - 1) / this.pageSize;
        int intPageNo = query.getPageNow() > pages ? pages : query.getPageNow();
        if (intPageNo < 1) {
            intPageNo = 1;
        }
        int start =(query.getPageNow()-1) * this.pageSize;
        int end = start+this.pageSize;
        List<LuceneVo> list =getLucenes(scoreDocs,indexSearcher);
        pList.setPages(pages);
        pList.setRows(scoreDocs.length);
        pList.setCurrentPage(intPageNo);
        pList.setVo_list(list);
        return pList;
    }


}
