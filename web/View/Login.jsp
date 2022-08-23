<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登入</title>
<link rel="stylesheet" href="../css/Login.css">
<script type="text/javascript" src="../js/jquery.min.js" ></script>
<script type="text/javascript" src="../js/index.js" ></script>
</head>
<body>
<div class="control">
    <div class="item">
        <div class="active">用户</div><div class=active1>管理员</div>
    </div>
    <div class="content">
        <div style="display: block;">
            <form action="UserLoginServlet" method="get">
                <p>账号</p>
                <input type="text" name="userName" placeholder="username" />
                <p>密码</p>
                <input type="password" name="password" placeholder="password"/>
                <br/>
                <button type="submit" style="float:left">登录</button>
            </form>
            <button type="submit"><a href="register.jsp">注册</a></button>
        </div>
    </div>

</div>
</body>
</html>