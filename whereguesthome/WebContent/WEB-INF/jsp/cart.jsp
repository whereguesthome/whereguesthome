<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
	 float:left; */
	
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("input").keyup(
				function() {
					//获取商品价格
					var a = $(this).parent().prev().text();
					//如果输入非数字，则替换为''，如果输入数字，则在每4位之后添加一个空格分隔
					var text = this.value = this.value.replace(/[^\d]/g, '')
							.replace(/(\d{4})(?=\d)/g, "$1 ");
					//总价格
					var sum = a * text;
					$(this).parent().next().find("span").text(sum);
				})
		//鼠标选中事件
		$(".sz").click(
				function() {
					//获取积分
					var a = parseFloat($("#jif").text());

					//获取金额
					var b = parseFloat($("#jr").text());
					if ($(this).is(':checked')) {
						//当前为选中状态
						var c = parseFloat($(this).parent().nextAll(".sping")
								.find("span").text());//当前选中商品的价格
						//当前选中商品数量为只读状态
						$(this).parent().nextAll(".shul").find("input").attr(
								"readonly", "true");
						$("#jif").text(parseInt(a + c));
						//金额
						$("#jr").text(parseInt(b + c));
						var d = $("#jr").text();
						$("#jinge").attr("value", d)
					} else {
						//当前为不选中状态
						var c = parseFloat($(this).parent().nextAll(".sping")
								.find("span").text());//当前选中商品的价格
						//当前选中商品数量为只读状态
						$(this).parent().nextAll(".shul").find("input")
								.removeAttr("readonly");
						//积分
						$("#jif").text(a - c);
						//金额
						var d = $("#jr").text(parseInt(b - c));
						var d = $("#jr").text();
						$("#jinge").attr("value", d)
					}
				})
		//批量删除
		$("#pilsc").click(function() {
			$("#userForm").attr("action", "cart/delete")
		})
	})
	function selectUsers() {
		document.userForm.action = "${pageContext.request.contextPath}/jsp/cart/modify";
		document.userForm.submit();
	}
</script>
</head>

<body>

	<%@include file="/WEB-INF/jsp/head.jsp"%>
	<form action="cart/modify" method="post" name="userForm" id="userForm">
		<div class="container">
			<div class="row">

				<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
					<strong style="font-size: 16px; margin: 5px 0;">订单详情</strong>

					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>操作</th>
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<c:forEach items="${shopcar }" var="s" varStatus="shop">
								<tr class="active">
									<td><input type="checkbox" name="gid"
										value="${s.goods.gId}" class="sz"><span>选中</span></td>
									<td width="60" width="40%"><input type="hidden"
										name="shopcars[${shop.index }].u_id" value="user.uId">
										<img
										src="${s.goods.gPhoto }"
										width="70" height="60"></td>
									<td width="30%"><a target="_blank">${s.goods.gName }</a></td>
									<td width="20%">${s.goods.gSaleprice }</td>
									<td width="10%" class="shul"><input type="text"
										name="shopcars[${shop.index }].s_num" value="${s.s_num }"
										maxlength="4" size="10"></td>
									<td width="15%" class="sping"><span class="subtotal">${s.goods.gSaleprice*s.s_num }</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input type="hidden" name="sums" value="" id="jinge" />
				</div>
			</div>

			<div style="margin-right: 130px;">
				<div style="text-align: right;">
					<em style="color: #ff6600;"> 登录后确认是否享有优惠&nbsp;&nbsp; </em> 赠送积分: <em
						style="color: #ff6600;" id="jif">0</em>&nbsp; 商品金额: <strong
						style="color: #ff6600;" id="jr">0</strong>
				</div>
				<div
					style="text-align: right; margin-top: 10px; margin-bottom: 10px;">
					<input type="submit" value="批量删除" id="pilsc" /> <input
						type="button" width="100" value="提交订单" border="0"
						style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white; "
						onclick="selectUsers()" />
				</div>
			</div>
		</div>
	</form>
	<div style="margin-top: 50px;">
		<img src="${pageContext.request.contextPath}/image/footer.jpg"
			width="100%" height="78" alt="我们的优势" title="我们的优势" />
	</div>

	<div style="text-align: center; margin-top: 5px;">
		<ul class="list-inline">
			<li><a>关于我们</a></li>
			<li><a>联系我们</a></li>
			<li><a>招贤纳士</a></li>
			<li><a>法律声明</a></li>
			<li><a>友情链接</a></li>
			<li><a target="_blank">支付方式</a></li>
			<li><a target="_blank">配送方式</a></li>
			<li><a>服务声明</a></li>
			<li><a>广告声明</a></li>
		</ul>
	</div>
	<div style="text-align: center; margin-top: 5px; margin-bottom: 20px;">
		Copyright &copy; 2005-2016 凡客商城 版权所有</div>

</body>

</html>