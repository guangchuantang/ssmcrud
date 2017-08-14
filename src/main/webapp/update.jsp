<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>登录</title>
  </head>
  
  <body>
      <form method="post" action="<%=basePath%>user/updateById">
      <input type="hidden" name="id" value="${User.id}"><br><br>
            用户名：<input type="text" name="userName" value="${User.userName}"><br><br>
            密码： <input type="text" name="password" value="${User.password}"><br><br>
            年龄： <input type="text" name="age" value="${User.age}"><br><br> 
           <input type="submit" value="修改">
      </form>
  </body>
</html>
