package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.InvitationService;
import service.impl.InvitationServiceImpl;

/**
 * Servlet implementation class DeleteInvi
 */
@WebServlet("/DeleteInvi")
public class DeleteInvi extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InvitationService invis = new InvitationServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInvi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int inviId = Integer.parseInt(request.getParameter("id"));
		// 调用业务层中删除指定ID帖子的方法
		boolean isOk = invis.deleteInviById(inviId);
		if(isOk) {
			response.sendRedirect("InviList");
		}else {
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
