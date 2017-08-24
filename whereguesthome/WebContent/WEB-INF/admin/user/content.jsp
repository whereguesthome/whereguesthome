<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style2.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/user_style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common_js.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/footer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/layer/layer.js" type="text/javascript"></script>
<title>用户中心</title>
</head>

<body>
<head>
 <div id="header_top">
  <div id="top">
    <div class="Inside_pages">
      <div class="Collection"><a href="#" class="green">请登录</a> <a href="#" class="green">免费注册</a></div>
	<div class="hd_top_manu clearfix">
	  <ul class="clearfix">
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">首页</a></li> 
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"> <a href="#">我的小充</a> </li>
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">消息中心</a></li>
       <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">商品分类</a></li>
        <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">我的购物车<b>(23)</b></a></li>	
	  </ul>
	</div>
    </div>
  </div>
  <div id="header"  class="header top_header_style">
  <div class="logo"><a href="index.html"><img src="${pageContext.request.contextPath}/img/fanke2.png" /></a></div>
  <!--结束图层-->
  <div class="Search">
        <div class="search_list">
            <ul>
                <li class="current"><a href="#">产品</a></li>
                <li><a href="#">信息</a></li>
            </ul>
        </div>
        <div class="clear search_cur">
           <input name="searchName" id="searchName" class="search_box" onkeydown="keyDownSearch()" type="text">
           <input name="" type="submit" value="搜 索"  class="Search_btn"/>
        </div>
        <div class="clear hotword">热门搜索词：香醋&nbsp;&nbsp;&nbsp;茶叶&nbsp;&nbsp;&nbsp;草莓&nbsp;&nbsp;&nbsp;葡萄&nbsp;&nbsp;&nbsp;菜油</div>
</div>
 <!--购物车样式-->
 <div class="hd_Shopping_list" id="Shopping_list">
   <div class="s_cart"><a href="#">我的购物车</a> <i class="ci-right">&gt;</i><i class="ci-count" id="shopping-amount">0</i></div>
   <div class="dorpdown-layer">
    <div class="spacer"></div>
	 <!--<div class="prompt"></div><div class="nogoods"><b></b>购物车中还没有商品，赶紧选购吧！</div>-->
	 <ul class="p_s_list">	   
		<li>
		    <div class="img"><img src="${pageContext.request.contextPath}/images/tianma.png"></div>
		    <div class="content"><p class="name"><a href="#">产品名称</a></p><p>颜色分类:紫花8255尺码:XL</p></div>
			<div class="Operations">
			<p class="Price">￥55.00</p>
			<p><a href="#">删除</a></p></div>
		  </li>
		</ul>		
	 <div class="Shopping_style">
	 <div class="p-total">共<b>1</b>件商品　共计<strong>￥ 515.00</strong></div>
	  <a href="Shop_cart.html" title="去购物车结算" id="btn-payforgoods" class="Shopping">去购物车结算</a>
	 </div>	 
   </div>
 </div>
</div>
<!--菜单栏-->
	<div class="Navigation" id="Navigation">
		 <ul class="Navigation_name">
			<li><a href="${pageContext.request.contextPath}/jsp/index.jsp">首页</a></li>
			<li><a href="Brands.html">联系我们</a></li>
		 </ul>			 
		</div>
	<script>$("#Navigation").slide({titCell:".Navigation_name li",trigger:"click"});</script>
    </div>
</head>
<!--用户中心样式-->
<div class="user_style clearfix">
 <div class="user_center clearfix">
 <div class="left_style">
     <div class="menu_style">
     <div class="user_title"><a href="${pageContext.request.contextPath}/admin/user/content.jsp">用户中心</a></div>
     <div class="user_Head">
     <div class="user_portrait">
      <a href="#" title="修改头像" class="btn_link"></a> <img src="${pageContext.request.contextPath}/images/people.png">
      <div class="background_img"></div>
      </div>
      <div class="user_name">
       <p><span class="name">化海天堂</span><a href="#">[修改密码]</a></p>
       <p>访问时间：2016-1-21 10:23</p>
       </div>           
     </div>
     <div class="sideMen">
     <!--菜单列表图层-->
     <dl class="accountSideOption1">
      <dt class="transaction_manage"><em class="icon_1"></em>订单管理</dt>
      <dd>
        <ul>
          <li> <a href="order.jsp">我的订单</a></li>
          <li> <a href="address.jsp">收货地址</a></li>
        </ul>
      </dd>
    </dl>
     <dl class="accountSideOption1">
      <dt class="transaction_manage"><em class="icon_2"></em>会员管理</dt>
        <dd>
      <ul>
        <li><a href="userInfo.jsp">用户信息</a></li>
        <li><a href="#">我的评论</a></li>
      </ul>
    </dd>
    </dl>
    </div>
      <script>jQuery(".sideMen").slide({titCell:"dt", targetCell:"dd",trigger:"click",defaultIndex:0,effect:"slideDown",delayTime:300,returnDefault:true});</script>
   </div>
   <!--浏览记录样式-->
    <div class="us_Records">
	  <div id="Record_ps" class="Record_p">
	    <div class="title_name"><span class="name left">浏览历史</span><span class="pageState right"></div>
	      <div class="hd"><a class="next">&lt;</a><a class="prev">&gt;</a></div>
            <div class="bd">
                <ul >
                <li>
                   <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_1.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>	
                    </li>
                <li >
                <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_12.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>		
                </li>
                    <li >
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_23.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>	
                    </li>
                    <li >
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_4.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>							
                    </li>
                    <li>
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_5.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>							
                    </li>
                        <li>
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_8.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>				
                    </li>
                        <li >
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_1.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>	
                    </li>
                        <li>
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_6.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>	
                    </li>
                    <li>
                <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_11.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>		
                </li>
                </ul>
                </div>            
         </div>
         <script type="text/javascript">jQuery("#Record_ps").slide({mainCell:".bd ul",autoPage:true,effect:"leftLoop",vis:1,autoPlay:false });</script>
	    </div>
   
 </div>
 <div class="right_style">
     <div class="info_content">
    <div class="Notice"><span>系统最新公告:</span>为了更好地服务于【每日鲜】的会员朋友及读者 发表意见。</div>
    <%--  <div class="user_info">
      <ul class="">
       <li class="Balance"><a href="#"><img src="${pageContext.request.contextPath}/images/user_img_05.png" /><h4>余额：￥54.00</h4></a></li>
       <li class="Order_form"><a href="#"><img src="${pageContext.request.contextPath}/images/user_img_04.png" /><h4>订单：(5)</h4></a></li>
       <li class="grade"><a href="#"><img src="${pageContext.request.contextPath}/images/user_img_08.png" /><h4>3</h4></a></li>
       <li class="Favorable"><a href="#"><img src="${pageContext.request.contextPath}/images/user_img_07.png" /><h4>钻石会员</h4></a></li>
       <li class="integral"><a href="#"><img src="${pageContext.request.contextPath}/images/user_img_06.png" /><h4>234分</h4></a></li>
      </ul>
     </div> --%>
     <!--样式-->
     <div class="user_info_p_s  clearfix">
       <!--订单记录-->
       <div class="left_user_cont">
     <div class="us_Orders left clearfix">
  <div class="Orders_name">
   <div class="title_name">
   <div class="Records">购买记录</div>
   <div class="right select">
   只记录你最近30天的购买记录   </div>
   </div>   
  </div>
  <table>
  <thead>
  <tr>
   <th>产品名称</th>
   <th>数量</th>
   <th>状态</th>
   <th>操作</th>
   </tr>
  </thead>
  <tbody>
   <tr>
    <td class="img_link">
    <a href="#" class="img"><img src="${pageContext.request.contextPath}/products/p_58.jpg" width="80" height="80"></a>
	<a href="#" class="title">雅诗兰黛（Estee Lauder）弹性紧实柔肤眼霜15ml(又名弹性紧实眼霜)（提拉紧致 保湿补水 淡化细纹）</a>
	</td>
	<td>2</td>
	<td>完成</td>
	<td><a href="#" class="View">查看</a></td>
   </tr>
    <tr>
    <td class="img_link">
    <a href="#" class="img" title="山东红富士苹果"><img src="${pageContext.request.contextPath}/products/p_2.jpg" width="80" height="80"></a>
     <i class="icon-copy"></i>
    <a href="#" class="img" title="进口澳洲苹果"><img src="${pageContext.request.contextPath}/products/p_3.jpg" width="80" height="80"></a>
     <i class="icon-copy"></i>
    <a href="#" class="img" title="进口水果"><img src="${pageContext.request.contextPath}/products/p_4.jpg" width="80" height="80"></a>
	</td>
	<td>2</td>
	<td>完成</td>
	<td><a href="#" class="View">查看</a></td>
   </tr>
     <tr>
    <td class="img_link">
    <a href="#" class="img" title="山东红富士苹果"><img src="${pageContext.request.contextPath}/products/p_2.jpg" width="80" height="80"></a>
     <i class="icon-copy"></i>
    <a href="#" class="img" title="进口水果"><img src="${pageContext.request.contextPath}/products/p_24.jpg" width="80" height="80"></a>
	</td>
	<td>2</td>
	<td>完成</td>
	<td><a href="#" class="View">查看</a></td>
   </tr>
   </tbody>
  </table>
   <div class="us_jls">共2条记录</div>
  </div>
    </div>
      <!--右侧记录样式-->
<%--     <div class="right_user_recording">
    <div class="us_Record">
	  <div id="Record_p" class="Record_p">
	    <div class="title_name"><span class="name left">浏览历史</span><span class="pageState right"><span>1</span>/7</span></div>
	      <div class="hd"><a class="next">&lt;</a><a class="prev">&gt;</a></div>
            <div class="bd">
                <ul >
                <li class="clone">
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_1.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>	
                    </li>
                <li >
                <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_12.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>		
                </li>
                    <li >
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_23.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>	
                    </li>
                    <li >
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_4.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>							
                    </li>
                    <li>
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_5.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>							
                    </li>
                        <li>
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_8.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>				
                    </li>
                        <li >
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_1.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>	
                    </li>
                        <li>
                        <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_6.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>	
                    </li>
                    <li class="clone" >
                <div class="p_width">
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_11.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="Purchase_info"><span class="p_Price">￥32.50</span> <a href="#" class="Purchase">立即购买</a></div>
                </div>		
                </li></ul></div>            
         </div>
         <script type="text/javascript">jQuery("#Record_p").slide({ mainCell:".bd ul",effect:"leftLoop",vis:1,autoPlay:false });</script>
	    </div>
       </div>      --%> 
     </div>
        <!--收藏商品-->
  <%--    <div class="Collections_p">
      <div class="slideGroups">
        <div class="parHd">
				<ul><li>收藏的商品</li><li>收藏的店铺</li></ul>
			</div>
            <div class="parBd">
             <div class="Collect_Products">
              <a class="sPrev" href="javascript:void(0)">&lt;</a>
                <ul >
              <li>
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_29.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>		
                </li>
                <li s>
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_19.jpg"></a></div>
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>
                </li>
                <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_37.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>							
                </li>
                <li>
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_24.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>								
                </li>
                    <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_33.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>					
                </li>
                    <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_29.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>		
                </li>
                    <li>
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_18.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>		
                </li>
                <li>
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_17.jpg"></a></div>
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>
                </li>
                <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_16.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>							
                </li>
                <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_12.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>								
                </li>
                <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_8.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>					
                </li>
                <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_11.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="p_Price">￥32.50</div>		
                </li>
              </ul>
              <a class="sNext" href="javascript:void(0)">&gt;</a>
              <a href="#" class="more">更多收藏</a>
             </div>
             <div class="Collect_Products">
             <a class="sPrev" href="javascript:void(0)">&lt;</a>
              <ul >
              <li>
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_29.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>		
                </li>
                <li s>
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_19.jpg"></a></div>
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                   <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>	
                </li>
                <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_37.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>							
                </li>
                <li>
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_24.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>									
                </li>
                    <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_33.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>						
                </li>
                    <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_29.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>			
                </li>
                    <li>
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_18.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>			
                </li>
                <li>
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_17.jpg"></a></div>
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>	
                </li>
                <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_16.jpg"></a></div>	
                    <div class="title"><a href="#">金龙鱼 东北大米 蟹稻共生 盘锦大米5KG</a></div>
                    <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>								
                </li>
                <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_12.jpg"></a></div>	
                    <div class="title"><a href="#">三只松鼠旗舰店</a></div>
                    <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>									
                </li>
                <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_8.jpg"></a></div>	
                    <div class="title"><a href="#">三只松鼠旗舰店</a></div>
                    <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>						
                </li>
                <li >
                    <div class="pic"><a href=""><img src="${pageContext.request.contextPath}/Products/P_11.jpg"></a></div>	
                    <div class="title"><a href="#">店铺名称是什么</a></div>
                    <div class="shop_name"><span>收藏：234</span><a href="#" >进入店铺</a></div>			
                </li>
              </ul>
              <a class="sNext" href="javascript:void(0)">&gt;</a>
              <a href="#" class="more">更多收藏</a>
             </div>
            </div>
      </div>
      <script type="text/javascript">
			/* 内层图片无缝滚动 */
			jQuery(".slideGroups .Collect_Products").slide({ mainCell:"ul",vis:5,prevCell:".sPrev",nextCell:".sNext",effect:"leftMarquee",interTime:50,autoPlay:true,trigger:"click"});

			/* 外层tab切换 */
			jQuery(".slideGroups").slide({titCell:".parHd li",mainCell:".parBd",trigger:"click"});

		</script>			
     </div> --%>
   <!--结束-->       
    </div>
 
  </div>
 </div>
</div>
<!--网站地图-->
<div class="fri-link-bg clearfix">
    <div class="fri-link">
        <div class="logo left margin-r20"><img src="${pageContext.request.contextPath}/images/fo-logo.jpg" width="152" height="81" /></div>
        <div class="left"><img src="${pageContext.request.contextPath}/images/qd.jpg" width="90"  height="90" />
            <p>扫描下载APP</p>
        </div>
       <div class="">
    <dl>
	 <dt>新手上路</dt>
	 <dd><a href="#">售后流程</a></dd>
     <dd><a href="#">购物流程</a></dd>
     <dd><a href="#">订购方式</a> </dd>
     <dd><a href="#">隐私声明 </a></dd>
     <dd><a href="#">推荐分享说明 </a></dd>
	</dl>
	<dl>
	 <dt>配送与支付</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>
	<dl>
	 <dt>售后保障</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>
	<dl>
	 <dt>支付方式</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>	
    <dl>
	 <dt>帮助中心</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>
     <dl>
	 <dt>帮助中心</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>
     <dl>
		   
   </div>
    </div>
</div>
<!--网站地图END-->
<!--网站页脚-->
<div class="copyright">
    <div class="copyright-bg">
        <div class="hotline">为生活充电在线 <span>招商热线：1598568548</span> 客服热线：400-6895258</div>
        <div class="hotline co-ph">
            <p>版权所有Copyright</p>
            <p>ICP备号 不良信息举报</p>
            <p>总机电话：8868888/194/195/196 客服电话：4000800988 
                
        </div>
    </div>
</div>
</body>
</html>