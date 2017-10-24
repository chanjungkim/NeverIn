package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import vo.Article;
import vo.Reply;

public class ReplyDao {
	// singleton
	private static ReplyDao instance;
	public static ReplyDao getInstance() {
		if(instance == null) {
			instance = new ReplyDao();
		}
		return instance;
	}
	private ReplyDao() {
		DBUtil.loadDriver(); // mysql 드라이버 로딩 
	}
	// END of singleton
	
	// DB 연결, 해제 관련 필드와 메소드들
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
		
	// SQL 실행 메소드
	public int insert(Reply reply) {
		con=DBUtil.makeConnection();
		String sql = "INSERT INTO REPLY"
				+ "(ARTICLE_NUM, WRITER, CONTENTS, WRITE_TIME) "
				+ "VALUES(?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reply.getArticleNum());
			pstmt.setString(2, reply.getWriter());
			pstmt.setString(3, reply.getContents());
			pstmt.setTimestamp(4, new Timestamp(reply.getWriteTime().getTime()));
			
			result = pstmt.executeUpdate(); // SQL 실행
		} catch (SQLException e) {
			System.out.println("reply dao insert 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
		
	}
///////////////////////////////////////////////////////////
	public Article select(int articleNum) {
		makeConnection();
		String sql = 
			"SELECT ARTICLE_NUM,TITLE,WRITER,"
			+ "CONTENTS,write_time,READ_COUNT FROM BOARD "
			+ "WHERE ARTICLE_NUM=?";
		Article article = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			rs = pstmt.executeQuery(); // SQL 실행
			
			if(rs.next()) {
				article = new Article();
				article.setAritlcleNum(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setWriter(rs.getString(3));
				article.setContents(rs.getString(4));
				article.setWriteDate(rs.getTimestamp(5));
				article.setReadCount(rs.getInt(6));
			}
		} catch (SQLException e) {
			System.out.println("dao select 에러");
			e.printStackTrace();
		} finally {
			closeRs();
			closePstmt();
			closeCon();
		}
		return article;
	}	
}