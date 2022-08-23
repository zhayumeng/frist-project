package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.Impt.OpenRoomServiceImpt;
import service.OpenRoomService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ORQuerySumMoneyServlet", value = "/View/ORQuerySumMoneyServlet")
public class ORQuerySumMoneyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //跳转进来直接查询总收入
        OpenRoomService ors = new OpenRoomServiceImpt();
        int sumMoney = ors.querySumMoney();
        System.out.println(sumMoney);

        // EL表达式拿的值必须在作用域中，常用的是session
        HttpSession session = request.getSession();
        session.setAttribute("sum", sumMoney);
        // 跳转
        response.sendRedirect("/hotelManagerSystem/View/tj.jsp");

//        response.setContentType("application/json;charset=utf-8");
//        PrintWriter pw = response.getWriter();
//        pw.println(sumMoney);//输出数据---会赋值给ajax中，responseText属性
//        pw.flush();
//        pw.close();
    }

}
