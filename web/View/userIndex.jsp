<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="../js/jquery.min.js" ></script>
    <script type="text/javascript" src="../js/index.js" ></script>
    <script src="../js/jquery.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".pay").click(function(){
                $(".tip").fadeIn(200);
            });
        });
    </script>
</head>

<script type="text/javascript">
    function  tijiao(){

        //1，创建异步对象
        var xmlHttp = new XMLHttpRequest()
        //2，绑定事件
        var data ="n";
        xmlHttp.onreadystatechange = function (){
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                data = xmlHttp.responseText;
                //eval是执行括号中的代码，把后台传过来的json字符串转为json对象
                //var jsonobj = eval("("+data+")");

            }
        }
        var price;
        var s=document.getElementById("myselect1").value;
        var bb=document.getElementById("myselect2").value;//通过document.getElementById(“id名”).value来获取value值。
        var userName = document.getElementById("userN").value;
        var type = s.substring(0,3);
        var roomid = s.substring(3,6);
        if(roomid == "101"||roomid == "102"||roomid == "103"){
            price= 100;
        }else{
            price=200;
        }
        var summoney = price*bb;


        var cc=document.getElementById("myselect1").value;
        var dd=document.getElementById("myselect2").value;


        //3，初始异步对象的请求参数
        // true :异步处理请求，使用异步对象发起请求后，不用等待数据处理完毕，
        // 就可以执行其他的操作。可以在send后面，继续创建新的异步对象进行处理。

        // false :同步，当前异步对象必须完成请求，从服务器端获取数据后，
        // 才能执行send之后的代码，任意时刻只能执行一个异步请求。
        xmlHttp.open("get","DingFangServlet?roomid="+roomid+"&type="+type+"&summoney="+summoney+"&userName="+userName+"&day="+dd,false);

        //4，发送请求
        xmlHttp.send();

        if (data == "订房失败"){
            alert("对不起，该房间已经被订购了")
        }else {
            document.getElementById("money").value = summoney;
            alert("您订购的是"+cc);
            alert("时间为"+dd+"天");
            alert("需要支付"+summoney+"元")
        }
    }
</script>
<script>
    function tuifang(){
        //1，创建异步对象
        var xmlHttp = new XMLHttpRequest()
        //2，绑定事件
        xmlHttp.onreadystatechange = function (){
        }
        var s=document.getElementById("myselect1").value;
        var userName = document.getElementById("userN").value;
        var roomid = s.substring(3,6);
        xmlHttp.open("get","UserTuiFangServlet?roomid="+roomid+"&userName="+userName,false);
        var tishi = "尊敬的 "+userName+" 您已经申请退房，等待管理员处理，欢迎下次再来！";
        alert(tishi)

        //4，发送请求
        xmlHttp.send();
    }
</script>

<link rel="stylesheet" href="../css/userIndex.css">

<body>
<div class="top">
    房间类目：  <select id="myselect1">
    <option value="雅致房101" >雅致房101</option>
    <option value="雅致房102" >雅致房102</option>
    <option value="雅致房103" >雅致房103</option>
    <option value="大床房201" >大床房201</option>
    <option value="大床房202" >大床房202</option>
    <option value="大床房203" >大床房203</option>

</select>
    住宿天数： <select id="myselect2">
    <option value="1">1天</option>
    <option value="2">2天</option>
    <option value="3">3天</option>
    <option value="4">4天</option>
    <option value="5">5天</option>
    <option value="6">6天</option>
    <option value="7">7天</option>
</select>

    支付金额：   <input type="text" id="money" placeholder="0元">
    <input type="submit" value="计算" onclick="tijiao()" >

    <button  class="pay">付款</button>
    <input type="submit" value="退房" onclick="tuifang()" style=" position: absolute;
    left: 1350px;">
    <button class="zhuxiao"><a href="Login.jsp" >退出登录</a></button>


</div>

<div class="centre">
    <div class="yazhi101">
        <div class="tupian"></div>
        <div class="jieshao">
            <p> 雅致房101</p>
            <p> 该房间价格为100/天</p>
            <p> 状态为：空闲中 </p>
        </div>
    </div>
    <div class="yazhi102">
        <div class="tupian"></div>
        <div class="jieshao">
            <p> 雅致房102</p>
            <p> 该房间价格为100/天</p>
            <p> 状态为：空闲中</p>
        </div>
    </div>
    <div class="yazhi103">
        <div class="tupian"></div>
        <div class="jieshao">
            <p>     雅致房103</p>
            <p>     该房间价格为100/天</p>
            <p>     状态为：空闲中 </p>
        </div>
    </div>


</div>
<div class="last">
    <div class="dachuang201">
        <div class="tupian2"></div>
        <div class="jieshao">
            <p>   大床房201</p>
            <p>   该房间价格为200/天</p>
            <p>   状态为：空闲中 </p>
        </div>
    </div>
    <div class="dachuang202">
        <div class="tupian2"></div>
        <div class="jieshao">
            <p>   大床房202</p>
            <p>   该房间价格为200/天</p>
            <p>   状态为：空闲中 </p>
        </div>
    </div>
    <div class="dachuang203">
        <div class="tupian2"></div>
        <div class="jieshao">
            <p>   大床房203</p>
            <p>   该房间价格为200/天</p>
            <p>   状态为：空闲中 </p>
        </div>
    </div>

    <div class="tip">
        <div class="xiugai">
            <img src="../images/money2.jpg">
        </div>
        <div class="xiugai">
            <img src="../images/money1.jpg">
        </div>

        <div class="tipbtn">
            <%-- <input name="" type="submit"  class="sure" value="完成付款" />--%>
            <button type="submit" class="sure" id="userN" value="${userLoginName}"><a href="userIndex.jsp">完成付款</a></button>
        </div>
    </div>

</div>
</body>
</html>