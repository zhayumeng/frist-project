package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserTuiFangServlet", value = "/View/UserTuiFangServlet")
public class UserTuiFangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取房间id，根据房间id进行修改房间状态
        String roomId = request.getParameter("roomid");
        //拿到用户名字
        String userName = request.getParameter("userName");

        System.out.println(roomId);
        System.out.println(userName);
        request.getSession().setAttribute("UserTFrooId",roomId);
        request.getSession().setAttribute("UserTFname",userName);
        String mamamam = roomId+"房间"+userName+"需要办理退房";
        System.out.println(mamamam);
        response.sendRedirect("/hotelManagerSystem/View/userIndex.jsp");

        //使用HttpServletResponse输出数据
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter pw = response.getWriter();
//
//        pw.println(mamamam);
//        System.out.println(mamamam);
//        pw.flush();
//        pw.close();
    }

}
