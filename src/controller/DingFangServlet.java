package controller;

import bean.Room;
import bean.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.Impt.OpenRoomServiceImpt;
import service.Impt.RoomManagerServiceImpt;
import service.Impt.UserServiceImpt;
import service.OpenRoomService;
import service.RoomManagerService;
import service.UserService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "DingFangServlet", value = "/View/DingFangServlet")
public class DingFangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String roomid = request.getParameter("roomid");
        //通过房间id查询房间状态，如果房间状态不为使用中，才能进行订房，
        // 房间在使用中，提示不能进行订房
        RoomManagerService rmsi = new RoomManagerServiceImpt();
        List<Room> room = rmsi.queryOne(Integer.parseInt(roomid));
        String occupy ="使用中";
        String roomStatuss = "";
        for (Room s :room){
            roomStatuss = s.getStatus();
        }
        System.out.println(roomid);
        System.out.println(roomStatuss);
        if (roomStatuss.equals(occupy)) {
            System.out.println("订房失败");
            response.getWriter().write("订房失败");
        }else {
            System.out.println("进来订房了");
        //根据roomid 去修改房间状态
        rmsi.updateStatus(Integer.parseInt(roomid),occupy);

        String userName = request.getParameter("userName");
        //拿到用户名字，去查询出该用户的信息

        UserService usi = new UserServiceImpt();
        List<User> users = usi.queryUserByName(userName);
        String idCard ="";
        for (User s :users){
            idCard = s.getIdCard();
        }

        String roomType = request.getParameter("type");

        String day = request.getParameter("day");
        int dayCount = Integer.parseInt(day);
        Date nowDate = new Date();
        Date lastTime = new Date(nowDate.getTime()+1000*60*60*24*dayCount);
		SimpleDateFormat time=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String startTime = time.format(nowDate);
        String endTime = time.format(lastTime);
        String s = endTime.substring(0, 10);
        String hh= endTime.substring(11, 13);
        String mm = endTime.substring(14, 16);
        String ss = endTime.substring(17, 19);
        hh = " 12:";  mm = "00:";  ss = "00";
        String eTiem = s+hh+mm+ss;

        String summoney = request.getParameter("summoney");

        OpenRoomServiceImpt ors = new OpenRoomServiceImpt();
        boolean insert = ors.insert(userName, idCard, Integer.parseInt(roomid), roomType, startTime, eTiem, Integer.parseInt(summoney), dayCount);

        }
    }

}
