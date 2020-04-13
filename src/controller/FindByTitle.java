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
		// ����������ַ�����
		request.setCharacterEncoding("UTF-8");
		// �����Ҫ��ѯ�ı�������
		String title = request.getParameter("title");
		List<Invitation> list = new ArrayList<Invitation>();
		if (title == null || "".equals(title)) {
			list = invis.getInvList();
		}else {
			// ����ҵ�����ͨ���������ƽ���ģ����ѯ�ķ���
			list = invis.findyByTitle(title);
		}
		// ���Ҵ���������õ�ҳ����
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
