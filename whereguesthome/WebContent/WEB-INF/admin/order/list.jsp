<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<!-- <script type="text/javascript">
			function showDetail(oid){
				var but = document.getElementById("but"+oid);
				var div1 = document.getElementById("div"+oid);
				if(but.value == "订单详情"){
					// 1.创建异步对象
					var xhr = createXmlHttp();
					// 2.设置监听
					xhr.onreadystatechange = function(){
						if(xhr.readyState == 4){
							if(xhr.status == 200){
								
								div1.innerHTML = xhr.responseText;
							}
						}
					}
					// 3.打开连接
					xhr.open("GET","${pageContext.request.contextPath}/adminOrder_findOrderItem.action?oid="+oid+"&time="+new Date().getTime(),true);
					// 4.发送
					xhr.send(null);
					but.value = "关闭";
				}else{
					div1.innerHTML = "";
					but.value="订单详情";
				}
				
			}
			function createXmlHttp(){
				   var xmlHttp;
				   try{ // Firefox, Opera 8.0+, Safari
				        xmlHttp=new XMLHttpRequest();
				    }
				    catch (e){
					   try{// Internet Explorer
					         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
					      }
					    catch (e){
					      try{
					         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					      }
					      catch (e){}
					      }
				    }

					return xmlHttp;
				 }
		</script> -->
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" >
										订单编号
									</td>
									<td align="center" >
										用户编号	
									</td>
									<td align="center" >
										收货人姓名
									</td>
									<td align="center" >
										收货地址
									</td>
									<td align="center" >
										邮编
									</td>
									<td align="center" >
										电话
									</td>
									<td align="center" >
										支付方式
									</td>
									
									<td align="center" >
										备注
									</td>
									
									<td align="center" >
										下单时间
									</td>
									
									<td align="center" >
										订单状态
									</td>
									
									<td align="center" >
										订单价格
									</td>
									
									<td align="center" >
										订单详情
									</td>
									
									<td align="center" >
										删除订单
									</td>
									
								</tr>
									<c:forEach items="${ listOrder}" var="l">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												${l.oId }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												${l.uId}
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												${l.oRealname}
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												${l.oAddress}
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												${l.oZip}
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												${l.oPhone}
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												${l.oPayment}
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												${l.oRemarks}
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												<fmt:formatDate value="${l.oTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												${l.oTag}
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												${l.oPrice}
											</td>
											
											<td align="center" style="HEIGHT: 22px">
											
												<a
										href="javascript:go('${l.oId }','${l.uId}')">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												<a href="${l.oId }/delete">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
											
											
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
					<tr align="center">
						<td colspan="7">
							第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页 
							<s:if test="pageBean.page != 1">
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=1">首页</a>|
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a>|
							</s:if>
							<s:if test="pageBean.page != pageBean.totalPage">
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a>|
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>|
							</s:if>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
		
		<form id="pageForm2" action="xianqing" method="post">
		
		<input type="hidden" name ="oId" id= "oId" value="">
		<input type="hidden" name ="uId" id= "uId" value="">	
	</form>
	</body>
	
	<script type="text/javascript">
		function go(id1,id2){
			
			document.getElementById("oId").value = id1;
			document.getElementById("uId").value = id2;
			
			document.getElementById("pageForm2").submit();
		}
	</script>
</HTML>

