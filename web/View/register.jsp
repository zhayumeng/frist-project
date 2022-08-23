<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<link rel="stylesheet" href="../css/register.css">
  
<title>注册页面</title>
</head>
<body>
   <div class="register"> 
        <!-- <img src="../image/register.jpg" alt="">  -->
     <h1 >注册页面</h1>
       <form action="AddUserServlet" method="get">
     账号ID：  <input type="text" name="userId"  placeholder="请输入ID号" ><br>
     用户名：  <input type="text" name="userName"   placeholder="请输入用户名"><br>
     密码：  <input type="text" name="userPassword"  placeholder="请输入密码"><br>
     身份证号：<input type="text" name="idCard"  placeholder="请输入身份证号"><br>
    <input type="submit" value="注册">
    <a href="Login.jsp">取消注册去登录</a>
       </form>
    </div>
</body>
</html>