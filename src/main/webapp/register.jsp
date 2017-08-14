<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>登录</title>
  </head>
  
  <body>
      <form method="post" action="user/addUser">
            用户名：<input type="text" name="userName"><br><br>
            密码： <input type="password" name="password"><br><br>
            年龄： <input type="text" name="age"><br><br> 
           <input type="submit" value="注册">
      </form>
  </body>
</html>
