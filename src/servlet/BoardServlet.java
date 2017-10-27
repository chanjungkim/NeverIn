package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.BoardService;
import service.ReplyService;
import vo.Article;
import vo.ArticlePageVO;
import vo.Reply;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private BoardService service = BoardService.getInstance();
	private ReplyService replyService = ReplyService.getInstance();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String path = "";
		
		if(type==null || type.equals("boardList")) {
			
			String pageStr = request.getParameter("p");
			int page = 1;
			if(pageStr!=null && pageStr.length()>0) {
				page = Integer.parseInt(pageStr);
			}
			
			ArticlePageVO articlePage = 
					service.makeArticlePage(page);

			request.setAttribute("articlePage", articlePage);
			
			path = "qa/board_list.jsp";
		}else if(type.equals("writeForm")) {
			path = "qa/write_form.jsp";
		}else if(type.equals("read")) {
			String articleNumStr = 
					request.getParameter("articleNum");
			

			int articleNum = 0;
			if(articleNumStr!=null && articleNumStr.length()>0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			Article article = 
					service.readAndReadCount(articleNum);
			
			if(article != null) {
				ArrayList<Reply> replyList = replyService.getReplyList(articleNum);
				
				request.setAttribute("replyList", replyList);
				request.setAttribute("article", article);
				path = "qa/read.jsp";
			} else {
				path = "qa/article_not_found.jsp";
			}
		} else if(type.equals("updateForm")) {
			String articleNumStr = 
						request.getParameter("articleNum");
			int articleNum = 0;
			if(articleNumStr!=null 
							&& articleNumStr.length()>0) {
				articleNum = 
						Integer.parseInt(articleNumStr);
			}
			Article original = 
					service.readWithoutReadCount(articleNum);
			
			request.setAttribute("original", original);
			
			path = "qa/update_form.jsp";
		} else if(type.equals("deleteForm")) {
			String articleNumStr = 
					request.getParameter("articleNum");
			int articleNum = 0;
			if (articleNumStr != null 
						&& articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			
			if(service.delete(articleNum)) {
				path = "qa/delete_success.jsp";
			}else {
				path = "qa/delete_fail.jsp";
			}
		}
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		request.setCharacterEncoding("euc-kr");
		String type = request.getParameter("type");
		String path = "";
		if(type.equals("write")) {
			Article article = new Article();
			article.setTitle(request.getParameter("title"));
			article.setWriter(request.getParameter("writer"));
			article.setContents(request.getParameter("contents"));
			if(service.writeArticle(article)) {
				path = "qa/write_success.jsp";
			}else {
				path = "qa/write_fail.jsp";
			}
		}else if(type.equals("update")) {
			Article updateArticle = new Article();
			updateArticle.setTitle(request.getParameter("title"));
			updateArticle.setContents(request.getParameter("contents"));
			String articleNumStr = request.getParameter("articleNum");
			int articleNum = 0;
			if(articleNumStr!=null && articleNumStr.length()>0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			updateArticle.setAritlcleNum(articleNum);
			if(service.idCheckUpdate(updateArticle)) {
				request.setAttribute
				("articleNum", updateArticle.getAritlcleNum());
				path = "qa/update_success.jsp";
			}else {
				path = "qa/update_fail.jsp";
			}			
		}else if(type.equals("delete")) {

			String articleNumStr = request.getParameter("articleNum");
			int articleNum = 0;
			if(articleNumStr!=null && articleNumStr.length()>0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			if(service.delete(articleNum)) {
				path = "qa/delete_success.jsp";
			}else {
				path = "qa/delete_fail.jsp";
			}
		}
		
		RequestDispatcher dispatcher = 
						request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	};

}










