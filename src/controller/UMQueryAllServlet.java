package controller;

import bean.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import net.sf.json.JSONArray;
import service.Impt.UserManagerServiceImpt;
import service.UserManagerService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UMQueryAllServlet", value = "/View/UMQueryAllServlet")
public class UMQueryAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        
        UserManagerService ums = new UserManagerServiceImpt();
        List<User> userList = ums.queryAllUser();
        System.out.println(userList);

        JSONArray jsonArray = JSONArray.fromObject(userList);
        System.out.println(jsonArray.toString());

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonArray.toString());
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}
