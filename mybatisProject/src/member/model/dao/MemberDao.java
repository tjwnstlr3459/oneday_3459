package member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;

public class MemberDao {
	public Member selectOneMember(SqlSession session, Member member) {
		//member는 mapper에있는 name값이다
		//selectOneMember는 mapper에있는 select id값이다
		Member m = session.selectOne("member.selectOneMember",member);
		return m;
	}

	public int insertMember(SqlSession session, Member m) {
		int result = session.insert("member.insertMember",m);
		return result;
	}

	public Member selectOneMember(SqlSession session, String memberId) {
		return session.selectOne("member.selectOneMemberId",memberId);
		//변수 안만들고 바로 리턴
	}

	public int updateMember(SqlSession session, Member m) {
		int result = session.update("member.updateMember",m);
		return result;
	}

	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("member.deleteMember",memberId);
		return result;
	}

	public List<Member> selectAllMember(SqlSession session) {
		List<Member> list = session.selectList("member.allMember");
		return list;
	}
	//전체조회 두번째 방법
//	public ArrayList<Member> selectAllMember(SqlSession session) {
//		List<Member> list = session.selectList("member.allMember");
//		return (ArrayList<Member>)list;
//	}
	
	
	public Member selectOneMember(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("member.idSearch",map);
	}

	public Member selectOneMemberPw(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("member.pwSearch",map);
	}

	public ArrayList<Member> ifTest(SqlSession session, HashMap<String, Object> map) {
		List<Member> list = session.selectList("member.ifTest",map);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> chooseTest(SqlSession session, HashMap<String, Object> map) {
		List<Member> list = session.selectList("member.chooseTest",map);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> chooseTest2(SqlSession session, HashMap<String, Object> map) {
		List<Member> list = session.selectList("member.chooseTest2",map);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> foreachTest(SqlSession session, String[] name) {
		//그냥 스트링배열이 넘어와도 자동으로 HashMap에 담아서 dao 넘겨주기에
		//mapper에서는 받는 타입 map 이다
		
		List<Member> list = session.selectList("member.foreachTest",name);
		return (ArrayList<Member>)list;
	}
	

	
	
}
