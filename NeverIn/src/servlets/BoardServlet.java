package servlets;

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
			// ï¿½Ô½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ï¿½Ö±ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Û¾ï¿½.
			// Å¬ï¿½ï¿½ï¿½Ì¾ï¿½Æ®ï¿½ï¿½ ï¿½ï¿½Ã»ï¿½Ï´ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ parameter ï¿½Þ±ï¿½
			String pageStr = request.getParameter("p");
			int page = 1;
			if(pageStr!=null && pageStr.length()>0) {
				page = Integer.parseInt(pageStr);
			}
			
			// page ï¿½ï¿½ï¿½ï¿½ ï¿½Ö¸é¼­ serviceï¿½ï¿½ï¿½ï¿½ ï¿½Ï½ï¿½Å°ï¿½ï¿½
			ArticlePageVO articlePage = 
					service.makeArticlePage(page);
			
			request.setAttribute("articlePage", articlePage);
			
			// ï¿½Ô½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿? html È­ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿? jspï¿½ï¿½ï¿½ï¿½ forward
			path = "board_list.jsp";
		}else if(type.equals("writeForm")) {
			// ï¿½ï¿½ ï¿½Ô·ï¿½ È­ï¿½ï¿½html ï¿½ï¿½ï¿½ï¿½ï¿½Ï±ï¿½
			path = "write_form.jsp";
		}else if(type.equals("read")) {
			// ï¿½Ð±ï¿½ ï¿½ï¿½Ã» ï¿½Þ¾ï¿½ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½È£ ï¿½Ä¶ï¿½ï¿½ï¿½Íµï¿? ï¿½Þ¾Æ¿ï¿½ï¿½ï¿½
			String articleNumStr = 
					request.getParameter("articleNum");
			int articleNum = 0;
			if(articleNumStr!=null && articleNumStr.length()>0) {
				// ï¿½ï¿½ ï¿½ï¿½È£ ï¿½Ä¶ï¿½ï¿½ï¿½Í¸ï¿? intï¿½ï¿½ ï¿½ï¿½È¯
				articleNum = Integer.parseInt(articleNumStr);
			}
			// ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ö·ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Ø´ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Ø¾ï¿½ï¿½ï¿½.
			Article article = 
					service.readAndReadCount(articleNum);
			
			if(article != null) {
				request.setAttribute("article", article);
				path = "read.jsp";
			} else {
				path = "article_not_found.jsp";
			}
		} else if(type.equals("updateForm")) {
			// ï¿½ï¿½ï¿½Ð±â¿¡ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï±ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ ï¿½Û¹ï¿½È£ ï¿½Þ±ï¿½
			String articleNumStr = 
						request.getParameter("articleNum");
			int articleNum = 0;
			if(articleNumStr!=null 
							&& articleNumStr.length()>0) {
				articleNum = 
						Integer.parseInt(articleNumStr);
			}
			// ï¿½ï¿½È¸ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½È¸ï¿½Ï´ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿?
			Article original = 
					service.readWithoutReadCount(articleNum);
			
			request.setAttribute("original", original);
			
			path = "update_form.jsp";
		} else if(type.equals("deleteForm")) {
            // ê¸??½ê¸°ì—?„œ ?‚­? œ?•˜ê¸? ?ˆŒ???„ ?•Œ ê¸?ë²ˆí˜¸ ë°›ê¸°
            String articleNumStr = 
                    request.getParameter("articleNum");
            int articleNum = 0;
            if (articleNumStr != null
                        && articleNumStr.length() > 0) {
                articleNum = Integer.parseInt(articleNumStr);
            }
            // ?‚­? œ?•  ê¸? ë²ˆí˜¸ë§? delete_form.jsp?— ? „?‹¬
            request.setAttribute("articleNum", articleNum);
            path = "delete_form.jsp";
        }
         
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
////////////////////////////////////////////////////////////	
	// post ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½Ã» Ã³ï¿½ï¿½
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		request.setCharacterEncoding("euc-kr");
		String type = request.getParameter("type");
		String path = "";
		
		if(type.equals("write")) {
			Article article = new Article();
			article.setTitle(request.getParameter("title"));
			article.setWriter(request.getParameter("writer"));
			article.setPassword(request.getParameter("password"));
			article.setContents(request.getParameter("contents"));
			// ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Ï½ï¿½Å°ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Ï¸ï¿½ ï¿½ï¿½.
			if(service.writeArticle(article)) {
				path = "write_success.jsp";
			}else {
				path = "write_fail.jsp";
			}
		}else if(type.equals("update")) {
			Article updateArticle  = new Article();
			updateArticle.setTitle(request.getParameter("title"));
			updateArticle.setPassword(request.getParameter("password"));
			updateArticle.setContents(request.getParameter("contents"));
			
			String articleNumStr = request.getParameter("articleNum");
			
			int articleNum = 0;
			if(articleNumStr!=null && articleNumStr.length()>0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			updateArticle.setAritlcleNum(articleNum);
			
			if(service.passwordCheckUpdate(updateArticle)) {
				request.setAttribute("articleNum", updateArticle.getAritlcleNum());
				path = "update_success.jsp";
			}else {
				path = "update_fail.jsp";
			}
		} else if(type.equals("delete")) {
			String password = request.getParameter("password");
			String articleNumStr = request.getParameter("articleNum");
			int articleNum=0;
			if(articleNumStr != null && articleNumStr.length() >0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			if(service.delete(password, articleNum)) {
				path="delete_success.jsp";
			}else {
				path="delete_fail.jsp";
			}
		}
		System.out.println(path);
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	};

}










