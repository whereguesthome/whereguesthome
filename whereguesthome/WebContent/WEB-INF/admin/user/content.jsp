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
<script type="text/javascript">
	window.onload = function() {
		var show = document.getElementById("show");
		setInterval(function() {
			var time = new Date();
			// 程序计时的月从0开始取值后+1
			var m = time.getMonth() + 1;
			var t = time.getFullYear() + "-" + m + "-" + time.getDate() + " "
					+ time.getHours() + ":" + time.getMinutes() + ":"
					+ time.getSeconds();
			show.innerHTML = t;
		}, 1000);
	};
</script>
<title>用户中心</title>
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
	<div id="header" class="header top_header_style">
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
<!--用户中心样式-->
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
								<li><a href="order">我的订单</a></li>
								<li><a href="address">收货地址</a></li>
							</ul>
						</dd>
					</dl>
					<dl class="accountSideOption1">
						<dt class="transaction_manage">
							<em class="icon_2"></em>会员管理
						</dt>
						<dd>
							<ul>
								<li><a href="userInfo">用户信息</a></li>
								<li><a href="#">我的评论</a></li>
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
		<div class="right_style">
			<div class="info_content">
				<div class="Notice">
					<span>系统最新公告:</span>为了更好地服务于【凡客家居】的会员朋友及读者 发表意见。
				</div>

				<div class="user_info_p_s  clearfix">
					<!--订单记录-->
					<div class="left_user_cont">
						<div class="us_Orders left clearfix">
							<div class="Orders_name">
								<div class="title_name"></div>
							</div>

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>