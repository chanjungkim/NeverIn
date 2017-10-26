//package servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import servlet.FreeBoardServlet;
//import vo.FreeBoardComment;
//
//@WebServlet("/freeboardcomment")
//public class FreeBoardCommentServlet extends HttpServlet{
//	private FreeBoardCommentService service = FreeBoardCommentService.getInstance();
//	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("euc-kr");
//		String type = request.getParameter("type");
//		String path = "";
//		
//		if(type.equals("writecomment")) {
//			int freeboardarticleNum = Integer.parseInt(request.getParameter("freeboardarticleNum"));
//			String nickname = request.getParameter("nickname");
//			String contents = request.getParameter("comment");
//			String id = request.getParameter("id");
//			FreeBoardComment comment = new FreeBoardComment();
//			comment.setArticlenum(freeboardarticleNum);
//			comment.setWriter(nickname);
//			comment.setContents(contents);
//			comment.setId(id);
//
//			boolean result = service.commentwrite(comment);
//			
//			PrintWriter writer = response.getWriter();
//			if(result) {
//				writer.print("��� ����");
//			}else {
//				writer.print("��� ����");
//			}
//			return;
//		}else if(type.equals("commentList")){
//			int freeboardarticleNum = Integer.parseInt(request.getParameter("freeboardarticleNum"));
//			List<FreeBoardComment> commentList = service.commentList(freeboardarticleNum);
//			
//			response.setContentType("text/json;charset=euc-kr");
//			PrintWriter writer = response.getWriter();
//			Gson gson = new Gson();
//			writer.print(gson.toJson(commentList));
//		}else if(type.equals("deletecomment")) {
//			int commentnum = Integer.parseInt(request.getParameter("commentnum"));
//			PrintWriter writer = response.getWriter();
//			
//			if(service.deletecomment(commentnum)) {
//				writer.print("���� ����");
//			}else {
//				writer.print("���� ����");
//			}
//		}else if(type.equals("updatecomment")) {
//			int commentnum = Integer.parseInt(request.getParameter("commentnum"));
//			String contents = request.getParameter("contents");
//			PrintWriter writer = response.getWriter();
//			
//			if(service.updatecomment(commentnum, contents)) {
//				writer.print("���� ����");
//			}else {
//				writer.print("���� ����");
//			}
//		}
//	}
//}
