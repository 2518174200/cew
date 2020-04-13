package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Reply;
import service.ReplyService;
import service.impl.ReplyServiceImpl;

/**
 * Servlet implementation class AddReply
 */
@WebServlet("/AddReply")
public class AddReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReplyService  rs = new ReplyServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 获得页面上的数据
		int inviId = Integer.parseInt(request.getParameter("inviId"));
		String content = request.getParameter("content");
		String author = request.getParameter("author");
		// 创建需要保存到数据库中的实体类对象
		Reply r = new Reply(inviId, content, author, new Date());
		// 
		boolean isOk = rs.saveReply(r);
		if (isOk) {
			response.sendRedirect("LookReply?inviId="+inviId);
		} else {
			response.sendRedirect("addReply.jsp");
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
