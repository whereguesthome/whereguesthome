<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
            	时间：2015-12-30
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="${pageContext.request.contextPath}/img/fanke2.png" />
				</div>
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}/img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
				
					<ol class="list-inline">
					 
					<c:if test="${empty user}">					
						<li><a href="dlu">登录</a></li>
						<li><a href="zhuc">注册</a></li>
						</c:if>
						
						<c:if test="${not empty user}">
						   ${user.uName }:你好
					   <li><a href="${pageContext.request.contextPath}/admin/user/content.jsp">个人中心</a></li>					   	
					   <li><a href="cart.jsp">购物车</a></li>
					   <li><form action="logout">
					   <a href="${pageContext.request.contextPath}/jsp/logout">退出</a>
					  </form>
					   </li>				
						</c:if>						
					</ol>
				</div>
			</div>
			<!--
            	时间：2015-12-30
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="index">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav" id="c_ul">
								
								
							</ul>
							<form class="navbar-form navbar-right" role="search" action="list">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Search" name="gName">
								</div>
								<button type="submit" class="btn btn-default">搜索</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
<script type="text/javascript">
	$(function(){
		//发送ajax 查询所有分类
		$.post("${pageContext.request.contextPath}/jsp/index",function(obj){
			//alert(obj);
			//遍历json列表,获取每一个分类,包装成li标签,插入到ul内部
			//$.each($(obj),function(){});
			$(obj).each(function(){
				//alert(this.cname);
				$("#c_ul").append("<li><a href='${pageContext.request.contextPath}/jsp/product?pageNumber=1&sId="+this.sId+"'>"+this.sName+"</a></li>");
			});
		},"json");
	})
</script>