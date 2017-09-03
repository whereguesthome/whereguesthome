<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	
	</HEAD>
	
	<body>
		<!--  -->
		<form id="userAction_save_do" name="Form1" action="updatego" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>修改商品</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						订单编号
					</td>
					<td class="ta_01" bgColor="#ffffff">
						${order.oId }
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						用户编号
					</td>
					<td class="ta_01" bgColor="#ffffff">
						${order.uId}
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						收货人姓名：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						${order.oRealname}
					</td>
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						地址：
					</td>
					
					<td class="ta_01" bgColor="#ffffff">
						${order.oAddress}
					</td>
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						电话号码：
					</td>
					
					<td class="ta_01" bgColor="#ffffff">
						${order.oPhone}
					</td>
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						支付方式：
					</td>
					
					<td class="ta_01" bgColor="#ffffff">
						${order.oPayment}
					</td>
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						备注：
					</td>
					
					<td class="ta_01" bgColor="#ffffff">
						${order.oRemarks}
					</td>
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						下单时间：
					</td>
					
					<td class="ta_01" bgColor="#ffffff">
						<fmt:formatDate value="${order.oTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						订单价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						${order.oPrice}
					</td>
				</tr>
				</table>
				</form>
				
				<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10">
										商品编号
									</td>
									
									<td align="center" >
										商品图片
									</td>
									<td align="center" >
										商品名称
									</td>
									
									<td align="center" >
										出厂价格
									</td>
									
									<td align="center" >
										销售价格
									</td>

									<td align="center" >
										商品储量
									</td>
									
									<td align="center" >
										上架日期
									</td>
									
									<td align="center" >
										类别
									</td>
									
									<td align="center" >
										购买数量
									</td>
									
								</tr>
									<c:forEach items="${listg}" var="s">
									<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${s.gId }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:if test="${s.gPhoto !=null }">
												<img src="/img/${s.gPhoto}" width="100" height="100"/></c:if>
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${s.gName }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${s.gPrice }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${s.gSaleprice}
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${s.gRepertory }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												<fmt:formatDate value="${s.gSaledate }" pattern="yyyy-MM-dd"/>
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${s.sId }
											</td>

											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${s.iCount }
											</td>
											
											</tr>
											</c:forEach>
											</table>
											</td>
											</tr>
											</table>
											</form>
											

	</body>
</HTML>
