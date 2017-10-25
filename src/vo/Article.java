package vo;

import java.sql.Timestamp;
import java.util.Date;

// �Խñ� VO Ŭ����
public class Article {
	private int aritlcleNum;	// �� ��ȣ
	private String title;		// �� ����
	private String writer;		// �ۼ���
	private int readCount;		// ��ȸ��
	private String filePath;
	private String contents;	// �� ����
	private Date writeDate;		// �ۼ��Ͻ�
	private int replyCount; 
	//////////////////////////////////////////////////////////////////////////////////////////
	public Article(int aritlcleNum, String title, String writer, int readCount, String filePath, String contents,
			Date writeDate) {
		super();
		this.aritlcleNum = aritlcleNum;
		this.title = title;
		this.writer = writer;
		this.readCount = readCount;
		this.filePath = filePath;
		this.contents = contents;
		this.writeDate = writeDate;
	}
	public Article() {
		
	}
	///////////////////////////////////////////////////////////////////////////////////////
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}	
/////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Article [aritlcleNum=" + aritlcleNum + ", title=" + title + ", writer=" + writer + ", readCount="
				+ readCount + ", filePath=" + filePath + ", contents=" + contents + ", writeDate=" + writeDate
				+ ", replyCount=" + replyCount + "]";
	}
	
}
