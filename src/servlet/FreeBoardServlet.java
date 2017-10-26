package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.FreeBoardCommentService;
import service.FreeBoardService;
import vo.FreeBoardArticle;
import vo.FreeBoardArticlePage;

@WebServlet("/freeboard")
public class FreeBoardServlet extends HttpServlet{
	private FreeBoardService service = FreeBoardService.getInstance();
	private FreeBoardCommentService commentservice = FreeBoardCommentService.getInstance();
////////////////////////////////////////////////////////////	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String path = "";
		
		if(type == null || type.equals("freeboardList")) {
			// 현재 요청 페이지 관련 파라미터 p 처리
			String pageStr = request.getParameter("p");
			int page = 1;
			if(pageStr != null && !pageStr.isEmpty()) {
				page = Integer.parseInt(pageStr);
			}
			// 서비스에게 해당 페이지 보여질 정보 요청
			FreeBoardArticlePage freeboardarticlePage = service.makePage(page);
			request.setAttribute("freeboardarticlePage", freeboardarticlePage);
			
			path = "board/freeboard_list.jsp";
		}else if(type.equals("writeForm")) {
			path = "board/freeboard_write_form.jsp";
		}else if(type.equals("read")) {
			HttpSession session = request.getSession();
			String loginId = (String) 
					session.getAttribute("loginId");
			String articleNumStr = request.getParameter("freeboardarticleNum");
			int articleNum = Integer.parseInt(articleNumStr);
			
			String nickname = service.nickname(loginId);
			request.setAttribute("nickname", nickname);

			FreeBoardArticle freeboardarticle = service.read(loginId, articleNum);
			if(freeboardarticle != null) {
				request.setAttribute("freeboardarticle", freeboardarticle);
				System.out.println(nickname);
				path = "board/freeboard_read_form.jsp";
			}else {
				path = "board/article_not_found.jsp";
			}
		}else if(type.equals("answerForm")) {
			String articleNumStr = request.getParameter("freeboardarticleNum");
			int articleNum = Integer.parseInt(articleNumStr);
			
			FreeBoardArticle freeboardarticle = service.answerRead(articleNum);
			
			if(freeboardarticle != null) {
				request.setAttribute("freeboardarticle", freeboardarticle);
				path = "board/freeboard_answer_form.jsp";
			}else {
				path = "board/article_not_found.jsp";
			}
		}else if(type.equals("deleteForm")) {
			String articleNumStr = request.getParameter("freeboardarticleNum");
			int articleNum = Integer.parseInt(articleNumStr);
			
			if(service.delete(articleNum)) {
				path = "board/freeboard_delete_success.jsp";
			}else {
				path = "board/freeboard_delete_fail.jsp";
			}
		}else if(type.equals("updateForm")) {
			String articleNumStr = request.getParameter("freeboardarticleNum");
			int articleNum = Integer.parseInt(articleNumStr);
			
			FreeBoardArticle freeboardarticle = service.readNoCount(articleNum);
			if(freeboardarticle != null) {
				request.setAttribute("freeboardarticle", freeboardarticle);
				path = "board/freeboard_update_form.jsp";
			}else {
				path = "board/article_not_found.jsp";
			}
		}
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String type = request.getParameter("type");
		String path = "";
		if(type.equals("write")) {
			FreeBoardArticle freeboardarticle = new FreeBoardArticle();
			freeboardarticle.setId(request.getParameter("id"));
			freeboardarticle.setTitle(request.getParameter("title"));
			freeboardarticle.setContents(request.getParameter("contents"));
			boolean result = service.write(freeboardarticle);
			if(result==true) {
				path = "board/freeboard_write_success.jsp";
			}else {
				path = "board/freeboard_write_fail.jsp";
			}
		}else if(type.equals("answer")) {
			FreeBoardArticle freeboardarticle = new FreeBoardArticle();
			freeboardarticle.setId(request.getParameter("id"));
			freeboardarticle.setTitle(request.getParameter("title"));
			freeboardarticle.setContents(request.getParameter("contents"));
			int articleNum = Integer.parseInt(request.getParameter("articleNum"));
			
			boolean result = service.answerWrite(freeboardarticle, articleNum);
			if(result==true) {
				path = "board/freeboard_write_success.jsp";
			}else {
				path = "board/freeboard_write_fail.jsp";
			}
		}else if(type.equals("update")) {
			FreeBoardArticle freeboardarticle = new FreeBoardArticle();
			freeboardarticle.setArticleNum(Integer.parseInt(request.getParameter("articleNum")));
			freeboardarticle.setTitle(request.getParameter("title"));
			freeboardarticle.setContents(request.getParameter("contents"));
			
			if(service.update(freeboardarticle)) {
				path = "board/freeboard_update_success.jsp";
			}else {
				path = "board/freeboard_update_fail.jsp";
			}
		}
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}




