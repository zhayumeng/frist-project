<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>房间管理</title>
<link rel="stylesheet" href="../css/fj.css">
<script type="text/javascript" src="../js/jquery.min.js" ></script>
<script type="text/javascript" src="../js/index.js" ></script>
<script src="../js/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".btn2").click(function(){
  $(".tip").fadeIn(200);
  });
});
</script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".btn").click(function(){
                $(".tuifang").fadeIn(200);
            });
        });
    </script>
<script>
        function  tete(){
            //1，创建异步对象
            var xmlHttp = new XMLHttpRequest()
            //2，绑定事件

            xmlHttp.onreadystatechange = function (){
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    document.getElementById("xiaoxi").value = xmlHttp.responseText;
                }
            }
            var roomid =  document.getElementById("UserTFId").value;
            var name =  document.getElementById("userNam").value;
            xmlHttp.open("get","ManagerTuiFangServlet?name="+name+"&roomid="+roomid,false);

            //4，发送请求
            xmlHttp.send();
        }
        function qingkong(){
            //1，创建异步对象
            var xmlHttp = new XMLHttpRequest()
            //2，绑定事件

            xmlHttp.onreadystatechange = function (){
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                   document.getElementById("UserTFId").value =xmlHttp.responseText;
                   document.getElementById("userNam").value =xmlHttp.responseText;
                   document.getElementById("xiaoxi").value = xmlHttp.responseText;
                }
            }
            var roomid =  document.getElementById("UserTFId").value;
            var name =  document.getElementById("userNam").value;
            xmlHttp.open("get","ManagerTuiFangServlet?name="+name+"&roomid="+10,false);

            //4，发送请求
            xmlHttp.send();
        }
</script>
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
            <div class="leftTiyle" id="flTitle">房间管理</div>
            <div class="thisUser">当前管理员:查裕盟</div>
        </div>
        <div class="tools">
            <form action="RMQueryAllServlet" style="float: left">
                <button type="submit" class="btn1"><img src="../images/search.png" class="tupian" />查询房间信息</button>
            </form>

            <button class="btn2"><img src="../images/t02.png" class="tupian" />根据房间id修改房间信息</button>

    </div>
        <table class="tablelist" border="1">
            <thead>
            <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>房间id<i class="sort"></i></th>
            <th>房间类型</th>
            <th>房间价格</th>
            <th>房间状态</th>
            <th>房间介绍</th>
            <th>办理退房</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${rooms}" var="room" varStatus="s">
            <tr>
            <td><input name="" type="checkbox" value="" /></td>
            <td>${room.roomId}</td>
            <td>${room.roomType}</td>
            <td>${room.price}</td>
            <td>${room.status}</td>
            <td>${room.introduce}</td>
            <td><a  onclick="qingkong()" href="TuiFangServlet?roomId=${room.roomId}" style="color: red">退房</a></td>
            </tr>
             </c:forEach>
            </tbody>
        </table>

        <form action="RMUpdateRoomIfmServlet" method="get">

        <div class="tip">
            <p>修改</p>
            <div class="xiugai">
            <input type="text" name="rooEd" placeholder="根据房间id修改">
            <input type="text" name="roomType" placeholder="房间类型">
            <input type="text" name="price"  placeholder="房间单价">
            <input type="text" name="introduce" placeholder="房间介绍">
            </div>

            <div class="tipbtn">
            <input name="" type="submit"  class="sure" value="确定" style="color: #00dd60"/>&nbsp;
                <button type="button" class="cancel" value="取消"><a href="fj.jsp" style="color: #00dd60">取消</a></button>
            </div>
        </div>
        </form>

        <button id="userNam" value="${UserTFname}" onclick="tete()" style="
                position:absolute;
                text-align: center;
                margin-left: 20%;
                margin-top: 700px;
                width: 80%;
                font-size: 25px;" class="btn"><img src="../images/dp.png"  style=" width: 20px;
                                       height:20px;
                                       margin-top: 10px;">消息</button>
        <div style="width:282px;
                    height:260px;
                    position:absolute;
                    top: 20%;
                    left: 50%;
                    background:#fcfdfd;
                    box-shadow:1px 8px 10px 1px #9b9b9b;
                    border-radius:1px;
                    display:none;
                    z-index:111111;" class="tuifang">

            <input type="text" id="xiaoxi" placeholder="暂时没有用户退房的消息"  style="height: 220px;width: 274px;text-align: center;font-size: 21px">
            <div class="tipbtn">
<%--                <input name="" type="button"  class="sure" value="确定" />&nbsp;--%>
                <button id="UserTFId" type="button" class="cancel" value="${UserTFrooId}" style="width: 282px;text-align: center"><a href="fj.jsp" style="color: #00d;">取消</a></button>
            </div>
        </div>
    </body>
</html>