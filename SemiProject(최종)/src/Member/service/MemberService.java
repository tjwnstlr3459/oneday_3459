package Member.service;

import java.sql.Connection;

import Member.dao.MemberDao;
import common.JDBCTemplate;
import donation.login.Member;


public class MemberService {

	public Member selectOneUser(String memberId, String memberPw) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = MemberDao.selectOneUser(conn,memberId,memberPw);
		JDBCTemplate.close(conn);
		return m;
	}

	public int inserMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().inserMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Member selectOneMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectOneUser(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateMember(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMember(conn,memberNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}

