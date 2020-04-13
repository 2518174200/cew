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
    // 创建操作回复信息的业务对象
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
		// 获得传递过来的id数据
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("inviId"));
		// 将这个id数据保存到session中
		request.getSession().setAttribute("inviId", id);
		// 将这个id的所有回复信息查询出来，并且将数据设置到回复中进行查看
		List<Reply> rlist = ps.getReplyList(id);
		// 将这个集合保存到作用域中
		request.getSession().setAttribute("rlist", rlist);
		// 页面跳转
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
