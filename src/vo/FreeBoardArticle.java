package vo;

import java.util.Date;

public class FreeBoardArticle {
	private int articleNum;
	private int groupNum;
	private int subNum;
	private int subCount;
	private String title;
	private String id;
	private String writer;
	private int readCount;
	private Date writeTime;
	private String contents;
	
	public FreeBoardArticle(int articleNum, int groupNum, int subNum, int subCount, String title,String id, String writer, int readCount,
			Date writeTime, String contents) {
		this.articleNum = articleNum;
		this.groupNum = groupNum;
		this.subNum = subNum;
		this.subCount = subCount;
		this.title = title;
		this.id = id;
		this.writer = writer;
		this.readCount = readCount;
		this.writeTime = writeTime;
		this.contents = contents;
	}
	
	public FreeBoardArticle() {
		
	}

	public int getArticleNum() {
		return articleNum;
	}

	public int getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}
	public int getSubNum() {
		return subNum;
	}
	public void setSubNum(int subNum) {
		this.subNum = subNum;
	}
	public int getSubCount() {
		return subCount;
	}
	public void setSubCount(int subCount) {
		this.subCount = subCount;
	}
	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Date getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "FreeBoardArticle [articleNum=" + articleNum + ", groupNum=" + groupNum + ", subNum=" + subNum
				+ ", subCount=" + subCount + ", title=" + title + ", id=" + id + ", writer=" + writer + ", readCount="
				+ readCount + ", writeTime=" + writeTime + ", contents=" + contents + "]";
	}
}
