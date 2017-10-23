package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Article;
import vo.ArticlePageVO;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{
	private BoardService service = BoardService.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String path = "";
		
		if(type==null || type.equals("boardList")) {
			// 게시판 목록 보여주기 위한 작업.
			// 클라이언트가 요청하는 페이지 parameter 받기
			String pageStr = request.getParameter("p");
			int page = 1;
			if(pageStr!=null && pageStr.length()>0) {
				page = Integer.parseInt(pageStr);
			}
			
			// page 정보 주면서 service한테 일시키기
			ArticlePageVO articlePage = 
					service.makeArticlePage(page);
			
			request.setAttribute("articlePage", articlePage);
			
			// 게시판 목록 html 화면을 만드는 jsp에게 forward
			path = "board_list.jsp";
		}else if(type.equals("writeForm")) {
			// 글 입력 화면html 제공하기
			path = "write_form.jsp";
		}else if(type.equals("read")) {
			// 읽기 요청 받았을 때 글 번호 파라미터도 받아오기
			String articleNumStr = 
					request.getParameter("articleNum");
			int articleNum = 0;
			if(articleNumStr!=null && articleNumStr.length()>0) {
				// 글 번호 파라미터를 int로 변환
				articleNum = Integer.parseInt(articleNumStr);
			}
			// 글 내용 보여주려면 서비스한테 해당글 가져오라 해야함.
			Article article = 
					service.readAndReadCount(articleNum);
			
			if(article != null) {
				request.setAttribute("article", article);
				path = "read.jsp";
			} else {
				path = "article_not_found.jsp";
			}
		} else if(type.equals("updateForm")) {
			// 글읽기에서 수정하기 눌렀을 때 글번호 받기
			String articleNumStr = 
						request.getParameter("articleNum");
			int articleNum = 0;
			if(articleNumStr!=null 
							&& articleNumStr.length()>0) {
				articleNum = 
						Integer.parseInt(articleNumStr);
			}
			// 조회수 증가 없이 원본 글 조회하는 서비스 기능
			Article original = 
					service.readWithoutReadCount(articleNum);
			
			request.setAttribute("original", original);
			
			path = "update_form.jsp";
		} else if(type.equals("deleteForm")) {
			// 글읽기에서 삭제하기 눌렀을 때 글번호 받기
			String articleNumStr = 
					request.getParameter("articleNum");
			int articleNum = 0;
			if (articleNumStr != null 
						&& articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			// 삭제할 글 번호만 delete_form.jsp에 전달
			request.setAttribute("articleNum", articleNum);
			path = "delete_form.jsp";
		}
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
////////////////////////////////////////////////////////////	
	// post 방식으로 들어온 요청 처리
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		request.setCharacterEncoding("euc-kr");
		String type = request.getParameter("type");
		String path = "";
		
		if(type.equals("${sessionScope.loginId}")) {
			Article article = new Article();
			article.setTitle(request.getParameter("title"));
			article.setWriter(request.getParameter("writer"));
			article.setContents(request.getParameter("contents"));
			// 서비스한테 일시키고 마무리 하면 됨.
			if(service.writeArticle(article)) {
				path = "write_success.jsp";
			}else {
				path = "write_fail.jsp";
			}
		}else if(type.equals("update")) {
			Article updateArticle = new Article();
			updateArticle.setTitle(request.getParameter("title"));
			updateArticle.setContents(request.getParameter("contents"));
			// 수정할 글번호 파라미터 문자열을 숫자로 변환
			String articleNumStr = request.getParameter("articleNum");
			int articleNum = 0;
			if(articleNumStr!=null && articleNumStr.length()>0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			updateArticle.setAritlcleNum(articleNum);
			// 수정된 내용들을 서비스에게 전달
			if(service.idCheckUpdate(updateArticle)) {
				request.setAttribute
				("articleNum", updateArticle.getAritlcleNum());
				path = "update_success.jsp";
			}else {
				path = "update_fail.jsp";
			}			
		}else if(type.equals("delete")) {

			// 삭제할 글번호 파라미터 int로 변환
			String articleNumStr = request.getParameter("articleNum");
			int articleNum = 0;
			if(articleNumStr!=null && articleNumStr.length()>0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			// 서비스에게 삭제하라고 하기
			if(service.delete(articleNum)) {
				path = "delete_success.jsp";
			}else {
				path = "delete_fail.jsp";
			}
		}
		
		RequestDispatcher dispatcher = 
						request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	};

}










