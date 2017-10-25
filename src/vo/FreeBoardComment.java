package vo;

public class FreeBoardComment {
	private int commentnum;
	private int articlenum;
	private int groupnum;
	private int subnum;
	private int subcount;
	private String writer;
	private String contents;
	private String id;
	
	public FreeBoardComment(int commentnum, int articlenum, int groupnum, int subnum, int subcount, String writer,
			String contents, String id) {
		super();
		this.commentnum = commentnum;
		this.articlenum = articlenum;
		this.groupnum = groupnum;
		this.subnum = subnum;
		this.subcount = subcount;
		this.writer = writer;
		this.contents = contents;
		this.id = id;
	}

	public FreeBoardComment() {
		
	}

	public int getCommentnum() {
		return commentnum;
	}

	public void setCommentnum(int commentnum) {
		this.commentnum = commentnum;
	}

	public int getArticlenum() {
		return articlenum;
	}

	public void setArticlenum(int articlenum) {
		this.articlenum = articlenum;
	}

	public int getGroupnum() {
		return groupnum;
	}

	public void setGroupnum(int groupnum) {
		this.groupnum = groupnum;
	}

	public int getSubnum() {
		return subnum;
	}

	public void setSubnum(int subnum) {
		this.subnum = subnum;
	}

	public int getSubcount() {
		return subcount;
	}

	public void setSubcount(int subcount) {
		this.subcount = subcount;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FreeBoardComment [commentnum=" + commentnum + ", articlenum=" + articlenum + ", groupnum=" + groupnum
				+ ", subnum=" + subnum + ", subcount=" + subcount + ", writer=" + writer + ", contents=" + contents
				+ ", id=" + id + "]";
	}

	
}
