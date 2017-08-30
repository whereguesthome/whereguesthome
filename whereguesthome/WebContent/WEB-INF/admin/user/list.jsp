<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>

</HEAD>
<script type="text/javascript">
if ("${msg}" != "") {
	alert("${msg}")
}
</script>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/user/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>用户列表</strong>
					</TD>
				</tr>
				<tr>

				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center">序号</td>
								<td align="center">用户名称</td>
								<td align="center">真实姓名</td>
								<td align="center">性别</td>
								<td align="center">电话</td>
								<td align="center">电子邮箱</td>
								<td width="7%" align="center">删除</td>
							</tr>
							<c:forEach items="${users.data }" var="u">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${u.uId }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${u.uAccount }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${u.uName }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${u.uSex }</td>

									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${u.uPhone }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${u.uEmail }</td>
									<td align="center" style="HEIGHT: 22px"><a
										href="javascript:deleteUser('${u.uId }')"> <img
											src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
				<tr align="center">
					<td colspan="7">第${users.pageNumber }/${users.totalPage }页 <a
						href="javascript:goPage(1)">首页</a>| <a
						href="javascript:goPage('${users.pageNumber-1 }')">上一页</a>| <a
						href="javascript:goPage('${users.pageNumber+1 }')">下一页</a>| <a
						href="javascript:goPage('${users.totalPage }')">尾页</a>|
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
	<form id="pageForm"
		action="${pageContext.request.contextPath}/admin/user/" method="post">
		<input type="hidden" name="pageNumber" id="curPage"
			value="${users.pageNumber }">
	</form>
	<form id="pageForm1"
		action="${pageContext.request.contextPath}/admin/user/delete"
		method="post">
		<input type="hidden" name="id" id="curPage1" value="">
	</form>
</body>
<script type="text/javascript">
	//页面提交controller
	function goPage(currentPage) {
		//页码和当前页显示的记录数  隐藏起来
		if (currentPage <= 1) {
			currentPage = 1;
		}
		if (currentPage > "${users.totalPage}") {
			currentPage = "${users.totalPage}";
		}

		document.getElementById("curPage").value = currentPage;
		document.getElementById("pageForm").submit();
	}
	//删除用户
	function deleteUser(id) {
		if (window.confirm("确定删除" + id + "该条记录？")) {
			document.getElementById("curPage1").value = id;
			document.getElementById("pageForm1").submit();
		}
	}
</script>
</HTML>

