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
	// DB ���� ���� ���ڿ� �����.
	private static final String DB_DRIVER = 
							"com.mysql.jdbc.Driver";
	private static final String DB_URL = 
							"jdbc:mysql://127.0.0.1:3306/jsp";
	private static final String DB_ID = 
							"root";
	private static final String DB_PW = 
							"sds1501";
////////////////////////////////////////////////////////////	
	// singleton ���� ����
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("mysql ����̹� �ε� ����");
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////	
	// DB ����, ���� ���� �ʵ�� �޼ҵ��
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void makeConnection() {
		try {
			con = DriverManager.getConnection
								(DB_URL, DB_ID, DB_PW);
		} catch (SQLException e) {
			System.out.println("Ŀ�ؼ� ���� ����");
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
	// SQL ���� �޼ҵ�
	// �Խ��� �����ؼ� ��Ϻ��� �۾��� �ʿ��� �޼ҵ�
	// 1. �� �Խñ��� ���� ��ȸ
	public int selectArticleCount() {
		makeConnection();
		String sql = "SELECT COUNT(*) FROM BOARD";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // sql ����
			
			// ��� ���� �ϳ� ���
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("dao count ����");
			e.printStackTrace();
		} finally {
			closeRs();
			closePstmt();
			closeCon();
		}
		return result;
	}
	
	// 2. Ư�� �������� ������ �Խñ� ��ȸ
	public List<Article> selectArticleList
							(int startRow, int count){
		makeConnection();
		String sql = "SELECT ARTICLE_NUM, TITLE,"
				+ "WRITER, CONTENTS, READ_COUNT,"
				+ "WRITE_DATE, PASSWORD FROM BOARD "
				+ "ORDER BY ARTICLE_NUM DESC LIMIT ?,?";
		List<Article> articleList = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery(); // SQL ����
			
			while(rs.next()) {
				Article article = new Article();
				article.setAritlcleNum(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setWriter(rs.getString(3));
				article.setContents(rs.getString(4));
				article.setReadCount(rs.getInt(5));
				article.setWriteDate(rs.getTimestamp(6));
				article.setPassword(rs.getString(7));
				
				articleList.add(article);
			}
		} catch (SQLException e) {
			System.out.println("dao selectArticleList ����");
			e.printStackTrace();
		} finally {
			closeRs();
			closePstmt();
			closeCon();
		}
		return articleList;
	}
	
//////////////////////////////////////////////////////////
	// �۾��� �޼ҵ�
	public int insert(Article article) {
		makeConnection();
		String sql = "INSERT INTO BOARD"
				+ "(TITLE,WRITER,PASSWORD,CONTENTS,READ_COUNT,"
				+ "WRITE_DATE) VALUES(?,?,?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getWriter());
			pstmt.setString(3, article.getPassword());
			pstmt.setString(4, article.getContents());
			pstmt.setInt(5, article.getReadCount());
			pstmt.setTimestamp(6, 
				new Timestamp(article.getWriteDate().getTime()));
			
			result = pstmt.executeUpdate(); // SQL ����
		} catch (SQLException e) {
			System.out.println("dao insert ����");
			e.printStackTrace();
		} finally {
			closePstmt();
			closeCon();
		}
		return result;
	}
//////////////////////////////////////////////////////////
	// �� �б� �۾��� �ʿ��� �޼ҵ�
	// 1. ��ȸ�� ����
	public int updateReadCount(int articleNum) {
		makeConnection();
		String sql = 
			"UPDATE BOARD SET READ_COUNT=READ_COUNT+1 "
			+ "WHERE ARTICLE_NUM=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			
			result = pstmt.executeUpdate(); // SQL ����			
		} catch (SQLException e) {
			System.out.println("dao update ����");
			e.printStackTrace();
		} finally {
			closePstmt();
			closeCon();
		}
		return result;
	}
	// 2. �ش� ��ȣ�� Article ��ȸ
	public Article select(int articleNum) {
		makeConnection();
		String sql = 
			"SELECT ARTICLE_NUM,TITLE,WRITER,"
			+ "CONTENTS,WRITE_DATE,READ_COUNT FROM BOARD "
			+ "WHERE ARTICLE_NUM=?";
		Article article = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			rs = pstmt.executeQuery(); // SQL ����
			
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
			System.out.println("dao select ����");
			e.printStackTrace();
		} finally {
			closeRs();
			closePstmt();
			closeCon();
		}
		return article;
	}	
	public int update(Article article) {
		makeConnection();
		int result = 0;
		String sql = "update board set title=?, contents=?,"
		+"write_date = ? where article_num=? and password=?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContents());
			pstmt.setString(2, article.getContents());
			pstmt.setTimestamp(3, new Timestamp(article.getWriteDate().getTime()));
			pstmt.setInt(4,  article.getAritlcleNum());
			pstmt.setString(5,  article.getPassword());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("dao update 에러");
			e.printStackTrace();
		} finally {
			closePstmt();
			closeCon();
		}
		return result;
	}
	
	public int delete(String pw, int articleNum){
		makeConnection();
		int result = 0;
		String sql = "delete from board where password=? and article_num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setInt(2, articleNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePstmt();
			closeCon();
		}
		
		return result;
	}
}
















