package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BsLoginServlet", value = "/View/BsLoginServlet")
public class BsLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String bsUserName = request.getParameter("BsUserName");
        String bsPassword = request.getParameter("BsPassword");
        if ("查裕盟".equals(bsUserName) && "zym".equals(bsPassword)){
            response.sendRedirect("/hotelManagerSystem/View/dr.jsp");
        }else {
            //调转到当前登录页面
            response.setHeader("refresh","0;url=BsLogin.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
