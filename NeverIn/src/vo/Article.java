package vo;

import java.sql.Timestamp;
import java.util.Date;

// 게시글 VO 클래스
public class Article {
	private int aritlcleNum;	// 글 번호
	private String title;		// 글 제목
	private String writer;		// 작성자
	private int readCount;		// 조회수
	private String contents;	// 글 내용
	private String password;	// 글 비밀번호
	private Date writeDate;		// 작성일시
/////////////////////////////////////////////////////////
	// 생성자
	public Article(int aritlcleNum, String title, String writer, int readCount, String contents, String password,
			Timestamp writeDate) {
		this.aritlcleNum = aritlcleNum;
		this.title = title;
		this.writer = writer;
		this.readCount = readCount;
		this.contents = contents;
		this.password = password;
		this.writeDate = writeDate;
	}
	public Article() {
	}
//////////////////////////////////////////////////////////	
	public int getAritlcleNum() {
		return aritlcleNum;
	}
	public void setAritlcleNum(int aritlcleNum) {
		this.aritlcleNum = aritlcleNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
///////////////////////////////////////////////////////////	
	@Override
	public String toString() {
		return "Article [aritlcleNum=" + aritlcleNum + ", title=" + title + ", writer=" + writer + ", readCount="
				+ readCount + ", contents=" + contents + ", password=" + password + ", writeDate=" + writeDate + "]";
	}	
}
