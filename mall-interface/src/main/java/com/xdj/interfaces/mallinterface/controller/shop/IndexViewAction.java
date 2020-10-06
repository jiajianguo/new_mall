package com.xdj.interfaces.mallinterface.controller.shop;


import com.xdj.interfaces.mallinterface.controller.view.*;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.BCryptUtil;
import com.xdj.www.core.tools.CommUtil;
import com.xdj.www.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author Administrator
 */
@Controller
public class IndexViewAction {
	@Resource
	private ISysConfigService configService;
	@Resource
	private IUserConfigService userConfigService;
	@Resource
	private IGoodsClassService goodsClassService;
	@Resource
	private IGoodsBrandService goodsBrandService;
	@Resource
	private IPartnerService partnerService;
	@Resource
	private IUserService userService;
	@Resource
	private IArticleClassService articleClassService;
	@Resource
	private IArticleService articleService;
	@Resource
	private IMessageService messageService;
	@Resource
	private IStoreService storeService;
	@Resource
	private IGoodsService goodsService;
	@Resource
	private IGroupGoodsService groupGoodsService;
	@Resource
	private IGroupService groupService;
	@Resource
	private IGoodsFloorService goodsFloorService;
	@Resource
	private IBargainGoodsService bargainGoodsService;
	@Resource
	private IDeliveryGoodsService deliveryGoodsService;
	@Resource
	private IStoreCartService storeCartService;
	@Resource
	private IGoodsCartService goodsCartService;
	@Resource
	private NavViewTools navTools;
	@Resource
	private SendMessageService sendMessageService;
	@Resource
	private GoodsFloorTools gf_tools;
	@Resource
	private GoodsViewTools goodsViewTools;
	@Resource
	private StoreViewTools storeViewTools;
	@Resource
	private ViewTools viewTools;
	@Resource
	private ArticleViewTools articleViewTools;
	@Resource
	private AccessoryViewTools accessViewTools;
	@Resource
	private IAdvertPositionService advertPositionService;
	@Resource
	private GoodsCartTools goodsCartTools;


	public static Logger log =LoggerFactory.getLogger("indexController" );

	/**
	 * 页面最上面部分
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping( { "/top.htm" } )
	public ModelAndView top( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "top.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response );
		List<ShoppingMessage> msgs = new ArrayList();
		if( SecurityUserHolder.getCurrentUser() != null ) {
			Map params = new HashMap();
			params.put( "status", Integer.valueOf( 0 ) );
			params.put( "reply_status", Integer.valueOf( 1 ) );
			params.put( "from_user_id", SecurityUserHolder.getCurrentUser().getId());
			params.put( "to_user_id", SecurityUserHolder.getCurrentUser().getId());
			msgs = this.messageService.queryByCondition(params);
			//( "select obj from Message obj where obj.parent.id is null and (obj.status=:status and obj.toUser.id=:to_user_id) or (obj.reply_status=:reply_status and obj.fromUser.id=:from_user_id) ", params, -1, -1 );
		}
		ShoppingStore store = null;
		if(SecurityUserHolder.getCurrentUser() != null ) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("user_id",SecurityUserHolder.getCurrentUser().getId());
			store = this.storeService.queryOne(map);
		}
		mv.addObject( "store", store );
		mv.addObject( "navTools", this.navTools );
		mv.addObject( "msgs", msgs );
		List<ShoppingGoodscart> list = new ArrayList<ShoppingGoodscart>();
		List<ShoppingStorecart> cart = new ArrayList<ShoppingStorecart>();
		List<ShoppingStorecart> user_cart = new ArrayList<ShoppingStorecart>();
		List<ShoppingStorecart> cookie_cart = new ArrayList<ShoppingStorecart>();
		ShoppingUser user = null;
		if(SecurityUserHolder.getCurrentUser() != null ) {
			user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId() );
		}
		String cart_session_id = "";
		Map params = new HashMap();
		Cookie[] cookies = request.getCookies();
		if( cookies != null ) {
			for( Cookie cookie : cookies ) {
				if( cookie.getName().equals( "cart_session_id" ) ) {
					cart_session_id = CommUtil.null2String( cookie.getValue() );
				}
			}
		}
		if( user != null ) {
			if( !cart_session_id.equals( "" ) ) {
				if( user.getStore() != null ) {
					params.clear();
					params.put( "cart_session_id", cart_session_id );
					params.put( "user_id", user.getId() );
					params.put( "sc_status", Integer.valueOf( 0 ) );
					params.put( "store_id", user.getStore().getId() );
					List<ShoppingStorecart> store_cookie_cart = this.storeCartService.queryByCondition(params);
					for( ShoppingStorecart sc : store_cookie_cart ) {
						for( ShoppingGoodscart gc : sc.getGcs() ) {
							gc.getGsps().clear();
							this.goodsCartService.delete( gc.getId() );
						}
						this.storeCartService.delete(sc.getId());
					}
				}

				params.clear();
				params.put( "cart_session_id", cart_session_id );
				params.put( "sc_status", Integer.valueOf( 0 ) );
				cookie_cart = this.storeCartService.queryByCondition(params);

				params.clear();
				params.put( "user_id", user.getId() );
				params.put( "sc_status", Integer.valueOf( 0 ) );
				user_cart = this.storeCartService.queryByCondition(params);
				//query( "select obj from StoreCart obj where obj.user.id=:user_id and obj.sc_status=:sc_status", params, -1, -1 );
			}
			else {
				params.clear();
				params.put( "user_id", user.getId() );
				params.put( "sc_status", Integer.valueOf( 0 ) );
				user_cart = this.storeCartService.queryByCondition(params);
				//query( "select obj from StoreCart obj where obj.user.id=:user_id and obj.sc_status=:sc_status", params, -1, -1 );
			}

		}
		else if( !cart_session_id.equals( "" ) ) {
			params.clear();
			params.put( "cart_session_id", cart_session_id );
			params.put( "sc_status", Integer.valueOf( 0 ) );
			cookie_cart = this.storeCartService.queryByCondition(params);
					//query( "select obj from StoreCart obj where obj.cart_session_id=:cart_session_id and obj.sc_status=:sc_status", params, -1, -1 );
		}

		for( ShoppingStorecart sc : user_cart ) {
			boolean sc_add = true;
			for( ShoppingStorecart sc1 : cart ) {
				if( sc1.getStore().getId().equals( sc.getStore().getId() ) ) {
					sc_add = false;
				}
			}
			if( sc_add ) {
				cart.add(sc);
			}
		}
		boolean sc_add;
		for( ShoppingStorecart sc : cookie_cart ) {
			sc_add = true;
			for( ShoppingStorecart sc1 : cart ) {
				if( sc1.getStore().getId().equals( sc.getStore().getId() ) ) {
					sc_add = false;
					for( ShoppingGoodscart gc : sc.getGcs() ) {
						gc.setSc( sc1 );
						this.goodsCartService.update( gc );
					}
					this.storeCartService.delete( sc.getId() );
				}
			}
			if( sc_add ) {
				cart.add( sc );
			}
		}
		if( cart != null ) {
			for( ShoppingStorecart sc : cart ) {
				if( sc != null ) {
					list.addAll( sc.getGcs() );
				}
			}
		}
		float total_price = 0.0F;
		for( ShoppingGoodscart gc : list ) {
			ShoppingGoods goods = this.goodsService.getObjById( gc.getGoods().getId() );
			if( CommUtil.null2String(gc.getCartType()).equals( "combin" ) ) {
				total_price = CommUtil.null2Float(goods.getCombinPrice());
			}else {
				total_price = CommUtil.null2Float( Double.valueOf( CommUtil.mul( Integer.valueOf( gc.getCount() ), goods.getGoodsCurrentPrice() ) ) ) + total_price;
			}
		}
		mv.addObject( "total_price", Float.valueOf( total_price ) );
		mv.addObject( "cart", list );
		return (ModelAndView)mv;
	}

	/**
	 * 横着的导航栏
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping( { "/nav.htm" } )
	public ModelAndView nav( HttpServletRequest request, HttpServletResponse response ) {
		log.info("-------------执行index-------------------------");
		ModelAndView mv = new JModelAndView("nav.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
		mv.addObject( "navTools", this.navTools );
		Map<String, Object> params = new HashMap<String, Object>();
		params.put( "display", Boolean.valueOf( true ) );
		params.put("parent_id","is null");
		params.put("orderBy","sequence");
		params.put("sort","asc");
		List<ShoppingGoodsclassWithBLOBs> gcs = this.goodsClassService.queryByCondition(params);
		if(gcs != null){
			for(ShoppingGoodsclassWithBLOBs gc: gcs){
                Map<String,Object> para = new HashMap<String,Object>();
                para.put("parent_id","= ".concat(gc.getId().toString()));
                List<ShoppingGoodsclassWithBLOBs> child=goodsClassService.queryByCondition(params);
                gc.setChilds(child);
			}
		}
				//query( "select obj from GoodsClass obj where obj.parent.id is null and obj.display=:display order by obj.sequence asc", params, 0, 14 );
		//List childs = gcs.get(0).getChilds();
		mv.addObject( "gcs", gcs );
		return mv;
	}

	@RequestMapping( { "/nav1.htm" } )
	public ModelAndView nav1( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "nav1.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		Map params = new HashMap();
		params.put( "display", Boolean.valueOf( true ) );
		params.put("orderBy","sequence");
		params.put("sort","asc");
		params.put("parent_id","is null");
		params.put("start",0);
		params.put("pageSize",14);
		List<ShoppingGoodsclass> gcs = this.goodsClassService.queryByCondition(params);
				//query( "select obj from GoodsClass obj where obj.parent.id is null and obj.display=:display order by obj.sequence asc", params, 0, 14 );
		mv.addObject( "gcs", gcs );
		mv.addObject( "navTools", this.navTools );
		return mv;
	}

	@RequestMapping( { "/head.htm" } )
	public ModelAndView head( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "head.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		String type = CommUtil.null2String( request.getAttribute( "type" ) );
		mv.addObject( "type", type.equals( "" ) ? "goods" : type );
		return mv;
	}

	@RequestMapping( { "/login_head.htm" } )
	public ModelAndView login_head( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "login_head.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		return mv;
	}

	@RequestMapping( { "/floor.htm" } )
	public ModelAndView floor( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "floor.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		Map params = new HashMap();
		params.put( "gf_display", 1);
		params.put("parent_id","is null");
		params.put("orderBy","gf_sequence");
		params.put("sort","asc");
		List floors = this.goodsFloorService.queryByCondition(params);
				//query( "select obj from GoodsFloor obj where obj.gf_display=:gf_display and obj.parent.id is null order by obj.gf_sequence asc", params, -1, -1 );
		mv.addObject( "floors", floors );
		mv.addObject( "gf_tools", this.gf_tools );
		mv.addObject( "url", CommUtil.getURL( request ) );
		return mv;
	}



	@RequestMapping({"/floor_ajax.htm"})
    public void floorAjax(HttpServletRequest request, HttpServletResponse response, Long id, Integer count) {
		Map params = new HashMap();
		params.put("gf_display", Boolean.valueOf(true));
		params.put("id", id);
		params.put("parent_id","is null");
		params.put("orderBy","gf_sequence");
		params.put("sort","asc");
		List floors = this.goodsFloorService.queryByCondition(params);
		//query("select obj from GoodsFloor obj where obj.gf_display=:gf_display and obj.parent.id is null and obj.id=:id order by obj.gf_sequence asc", params, -1, -1);
		Map<String, Object> map = new HashMap<String, Object>();
		com.xdj.interfaces.mallinterface.util.CommUtil.saveWebPaths(map,this.configService.getSysConfig(),request);
		String ret = showLoadFloorAjaxHtml(floors, count, CommUtil.getURL(request), map);
		response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try {
			PrintWriter writer = response.getWriter();
			writer.print(ret);
        } catch (IOException e) {
			e.printStackTrace();
        }
    }

	@RequestMapping( { "/footer.htm" } )
	public ModelAndView footer( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "footer.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );
		if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
			mv = new JModelAndView( "wap/footer.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		}
		mv.addObject( "navTools", this.navTools );
		return mv;
	}


	@RequestMapping({"/newIndex.htm"})
	public ModelAndView newIndex (HttpServletRequest request,HttpServletResponse response,String pageNow){
		ModelAndView mv = new JModelAndView( "index_new.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		//获取所有主分类
		Map params = new HashMap();
		params.put( "display", Boolean.valueOf( true ));
		params.put("start",0);
		params.put("pageSize",15);
		params.put("orderBy","sequence");
		params.put("sort","asc");
		params.put("parent_id","is null");
		/*商品全部分类*/
		List<ShoppingGoodsclassWithBLOBs> gcs = this.goodsClassService.queryByCondition(params);
		if(gcs != null){
			for(ShoppingGoodsclassWithBLOBs gs: gcs){
				params.clear();
				params.put("parent_id","= ".concat(gs.getId().toString()));
				List<ShoppingGoodsclassWithBLOBs> child = goodsClassService.queryByCondition(params);
				if(child != null){
					gs.setChilds(child);
					for(ShoppingGoodsclassWithBLOBs gson: child ){
						params.clear();
						params.put("parent_id","= ".concat(gs.getId().toString()));
						List<ShoppingGoodsclassWithBLOBs> grandson = goodsClassService.queryByCondition(params);
						gson.setChilds(grandson);
					}
				}
			}
		}
		mv.addObject( "gcs", gcs );
		params.clear();

		// 推荐品牌
		params.put( "audit", Integer.valueOf( 1 ) );
		params.put( "recommend", Boolean.valueOf( true ) );
		params.put("start",0);
		params.put("pageSize",8);
		params.put("orderBy","sequence");
		params.put("sort","asc");
		List<ShoppingGoodsbrand> gbs = this.goodsBrandService.queryByCondition(params);
		accessViewTools.logoPhotoHandle(gbs);

		mv.addObject("brands",gbs);
		// 头部商城新闻（显示最新商城公告）
		params.clear();
		params.put( "mark", "news" );
		ShoppingArticleclass articleclass = this.articleClassService.queryByMap(params);
		List<ShoppingArticle> articles=articleViewTools.queryArticles(articleclass);
		mv.addObject( "articles", articles );
		//新品
		params.clear();
		params.put("start",0);
		params.put("pageSize",6);
		params.put("orderBy","addTime");
		params.put("sort","desc");
		List<ShoppingGoodsWithBLOBs> newGoods = goodsService.queryByCondition(params);
		accessViewTools.addMainPhotos(newGoods);
		//二级域名商品要添加store信息
		storeViewTools.addStoreGoodss(newGoods);
		mv.addObject("newGoods",newGoods);
		//推荐商品
		params.clear();
		params.put( "store_recommend", Boolean.valueOf( true ) );
		params.put( "goods_status", Integer.valueOf( 0 ) );
		params.put("orderBy","sg.store_recommend_time");
		params.put("sort","desc");
		int pageN = 1;
		if(StringUtils.isNotBlank(pageNow)){
			pageN = Integer.parseInt(pageNow);
		}
		int pageS = 18;
		params.put("start",(pageN-1)*pageS);
		params.put("pageSize",pageS);
		log.info("-----推荐----start------");
		List<ShoppingGoodsWithBLOBs> store_recommend_goods_list = this.goodsService.pageList(params);
		viewTools.mainPhotoHandle(store_recommend_goods_list);
		storeViewTools.addStoreGoodss(store_recommend_goods_list);
		mv.addObject("recommendGoods",store_recommend_goods_list);
		log.info("-----推荐---end----");
		//团购商品
		params.clear();
		params.put("beginTime", new Date());
		params.put("endTime", new Date());
		List<ShoppingGroup> groups = this.groupService.queryByCondition(params);
		if(groups != null){
			params.put("start",0);
			params.put("pageSize",5);
			List<ShoppingGroupGoods> groupGoods =groupGoodsService.queryByCondition(params);
			if(groupGoods !=null){
				goodsViewTools.addggGoods(groupGoods);
			}
			mv.addObject("groupGoods",groupGoods);
		}
		// 3、天天特价
		params.clear();
		params.put( "bg_time", CommUtil.formatDate( CommUtil.formatShortDate( new Date() ) ) );
		params.put( "bg_status", Integer.valueOf( 1 ) );
		params.put("start",0);
		params.put("pageSize",5);
		List<ShoppingBargainGoods> bgs = this.bargainGoodsService.queryByCondition(params);
		mv.addObject( "bgs", bgs );
		// 4、热销商品倒序-疯狂抢购
		params.clear();
		params.put("goods_status", Integer.valueOf(0));
		params.put("orderBy","goods_salenum");
		params.put("sort","desc");
		params.put("start",0);
		params.put("pageSize",5);
		List<ShoppingGoodsWithBLOBs> list = this.goodsService.queryByCondition(params);
		viewTools.mainPhotoHandle(list);
		storeViewTools.addStoreGoodss(list);
		mv.addObject( "fengKuangs", list );
		//轮播图
		log.info("------品牌开始------");
		ShoppingAdvPosExample ex= new ShoppingAdvPosExample();
		ex.createCriteria().andApStatusEqualTo(1);
		log.info("------banner--start----");
		List<ShoppingAdvPosWithBLOBs> advs = advertPositionService.selectExample(ex);
		if(advs != null){
			//获取随机数
			int i= com.xdj.interfaces.mallinterface.util.CommUtil.getRandomInt(advs.size());
			log.info("-----随机轮播图=====");
			viewTools.advertInvoke(mv,advs.get(i).getId().toString(),"advert_invoke");
		}
		log.info("------banner-end------");
		log.info("------品牌结束------");
		params.clear();
		params.put( "goods_status", Integer.valueOf( 0 ) );
		params.put("orderBy","goods_click");
		params.put("sort","desc");
		params.put("start",0);
		params.put("pageSize",5);
		List<ShoppingGoodsWithBLOBs> hot_goods_list = this.goodsService.queryByCondition(params);
		viewTools.mainPhotoHandle(hot_goods_list);
		viewTools.navHandle(mv);
		storeViewTools.addStoreGoodss(hot_goods_list);
		mv.addObject( "hots", hot_goods_list );
		params.clear();
		params.put( "mark", "news" );
		params.put("orderBy","sequence");
		params.put("sort","asc");
		params.put("start",0);
		params.put("pageSize",9);
		params.put("parent_id","is null");
		List<ShoppingArticleclass> acs = this.articleClassService.queryByCondition(params);
		//query( "select obj from ArticleClass obj where obj.parent.id is null and obj.mark!=:mark order by obj.sequence asc", params, 0, 9 );
		mv.addObject( "acs", acs );
		//友情链接
		params.clear();
		params.put("image_id ", "is null");
		params.put("orderBy","sequence");
		params.put("sort","asc");
		List<ShoppingPartner> img_partners = this.partnerService.queryByCondition(params);
		//( "select obj from Partner obj where obj.image.id is not null order by obj.sequence asc", params, -1, -1 );
		mv.addObject( "img_partners", img_partners );
		return mv;
	}


	@RequestMapping( { "/index.htm" } )
	public ModelAndView index( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "index.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		Map params = new HashMap();
		params.put( "display", Boolean.valueOf( true ));
		params.put("start",0);
		params.put("pageSize",15);
		params.put("orderBy","sequence");
		params.put("sort","asc");
		params.put("parent_id","is null");
		/*商品全部分类*/
		List<ShoppingGoodsclassWithBLOBs> gcs = this.goodsClassService.queryByCondition(params);
		if(gcs != null){
			for(ShoppingGoodsclassWithBLOBs gs: gcs){
				params.clear();
				params.put("parent_id","= ".concat(gs.getId().toString()));
				List<ShoppingGoodsclassWithBLOBs> child = goodsClassService.queryByCondition(params);
				if(child != null){
					gs.setChilds(child);
					for(ShoppingGoodsclassWithBLOBs gson: child ){
						params.clear();
						params.put("parent_id","= ".concat(gs.getId().toString()));
						List<ShoppingGoodsclassWithBLOBs> grandson = goodsClassService.queryByCondition(params);
						gson.setChilds(grandson);
					}
				}
			}
		}
		mv.addObject( "gcs", gcs );
		params.clear();
		// 推荐品牌
		params.put( "audit", Integer.valueOf( 1 ) );
		params.put( "recommend", Boolean.valueOf( true ) );
		params.put("start",0);
		params.put("pageSize",4);
		params.put("orderBy","sequence");
		params.put("sort","asc");
		List<ShoppingGoodsbrand> gbs = this.goodsBrandService.queryByCondition(params);
		System.out.println("------gbs--end----------" );
		accessViewTools.logoPhotoHandle(gbs);
			//	( "select obj from GoodsBrand obj where obj.audit=:audit and obj.recommend=:recommend order by obj.sequence", params, 0, 4 );
		mv.addObject( "gbs", gbs );
		// 底部显示的合作伙伴
		params.clear();
		params.put("image_id ", "is null");
		params.put("orderBy","sequence");
		params.put("sort","asc");
		/*合作伙伴*/
		List<ShoppingPartner> img_partners = this.partnerService.queryByCondition(params);
				//( "select obj from Partner obj where obj.image.id is not null order by obj.sequence asc", params, -1, -1 );
		mv.addObject( "img_partners", img_partners );
		List<ShoppingPartner> text_partners = this.partnerService.queryByCondition(params);
				//query( "select obj from Partner obj where obj.image.id is null order by obj.sequence asc", params, -1, -1 );
		mv.addObject( "text_partners", text_partners );
		// 底部新闻分类显示
		params.clear();
		params.put( "mark", "news" );
		params.put("orderBy","sequence");
		params.put("sort","asc");
		params.put("start",0);
		params.put("pageSize",9);
		params.put("parent_id","is null");
		List<ShoppingArticleclass> acs = this.articleClassService.queryByCondition(params);
				//query( "select obj from ArticleClass obj where obj.parent.id is null and obj.mark!=:mark order by obj.sequence asc", params, 0, 9 );
		mv.addObject( "acs", acs );

		// 商城新闻
		params.clear();
		params.put( "mark", "news" );
		ShoppingArticleclass articleclass = this.articleClassService.queryByMap(params);
		List<ShoppingArticle> articles=articleViewTools.queryArticles(articleclass);
		mv.addObject( "articles", articles );

		// 查询推荐店铺商品(推荐)
		params.clear();
		params.put( "store_recommend", Boolean.valueOf( true ) );
		params.put( "goods_status", Integer.valueOf( 0 ) );
		params.put("orderBy","store_recommend_time");
		params.put("sort","desc");
		List<ShoppingGoodsWithBLOBs> store_reommend_goods_list = this.goodsService.queryByCondition(params);
		viewTools.mainPhotoHandle(store_reommend_goods_list);
		storeViewTools.addStoreGoodss(store_reommend_goods_list);
		//( "select obj from Goods obj where obj.store_recommend=:store_recommend and obj.goods_status=:goods_status order by obj.store_recommend_time desc", params, -1, -1 );
		List store_reommend_goods = new ArrayList();
		int max = store_reommend_goods_list.size() >= 5 ? 4 : store_reommend_goods_list.size() - 1;
		for( int i = 0; i <= max; i++ ) {
			store_reommend_goods.add( store_reommend_goods_list.get( i ) );
		}
		// 1、推荐商品可在后台编辑
		mv.addObject( "store_reommend_goods", store_reommend_goods );
		mv.addObject( "store_reommend_goods_count", Double.valueOf( Math.ceil( CommUtil.div( Integer.valueOf( store_reommend_goods_list.size() ), Integer.valueOf( 5 ) ) ) ) );
		if(SecurityUserHolder.getCurrentUser() != null ) {
			mv.addObject( "user", SecurityUserHolder.getCurrentUser() );
		}
		// 团购查询
		params.clear();
		params.put( "beginTime", new Date() );
		params.put( "endTime", new Date() );
		List<ShoppingGroup> groups = this.groupService.queryByCondition(params);
				//( "select obj from Group obj where obj.beginTime<=:beginTime and obj.endTime>=:endTime", params, -1, -1 );
		if( groups != null) {
			// 2、团购商品
			params.clear();
			params.put( "gg_status", Integer.valueOf(1));
			params.put( "gg_recommend", Integer.valueOf(1));
			params.put( "group_id", groups.get(0).getId());
			params.put("orderBy","gg_recommend_time");
			params.put("sort","desc");
			params.put("start",0);
			params.put("pageSize",5);
			List<ShoppingGroupGoods> ggs = this.groupGoodsService.queryByCondition(params);
			goodsViewTools.addggGoods(ggs);

					//( "select obj from GroupGoods obj where obj.gg_status=:gg_status and obj.gg_recommend=:gg_recommend and obj.group.id=:group_id order by obj.gg_recommend_time desc", params, 0, 5 );
			if( ggs.size() > 0 ) {
				mv.addObject("ggs", ggs);
			}
		}
		// 3、天天特价
		params.clear();
		params.put( "bg_time", CommUtil.formatDate( CommUtil.formatShortDate( new Date() ) ) );
		params.put( "bg_status", Integer.valueOf( 1 ) );
		params.put("start",0);
		params.put("pageSize",5);
		List<ShoppingBargainGoods> bgs = this.bargainGoodsService.queryByCondition(params);
		//query( "select obj from BargainGoods obj where obj.bg_time=:bg_time and obj.bg_status=:bg_status", params, 0, 5 );
		mv.addObject( "bgs", bgs );
		// 4、热销商品倒序-疯狂抢购
		params.clear();
		params.put("goods_status", Integer.valueOf(0));
		params.put("orderBy","goods_salenum");
		params.put("sort","desc");
		params.put("start",0);
		params.put("pageSize",5);
		List<ShoppingGoodsWithBLOBs> list = this.goodsService.queryByCondition(params);
		viewTools.mainPhotoHandle(list);
		storeViewTools.addStoreGoodss(list);
		mv.addObject( "fengKuangs", list );
		// 5、随机生成推荐商品 猜您喜欢
		List store_guess_goods = new ArrayList();
		Random rand = new Random();
		int recommend_goods_random = rand.nextInt(5);
		int begin = recommend_goods_random * 5;
		if( begin > store_reommend_goods_list.size() - 1 ) {
			begin = 0;
		}
		int maxsize = begin + 5;
		if( maxsize > store_reommend_goods_list.size() ) {
			begin -= maxsize - store_reommend_goods_list.size();
			maxsize--;
		}
		for( int i = 0; i < store_reommend_goods_list.size(); i++ ) {
			if( (i >= begin) && (i < maxsize) ) {
				store_guess_goods.add(store_reommend_goods_list.get( i ) );
			}
		}
		mv.addObject( "cais", store_guess_goods );
		// 6、满送商品
		params.clear();
		params.put( "d_status", Integer.valueOf( 1 ) );
		params.put( "d_begin_time", new Date() );
		params.put( "d_end_time", new Date() );
		params.put("orderBy","d_audit_time");
		params.put("sort","desc");
		params.put("start",0);
		params.put("pageSize",5);
		List<ShoppingDeliveryGoods> dgs = this.deliveryGoodsService.queryByCondition(params);
		viewTools.addDeliveryGoods(dgs);
		//( "select obj from DeliveryGoods obj where obj.d_status=:d_status and obj.d_begin_time<=:d_begin_time and obj.d_end_time>=:d_end_time order by obj.d_audit_time desc", params, 0, 5 );
		mv.addObject( "dgs", dgs );
		// 7、新品上架
		params.clear();
		params.put( "goods_status", Integer.valueOf( 0 ) );
		params.put("orderBy","addTime");
		params.put("sort","desc");
		params.put("start",0);
		params.put("pageSize",5);
		List<ShoppingGoodsWithBLOBs> new_goods_list = this.goodsService.queryByCondition(params);
		viewTools.mainPhotoHandle(new_goods_list);
		storeViewTools.addStoreGoodss(new_goods_list);
		mv.addObject( "xinShangs", new_goods_list );
		// 8、点击数最多:人气商品
		params.clear();
		params.put( "goods_status", Integer.valueOf( 0 ) );
		params.put("orderBy","goods_click");
		params.put("sort","desc");
		params.put("start",0);
		params.put("pageSize",5);
		List<ShoppingGoodsWithBLOBs> hot_goods_list = this.goodsService.queryByCondition(params);
		viewTools.mainPhotoHandle(hot_goods_list);
		storeViewTools.addStoreGoodss(hot_goods_list);
		mv.addObject( "hots", hot_goods_list );
		viewTools.topHandle(mv,request);
		viewTools.advertInvoke(mv,"262150","advert_invoke");
		viewTools.advertInvoke(mv,"1","slideshow");
		viewTools.navHandle(mv);
		viewTools.handleFoor(mv ,request);
		viewTools.footerHandle(mv);
		return mv;
	}

	@RequestMapping( { "/close.htm" } )
	public ModelAndView wapclose( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "close.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );
		if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
			mv = new JModelAndView( "wap/close.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		}
		return mv;
	}

	@RequestMapping( { "/404.htm" } )
	public ModelAndView error404( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "404.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );
		if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
			//String store_id = CommUtil.null2String( request.getSession( false ).getAttribute( "store_id" ) );
			mv = new JModelAndView( "wap/404.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
			mv.addObject( "url", CommUtil.getURL( request ) + "/wap/index.htm");
		}
		return mv;
	}

	@RequestMapping( { "/500.htm" } )
	public ModelAndView error500( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "500.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		String shopping_view_type = CommUtil.null2String( request.getSession( false ).getAttribute( "shopping_view_type" ) );
		if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
			String store_id = CommUtil.null2String( request.getSession( false ).getAttribute( "store_id" ) );
			mv = new JModelAndView( "wap/500.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
			mv.addObject( "url", CommUtil.getURL( request ) + "/wap/index.htm?store_id=" + store_id );
		}

		return mv;
	}

	@RequestMapping( { "/goods_class.htm" } )
	public ModelAndView goods_class( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "goods_class.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		String shopping_view_type = CommUtil.null2String( request.getSession( false ).getAttribute( "shopping_view_type" ) );
		if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
			mv = new JModelAndView( "wap/goods_class.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		}
		Map params = new HashMap();
		params.put( "display", Boolean.valueOf( true ) );
		params.put("orderBy","sequence");
		params.put("sort","asc");
		List gcs = this.goodsClassService.queryByCondition(params);
				//query( "select obj from GoodsClass obj where obj.parent.id is null and obj.display=:display order by obj.sequence asc", params, -1, -1 );
		mv.addObject( "gcs", gcs );
		return mv;
	}

	@RequestMapping( { "/goodsclass.htm" } )
	public ModelAndView goodsclass( HttpServletRequest request, HttpServletResponse response ) {

		ModelAndView mv = new JModelAndView( "goodsclass.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		String shopping_view_type = CommUtil.null2String( request.getSession( false ).getAttribute( "shopping_view_type" ) );
		if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
			mv = new JModelAndView( "wap/goodsclass.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		}
		Map params = new HashMap();
		params.put("orderBy","sequence");
		params.put("sort","asc");
		params.put("parent_id","is null");
		List gcs = this.goodsClassService.queryByCondition(params);
				//query( "select obj from GoodsClass obj where obj.parent.id is null  order by obj.sequence asc", params,-1, -1 );
		mv.addObject( "gcs", gcs );

		return mv;
	}

	@RequestMapping( { "/forget.htm" } )
	public ModelAndView forget( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "forget.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		ShoppingSysconfig config = this.configService.getSysConfig();
		if( !config.getEmailenable() ) {
			mv = new JModelAndView( "error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
			mv.addObject( "op_title", "系统关闭邮件功能，不能找回密码" );
			mv.addObject( "url", CommUtil.getURL( request ) + "/index.htm" );
		}
		return mv;
	}

	@RequestMapping( { "/find_pws.htm" } )
	public ModelAndView find_pws( HttpServletRequest request, HttpServletResponse response, String userName, String email, String code ) {
		ModelAndView mv = new JModelAndView( "success.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		HttpSession session = request.getSession( false );
		String verify_code = (String)session.getAttribute( "verify_code" );
		if( code.toUpperCase().equals( verify_code ) ) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userName",userName);
			ShoppingUser user = this.userService.getOne(map);
			if( user.getEmail().equals( email.trim() ) ) {
				String pws = CommUtil.randomString( 6 ).toLowerCase();
				String subject = this.configService.getSysConfig().getTitle() + "密码找回邮件";
				String content = user.getUsername() + ",您好！您通过密码找回功能重置密码，新密码为：" + pws;
				boolean ret = this.sendMessageService.sendEmail( email, subject, content );
				if( ret ) {
					user.setPassword(BCryptUtil.encode(pws));
					this.userService.update( user );
					mv.addObject( "op_title", "新密码已经发送到邮箱:<font color=red>" + email + "</font>，请查收后重新登录" );
					mv.addObject( "url", CommUtil.getURL( request ) + "/user/login.htm" );
				}
				else {
					mv = new JModelAndView( "error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
					mv.addObject( "op_title", "邮件发送失败，密码暂未执行重置" );
					mv.addObject( "url", CommUtil.getURL( request ) + "/forget.htm" );
				}
			}
			else {
				mv = new JModelAndView( "error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
				mv.addObject( "op_title", "用户名、邮箱不匹配" );
				mv.addObject( "url", CommUtil.getURL( request ) + "/forget.htm" );
			}
		}
		else {
			mv = new JModelAndView( "error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
			mv.addObject( "op_title", "验证码不正确" );
			mv.addObject( "url", CommUtil.getURL( request ) + "/forget.htm" );
		}
		return mv;
	}

	@RequestMapping( { "/switch_recommend_goods.htm" } )
	public ModelAndView switch_recommend_goods( HttpServletRequest request, HttpServletResponse response, int recommend_goods_random ) {
		ModelAndView mv = new JModelAndView( "switch_recommend_goods.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		Map params = new HashMap();
		params.put( "store_recommend", Boolean.valueOf( true ) );
		params.put( "goods_status", Integer.valueOf( 0 ) );
		params.put("orderBy","store_recommend_time");
		params.put("sort","desc");

		List<ShoppingGoodsWithBLOBs> store_reommend_goods_list = this.goodsService.queryByCondition(params);
				//query( "select obj from Goods obj where obj.store_recommend=:store_recommend and obj.goods_status=:goods_status order by obj.store_recommend_time desc", params, -1, -1 );
		List store_reommend_goods = new ArrayList();
		int begin = recommend_goods_random * 5;
		if( begin > store_reommend_goods_list.size() - 1 ) {
			begin = 0;
		}
		int max = begin + 5;
		if( max > store_reommend_goods_list.size() ) {
			begin -= max - store_reommend_goods_list.size();
			max--;
		}
		for( int i = 0; i < store_reommend_goods_list.size(); i++ ) {
			if( (i >= begin) && (i < max) ) {
				store_reommend_goods.add( store_reommend_goods_list.get( i ) );
			}
		}
		mv.addObject( "store_reommend_goods", store_reommend_goods );
		return mv;
	}

	@RequestMapping( { "/outline.htm" } )
	public ModelAndView outline( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		mv.addObject( "op_title", "该用户在其他地点登录，您被迫下线！" );
		mv.addObject( "url", CommUtil.getURL( request ) + "/index.htm" );
		String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );
		if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
			mv = new JModelAndView( "wap/error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
			mv.addObject( "url", CommUtil.getURL( request ) + "/wap/index.htm" );
		}
		return mv;
	}



	/** wap首页业务逻辑begin */

	/**
	 * wap首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping( { "/wap/index.htm" } )
	public ModelAndView wapindex( HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView mv = new JModelAndView( "wap/index.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response );
		//设置为wap访问
		request.getSession().setAttribute("shopping_view_type", "wap");
		Map params = new HashMap();
		params.put( "display", Boolean.valueOf( true ) );
		params.put("orderBy","sequence");
		params.put("sort","asc");
		params.put("start",0);
		params.put("pageSize",15);
		List<ShoppingGoodsclass> gcs = this.goodsClassService.queryByCondition(params);
				//query( "select obj from GoodsClass obj where obj.parent.id is null and obj.display=:display order by obj.sequence asc", params, 0, 15 );
		mv.addObject( "gcs", gcs );
		params.clear();
		params.put( "audit", Integer.valueOf( 1 ) );
		params.put( "recommend", Boolean.valueOf( true ) );
		params.put("orderBy","sequence");
		params.put("sort","asc");
		params.put("start",0);
		params.put("pageSize",4);
		List<ShoppingGoodsbrand> gbs = this.goodsBrandService.queryByCondition(params);
		accessViewTools.logoPhotoHandle(gbs);
				//.query( "select obj from GoodsBrand obj where obj.audit=:audit and obj.recommend=:recommend order by obj.sequence", params, -1, -1 );

		mv.addObject( "gbs", gbs );
		params.clear();
		params.put("orderBy","sequence");
		params.put("sequence","asc");
		params.put("image_id","is null");
		List<ShoppingPartner> img_partners = this.partnerService.queryByCondition(params);
		mv.addObject( "img_partners", img_partners );
		params.put("orderBy","sequence");
		params.put("sequence","asc");
		params.put("image_id","is null");
		List<ShoppingPartner> text_partners = this.partnerService.queryByCondition(params);
		mv.addObject( "text_partners", text_partners );
		params.clear();
		params.put( "mark", "news" );
		params.put("sequence","asc");
		params.put("parent_id","is null");
		List acs = this.articleClassService.queryByCondition(params);
		//query( "select obj from ArticleClass obj where obj.parent.id is null and obj.mark!=:mark order by obj.sequence asc", params, 0, 9 );
		mv.addObject( "acs", acs );
		params.clear();
		params.put( "store_recommend", Boolean.valueOf( true ) );
		params.put( "goods_status", Integer.valueOf( 0 ) );
		params.put("orderBy","store_recommend_time");
		params.put("sort","desc");
		params.put("start",0);
		params.put("pageSize",6);
		List<ShoppingGoodsWithBLOBs> store_reommend_goods_list = this.goodsService.queryByCondition(params);
				//query( "select obj from Goods obj where obj.store_recommend=:store_recommend and obj.goods_status=:goods_status order by obj.store_recommend_time desc", params, 0, 6 );
		accessViewTools.addMainPhotos(store_reommend_goods_list);
		mv.addObject( "store_reommend_goods", store_reommend_goods_list );
		mv.addObject( "store_reommend_goods_count", Double.valueOf( Math.ceil( CommUtil.div( Integer.valueOf( store_reommend_goods_list.size() ), Integer.valueOf( 5 ) ) ) ) );
		mv.addObject( "goodsViewTools", this.goodsViewTools );
		mv.addObject( "storeViewTools", this.storeViewTools );
		if( SecurityUserHolder.getCurrentUser() != null ) {
			mv.addObject( "user", SecurityUserHolder.getCurrentUser() );
		}
		params.clear();
		params.put( "beginTime", new Date() );
		params.put( "endTime", new Date() );
		List<ShoppingGroup> groups = this.groupService.queryByCondition(params);
				//query( "select obj from Group obj where obj.beginTime<=:beginTime and obj.endTime>=:endTime", params, -1, -1 );
		if( groups.size() > 0 ) {
			params.clear();
			params.put( "gg_status", Integer.valueOf( 1 ) );
			params.put( "gg_recommend", Integer.valueOf( 1 ) );
			params.put( "group_id", groups.get( 0 ).getId());
			params.put("orderBy","gg_recommend_time");
			params.put("sort","desc");
			params.put("start",0);
			params.put("pageSize",1);
			List<ShoppingGroupGoods> ggs = this.groupGoodsService.queryByCondition(params);
					//query( "select obj from GroupGoods obj where obj.gg_status=:gg_status and obj.gg_recommend=:gg_recommend and obj.group.id=:group_id order by obj.gg_recommend_time desc", params, 0, 1 );
			if( ggs.size() > 0 ) {
				mv.addObject("group", ggs.get(0));
			}
		}
		params.clear();
		params.put( "bg_time", CommUtil.formatDate( CommUtil.formatShortDate( new Date() ) ) );
		params.put( "bg_status", Integer.valueOf( 1 ) );
		List bgs = this.bargainGoodsService.queryByCondition(params);
				//query( "select obj from BargainGoods obj where obj.bg_time=:bg_time and obj.bg_status=:bg_status", params, 0, 5 );
		mv.addObject( "bgs", bgs );
		params.clear();
		params.put( "d_status", Integer.valueOf( 1 ) );
		params.put( "d_begin_time", new Date() );
		params.put( "d_end_time", new Date() );
		params.put("start",0);
		params.put("pageSize",3);
		params.put("orderBy","d_audit_time");
		params.put("sort","desc");
		List<ShoppingDeliveryGoods> dgs = this.deliveryGoodsService.queryByCondition(params);
		viewTools.addDeliveryGoods(dgs);
		mv.addObject( "dgs", dgs );

		List msgs = new ArrayList();
		if( SecurityUserHolder.getCurrentUser() != null ) {
			params.clear();
			params.put( "status", Integer.valueOf( 0 ) );
			params.put( "reply_status", Integer.valueOf( 1 ) );
			params.put( "from_user_id", SecurityUserHolder.getCurrentUser().getId() );
			params.put( "to_user_id", SecurityUserHolder.getCurrentUser().getId() );
			msgs = this.messageService.queryByCondition(params);
					//query( "select obj from Message obj where obj.parent.id is null and (obj.status=:status and obj.toUser.id=:to_user_id) or (obj.reply_status=:reply_status and obj.fromUser.id=:from_user_id) ", params, -1, -1 );
		}
		ShoppingStore store = null;
		if(SecurityUserHolder.getCurrentUser() != null ) {
			params.clear();
			params.put("user_id",SecurityUserHolder.getCurrentUser().getId());
			store = this.storeService.getOne(params);
		}
		mv.addObject( "store", store );
		mv.addObject( "navTools", this.navTools );
		mv.addObject( "msgs", msgs );
		List<ShoppingGoodscart> list = new ArrayList<ShoppingGoodscart>();
		List<ShoppingStorecart> cart = new ArrayList<ShoppingStorecart>();
		List<ShoppingStorecart> user_cart = new ArrayList<ShoppingStorecart>();
		List<ShoppingStorecart> cookie_cart = new ArrayList<ShoppingStorecart>();
		ShoppingUser user = null;
		if( SecurityUserHolder.getCurrentUser() != null ) {
			user = SecurityUserHolder.getCurrentUser();
		}
		String cart_session_id = "";
		params.clear();
		Cookie[] cookies = request.getCookies();
		if( cookies != null ) {
			for( Cookie cookie : cookies ) {
				if( cookie.getName().equals( "cart_session_id" ) ) {
					cart_session_id = CommUtil.null2String( cookie.getValue() );
				}
			}
		}
		if( user != null ) {
			if( !cart_session_id.equals( "" ) ) {
				if( user.getStore() != null ) {
					params.clear();
					params.put( "cart_session_id", cart_session_id );
					params.put( "user_id", user.getId() );
					params.put( "sc_status", Integer.valueOf( 0 ) );
					params.put( "store_id", user.getStore().getId() );
					List<ShoppingStorecart> store_cookie_cart = this.storeCartService.queryByCondition(params);
					// "select obj from StoreCart obj where (obj.cart_session_id=:cart_session_id or obj.user.id=:user_id) and obj.sc_status=:sc_status and obj.store.id=:store_id",
					  //  params, -1, -1 );
					for( ShoppingStorecart sc : store_cookie_cart ) {
						for( ShoppingGoodscart gc : sc.getGcs() ) {
							gc.getGsps().clear();
							this.goodsCartService.delete( gc.getId() );
						}
						this.storeCartService.delete(sc.getId() );
					}
				}

				params.clear();
				params.put( "cart_session_id", cart_session_id );
				params.put( "sc_status", Integer.valueOf( 0 ) );
				cookie_cart = this.storeCartService.queryByCondition(params);
						//query( "select obj from StoreCart obj where obj.cart_session_id=:cart_session_id and obj.sc_status=:sc_status", params, -1, -1 );

				params.clear();
				params.put( "user_id", user.getId() );
				params.put( "sc_status", Integer.valueOf( 0 ) );
				user_cart = this.storeCartService.queryByCondition(params);
						//query( "select obj from StoreCart obj where obj.user.id=:user_id and obj.sc_status=:sc_status", params, -1, -1 );
			}
			else {
				params.clear();
				params.put( "user_id", user.getId() );
				params.put( "sc_status", Integer.valueOf( 0 ) );
				user_cart = this.storeCartService.queryByCondition(params);
						//query( "select obj from StoreCart obj where obj.user.id=:user_id and obj.sc_status=:sc_status", params, -1, -1 );
			}

		}
		else if( !cart_session_id.equals( "" ) ) {
			params.clear();
			params.put( "cart_session_id", cart_session_id );
			params.put( "sc_status", Integer.valueOf( 0 ) );
			cookie_cart = this.storeCartService.queryByCondition(params);
					//query( "select obj from StoreCart obj where obj.cart_session_id=:cart_session_id and obj.sc_status=:sc_status", params, -1, -1 );
		}
		for( ShoppingStorecart sc : user_cart ) {
			boolean sc_add = true;
			for( ShoppingStorecart sc1 : cart ) {
				if( sc1.getStore().getId().equals( sc.getStore().getId() ) ) {
					sc_add = false;
				}
			}
			if( sc_add ) {
				cart.add(sc);
			}
		}

		boolean sc_add;
		for( ShoppingStorecart sc : cookie_cart ) {
			sc_add = true;
			for( ShoppingStorecart sc1 : cart ) {
				if( sc1.getStoreId().equals(sc.getStoreId()) ) {
					sc_add = false;
					goodsCartTools.addGcs(sc);
//					for( ShoppingGoodscart gc : sc.getGcs() ) {
//						gc.setSc( sc1 );
//						this.goodsCartService.update( gc );
//					}
//					this.storeCartService.delete( sc.getId() );
				}
			}
			if( sc_add ) {
				cart.add( sc );
			}
		}
		if( cart != null ) {
			for( ShoppingStorecart sc : cart ) {
				goodsCartTools.addGcs(sc);
				if( sc != null ) {
					list.addAll( sc.getGcs() );
				}
			}
		}
		float total_price = 0.0F;
		for( ShoppingGoodscart gc : list ) {
			ShoppingGoods goods = this.goodsService.getObjById( gc.getGoodsId() );
			if( CommUtil.null2String( gc.getCartType() ).equals( "combin" ) ) {
				total_price = CommUtil.null2Float(goods.getCombinPrice());
			}else {
				total_price = CommUtil.null2Float( Double.valueOf( CommUtil.mul( Integer.valueOf( gc.getCount() ), goods.getGoodsCurrentPrice() ) ) ) + total_price;
			}
		}
		mv.addObject( "total_price", Float.valueOf( total_price ) );
		mv.addObject( "cart", list );

		return mv;
	}


	 public String showLoadFloorAjaxHtml(List<ShoppingGoodsFloorWithBLOBs> lists, int i, String url, Map<String, Object> map) {
		   String img = null;
		   String loadimg = map.get("imageWebServer")+ "/static/style/common/images/loader.gif";
		   String errorimg = map.get("webPath")+"/"+map.get("goodsImagePath")+"/"+map.get("goodsImageName");
		   String goods_url = null;
		   String goods_class_url = null;
		   String child_goods_class_url = null;
		   ShoppingGoodsFloorWithBLOBs floor = lists.get(0);
		   img = null;
		   StringBuffer sb = new StringBuffer(1000);
		   sb.append("<div class='floor "+floor.getGfCss()+"'>").append("<div class='floor_box' id='floor_"+i+"'>");
		   sb.append("<div class='floor_menu'>").append("<div class='title'>").append("<div class='txt-type'>").append("<span>").append(i).append("</span>");
		   sb.append("<h2 title='").append(floor.getGfName()).append("'>").append(floor.getGfName()).append("</h2></div></div><div class='flr_m_details'><ul class='flr_m_du'>");
		   List<ShoppingGoodsclassWithBLOBs> gcs = this.gf_tools.generic_gf_gc(floor.getGfGcList());
		   for(ShoppingGoodsclassWithBLOBs gc : gcs){
			   goods_class_url = map.get("webPath")+"/store_goods_list_"+gc.getId()+".htm";
			   sb.append("<li><h4><a href='").append(goods_class_url).append("'>").append(gc.getClassname()).append("</a></h4><p>");
			   for(ShoppingGoodsclassWithBLOBs c_gc : gc.getChilds()){
				   child_goods_class_url = map.get("webPath")+"/store_goods_list_"+c_gc.getId()+".htm";
				   sb.append("<span><a href='").append(child_goods_class_url).append("' target='_blank'>").append(c_gc.getClassname()).append("</a></span>");
			   }
			   sb.append("</p></li>");
		   }
		   sb.append("</ul><div class='flr_advertisment'>");
		   //拼接左侧广告
		   sb.append(gf_tools.generic_adv(url,floor.getGfLeftAdv()));
		   sb.append("</div></div></div><div class='floorclass'><ul class='floorul'>");
		   int num = 0;
		   for(ShoppingGoodsFloorWithBLOBs info : floor.getChilds()){
			   num++;
			   sb.append("<li ");
			   if(num==1){
				   sb.append("class='this'");
			   }
			   sb.append("style='cursor:pointer;' id='").append(info.getId()).append("' store_gc='").append(floor.getId()).append("' >");
			   sb.append(info.getGfName()).append("<s></s></li>");
		   }
		   sb.append("</ul>");
		   int count = 0;
		   for(ShoppingGoodsFloorWithBLOBs info : floor.getChilds()){
			   count++;
			   sb.append("<div id='").append(info.getId()).append("' store_gc='").append(floor.getId()).append("' class='ftab'");
			   if(count>1){
				   sb.append("style='display:none;'");
			   }
			   sb.append("><div class='ftabone'><div class='classpro'>");
			   for(ShoppingGoodsWithBLOBs goods : this.gf_tools.generic_goods(info.getGfGcList())){
				   if(goods!=null){
					   if(goods.getGoods_main_photo() !=null ) {
						   img = map.get("imageWebServer") + "/" + goods.getGoods_main_photo().getPath() + "/" + goods.getGoods_main_photo().getName() + "_small." + goods.getGoods_main_photo().getExt();
					   }else {
						   img = map.get("imageWebServer") + "/" + map.get("goodsImagePath") + "/" + map.get("goodsImageName");
						   goods_url = map.get("webPath") + "/goods_" + goods.getId() + ".htm";
					   }
				       if((Boolean)map.get("IsSecondDomainOpen")) {
				    	   goods_url="http://"+goods.getGoods_store().getStoreSecondDomain()+"."+map.get("domainPath")+"/goods_"+goods.getId()+".htm";
				       }
				       sb.append("<div class='productone'><ul class='this'><li><span class='center_span'>");
				       //sb.append("<p><a href='").append(goods_url).append("' target='_blank' ><img src='").append(loadimg).append("' original='");
				       //sb.append(img).append("' onerror=\"this.src=").append(errorimg).append(";\" width='28' height='28'/></a></p></span></li>");
				       sb.append("<p><a href='").append(goods_url).append("' target='_blank' ><img src='").append(img).append("' original='");
				       sb.append(img).append("' onerror=\"this.src=").append(errorimg).append(";\" /></a></p></span></li>");
				       sb.append("<li class='pronames'><a href='").append(goods_url).append("' target='_blank'>").append(goods.getGoodsName()).append("</a></li>");
				       sb.append("<li><span class=\"hui2\">市场价：</span><span class=\"through hui\">¥").append(goods.getGoodsPrice());
				       sb.append("</span></li><li><span class=\"hui2\">商城价：</span><strong class=\"red\">¥").append(goods.getGoodsCurrentPrice());
				       sb.append("</strong></li></ul></div>");
				   }
			   }
			   sb.append("</div></div></div>");
		   }
		   sb.append("</div><div class='ranking'>");
		   Map<String, Object> mmap = gf_tools.generic_goods_list(floor.getGfGcList());
		   sb.append("<h1>").append(mmap.get("list_title")).append("</h1>");
		   if(mmap.get("goods1") != null){
			   ShoppingGoodsWithBLOBs goods=(ShoppingGoodsWithBLOBs) mmap.get("goods1");
			   if(goods.getGoods_main_photo()!=null) {
				   img = map.get("imageWebServer") + "/" + goods.getGoods_main_photo().getPath() + "/" + goods.getGoods_main_photo().getName() + "_small." + goods.getGoods_main_photo().getExt();
			   }else {
				   img = map.get("imageWebServer") + "/" + map.get("goodsImagePath") + "/" + map.get("goodsImageName");
			   }
			   goods_url=map.get("webPath")+"/goods_"+goods.getId()+".htm";

			   sb.append("<ul class=\"rankul\"><li class=\"rankimg\"><a href='").append(goods_url).append("' target=\"_blank\">");
			   //sb.append("<img src='").append(loadimg).append("' original='").append(img).append("' onerror=\"this.src='").append(errorimg).append("';\" width='28' height='28'/>");
			   sb.append("<img src='").append(img).append("' original='").append(img).append("' onerror=\"this.src='").append(errorimg).append("';\"  width='73' height='73'/>");
			   sb.append("</a><span class=\"rankno1\"></span></li><li class=\"rankhui\"><strong><a href='").append(goods_url).append("' target=\"_blank\">");
			   sb.append(CommUtil.substring(goods.getGoodsName(),12)).append("</a></strong></li><li class=\"rankmoney\">¥").append(goods.getGoodsCurrentPrice());
			   sb.append("</li></ul>");
		   }

		   if(mmap.get("goods2") != null){
			   ShoppingGoodsWithBLOBs goods=(ShoppingGoodsWithBLOBs)mmap.get("goods2");
			   if(goods.getGoods_main_photo()!=null) {
				   img = map.get("imageWebServer") + "/" + goods.getGoods_main_photo().getPath() + "/" + goods.getGoods_main_photo().getName() + "_small." + goods.getGoods_main_photo().getExt();
			   }else {
				   img = map.get("imageWebServer") + "/" + map.get("goodsImagePath") + "/" + map.get("goodsImageName");
			   }
			   goods_url=map.get("webPath")+"/goods_"+goods.getId()+".htm";

			   sb.append("<ul class=\"rankul\"><li class=\"rankimg\"><a href='").append(goods_url).append("' target=\"_blank\">");
			 //sb.append("<img src='").append(loadimg).append("' original='").append(img).append("' onerror=\"this.src='").append(errorimg).append("';\" width='28' height='28'/>");
			   sb.append("<img src='").append(img).append("' original='").append(img).append("' onerror=\"this.src='").append(errorimg).append("';\"  width='73' height='73'/>");
			   sb.append("</a><span class=\"rankno1\"></span></li><li class=\"rankhui\"><strong><a href='").append(goods_url).append("' target=\"_blank\">");
			   sb.append(CommUtil.substring(goods.getGoodsName(),12)).append("</a></strong></li><li class=\"rankmoney\">¥").append(goods.getGoodsCurrentPrice());
			   sb.append("</li></ul>");
		   }

		   if(mmap.get("goods3") != null){
			   ShoppingGoodsWithBLOBs goods=( ShoppingGoodsWithBLOBs)mmap.get("goods3");
			   if(goods.getGoods_main_photo()!=null) {
				   img = map.get("imageWebServer") + "/" + goods.getGoods_main_photo().getPath() + "/" + goods.getGoods_main_photo().getName() + "_small." + goods.getGoods_main_photo().getExt();
			   }else {
				   img = map.get("imageWebServer") + "/" + map.get("goodsImagePath") + "/" + map.get("goodsImageName");
			   }
			   goods_url=map.get("webPath")+"/goods_"+goods.getId()+".htm";

			   sb.append("<ul class=\"rankul\"><li class=\"rankimg\"><a href='").append(goods_url).append("' target=\"_blank\">");
			 //sb.append("<img src='").append(loadimg).append("' original='").append(img).append("' onerror=\"this.src='").append(errorimg).append("';\" width='28' height='28'/>");
			   sb.append("<img src='").append(img).append("' original='").append(img).append("' onerror=\"this.src='").append(errorimg).append("';\"  width='73' height='73'/>");
			   sb.append("</a><span class=\"rankno1\"></span></li><li class=\"rankhui\"><strong><a href='").append(goods_url).append("' target=\"_blank\">");
			   sb.append(CommUtil.substring(goods.getGoodsName(),12)).append("</a></strong></li><li class=\"rankmoney\">¥").append(goods.getGoodsCurrentPrice());
			   sb.append("</li></ul>");
		   }

		   sb.append("<ul class=\"rankul2\">");
		   if(mmap.get("goods4")!=null){
			   ShoppingGoodsWithBLOBs goods=(ShoppingGoodsWithBLOBs)mmap.get("goods4");
			   goods_url=map.get("webPath")+"/goods_"+goods.getId()+".htm";
			   sb.append("<li><a href='").append(goods_url).append("' target='_blank'>").append(CommUtil.substring(goods.getGoodsName(),14)).append("</a></li>");
		   }
		   if(mmap.get("goods5") != null){
			   ShoppingGoodsWithBLOBs goods=(ShoppingGoodsWithBLOBs)mmap.get("goods5");
			   goods_url=map.get("webPath")+"/goods_"+goods.getId()+".htm";
			   sb.append("<li><a href='").append(goods_url).append("' target='_blank'>").append(CommUtil.substring(goods.getGoodsName(),14)).append("</a></li>");
		   }
		   if(mmap.get("goods6")!=null){
			   ShoppingGoodsWithBLOBs goods=(ShoppingGoodsWithBLOBs)mmap.get("goods6");
			   goods_url=map.get("webPath")+"/goods_"+goods.getId()+".htm";
			   sb.append("<li><a href='").append(goods_url).append("' target='_blank'>").append(CommUtil.substring(goods.getGoodsName(),14)).append("</a></li>");
		   }
		   sb.append("</ul><div class=\"rank_advertisment\">");
		   //拼接右侧广告
		   sb.append(this.gf_tools.generic_adv(url, floor.getGfRightAdv()));
		   sb.append("</div></div></div><div class=\"floor_brand\"><span class=\"fl_brand_sp\"></span><span class=\"flr_sp_brand\">");
		   for(ShoppingGoodsbrand brand : this.gf_tools.generic_brand(floor.getGfBrandList())){
			   String brand_url = map.get("webPath")+"/brand_goods_"+brand.getId()+".htm";
			   String brand_img = map.get("imageWebServer") + "/" + brand.getBrandLogo().getPath() + "/" + brand.getBrandLogo().getName();
			   sb.append("<a href='").append(brand_url).append("' target='_blank'><img src='").append(brand_img).append("' width='98' height='35' /></a>");
		   }
		   sb.append("</span></div></div>");

	     return sb.toString();
	}

}
