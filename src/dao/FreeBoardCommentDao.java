package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vo.FreeBoardArticle;
import vo.FreeBoardComment;

public class FreeBoardCommentDao {
	// singleton
	private static FreeBoardCommentDao instance;
	public static FreeBoardCommentDao getInstance() {
		if(instance == null)
			instance = new FreeBoardCommentDao();
		return instance;
	}
	private FreeBoardCommentDao() {}
///////////////////////////////////////////////////////////
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
/////////////////////////////////////////////////////////	
	public int selectGroupCount(int articlenum) {
		con = DBUtil.makeConnection();
		String sql = "select count(distinct group_num) from fdcomment where article_num=?";
		
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, articlenum);
			
			rs = pstmt.executeQuery(); // sql 실행

			// 결과 숫자 하나 얻기
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("dao selectGroupCount 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	public int insertComment(FreeBoardComment freeboardcomment) {
		con = DBUtil.makeConnection();
		String sql = "INSERT INTO fdcomment"
				+ "(article_num, group_num, writer, contents, id) VALUES(?,?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, freeboardcomment.getArticlenum());
			pstmt.setInt(2, freeboardcomment.getGroupnum());
			pstmt.setString(3, freeboardcomment.getWriter());
			pstmt.setString(4, freeboardcomment.getContents());
			pstmt.setString(5, freeboardcomment.getId());
			
			result = pstmt.executeUpdate(); // SQL 실행
		} catch (SQLException e) {
			System.out.println("dao insertComment 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	
	public List<FreeBoardComment> commentList(int articlenum) {
		con = DBUtil.makeConnection();
		String sql = "select comment_num, writer, contents, id from fdcomment where article_num=? order by comment_num";
		List<FreeBoardComment> commentList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articlenum);
			rs = pstmt.executeQuery(); // SQL 실행

			while (rs.next()) {
				FreeBoardComment freeboardcommnet = new FreeBoardComment();
				freeboardcommnet.setCommentnum(rs.getInt(1));
				freeboardcommnet.setWriter(rs.getString(2));
				freeboardcommnet.setContents(rs.getString(3));
				freeboardcommnet.setId(rs.getString(4));

				commentList.add(freeboardcommnet);
			}
		} catch (SQLException e) {
			System.out.println("dao commentList 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return commentList;
	}
	
	public int commentdelete(int commentnum) {
		con = DBUtil.makeConnection();
		String sql = "DELETE FROM fdcomment WHERE comment_num=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, commentnum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("dao commentdelete 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	
	public int commentupdate(int commentnum, String contents) {
		con = DBUtil.makeConnection();
		int result = 0;
		String sql = "UPDATE fdcomment SET contents=? WHERE comment_num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, contents);
			pstmt.setInt(2, commentnum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("dao commentupdate 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
}

