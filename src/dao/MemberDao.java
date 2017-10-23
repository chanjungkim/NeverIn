package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class MemberDao {
////////////////////////////////////////////////////////////
	// singleton
	private static MemberDao instance;
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	private MemberDao() {
		DBUtil.loadDriver(); // mysql ����̹� �ε� 
	}
////////////////////////////////////////////////////////////
	// DB ����, ���� ���� �ʵ�� �޼ҵ��
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;	
////////////////////////////////////////////////////////////
	// SQL ���� �޼ҵ�
	public int insert(Member member) {
		con = DBUtil.makeConnection();
		String sql = "INSERT INTO MEMBER(ID,PW,PHONE,NAME)"
				+ "VALUES(?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getName());
			
			result = pstmt.executeUpdate(); // SQL ����
		} catch (SQLException e) {
			System.out.println("Member dao insert error");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
		
	}
///////////////////////////////////////////////////////////
	public String selectIdUsingIdPw(String id, String pw) {
		con = DBUtil.makeConnection();
		String sql = 
			"SELECT ID FROM MEMBER WHERE ID=? AND PW=?";
		String result = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("member dao select error");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
}








