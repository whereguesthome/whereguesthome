<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<table width="500" height="300" border="1px" align="center"
		bgcolor="#FAEBD7">
		<c:forEach items="${user }" var="u">
			<tr align="center">
				<td>${u.uId }</td>
				<td>${u.uName }</td>
				
		</c:forEach>


	</table>

</body>
</html>