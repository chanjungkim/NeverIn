package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

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
	public ArrayList<Reply> select(int articleNum) {
		con=DBUtil.makeConnection();
		String sql = "SELECT WRITER, CONTENTS, WRITE_TIME FROM REPLY WHERE ARTICLE_NUM = ?";
		
		ArrayList<Reply> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			
			rs = pstmt.executeQuery();
					
			while(rs.next()) {			
				Reply reply = new Reply();
				reply.setWriter(rs.getString(1));
				reply.setContents(rs.getString(2));
				reply.setWriteTime(rs.getTimestamp(3));
				list.add(reply);
			}
			System.out.println(articleNum+"의 reply 사이즈: "+list.size());
		} catch (SQLException e) {
			System.out.println("reply dao select 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return list;
	}
}