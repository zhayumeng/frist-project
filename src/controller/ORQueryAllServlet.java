package controller;

import bean.OpenRoomReconrd;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import service.Impt.OpenRoomServiceImpt;
import service.OpenRoomService;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ORQueryAllServlet", value = "/View/ORQueryAllServlet")
public class ORQueryAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        //设置编码防止乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        //直接查询出所有开房信息
        OpenRoomService ops = new OpenRoomServiceImpt();
        List<OpenRoomReconrd> OpenRoomReconrd = ops.queryAll();
        // EL表达式拿的值必须在作用域中，常用的是session
        // HttpSession session = request.getSession();
        // session.setAttribute("OpenRoomReconrd", OpenRoomReconrd);
        // 跳转
        // response.sendRedirect("/hotelManagerSystem/View/kf.jsp");

        /*json 数据格式有两种，
            一，json对象格式
                {"id":1,"name":"张三","sex":"男"}
            二，json数组格式
                [{"id":1,"name":"张三","sex":"男"},{"id":2,"name":"李四","sex":"女"}]
        */
        //需要使用JSONArray.fromObject把 List<OpenRoomReconrd>  集合转为  json数组格式
        System.out.println(OpenRoomReconrd);
        JSONArray jsonArray = JSONArray.fromObject(OpenRoomReconrd);
        System.out.println(jsonArray);
//        System.out.println("JSONArray对象数据格式：");
//        System.out.println(jsonArray.toString());


        //把获取的数据，通过网络传给ajax中的异步对象，响应结果数据
        //指定服务器端（servlet）返回给游览器的是json格式的数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonArray.toString());//输出数据---会赋值给ajax中，responseText属性
        pw.flush();
        pw.close();
    }
}
