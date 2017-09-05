<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						商品名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="gName" value="${goods.gName }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						状态：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						  <select name="is_status">
							<option value="1" <c:if test="${goods.gStatus==1 }">selected='selected'</c:if>>未下架</option>
							
							<option value="2" <c:if test="${goods.gStatus==2 }">selected='selected'</c:if>>已下架</option>
						</select>   
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						出厂价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="gPrice" value="${goods.gPrice }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						销售价格：
					</td>
					
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="gSaleprice" value="${goods.gSaleprice}" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品图片：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<img src="/pic/${goods.gPhoto}" width="100" height="100">
						<input type="file" name="photo" />
					</td>
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						储量：
					</td>
					
					<td class="ta_01" bgColor="#ffffff">
						<input type="text"  name="gRepertory" value="${goods.gRepertory}" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属分类：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select name="fenlei" id="">
						<c:forEach items="${list }" var="c">
						<option value="${c.sName }" <c:if test="${c.sName==sort2.sName}">selected='selected'</c:if>>${c.sName }</option>
						</c:forEach>
								
						</select>
					</td>
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品编号：
					</td>
					
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="gId" value="${goods.gId}" id="userAction_save_do_logonName" class="bg" readonly="readonly"/>
					</td>
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<textarea name="gDescribes" rows="5" cols="30">${goods.gDescribes}</textarea>
					</td>
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品介绍：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<textarea name="gContents" rows="5" cols="30">${goods.gContents}</textarea>
					</td>
				</tr>
				
				
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>
