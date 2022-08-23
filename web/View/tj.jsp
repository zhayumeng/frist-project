<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>统计管理</title>
    <link rel="stylesheet" href="../css/tj.css">
    <script type="text/javascript" src="../js/jquery.min.js" ></script>
    <script type="text/javascript" src="../js/index.js" ></script>
</head>
<body>
<div class="left">
    <div class="bigTitle">酒店后台管理系统</div>
    <div class="lines">
        <div onclick="pageClick(this)" class="code0"><img src="../images/bp1.png" /><a href="dr.jsp">登录管理</a></div>
        <div onclick="pageClick(this)" class="code"><img src="../images/bp2.jpg" /><a href="fj.jsp">房间管理</a></div>
        <div onclick="pageClick(this)" class="code1"><img src="../images/bp3.png" /><a href="kf.jsp">开房管理</a></div>
        <div onclick="pageClick(this)" class="code2"><img src="../images/bp4.jpg " /><a href="tj.jsp">统计管理</a></div>
        <div onclick="pageClick(this)" class="code3"><img src="../images/bp5.jpg" /><a href="yh.jsp">用户管理</a></div>
    </div>
</div>
<div class="top">
    <div class="leftTiyle" id="flTitle">统计管理</div>
    <div class="thisUser">当前管理员:查裕盟</div>
</div>
<div class="tools">
    <img src="../images/qian1.webp" alt="">
</div>
<table class="tablelist">
</table>

<form action="ORQuerySumMoneyServlet" method="get">
    <button class="btn"><img src="../images/t04.png" class="tupian1">利润</button>
</form>
<%--<a href="ORQuerySumMoneyServlet">fads</a>--%>
<p class="xsss">${sum}</p>

</body>
</html>