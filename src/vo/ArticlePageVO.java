package vo;

import java.util.List;

// 게시판 목록보기에서 한 화면에 보여질 정보들
public class ArticlePageVO {
	private List<Article> articleList;	// 보여질 게시글 객체
	private int startPage;	// 화면 하단의 시작 페이지
	private int endPage;	// 화면 하단의 끝 페이지
	private int totalPage;	// 총 페이지 수
	private int requestPage;// 현재 보고있는 요청페이지
//////////////////////////////////////////////////////////
	public ArticlePageVO(List<Article> articleList, int startPage, int endPage, int totalPage, int requestPage) {
		this.articleList = articleList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;
		this.requestPage = requestPage;
	}
	public ArticlePageVO() {
	}
//////////////////////////////////////////////////////////	
	public List<Article> getArticleList() {
		return articleList;
	}
	
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getRequestPage() {
		return requestPage;
	}
	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}
////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "ArticlePageVO [articleList=" + articleList + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", totalPage=" + totalPage + ", requestPage=" + requestPage + "]";
	}
}
