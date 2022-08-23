package controller;

import bean.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.Impt.UserServiceImpt;
import service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserLoginServlet", value = "/View/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        //先查询出来所有的用户
        UserService us = new UserServiceImpt();
        List<User> userList = us.queryAllUsers();

        List<User> i = new ArrayList<>();
        User user = new User();
        User user1 = new User();
        i.add(user);
        i.add(user1);
       for (User s :userList){
           if (userName.equals(s.getUserName())&&password.equals(s.getUserPassword())){

               // 把登录的姓名和密码给前端使用
               HttpSession session = request.getSession();
               session.setAttribute("userLoginName", userName);
               session.setAttribute("userLoginPassword",password);
               // 跳转
               response.sendRedirect("/hotelManagerSystem/View/userIndex.jsp");
           }else {
               //调转到当前登录页面
               response.setHeader("refresh","0;url=Login.jsp");
           }


       }
    }

}
