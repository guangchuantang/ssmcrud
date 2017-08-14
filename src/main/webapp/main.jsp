<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>登录</title>
	<script type="text/javascript">
	<c:choose>
	<c:when test="${not empty error}">//若错误不为空，则弹出错误提示
        
		$("#msg").html("${msg}").fadeIn(5000).fadeOut(5000); 
		//$("#login_tel").css("border","red 1px solid");
		
	
	</c:when>
	</c:choose>
    </script>
  </head> 
  <body>
    <h3>欢迎${user.userName}登录XXX管理系统</h3>
    <h4 id="msg"></h4>
    <a href="<%=basePath%>user/selectUser">查询</a>
    <a href="<%=basePath%>user/delete?id=1">删除</a>
    <a href="<%=basePath%>register.jsp">注册</a>
  </body>
</html>
