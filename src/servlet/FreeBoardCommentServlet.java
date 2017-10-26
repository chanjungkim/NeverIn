package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.FreeBoardCommentService;
import vo.FreeBoardComment;

@WebServlet("/freeboardcomment")
public class FreeBoardCommentServlet extends HttpServlet{
	private FreeBoardCommentService service = FreeBoardCommentService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String type = request.getParameter("type");
		String path = "";
		
		if(type.equals("writecomment")) {
			int freeboardarticleNum = Integer.parseInt(request.getParameter("freeboardarticleNum"));
			String nickname = request.getParameter("nickname");
			String contents = request.getParameter("comment");
			String id = request.getParameter("id");
			FreeBoardComment comment = new FreeBoardComment();
			comment.setArticlenum(freeboardarticleNum);
			comment.setWriter(nickname);
			comment.setContents(contents);
			comment.setId(id);

			boolean result = service.commentwrite(comment);
			
			PrintWriter writer = response.getWriter();
			if(result) {
				writer.print("등록 성공");
			}else {
				writer.print("등록 실패");
			}
			return;
		}else if(type.equals("commentList")){
			int freeboardarticleNum = Integer.parseInt(request.getParameter("freeboardarticleNum"));
			List<FreeBoardComment> commentList = service.commentList(freeboardarticleNum);
			
			response.setContentType("text/json;charset=euc-kr");
			PrintWriter writer = response.getWriter();
			Gson gson = new Gson();
			System.out.println(gson.toJson(commentList));
			writer.print(gson.toJson(commentList));
		}else if(type.equals("deletecomment")) {
			int commentnum = Integer.parseInt(request.getParameter("commentnum"));
			PrintWriter writer = response.getWriter();
			
			if(service.deletecomment(commentnum)) {
				writer.print("삭제 성공");
			}else {
				writer.print("삭제 실패");
			}
		}else if(type.equals("updatecomment")) {
			int commentnum = Integer.parseInt(request.getParameter("commentnum"));
			String contents = request.getParameter("contents");
			PrintWriter writer = response.getWriter();
			
			if(service.updatecomment(commentnum, contents)) {
				writer.print("수정 성공");
			}else {
				writer.print("수정 실패");
			}
		}
	}
}
