package controller;

import bean.OpenRoomReconrd;
import bean.Page;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import net.sf.json.JSONArray;
import service.Impt.OpenRoomServiceImpt;
import service.OpenRoomService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ORQueryByNameServlet", value = "/View/ORQueryByNameServlet")
public class ORQueryByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String userName = request.getParameter("userName");
        String selectByName = request.getParameter("selectByName");
        OpenRoomService ors = new OpenRoomServiceImpt();
        List<OpenRoomReconrd> OpenRoomReconrd = ors.queryByName(selectByName);
        System.out.println(OpenRoomReconrd);

        //展示所查询的数据
        Page p = new Page();
        int currrentPage = 1;

        int pageSize = 5;
        p.setPageSize(pageSize);//把设置每页展示的数量
        p.setTotalPage(currrentPage);//设置总页数为 1

        //最后设置当前页
        p.setCurrentPage(currrentPage);

        p.setOpenRoomReconrds(OpenRoomReconrd);

        request.getSession().setAttribute("p", p);

        request.getSession().setAttribute("OpenRoomReconrd", OpenRoomReconrd);
        // 跳转
        response.sendRedirect("/hotelManagerSystem/View/kf.jsp");


//        JSONArray jsonArray = JSONArray.fromObject(list);
//        System.out.println(jsonArray.toString());


//        response.setContentType("application/json;charset=utf-8");
//        PrintWriter pw = response.getWriter();
//        pw.println(jsonArray.toString());//输出数据---会赋值给ajax中，responseText属性
//        pw.flush();
//        pw.close();

    }

}
