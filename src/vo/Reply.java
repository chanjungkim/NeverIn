package vo;

import java.util.Date;

public class Reply {
	private int replyNum;
	private int articleNum;
	private String writer;
	private String contents;
	private Date writeTime;
	
	public Reply(int replyNum, int articleNum, String writer, String contents, Date writeTime) {
		this.replyNum = replyNum;
		this.articleNum = articleNum;
		this.writer = writer;
		this.contents = contents;
		this.writeTime = writeTime;
	}
	public Reply() {
	}
	
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public int getArticleNum() {
		return articleNum;
	}
	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
	@Override
	public String toString() {
		return "Reply [replyNum=" + replyNum + ", articleNum=" + articleNum + ", writer=" + writer + ", contents="
				+ contents + ", writeTime=" + writeTime + "]";
	}
}
