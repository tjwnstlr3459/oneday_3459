package member.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	//계속 쓸거기에 메소드 선언
	private SqlSession getSqlSession() {
		SqlSession session = null;
		//리소스폴더가 "/"<-
		String resource = "/mybatis-config.xml";
		try {
			
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			//이 객체가 DataSource를 참조하여 MyBatis와 Mysql 서버를 연동시켜준다
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession(false);	//auto commit 해제를 위한 false값 전달
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
	
	
	public Member selectOneMember(Member member) {
		SqlSession session = getSqlSession();	//connection대신 sqlsession사용
		Member m = new MemberDao().selectOneMember(session,member);
		
		session.close();
		return m;
	}


	public int insertMember(Member m) {
		SqlSession session = getSqlSession();
		int result = new MemberDao().insertMember(session,m);
		
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}


	public Member selectOneMember(String memberId) {
		SqlSession session = getSqlSession();
		Member m = new MemberDao().selectOneMember(session, memberId);
		session.close();
		return m;
	}


	public int updateMember(Member m) {
		SqlSession session = getSqlSession();
		int result = new MemberDao().updateMember(session,m);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}


	public int deleteMember(String memberId) {
		SqlSession session = getSqlSession();
		int result = new MemberDao().deleteMember(session,memberId);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}


	public ArrayList<Member> selectAllMember() {
		SqlSession session = getSqlSession();
		ArrayList<Member> list = (ArrayList<Member>)new MemberDao().selectAllMember(session);
		session.close();
		return list;
	}


	public Member selectOneMember(String memberName, String phone) {
		SqlSession session = getSqlSession();
//		int num1 = 10;
//		int num2 = 200;
		HashMap<String, Object> map = new HashMap<>();
		map.put("memberName", memberName);
		map.put("phone", phone);
//		map.put("num1", num1);
//		map.put("num2", num2);
		
		Member m = new MemberDao().selectOneMember(session,map);
		session.close();
		return m;
	}


	public Member selectOneMemberPw(String memberId, String phone) {
		SqlSession session = getSqlSession();
		HashMap<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("phone", phone);
		
		Member m = new MemberDao().selectOneMemberPw(session,map);
		session.close();
		return m;
	}


	public ArrayList<Member> ifTest(String ckName, String ckPhone, String ckAddress) {
		SqlSession session = getSqlSession();
		
		//여러러 값을 넣기위해 맵을 사용해 넣기
		HashMap<String, Object> map = new HashMap<>();
		map.put("ckName", ckName);
		map.put("ckPhone", ckPhone);
		map.put("ckAddress", ckAddress);
		ArrayList<Member> list = new MemberDao().ifTest(session,map);
		session.close();
		return list;
	}


	public ArrayList<Member> chooseTest(String type, String keyword) {
		SqlSession session = getSqlSession();
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("type", type);
		map.put("keyword", keyword);
		ArrayList<Member> list = new MemberDao().chooseTest(session,map);
		session.close();
		return list;
	}


	public ArrayList<Member> chooseTest2(String name, String address) {
		SqlSession session = getSqlSession();
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("address", address);
		ArrayList<Member> list = new MemberDao().chooseTest2(session,map);
		session.close();
		return list;
	}


	public ArrayList<Member> foreachTest(String[] name) {
		SqlSession session =getSqlSession();
		ArrayList<Member> list = new MemberDao().foreachTest(session,name);
		session.close();
		return list;
	}
}












