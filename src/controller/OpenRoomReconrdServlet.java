package controller;

import bean.OpenRoomReconrd;
import bean.Page;
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

@WebServlet(name = "OpenRoomReconrdServlet", value = "/View/OpenRoomReconrdServlet")
public class OpenRoomReconrdServlet extends HttpServlet {

    @Override//处理分页数据请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //默认是第一页数据
            int currrentPage;

            String cPate = request.getParameter("currentPage");
            if (cPate ==null){
                cPate = "1";
            }
            currrentPage = Integer.parseInt(cPate);

            //防止上一页越界
            if (currrentPage <1) {
                currrentPage = 1;

            }

            Page p = new Page();

            OpenRoomService ors = new OpenRoomServiceImpt();

            //拿到总条数
            int totalCount = ors.queryTotalCount();
            p.setTotalCount(totalCount);//给该对象，赋总条数的值


            int pageSize = 5;
            p.setPageSize(pageSize);//把设置每页展示的数量


            //防止下一页越界
            int totalPage = p.getTotalPage();
            if (currrentPage > totalPage){
                currrentPage = totalPage;
            }

            //最后设置当前页
            p.setCurrentPage(currrentPage);

            //查询当前页的数据，并加入到该对象中去。
            List<OpenRoomReconrd> openRoomReconrds = ors.queryPageRecords(currrentPage, pageSize);
            p.setOpenRoomReconrds(openRoomReconrds);

            request.getSession().setAttribute("p", p);


            System.out.println("two被访问了");//证明ORDeleteServlet进来过执行了
            if (p.getOpenRoomReconrds() != null) {
                    request.getRequestDispatcher("kf.jsp").forward(request, response);
                }

    }

}
