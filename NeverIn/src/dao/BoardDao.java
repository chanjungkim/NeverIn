package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.Article;

public class BoardDao {
	// DB 접속 관련 문자열 상수들.
	private static final String DB_DRIVER = 
							"com.mysql.jdbc.Driver";
	private static final String DB_URL = 
							"jdbc:mysql://127.0.0.1:3306/jsp";
	private static final String DB_ID = 
							"root";
	private static final String DB_PW = 
							"sds1501";
////////////////////////////////////////////////////////////	
	// singleton 패턴 적용
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("mysql 드라이버 로딩 오류");
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////	
	// DB 연결, 해제 관련 필드와 메소드들
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void makeConnection() {
		try {
			con = DriverManager.getConnection
								(DB_URL, DB_ID, DB_PW);
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
			e.printStackTrace();
		}
	}
	private void closeCon() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	private void closePstmt() {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	private void closeRs() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
////////////////////////////////////////////////////////////

	// 1. 총 게시글의 갯수 조회
	public int selectArticleCount() {
		makeConnection();
		String sql = "SELECT COUNT(*) FROM BOARD";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // sql 실행
			
			// 결과 숫자 하나 얻기
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("dao count 에러");
			e.printStackTrace();
		} finally {
			closeRs();
			closePstmt();
			closeCon();
		}
		return result;
	}
	
	// 2. 특정 페이지에 보여질 게시글 조회
	public List<Article> selectArticleList
							(int startRow, int count){
		makeConnection();
		String sql = "SELECT ARTICLE_NUM, TITLE,"
				+ "WRITER, CONTENTS, READ_COUNT,"
				+ "write_time FROM BOARD "
				+ "ORDER BY ARTICLE_NUM DESC LIMIT ?,?";
		List<Article> articleList = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery(); // SQL 실행
			
			while(rs.next()) {
				Article article = new Article();
				article.setAritlcleNum(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setWriter(rs.getString(3));
				article.setContents(rs.getString(4));
				article.setReadCount(rs.getInt(5));
				article.setWriteDate(rs.getTimestamp(6));
				
				articleList.add(article);
			}
		} catch (SQLException e) {
			System.out.println("dao selectArticleList 에러");
			e.printStackTrace();
		} finally {
			closeRs();
			closePstmt();
			closeCon();
		}
		return articleList;
	}
	
//////////////////////////////////////////////////////////
	// 글쓰기 메소드
	public int insert(Article article) {
		makeConnection();
		String sql = "INSERT INTO BOARD"
				+ "(TITLE,WRITER,CONTENTS,READ_COUNT,"
				+ "WRITE_TIME) VALUES(?,?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getWriter());
			pstmt.setString(3, article.getContents());
			pstmt.setInt(4, article.getReadCount());
			pstmt.setTimestamp(5, 
				new Timestamp(article.getWriteDate().getTime()));
			
			result = pstmt.executeUpdate(); // SQL 실행
		} catch (SQLException e) {
			System.out.println("dao insert 에러");
			e.printStackTrace();
		} finally {
			closePstmt();
			closeCon();
		}
		return result;
	}
//////////////////////////////////////////////////////////

	// 1. 조회수 증가
	public int updateReadCount(int articleNum) {
		makeConnection();
		String sql = 
			"UPDATE BOARD SET READ_COUNT=READ_COUNT+1 "
			+ "WHERE ARTICLE_NUM=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			
			result = pstmt.executeUpdate(); // SQL 실행			
		} catch (SQLException e) {
			System.out.println("dao update 에러");
			e.printStackTrace();
		} finally {
			closePstmt();
			closeCon();
		}
		return result;
	}
	// 2. 해당 번호의 Article 조회
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
//////////////////////////////////////////////////////////
	// 수정하기
	public int update(Article article) {
		makeConnection();
		int result = 0;
		String sql = 
		"UPDATE BOARD SET TITLE=?,CONTENTS=?,write_time=? "
		+ "WHERE ARTICLE_NUM=? ";
		
		System.out.println("dao update:"+article);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContents());
			pstmt.setTimestamp(3, 
					new Timestamp
						(article.getWriteDate().getTime()));
			pstmt.setInt(4, article.getAritlcleNum());
			
			result = pstmt.executeUpdate();//SQL 실행
		} catch (SQLException e) {
			System.out.println("dao update 에러");
			e.printStackTrace();
		} finally {
			closePstmt();
			closeCon();
		}
		return result;
	}
/////////////////////////////////////////////////////////
	// 삭제하기
	public int delete(int articleNum) {
		makeConnection();
		int result = 0;
		String sql = 
				"DELETE FROM BOARD "
				+ "WHERE ARTICLE_NUM=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			
			result = pstmt.executeUpdate();//SQL 실행
		} catch (SQLException e) {
			System.out.println("dao delete 에러");
			e.printStackTrace();
		} finally {
			closePstmt();
			closeCon();
		}
		return result;
	}
}
















