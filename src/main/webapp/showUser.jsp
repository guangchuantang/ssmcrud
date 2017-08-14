<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>用户信息显示</title>
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script>
	       function select(){
	    	   var name=$("#name").val();
	    	   $.ajax({
	    		   type:"get",//请求方式
	    		   url:'<%=path%>/user/selectUserByName?',
	    		   data:{name:name},//提交到服务器接口的参数
	    		   dataType:'json',//请求类型为json
	    	       async:true,//是否为异步请求，默认为true
	    	       timeout:7000,//请求超时后停止请求
	    	       success:function(data){
	    	    	   var d = data.list;
	    	    	   var s = "";
	    	    	   $.each(d,function(i){
	    	                s+=('<p>id:'+d[i].age +'  |  name:'+d[i].userName+'</p><hr/>');
	    	            });
	    	            $('#out').html(s);
	    	          }
	    		   });
	       }
	</script>
  </head>
  
  <body>
        根据用户名查询：<input type="text" id="name" name="name"><button id="btn1" onclick="select()">查询</button> 
        <div id="out"></div>
        <table>
             <tr>
                <td>姓名</td>
                <td>密码</td>
                <td>年龄</td>
                <td>操作</td>
                <td>结果</td>
             </tr>
             <c:forEach items="${json.data}" var="User">
             <tr>
                <td>${User.userName}</td>
                <td>${User.password}</td>
                <td>${User.age}</td>
                <td><a href="<%=basePath%>user/delete?id=${User.id}">删除</a>  
                <a href="<%=basePath%>user/showUser?id=${User.id}">修改</a></td>
                <td>${User.userName}</td>
             </tr>
             </c:forEach>
        </table>
  </body>
</html>
