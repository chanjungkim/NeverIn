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
		DBUtil.loadDriver(); // mysql 드라이버 로딩 
	}
////////////////////////////////////////////////////////////
	// DB 연결, 해제 관련 필드와 메소드들
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
		


////////////////////////////////////////////////////////////
	// SQL 실행 메소드
	public int insert(Member member) {
		con=DBUtil.makeConnection();
		String sql = "INSERT INTO MEMBER(ID,PW,NAME,BIRTH,GENDER,NICKNAME,EMAIL,PHONE,POINT,LV)"
				+ "VALUES(?,?,?,?,?,?,?,?,0,0)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2,member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getNickname());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getPhone());

			
			result = pstmt.executeUpdate(); // SQL 실행
		} catch (SQLException e) {
			System.out.println("Member dao insert 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
		
	}
///////////////////////////////////////////////////////////
	public String selectIdUsingIdPw(String id,String pw) {
		con=DBUtil.makeConnection();
		String sql = 
			"SELECT ID FROM MEMBER WHERE ID=? and pw=?";
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
			System.out.println("member dao select 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	
	public Member selectMember(String id) {
		con=DBUtil.makeConnection();
		String sql = "SELECT * FROM MEMBER WHERE ID=?";

		Member member = new Member();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				member.setId(rs.getString(1));
				member.setPw(rs.getString(2));
				member.setName(rs.getString(3));
				member.setBirth(rs.getString(4));
				member.setGender(rs.getString(5));
				member.setNickname(rs.getString(6));
				member.setEmail(rs.getString(7));
				member.setPhone(rs.getString(8));
				member.setPoint(rs.getInt(9));
				member.setLv(rs.getInt(10));
			}
		} catch (SQLException e) {
			System.out.println("member dao select 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return member;
	}
}








