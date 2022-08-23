<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>开房管理</title>
    <link rel="stylesheet" href="../css/fj.css">
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
    <div class="leftTiyle" id="flTitle">开房管理</div>
    <div class="thisUser">当前管理员:查裕盟</div>
</div>

<%--ORQueryAllServlet--%>
<div class="tools">
    <form action="OpenRoomReconrdServlet?currentPage=1" method="get" style="float: left">
        <button class="btn1"><img src="../images/search.png" class="tupian" />查询开房记录</button>
    </form>
    <form action="ORQueryByNameServlet" method="get" style="float: right">
        <img src="../images/t01.png" class="tupian1" /><input type="text" name="selectByName" placeholder="根据名字查询开房记录" class="like">
    </form>


</div>
<table class="tablelist" border="1">
    <thead>
    <tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>开房记录id<i class="sort"></i></th>
        <th>房主姓名</th>
        <th>身份证号</th>
        <th>房间id</th>
        <th>房间类型</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>住房天数</th>
        <th>费用总计</th>
        <th>操作</th>
    </tr>
    </thead>

    <tbody>
    <c:if test="${not empty p.openRoomReconrds}">
        <c:forEach items="${p.openRoomReconrds}" var="OpenRoomReconrd" varStatus="s">
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>${OpenRoomReconrd.reconrdRoomId}</td>
                <td>${OpenRoomReconrd.userName}</td>
                <td>${OpenRoomReconrd.idCard}</td>
                <td>${OpenRoomReconrd.roomId}</td>
                <td>${OpenRoomReconrd.roomType}</td>
                <td>${OpenRoomReconrd.startTime}</td>
                <td>${OpenRoomReconrd.endTime}</td>
                <td>${OpenRoomReconrd.day}</td>
                <td>${OpenRoomReconrd.money}</td>
                <td><a href="ORDeleteServlet?id=${OpenRoomReconrd.reconrdRoomId}" style="color: red"> 删除</a></td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>

<div style="float: right;
                      text-align: center;
                      width: 80%;
                      margin-top: 40px;
                      font-size: 20px;">
    <a href="OpenRoomReconrdServlet?currentPage=${p.currentPage-1 }" style="color: black;">上一页</a>
    <a href="OpenRoomReconrdServlet?currentPage=${p.currentPage+1 }" style="color: black;">下一页</a>
    <a href="OpenRoomReconrdServlet?currentPage=${p.totalPage}" style="color: black;">末页</a>
    第<input type="text" value="${p.currentPage}" style="width:20px;height:20px;">/${p.totalPage}页


</div>

</body>
</html>