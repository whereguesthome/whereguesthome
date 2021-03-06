<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style2.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/user_style.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/skins/all.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common_js.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/footer.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/layer/layer.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/iCheck.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/custom.js"
	type="text/javascript"></script>
<script type="text/javascript">
 window.onload = function() {
  var show = document.getElementById("show");
  setInterval(function() {
   var time = new Date();
   // 程序计时的月从0开始取值后+1
   var m = time.getMonth() + 1;
   var t = time.getFullYear() + "-" + m + "-"
     + time.getDate() + " " + time.getHours() + ":"
     + time.getMinutes() + ":" + time.getSeconds();
   show.innerHTML = t;
  }, 1000);
 };
</script>
<title>订单管理</title>
</head>

<body>
<head>
<div id="header_top">
	<div id="top">
		<div class="Inside_pages">
			<div class="Collection">
				<c:if test="${empty user}">
					<a href="${pageContext.request.contextPath}/jsp/dlu" class="green">请登录</a>
					<a href="${pageContext.request.contextPath}/jsp/zhuc" class="green">免费注册</a>
				</c:if>
				<c:if test="${not empty user}">
						   ${user.uName }:你好
			    <a href="${pageContext.request.contextPath}/jsp/logout">退出</a>
				</c:if>
			</div>
			<div class="hd_top_manu clearfix">
				<ul class="clearfix">
					<li class="hd_menu_tit" data-addclass="hd_menu_hover"><a
						href="${pageContext.request.contextPath}/jsp/index">首页</a></li>
					<li class="hd_menu_tit" data-addclass="hd_menu_hover"><a
						href="#">我的小充</a></li>
					<li class="hd_menu_tit" data-addclass="hd_menu_hover"><a
						href="#">消息中心</a></li>
					<li class="hd_menu_tit" data-addclass="hd_menu_hover"><a
						href="#">商品分类</a></li>
					<li class="hd_menu_tit" data-addclass="hd_menu_hover"><a
						href="${pageContext.request.contextPath}/jsp/cart">我的购物车<b>(23)</b></a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="header" class="header page_style">
		<div class="logo">
			<a href="index.html"><img
				src="${pageContext.request.contextPath}/img/fanke2.png" /></a>
		</div>
		<!--结束图层-->
		<div class="Search">
			<div class="search_list">
				<ul>
					<li class="current"><a href="#">产品</a></li>
					<li><a href="#">信息</a></li>
				</ul>
			</div>
			<div class="clear search_cur">
				<input name="searchName" id="searchName" class="search_box"
					onkeydown="keyDownSearch()" type="text"> <input name=""
					type="submit" value="搜 索" class="Search_btn" />
			</div>
			<div class="clear hotword">热门搜索词：香醋&nbsp;&nbsp;&nbsp;茶叶&nbsp;&nbsp;&nbsp;草莓&nbsp;&nbsp;&nbsp;葡萄&nbsp;&nbsp;&nbsp;菜油</div>
		</div>
		<!--购物车样式-->
		<div class="hd_Shopping_list" id="Shopping_list">
			<div class="s_cart">
				<a href="#">我的购物车</a> <i class="ci-right">&gt;</i><i
					class="ci-count" id="shopping-amount">0</i>
			</div>
			<div class="dorpdown-layer">
				<div class="spacer"></div>
				<!--<div class="prompt"></div><div class="nogoods"><b></b>购物车中还没有商品，赶紧选购吧！</div>-->
				<ul class="p_s_list">
					<li>
						<div class="img">
							<img src="${pageContext.request.contextPath}/images/tianma.png">
						</div>
						<div class="content">
							<p class="name">
								<a href="#">产品名称</a>
							</p>
							<p>颜色分类:紫花8255尺码:XL</p>
						</div>
						<div class="Operations">
							<p class="Price">￥55.00</p>
							<p>
								<a href="#">删除</a>
							</p>
						</div>
					</li>
				</ul>
				<div class="Shopping_style">
					<div class="p-total">
						共<b>1</b>件商品 共计<strong>￥ 515.00</strong>
					</div>
					<a href="Shop_cart.html" title="去购物车结算" id="btn-payforgoods"
						class="Shopping">去购物车结算</a>
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
	<script>
		$("#Navigation").slide({
			titCell : ".Navigation_name li",
			trigger : "click"
		});
	</script>
</div>
</head>
<div class="user_style clearfix">
	<div class="user_center clearfix">
		<div class="left_style">
			<div class="menu_style">
				<div class="user_title">
					<a href="${pageContext.request.contextPath}/admin/user/content.jsp">用户中心</a>
				</div>
				<div class="user_Head">
					<div class="user_portrait">
						<a href="#" title="修改头像" class="btn_link"></a> <img
							src="${pageContext.request.contextPath}/images/people.png">
						<div class="background_img"></div>
					</div>
					<div class="user_name">
						<p>
							<span class="name">${user.uName }</span><a href="#">[修改密码]</a>
						</p>
						<p><div id="show"></div></p>
					</div>
				</div>
				<div class="sideMen">
					<!--菜单列表图层-->
					<dl class="accountSideOption1">
						<dt class="transaction_manage">
							<em class="icon_1"></em>订单管理
						</dt>
						<dd>
							<ul>
								<li><a href="address">收货地址</a></li>
								<li><a href="用户中心-产品预订.html">产品预订</a></li>
							</ul>
						</dd>
					</dl>
					<dl class="accountSideOption1">
						<dt class="transaction_manage">
							<em class="icon_2"></em>会员管理
						</dt>
						<dd>
							<ul>
								<li><a href="userInfo"> 用户信息</a></li>
								<li><a href="#"> 我的评论</a></li>
							</ul>
						</dd>
					</dl>
				</div>
				<script>
					jQuery(".sideMen").slide({
						titCell : "dt",
						targetCell : "dd",
						trigger : "click",
						defaultIndex : 0,
						effect : "slideDown",
						delayTime : 300,
						returnDefault : true
					});
				</script>
			</div>
		</div>
		<!--右侧样式-->
		<div class="right_style">
			<div class="title_style">
				<em></em>订单管理
			</div>
			<div class="Order_form_style">

				<div class="Order_Operation">
					<div class="left">
						<label><input name="" type="checkbox" value=""
							class="checkbox" />全选</label> <input name="" type="submit"
							value="批量确认收货" class="confirm_Order" />
					</div>
					<div class="right_search">
						<input name="" type="text" class="add_Ordertext"
							placeholder="请输入产品标题或订单号进行搜索" /><input name="" type="submit"
							value="搜索订单" class="search_order" />
					</div>
				</div>
				<div class="Order_form_list">
					<table>
						<thead>
							<tr>
								<td class="list_name_title0">商品</td>
								<td class="list_name_title1">单价(元)</td>
								<td class="list_name_title4">实付款(元)</td>
								<td class="list_name_title5">订单状态</td>
								<td class="list_name_title6">操作</td>
							</tr>
						</thead>
						<c:forEach items="${list1 }" var="o">
							<tbody>
								<tr class="Order_info">
									<td colspan="6" class="Order_form_time"><input name=""
										type="checkbox" value="" class="checkbox" />下单时间：<fmt:formatDate
											value="${o.order.oTime }" pattern="yyyy-MM-dd" /> |
										订单号：${o.order.o_orderId } <em></em></td>
								</tr>
								<tr class="Order_Details">
									<td colspan="2">
										<table class="Order_product_style">
											<tbody>
												<c:forEach items="${o.goods }" var="g">
													<tr>
														<td>
															<div class="product_name clearfix">
																<a href="#" class="product_img"><img
																	src="${pageContext.request.contextPath}/picture/${g.gPhoto }" width="80px" height="80px"></a> <a
																	href="3" class="p_name">${g.gName }</a>
																<p class="specification">${g.gDescribes }</p>
															</div>
														</td>
														<td>${g.gSaleprice }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</td>
									<td class="split_line">${o.order.oPrice }</td>
									<td class="split_line"><p style="color: #F30">${o.order.oTag }</p></td>
									<td class="operating"><a href="#">查看订单</a> <a href="#">查看物流</a>
										<a href="#">联系客服</a> <a href="#">删除</a></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

		<script>
			$(document).ready(function() {
				$('.Order_form_style input').iCheck({
					checkboxClass : 'icheckbox_flat-green',
					radioClass : 'iradio_flat-green'
				});
			});
		</script>
	</div>
</div>
<!--网站地图-->
<div class="fri-link-bg clearfix">
	<div class="fri-link">
		<div class="logo left margin-r20">
			<img src="${pageContext.request.contextPath}/images/fo-logo.jpg"
				width="152" height="81" />
		</div>
		<div class="left">
			<img src="${pageContext.request.contextPath}/images/qd.jpg"
				width="90" height="90" />
			<p>扫描下载APP</p>
		</div>
		<div class="">
			<dl>
				<dt>新手上路</dt>
				<dd>
					<a href="#">售后流程</a>
				</dd>
				<dd>
					<a href="#">购物流程</a>
				</dd>
				<dd>
					<a href="#">订购方式</a>
				</dd>
				<dd>
					<a href="#">隐私声明 </a>
				</dd>
				<dd>
					<a href="#">推荐分享说明 </a>
				</dd>
			</dl>
			<dl>
				<dt>配送与支付</dt>
				<dd>
					<a href="#">保险需求测试</a>
				</dd>
				<dd>
					<a href="#">专题及活动</a>
				</dd>
				<dd>
					<a href="#">挑选保险产品</a>
				</dd>
				<dd>
					<a href="#">常见问题 </a>
				</dd>
			</dl>
			<dl>
				<dt>售后保障</dt>
				<dd>
					<a href="#">保险需求测试</a>
				</dd>
				<dd>
					<a href="#">专题及活动</a>
				</dd>
				<dd>
					<a href="#">挑选保险产品</a>
				</dd>
				<dd>
					<a href="#">常见问题 </a>
				</dd>
			</dl>
			<dl>
				<dt>支付方式</dt>
				<dd>
					<a href="#">保险需求测试</a>
				</dd>
				<dd>
					<a href="#">专题及活动</a>
				</dd>
				<dd>
					<a href="#">挑选保险产品</a>
				</dd>
				<dd>
					<a href="#">常见问题 </a>
				</dd>
			</dl>
			<dl>
				<dt>帮助中心</dt>
				<dd>
					<a href="#">保险需求测试</a>
				</dd>
				<dd>
					<a href="#">专题及活动</a>
				</dd>
				<dd>
					<a href="#">挑选保险产品</a>
				</dd>
				<dd>
					<a href="#">常见问题 </a>
				</dd>
			</dl>
			<dl>
				<dt>帮助中心</dt>
				<dd>
					<a href="#">保险需求测试</a>
				</dd>
				<dd>
					<a href="#">专题及活动</a>
				</dd>
				<dd>
					<a href="#">挑选保险产品</a>
				</dd>
				<dd>
					<a href="#">常见问题 </a>
				</dd>
			</dl>
			<dl>
		</div>
	</div>
</div>
<!--网站地图END-->
<!--网站页脚-->
<div class="copyright">
	<div class="copyright-bg">
		<div class="hotline">
			为生活充电在线 <span>招商热线：1598568548</span> 客服热线：400-6895258
		</div>
		<div class="hotline co-ph">
			<p>版权所有Copyright</p>
			<p>ICP备号 不良信息举报</p>
			<p>总机电话：8868888/194/195/196 客服电话：4000800988
		</div>
	</div>
</div>
</body>

</html>