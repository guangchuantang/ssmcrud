<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>jQuery站点后台登录表单代码 -爱编程实例，分享jQuery、html5、css3等插件</title>
<meta name="author" content="DeathGhost">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/Particleground.js"></script>
<script src="${pageContext.request.contextPath}/js/verificationNumbers.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
  //测试提交
  $(".submit_btn").click(function(){
	  var bool=validate();
	  if(bool){
		  document.getElementById("myform").submit();    
	  }
  }); 
});
</script>
</head>
<body>
<form method="post" id="myform" action="<%=basePath%>user/loginUser">
<dl class="admin_login">
 <dt>
  <strong>欢迎登陆XXX后台管理系统</strong>
  
 </dt>
 
 <span id="error" style="color:red"></span>

 <dd class="user_icon">
  <input type="text" placeholder="账号" class="login_txtbx" name="name" id="name">
 </dd>
 <dd class="pwd_icon">
  <input type="password" placeholder="密码" class="login_txtbx" name="pwd" id="pwd">
 </dd>
 <dd class="val_icon">
  <div class="checkcode">
    <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
    <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
  </div>
 </dd>
 <dd>
  <input type="button" value="立即登陆" class="submit_btn">
 </dd>
 <dd>
 <p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
 </dd>
</dl>
</form>
<script type="text/javascript">
	<c:choose>
	<c:when test="${not empty error}">//若错误不为空，则弹出错误提示
		$("#error").html("${error}").fadeIn(10000).fadeOut(10000); 
		//$("#login_tel").css("border","red 1px solid");
	</c:when>
	</c:choose>
</script>
</body>
</html>
