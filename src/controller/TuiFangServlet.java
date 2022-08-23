package controller;

import bean.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.Impt.RoomManagerServiceImpt;
import service.RoomManagerService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "TuiFangServlet", value = "/View/TuiFangServlet")
public class TuiFangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取房间id，根据房间id进行修改房间状态
        String roomId = request.getParameter("roomId");

        //拿到房间id,现在将空闲的状态更新到该房间中去
        String roomStatus = "空闲";
        RoomManagerService rmsi = new RoomManagerServiceImpt();
        boolean b = rmsi.updateStatus(Integer.parseInt(roomId), roomStatus);
        System.out.println(b);
        List<Room> rooms = rmsi.selectAll();

        HttpSession session = request.getSession();
        session.setAttribute("rooms", rooms);

        // 跳转
        response.sendRedirect("/hotelManagerSystem/View/fj.jsp");

    }

}
