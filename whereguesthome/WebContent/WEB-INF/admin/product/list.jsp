<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/admin/product/add";
			}
			
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>商品列表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addProduct()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" >
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
										商品描述
									</td>
									
									<td align="center" >
										商品介绍
									</td>
									<td align="center" >
										商品储量
									</td>
									
									<td align="center" >
										商品状态
									</td>
									
									<td align="center" >
										上架日期
									</td>
									
									<td align="center" >
										类别
									</td>
									
									<td align="center">
										编辑
									</td>
									<td align="center">
										删除
									</td>
								</tr>
								<c:forEach items="${goodslist }" var="g">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${g.gId }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:if test="${g.gPhoto !=null }">
												<img src="/pho/${g.gPhoto}" width="100" height="100"/></c:if>
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${g.gName }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${g.gPrice }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${g.gSaleprice }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${g.gDescribes }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${g.gContents }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${g.gRepertory }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												<c:if test="${p.gStatus==1 }">未下架</c:if>
												<c:if test="${p.gStatust==2 }">已下架</c:if>
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												<fmt:formatDate value="${g.gSaledate }" pattern="yyyy-MM-dd"/>
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${g.sId }
											</td>
											
											
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/adminProduct_edit.action?pid=">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/adminProduct_delete.action?pid=">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

