package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Reply;
import service.ReplyService;
import service.impl.ReplyServiceImpl;

/**
 * Servlet implementation class LookReply
 */
@WebServlet("/LookReply")
public class LookReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // ���������ظ���Ϣ��ҵ�����
	private ReplyService ps = new ReplyServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ô��ݹ�����id����
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("inviId"));
		// �����id���ݱ��浽session��
		request.getSession().setAttribute("inviId", id);
		// �����id�����лظ���Ϣ��ѯ���������ҽ��������õ��ظ��н��в鿴
		List<Reply> rlist = ps.getReplyList(id);
		// ��������ϱ��浽��������
		request.getSession().setAttribute("rlist", rlist);
		// ҳ����ת
		response.sendRedirect("replyDetials.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
