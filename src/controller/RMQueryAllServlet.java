package controller;

import bean.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import net.sf.json.JSONArray;
import service.Impt.RoomManagerServiceImpt;
import service.RoomManagerService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "RMQueryAllServlet", value = "/View/RMQueryAllServlet")
public class RMQueryAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RoomManagerService rms = new RoomManagerServiceImpt();
        List<Room> rooms = rms.selectAll();

        // EL表达式拿的值必须在作用域中，常用的是session
        HttpSession session = request.getSession();
        session.setAttribute("rooms", rooms);
        // 跳转
        response.sendRedirect("/hotelManagerSystem/View/fj.jsp");



//        JSONArray jsonArray = JSONArray.fromObject(roomList);
//        System.out.println(jsonArray.toString());
//        response.setContentType("application/json;charset=utf-8");
//        PrintWriter pw = response.getWriter();
//        pw.println(jsonArray.toString());//输出数据---会赋值给ajax中，responseText属性
//        pw.flush();
//        pw.close();
    }

}
