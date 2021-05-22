package Member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import donation.login.Member;

public class MemberDao {

	public static Member selectOneUser(Connection conn, String memberId, String memberPw) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where member_id=? and member_pw=?";
		Member m = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberAddr(rset.getString("member_Addr"));
				m.setMemberEmail(rset.getString("member_Email"));
				m.setMemberId(rset.getString("member_Id"));
				m.setMemberPw(rset.getString("member_Pw"));
				m.setMemberName(rset.getString("member_Name"));
				m.setMemberNo(rset.getInt("member_No"));
				m.setMemberPhone(rset.getString("Phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int inserMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member values(member_seq.nextval,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberAddr());
			pstmt.setString(5, m.getMemberEmail());
			pstmt.setString(6, m.getMemberPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member selectOneUser(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where member_id=?";
		Member m = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberAddr(rset.getString("member_Addr"));
				m.setMemberEmail(rset.getString("member_Email"));
				m.setMemberId(rset.getString("member_Id"));
				m.setMemberName(rset.getString("member_Name"));
				m.setMemberNo(rset.getInt("member_No"));
				m.setMemberPw(rset.getString("member_Pw"));
				m.setMemberPhone(rset.getString("Phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(rset);
		}
		
		return m;
	}

	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member set member_pw=?, member_email=?, member_addr=?,Phone=? where member_id = ?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getMemberEmail());
			pstmt.setString(3, m.getMemberAddr());
			pstmt.setString(4, m.getMemberPhone());
			pstmt.setString(5, m.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from member where member_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	

}
