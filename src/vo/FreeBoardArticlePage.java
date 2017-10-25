package vo;

import java.util.List;

public class FreeBoardArticlePage {
	private List<FreeBoardArticle> freeboardarticleList;
	private int startPage;
	private int endPage;
	private int currentPage;
	private int totalPage;

	public FreeBoardArticlePage(List<FreeBoardArticle> freeboardarticleList, int startPage, int endPage, int currentPage, int totalPage) {
		this.freeboardarticleList = freeboardarticleList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	public FreeBoardArticlePage() {
		
	}
	
	public List<FreeBoardArticle> getFreeboardarticleList() {
		return freeboardarticleList;
	}
	public void setFreeboardarticleList(List<FreeBoardArticle> freeboardarticleList) {
		this.freeboardarticleList = freeboardarticleList;
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
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "ArticlePage [freeboardarticleList=" + freeboardarticleList + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", currentPage=" + currentPage + ", totalPage=" + totalPage + "]";
	}
}
