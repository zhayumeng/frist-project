<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台登录</title>
<link rel="stylesheet" href="../css/Login.css">
<script type="text/javascript" src="../js/jquery.min.js" ></script>
<script type="text/javascript" src="../js/index.js" ></script>
</head>
<body>
<div class="control">
    <div class="item">
        <div class="active">用户</div><div class="active1">管理员</div>
    </div>
    <div class="content">
        <div style="display: block;">
            <form action="BsLoginServlet" method="get">
            <p>用户名</p>
            <input type="text" name="BsUserName" placeholder="username" />
            <p>密码</p>
            <input type="password" name="BsPassword" placeholder="password"/>
            <br/>
            <input type="submit" value="登录"/>
        </form>
        </div>
    </div>
</div>
</body>
</html>