package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReplyService;
import vo.Reply;

@WebServlet("/reply")
public class ReplyServlet extends HttpServlet{
	private ReplyService service=ReplyService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		String path="";
		if(type.equals("replyForm")) {
			String articleNum=request.getParameter("articleNum");
			request.setAttribute("articleNum", articleNum);
			path="qa/reply_form.jsp";
		}else if(type==null) {
			
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		String path="";
		
		if(type.equals("replyWrite")) {
			Reply reply=new Reply();
			reply.setWriter(request.getParameter("writer"));
			reply.setContents(request.getParameter("contents"));
			reply.setArticleNum(Integer.parseInt(request.getParameter("articleNum")));
			if(service.writeReply(reply)) {
				path="qa/reply_success.jsp";
			}else {
				path="qa/reply_fail.jsp";
			}
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}
