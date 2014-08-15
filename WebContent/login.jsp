<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Cov Ops</title>
		<link rel="stylesheet" type="text/css" href="${contextPath}/static/ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="${contextPath}/static/ext/ext-all.js"></script>
		<script type="text/javascript">
			var contextPath = "${contextPath}";
			
			function login(){
				var $userName = document.getElementById("userName").value;
				var $password = document.getElementById("password").value;
				if($userName == ""){
					alert("请输入用户名");
					return;
				}
				if($password == ""){
					alert("请输入密码");
					return;
				}
				Ext.Ajax.request({
					url : "${contextPath}/sys/sysuser/login",
					method : "post",
					params : {
						userName : $userName,
						password : $password
					},
					success : function(form, action){
						var returninfo = eval("(" + form.responseText + ")");
						if(returninfo.result == 1){
							document.location.href = "${contextPath}/sys/sysuser/home";
						}else if(returninfo.result == -1){
							Ext.MessageBox.alert("登录错误", "用户名有误或已被禁用！", function(){
		
							});
						}else if(returninfo.result == -2){
							Ext.MessageBox.alert("登录错误", "密码错误！", function(){
		
							});
						}else{
							Ext.MessageBox.alert("登录错误", "服务器错误！", function(){
		
							});
						}
					}
				});
			}
		</script>
		<style>
			#bgcc {
				position: absolute;
				width: 1019px;
				height: 577px;
				left: 40%;
				top: 35%;
				margin-left: -325px;
				margin-top: -149px;
			}
			
			#content {
				position: absolute;
				left: 221px;
				top: 111px;
				width: 582px;
				height: 296px;
				background-image: url('static/img/bg1.png');
			}
			
			.inputcss-userName {
				position: absolute;
				width: 200px;
				height: 30px;
				background: transparent;
				border: 0px solid #ffffff;
				font-size: 15px;
				left: 335px;
				top: 131px;
				top: 136px\9;
			}
			
			.inputcss-password {
				position: absolute;
				width: 200px;
				height: 30px;
				background: transparent;
				border: 0px solid #ffffff;
				font-size: 15px;
				left: 335px;
				top: 169px;
				top: 172px\9;
			}
			
			.save {
				position: absolute;
				left: 335px;
				top: 213px;
			}
			
			.reset {
				position: absolute;
				left: 410px;
				top: 213px;
			}
		</style>
	</head>
	<body>
		<div id="bgcc">
			<div id="content">
				<form name="form1" id="form1" method="post" action="${contextPath}/sys/user/login">
					<div>
						<input name="userName" type="text" class="inputcss-userName" id="userName" value="admin"><br>
						<input name="password" type="password" class="inputcss-password" id="password" value="123456">
					</div>
					<div class="save">
						<a href="javascript:login();"> 
							<img src="static/img/btnlogin.png"></img>
						</a>
					</div>
					<div class="reset">
						<a href="#"> 
							<img src="static/img/reset.png"></img>
						</a>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>