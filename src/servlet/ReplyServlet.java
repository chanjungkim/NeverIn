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
			String articleNum = request.getParameter("articleNum");
			
			request.setAttribute("articleNum", articleNum);
			
			path="qa/reply_form.jsp";
		} 
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String type=request.getParameter("type");
		String path="";
		
		if(type.equals("replyWrite")) {
			Reply reply=new Reply();
			reply.setWriter(request.getParameter("writer"));
			reply.setContents(request.getParameter("contents"));
			System.out.println(reply.getContents());
			reply.setArticleNum(Integer.parseInt(request.getParameter("articleNum")));
			request.setAttribute("articleNum", reply.getArticleNum());
			
			if(service.writeReply(reply)) {
				path="qa/reply_success.jsp";
			}else {
				path="qa/reply_fail.jsp";
			}
		} else if (type.equals("updateReply")) {
			String articleNum = request.getParameter("articleNum");
			String replyNum = request.getParameter("replyNum");
			String contents = request.getParameter("contents");
			
			System.out.println(articleNum + " "+ replyNum +" " + contents);
			request.setAttribute("articleNum", articleNum);
			int result = service.updateReply(articleNum, replyNum, contents);
			
			if(result == 1) {
				path="qa/reply_update_success.jsp";
			}else {
				path="qa/reply_update_fail.jsp";
			}
		} else if (type.equals("delete")) {
			String articleNum = request.getParameter("articleNum");
			String replyNum = request.getParameter("replyNum");	
			int reply = service.deleteReply(articleNum, replyNum);
			
			request.setAttribute("articleNum", articleNum);
			if(reply == 1) {
				request.setAttribute("articleNum", articleNum);
				path = "qa/reply_delete_success.jsp";
			} else {
				request.setAttribute("articleNum", articleNum);
				path = "qa/reply_delete_fail.jsp";
			}
		} else if (type.equals("edit")) {
			String articleNum = request.getParameter("articleNum");
			String replyNum = request.getParameter("replyNum");
			Reply reply = service.getReply(articleNum, replyNum);
			System.out.println(articleNum+" "+replyNum);

			request.setAttribute("articleNum", articleNum);
			request.setAttribute("reply", reply);
			
			path="qa/reply_update_form.jsp";
		} 
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}
