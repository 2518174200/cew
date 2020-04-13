package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Invitation;
import pojo.Pager;
import service.InvitationService;
import service.impl.InvitationServiceImpl;

/**
 * Servlet implementation class InviList
 */
@WebServlet("/InviList")
public class InviList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // ����һ��ҵ���ӿڶ���
	private InvitationService ins = new InvitationServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InviList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建一个分页类的对象
		Pager pg=new Pager();
		pg.setTotalCount(totalCount);
		// ���û�����ݵķ���
		List<Invitation> list = ins.getInvList();
		request.getSession().setAttribute("list", list);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
