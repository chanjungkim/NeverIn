package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vo.FreeBoardArticle;

public class FreeBoardDao {
	// singleton
	private static FreeBoardDao instance;
	public static FreeBoardDao getInstance() {
		if(instance == null)
			instance = new FreeBoardDao();
		return instance;
	}
	private FreeBoardDao() {}
///////////////////////////////////////////////////////////
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
/////////////////////////////////////////////////////////	
	public int selectFreeBoardArticleCount() {
		con = DBUtil.makeConnection();
		String sql = "select count(*) from freeboard";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // sql 실행

			// 결과 숫자 하나 얻기
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("dao selectFreeBoardArticleCount 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	// 2. 특정 페이지에 보여질 게시글 조회
	public List<FreeBoardArticle> selectFreeBoardArticleList(int startRow, int count) {
		con = DBUtil.makeConnection();
		String sql = "select article_num, title, writer, contents, read_count, write_time from freeboard order by group_num desc, sub_count asc limit ?,?";
		List<FreeBoardArticle> freeboardarticleList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery(); // SQL 실행

			while (rs.next()) {
				FreeBoardArticle freeboardarticle = new FreeBoardArticle();
				freeboardarticle.setArticleNum(rs.getInt(1));
				freeboardarticle.setTitle(rs.getString(2));
				freeboardarticle.setWriter(rs.getString(3));
				freeboardarticle.setContents(rs.getString(4));
				freeboardarticle.setReadCount(rs.getInt(5));
				freeboardarticle.setWriteTime(rs.getTimestamp(6));

				freeboardarticleList.add(freeboardarticle);
			}
		} catch (SQLException e) {
			System.out.println("dao selectFreeBoardArticleList 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return freeboardarticleList;
	}
	
	
	public String selectNickName(String id) {
		con = DBUtil.makeConnection();
		String sql = 
			"SELECT nickname FROM MEMBER WHERE ID=?";
		String result = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("dao selectNickName 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	// 그룹 갯수 조회
	public int selectGroupCount() {
		con = DBUtil.makeConnection();
		String sql = "select count(distinct group_num) from freeboard";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // sql 실행

			// 결과 숫자 하나 얻기
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("dao Groupcount 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	public int insertArticle(FreeBoardArticle freeboardarticle, int writeCount, String nickname) {
		con = DBUtil.makeConnection();
		String sql = "INSERT INTO freeboard"
				+ "(group_num,TITLE,id,WRITER,CONTENTS,READ_COUNT,"
				+ "WRITE_TIME) VALUES(?,?,?,?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, writeCount);
			pstmt.setString(2, freeboardarticle.getTitle());
			pstmt.setString(3, freeboardarticle.getId());
			pstmt.setString(4, nickname);
			pstmt.setString(5, freeboardarticle.getContents());
			pstmt.setInt(6, freeboardarticle.getReadCount());
			pstmt.setTimestamp(7, 
				new Timestamp(freeboardarticle.getWriteTime().getTime()));
			
			result = pstmt.executeUpdate(); // SQL 실행
		} catch (SQLException e) {
			System.out.println("dao insert 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	// 2. 해당 번호의 Article 조회
	public FreeBoardArticle freeboardarticleselect(int articleNum) {
		con = DBUtil.makeConnection();
		String sql = "SELECT ARTICLE_NUM,TITLE,WRITER," 
				+ "CONTENTS,WRITE_TIME,READ_COUNT,id,group_num, sub_num, sub_count FROM freeboard "
				+ "WHERE ARTICLE_NUM=?";
		FreeBoardArticle freeboardarticle = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			rs = pstmt.executeQuery(); // SQL 실행

			if (rs.next()) {
				freeboardarticle = new FreeBoardArticle();
				freeboardarticle.setArticleNum(rs.getInt(1));
				freeboardarticle.setTitle(rs.getString(2));
				freeboardarticle.setWriter(rs.getString(3));
				freeboardarticle.setContents(rs.getString(4));
				freeboardarticle.setWriteTime(rs.getTimestamp(5));
				freeboardarticle.setReadCount(rs.getInt(6));
				freeboardarticle.setId(rs.getString(7));
				freeboardarticle.setGroupNum(rs.getInt(8));
				freeboardarticle.setSubNum(rs.getInt(9));
				freeboardarticle.setSubCount(rs.getInt(10));
			}
		} catch (SQLException e) {
			System.out.println("dao freeboardarticleselect 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return freeboardarticle;
	}
	
	// 1. 조회수 증가
	public int updateReadCount(int articleNum) {
		con = DBUtil.makeConnection();
		String sql = "UPDATE FREEBOARD SET READ_COUNT=READ_COUNT+1 " 
				+ "WHERE ARTICLE_NUM=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);

			result = pstmt.executeUpdate(); // SQL 실행
		} catch (SQLException e) {
			System.out.println("dao updateReadCount 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	
	public int insertAnswerArticle(FreeBoardArticle freeboardarticle) {
		con = DBUtil.makeConnection();
		String sql = "INSERT INTO freeboard (group_num,sub_num,sub_count,TITLE,id,WRITER,CONTENTS,READ_COUNT,"
				+ "WRITE_TIME) VALUES(?,?,?,?,?,?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, freeboardarticle.getGroupNum());
			pstmt.setInt(2, freeboardarticle.getSubNum());
			pstmt.setInt(3, freeboardarticle.getSubCount());
			pstmt.setString(4, freeboardarticle.getTitle());
			pstmt.setString(5, freeboardarticle.getId());
			pstmt.setString(6, freeboardarticle.getWriter());
			pstmt.setString(7, freeboardarticle.getContents());
			pstmt.setInt(8, freeboardarticle.getReadCount());
			pstmt.setTimestamp(9, 
				new Timestamp(freeboardarticle.getWriteTime().getTime()));
			
			result = pstmt.executeUpdate(); // SQL 실행
		} catch (SQLException e) {
			System.out.println("dao insertAnswerArticle 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	public int checkAnswer(FreeBoardArticle freeBoardArticle) {
		con = DBUtil.makeConnection();
		String sql = "SELECT article_num FROM freeboard WHERE group_num=? and sub_count=?";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, freeBoardArticle.getGroupNum());
			pstmt.setInt(2, freeBoardArticle.getSubCount());
			rs = pstmt.executeQuery(); // SQL 실행

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("dao checkAnswer 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	public int selectSubCount(FreeBoardArticle freeBoardArticle) {
		con = DBUtil.makeConnection();
		String sql = "SELECT sub_count FROM freeboard WHERE group_num=?";
		int result = 0;
		int subcount=0;
		int subnum=0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, freeBoardArticle.getGroupNum());
			rs = pstmt.executeQuery(); // SQL 실행
			
			while(rs.next()) {
				subcount = rs.getInt(1);
				subnum = rs.getInt(2);
				
				if(subnum == freeBoardArticle.getSubNum()) {
					break;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("dao checkAnswer 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	public int subsubCountUpdate(FreeBoardArticle article) {
		con = DBUtil.makeConnection();
		int result = 0;
		String sql = "UPDATE freeboard SET sub_count=sub_count+1 WHERE group_num=? and sub_count>=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getGroupNum());
			pstmt.setInt(2, article.getSubCount());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("dao subCountUpdate 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	public int subCountUpdate(FreeBoardArticle article) {
		con = DBUtil.makeConnection();
		int result = 0;
		String sql = "UPDATE freeboard SET sub_count=sub_count+1 WHERE group_num=? and sub_count>=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getGroupNum());
			pstmt.setInt(2, article.getSubCount());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("dao subCountUpdate 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	public int delete(int articleNum) {
		con = DBUtil.makeConnection();
		String sql = "DELETE FROM freeboard WHERE ARTICLE_NUM=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("dao delete 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	public int update(FreeBoardArticle article) {
		con = DBUtil.makeConnection();
		int result = 0;
		String sql = "UPDATE freeboard SET TITLE=?,CONTENTS=? WHERE ARTICLE_NUM=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContents());
			pstmt.setInt(3, article.getArticleNum());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("dao update 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
/////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
	// 글 읽기 작업에 필요한 메소드


	
	public FreeBoardArticle subNum(int articleNum) {
		con = DBUtil.makeConnection();
		String sql = "SELECT group_num, sub_num, sub_count FROM BOARD "
				+ "WHERE ARTICLE_NUM=?";
		FreeBoardArticle article = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			rs = pstmt.executeQuery(); // SQL 실행

			if (rs.next()) {
				article = new FreeBoardArticle();
				article.setGroupNum(rs.getInt(1));
				article.setSubNum(rs.getInt(2));
				article.setSubCount(rs.getInt(3));
			}
		} catch (SQLException e) {
			System.out.println("dao subNum 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return article;
	}
	
	
	public int subCount(int groupNum) {
		con = DBUtil.makeConnection();
		String sql = "SELECT max(sub_count) FROM BOARD WHERE group_num=?";
		int result = -1;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, groupNum);
			rs = pstmt.executeQuery(); // SQL 실행

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("dao subCount 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	public int insertAnswer(FreeBoardArticle article) {
		con = DBUtil.makeConnection();
		String sql = "INSERT INTO BOARD (group_num,sub_num,sub_count,TITLE,WRITER,CONTENTS,READ_COUNT, WRITE_TIME) VALUES(?,?,?,?,?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getGroupNum());
			pstmt.setInt(2, article.getSubNum());
			pstmt.setInt(3, article.getSubCount());
			pstmt.setString(4, article.getTitle());
			pstmt.setString(5, article.getWriter());
			pstmt.setString(6, article.getContents());
			pstmt.setInt(7, article.getReadCount());
			pstmt.setTimestamp(8, 
				new Timestamp(article.getWriteTime().getTime()));
			
			result = pstmt.executeUpdate(); // SQL 실행
		} catch (SQLException e) {
			System.out.println("dao insertAnswer 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	


}

