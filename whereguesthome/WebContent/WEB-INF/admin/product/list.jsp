<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<td class="ta_01" align="left">
						<select name="fenlei2" id="fenlei2" style="width: 70px;height: 30px;font-size: 15px;color: black;">
						<c:forEach items="${listSort2}" var="s" >
						<option value="${s.sName }" <c:if test="${s.sName==sort.sName}">selected='selected'</c:if>>${s.sName }</option>
						</c:forEach>
						</select>
						</td>
						
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" style="width: 50px;height: 30px;" class="button_add" onclick="addProduct()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr >
					
					<td >
					<div style="float: left" >
					<a>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
					<label>关键字搜索:</label>
					<input type="text" name = "sname" id="sname" size="5" /></div>
					<div style="float: left">
					<a>&nbsp; &nbsp;&nbsp;</a>
					</div>
						<div style="float: left">
						<label>价格区间:</label>
						<input size="5" type="text" id="Sprice1" name="Sprice1">-
						<input size="5" type="text" id="Sprice2" name="Sprice2">
						</div>
						
						<div style="float: left">
						<a>&nbsp; &nbsp;</a>
						<a href="javascript:change()">搜索</a></div>
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
									<c:forEach items="${goods.data }" var="g">
									<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${g.gId }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:if test="${g.gPhoto !=null }">
												<img src="/img/${g.gPhoto}" width="100" height="100"/></c:if>
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
												<c:if test="${g.gStatus==1 }">未下架</c:if>
												<c:if test="${g.gStatus==2 }">已下架</c:if>
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
												<a href="${g.gId }">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
											<%-- 	<a href="${g.gId}/delete"> --%>
											<a href="javascript: if(window.confirm('是否删除？')){window.location.href='${g.gId}/delete'}" >
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
										</c:forEach>
							</table>
						</td>
					</tr>
					
					<tr align="center">
					<td colspan="7">第${goods.pageNumber }/${goods.totalPage }页 <a
						href="javascript:goPage(1)">首页</a>| <a
						href="javascript:goPage('${goods.pageNumber-1 }')">上一页</a>| <a
						href="javascript:goPage('${goods.pageNumber+1 }')">下一页</a>| <a
						href="javascript:goPage('${goods.totalPage }')">尾页</a>|
					</td>
				</tr>
				
				</TBODY>
			</table>
		</form>
	<form id="pageForm"
		action="fenye" method="post">
		<input type="hidden" name="pageNumber" id="curPage"
			value="${goods.pageNumber }">
		<input type="hidden" name ="name" id= "name" value="">
		<input type="hidden" name ="name1" id= "name1" value="">	
		<input type="hidden" name ="gSprice" id= "gSprice" value="">
		<input type="hidden" name ="gSprice2" id= "gSprice2" value="">		
		
	</form>
	<%-- <form id="pageForm1"
		action="${pageContext.request.contextPath}/admin/user/delete"
		method="post">
		<input type="hidden" name="id" id="curPage1" value="">
	</form> --%>
</body>
<script type="text/javascript">

 function change(){
	 currentPage =1;
	var type = document.getElementById("fenlei2").value;
	document.getElementById("name").value = type;
	
	var type2 = document.getElementById("sname").value;
	var type3 = document.getElementById("Sprice1").value;
	var type4 = document.getElementById("Sprice2").value;
	
	
	document.getElementById("name1").value = type2;
	document.getElementById("gSprice").value = type3;
	document.getElementById("gSprice2").value = type4;
	
	document.getElementById("curPage").value = currentPage;
	document.getElementById("pageForm").submit();
}

	//页面提交controller
	function goPage(currentPage) {
		//页码和当前页显示的记录数  隐藏起来
		if (currentPage <= 1) {
			currentPage = 1;
		}
		if (currentPage > "${goods.totalPage}") {
			currentPage = "${goods.totalPage}";
		}
		
		var type = document.getElementById("fenlei2").value;
		document.getElementById("name").value = type;
		
		document.getElementById("curPage").value = currentPage;
		document.getElementById("pageForm").submit();
	}
	
	//删除用户
	/*  function deleteUser(id) {
		if (window.confirm("确定删除" + id + "该条记录？")) {
			document.getElementById("curPage1").value = id;
			document.getElementById("pageForm1").submit();
		}
	}  */

</script>

</HTML>

