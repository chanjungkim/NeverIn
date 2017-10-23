package service;

import java.util.Date;
import java.util.List;

import dao.BoardDao;
import vo.Article;
import vo.ArticlePageVO;

public class BoardService {
	private static final int COUNT_PER_PAGE = 10;

	private BoardDao dao = BoardDao.getInstance();
///////////////////////////////////////////////////////////

	private static BoardService instance = new BoardService();
	public static BoardService getInstance() {
		return instance;
	}
	private BoardService() {}
///////////////////////////////////////////////////////////	

	public ArticlePageVO makeArticlePage(int page) {
		int totalArticleCount = dao.selectArticleCount();
		int totalPage = totalArticleCount / COUNT_PER_PAGE;
		if(totalArticleCount%COUNT_PER_PAGE>0) {
			totalPage++;
		}
		
		// 하단 시작 페이지
		int startPage = (page-1)/10*10 + 1;
		
		// 하단 끝 페이지
		int endPage = startPage+9;
		if(endPage>totalPage) {
			endPage = totalPage;
		}
		
		// limit 시작행 계산
		int startRow = (page-1)*10;
		
		// DB 에서 현재 페이지에 보여질 게시글들 조회
		List<Article> articleList = 
			dao.selectArticleList(startRow, COUNT_PER_PAGE);
		
		// 한 페이지에 보여질 모든 데이터 담아서 작업 완료
		return new ArticlePageVO
			(articleList, startPage, endPage, totalPage, page);
	}

	// 서블릿이 전달한 미완성 article에 나머지 값 채워서 DB에추가
	public boolean writeArticle(Article article) {
		article.setReadCount(0);
		article.setWriteDate(new Date());
		
		// dao 한테 추가작업 시킬 차례
		int insertResult = dao.insert(article);
		if(insertResult==1) {
			return true;
		}else {
			return false;
		}		
	}


	public Article readAndReadCount(int articleNum) {
		Article article = null;
		if(dao.updateReadCount(articleNum)==1) {

			article = dao.select(articleNum);
		}
		return article;
	}
	

	public Article readWithoutReadCount(int articleNum) {
		return dao.select(articleNum);
	}
	

	public boolean idCheckUpdate(Article updateArticle) {
		updateArticle.setWriteDate(new Date());
		

		if(dao.update(updateArticle)==1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean delete(int articleNum) {
		if(dao.delete(articleNum)==1) {
			return true;
		}else {
			return false;
		}
	}
}






