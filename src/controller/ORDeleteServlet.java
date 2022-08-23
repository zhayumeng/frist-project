package controller;

import bean.OpenRoomReconrd;
import bean.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.Impt.OpenRoomServiceImpt;
import service.Impt.RoomManagerServiceImpt;
import service.OpenRoomService;
import service.RoomManagerService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ORDeleteServlet", value = "/View/ORDeleteServlet")
public class ORDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String reconrdRoomId = request.getParameter("id");
       int delectId = Integer.parseInt(reconrdRoomId);
        OpenRoomService ors = new OpenRoomServiceImpt();
        boolean deleteSucc = ors.delete(delectId);

        //删除之后，再次重新查询开房记录表中的数据
        OpenRoomService ops = new OpenRoomServiceImpt();
        List<OpenRoomReconrd> OpenRoomReconrd = ops.queryAll();
        // EL表达式拿的值必须在作用域中，常用的是session
        HttpSession session = request.getSession();
        session.setAttribute("OpenRoomReconrd", OpenRoomReconrd);
        // 跳转
        System.out.println("one被访问了");

        //重定向，跳转到/View/OpenRoomReconrdServlet这个servlet里面
        RequestDispatcher report = request.getRequestDispatcher("/View/OpenRoomReconrdServlet");
        report.forward(request,response);
        response.sendRedirect("/hotelManagerSystem/View/kf.jsp");

    }
}
