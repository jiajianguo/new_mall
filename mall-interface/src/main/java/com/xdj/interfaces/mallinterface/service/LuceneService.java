package com.xdj.interfaces.mallinterface.service;




import com.xdj.interfaces.mallinterface.mv.PageQuery;
import com.xdj.interfaces.mallinterface.mv.SeckillModel;
import com.xdj.interfaces.mallinterface.util.LuceneResult;
import com.xdj.interfaces.mallinterface.util.LuceneVo;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;

import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 */
public interface LuceneService {

    public void synProductCreatIndex() throws IOException;

    /**
     * 通过商品创建Lucene索引文件
     *
     * @param productList
     * @throws IOException
     */
    public void createProductIndex(List<LuceneVo> productList) throws IOException;

    /**
     * 查询数据不分页
     *
     * @param keyword     查询条件
     * @param start       开始
     * @param size        页大小
     * @param begin_price 初始价格
     * @param end_price   最大价格
     * @param sort        封装排序信息
     * @return
     * @throws IOException
     * @throws ParseException
     * @throws InvalidTokenOffsetsException
     */
    public List<LuceneVo> searchProduct(String keyword, int start, int size, double begin_price, double end_price, Sort sort) throws IOException, ParseException, InvalidTokenOffsetsException;

    /**
     * 更新Lucene 文件中的数据
     *
     * @param id
     * @param vo
     * @throws IOException
     */
    public void update(String id, LuceneVo vo) throws IOException;

    /**
     * 分页查询
     *
     * @param params      参数（查询条件）
     * @param pageNo      当前页
     * @param begin_price 开始价格
     * @param end_price   最大价格
     * @param after
     * @param sort        排序
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public LuceneResult search(String params, int pageNo, double begin_price, double end_price, ScoreDoc after, Sort sort) throws IOException, ParseException;

    /**
     * 通过id删除Lucene中的索引
     *
     * @param id
     * @throws IOException
     */
    public void delete_index(String id) throws IOException;

    LuceneResult search(PageQuery query, float begin_price, float end_price, Object o, Sort sort) throws IOException, ParseException;
}
