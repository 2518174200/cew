package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Invitation;
import service.InvitationService;
import service.impl.InvitationServiceImpl;

/**
 * Servlet implementation class FindByTitle
 */
@WebServlet("/FindByTitle")
public class FindByTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InvitationService invis = new InvitationServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByTitle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置请求的字符编码
		request.setCharacterEncoding("UTF-8");
		// 获得需要查询的标题内容
		String title = request.getParameter("title");
		List<Invitation> list = new ArrayList<Invitation>();
		if (title == null || "".equals(title)) {
			list = invis.getInvList();
		}else {
			// 调用业务层中通过标题名称进行模糊查询的方法
			list = invis.findyByTitle(title);
		}
		// 将找打的数据设置到页面上
		request.getSession().setAttribute("list", list);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
