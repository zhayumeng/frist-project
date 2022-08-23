package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ManagerTuiFangServlet", value = "/View/ManagerTuiFangServlet")
public class ManagerTuiFangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String userName = request.getParameter("name");
        String roomId = request.getParameter("roomid");
        String  result ="";
        if ("101".equals(roomId)||"102".equals(roomId)||"103".equals(roomId)||"201".equals(roomId)||"202".equals(roomId)||"203".equals(roomId)){
            result= roomId + "房间" + userName + "需要办理退房";
        }else {
            result = "暂时没有用户需要办理退房";
        }



        System.out.println(userName);
        System.out.println(roomId);
        System.out.println(result);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(result);
        pw.flush();
        pw.close();
    }


}
