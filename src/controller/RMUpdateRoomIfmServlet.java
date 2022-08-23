package controller;

import bean.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.Impt.RoomManagerServiceImpt;
import service.RoomManagerService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RMUpdateRoomIfmServlet", value = "/View/RMUpdateRoomIfmServlet")
public class RMUpdateRoomIfmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String roomId = request.getParameter("rooEd");
        if ("101".equals(roomId) || "102".equals(roomId) || "103".equals(roomId) || "201".equals(roomId) || "202".equals(roomId) || "203".equals(roomId)) {
            int id = Integer.parseInt(roomId);
            System.out.println("333");
            String roomType = request.getParameter("roomType");
            String price = request.getParameter("price");
            String introduce = request.getParameter("introduce");
            RoomManagerService rms = new RoomManagerServiceImpt();
            System.out.println(id);
            System.out.println(roomType);
            System.out.println(price);
            System.out.println(introduce);

            //一旦需要修改的值没有填写，则不进行修改
            if (!("".equals(roomType) || "".equals(price) || "".equals(introduce))){
                boolean updateRoomIfmSucc = rms.updateRoomIfm(id, roomType, Integer.parseInt(price), introduce);
            }

            RoomManagerService rm = new RoomManagerServiceImpt();
            List<Room> rooms = rm.selectAll();
            System.out.println(rooms);
            // EL表达式拿的值必须在作用域中，常用的是session
            HttpSession session = request.getSession();
            session.setAttribute("rooms", rooms);
            // 跳转
            response.sendRedirect("/hotelManagerSystem/View/fj.jsp");
        }else {
           // response.setHeader("refresh","0;url=fj.jsp");
            response.sendRedirect("/hotelManagerSystem/View/fj.jsp");
        }
    }

}
