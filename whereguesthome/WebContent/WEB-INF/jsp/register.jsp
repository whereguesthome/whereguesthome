<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员注册</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
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
</head>
<script type="text/javascript">
function clearPhone(obj) {
	if (isNaN(obj.value)==true){	
		obj.value='';
	 } 
}
function clearMail(obj) {
	obj.value='';
}

function check(){
	//得到表单对象
	var uPhoneObj=document.getElementById("uPhone");
	var uEmailObj=document.getElementById("uEmail");
 if((checkPhone(uPhoneObj))&&(checkMail(uEmailObj))){
		return true;//验证通过
 }else{	
	return false;//验证通过
 }
}
function checkPhone(obj){	
//验证手机号码
var uPhone=obj.value;
if(uPhone.length==0||uPhone==null){
	//alert("手机号码不能为空");
	document.getElementById("umag").innerHTML="<font color='red'>手机号码不能为空</font>";
	obj.focus();
	return false;
}else if(uPhone.length<11){
	document.getElementById("umag").innerHTML="<font color='red'>手机号码应为11位</font>";
	obj.focus();
	return false;
}else if(uPhone.length>11){
	document.getElementById("umag").innerHTML="<font color='red'>手机号码应为11位</font>";
	obj.focus();
	return false;
}else{
	for(var i=0;i<uPhone.length;i++){
		var c=uPhone.charAt(i);
		if(!(c>='0'&&c<='9')){
			//alert("手机号码只能为数字");
			document.getElementById("umag").innerHTML="<font color='red'>手机号码只能为数字</font>";
			obj.focus();
		return false;
	}
   }	
 }
   obj.blur();//给用户名对象释放焦点
  document.getElementById("umag").innerHTML='';
   return true;
}
function checkMail(obj) {
	//验证邮箱
	var uEmail=obj.value;
	if(uEmail==null || uEmail.length==0){
		//alert("邮箱不能为空");
		document.getElementById("mag").innerHTML="<font color='red'>邮箱不能为空</font>";
		obj.focus();//给邮箱对象焦点
		return false;
	}else{
		var index1=uEmail.indexOf('@');
		var index2=uEmail.lastIndexOf('.');
		if(index1<=0 || index2==-1 ||index1>index2){
			//alert("邮箱包含@，.且.在@后面！");
			document.getElementById("mag").innerHTML="<font color='red'>邮箱包含@，.且.在@后面！</font>";
			obj.focus();
			return false;
		}		
	}
	obj.blur();//给用户名对象释放焦点
	document.getElementById("mag").innerHTML='';
	return true;//验证通过
}

</script> 
<body>



 <%@include file="/WEB-INF/jsp/head.jsp" %>





<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/image/regist_bg.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	
	


	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>会员注册   ${users}</font>
		<form class="form-horizontal" style="margin-top:5px;" method="post" action="regist" onsubmit="return check()">
			<input type="hidden" name="method" value="regist">
			 <div class="form-group">
			    <label for="uName" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="uName" placeholder="请输入用户名" name="uName">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="password" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" id="uPassword" placeholder="请输入密码" name="uPassword">
			    </div>
			  </div> 
			    <!-- <div class="form-group">
			     <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" id="confirmpwd" placeholder="请输入确认密码"> 
			    </div> 
			  </div>  -->
			  <div class="form-group">
			    <label for="email" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-6">
			    <!-- <input type="email" class="form-control" id="uEmail" placeholder="Email" name="uEmail"> -->
			      <input type="email" class="form-control" id="uEmail"  name="uEmail" onblur="checkMail(this)" onfocus="clearMail(this)" >
			    <div id="mag" style="display:inline"></div><br>
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="phone" class="col-sm-2 control-label">手机号</label>
			    <div class="col-sm-6">
			    <!-- <input type="text" class="form-control" id="uPhone" placeholder="请输入手机号" name="uPhone"> -->
			      <input type="text" class="form-control" id="uPhone" name="uPhone" onblur="checkPhone(this)" onfocus="clearPhone(this)" >
			    <div id="umag" style="display:inline"></div><br> 
			    </div>
			  </div>
			  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
			  <div class="col-sm-6">
			    <label class="radio-inline">
			  <input type="radio" name="uSex" id="uSex" value="1"> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" name="uSex" id="uSex value="0"> 女
			</label>
			</div>
			  </div>		
			  <div class="form-group">
			    <label for="account" class="col-sm-2 control-label">支付账号</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control"  name="uAccount" id="uAccount" placeholder="请输入支付账号">		      
			    </div>
			  </div>
			  
			 <!--  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">验证码</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control"  >
			      
			    </div> -->
			   <%--  <div class="col-sm-2">
			    <img src="${pageContext.request.contextPath}/image/captcha.jhtml"/>
			    </div> --%>
			    
			  
			 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-12"> 
			    
			      <input type="submit"  width="150" value="注册" name="submit" border="0"
				    style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
			    </div>
			  </div>
			</form>
	</div>
	
	<div class="col-md-2"></div>
  
</div>
</div>

	  
	
	<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
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
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2005-2016 凡客商城 版权所有
		</div>

</body></html>




