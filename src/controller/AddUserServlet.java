package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Impt.UserServiceImpt;
import service.UserService;




@WebServlet(name = "AddUserServlet", value = "/View/AddUserServlet")
public class AddUserServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		//获取注册信息
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String idCard = request.getParameter("idCard");
		if (!(userId.equals("") || userName.equals("") || userPassword.equals("") || idCard.equals(""))) {
			UserService usi = new UserServiceImpt();
			usi.insert(Integer.parseInt(userId), userName, userPassword, idCard);

			// 跳转
			response.sendRedirect("/hotelManagerSystem/View/Login.jsp");
		}else {
			response.setHeader("refresh","0;url=register.jsp");
		}
	}


}
