package cafe.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cafe.model.dao.CafeDao;
import cafe.model.vo.Cafe;

public class CafeService {
	//세션 메소드 쓸거기에 메소드 선언
	private SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "/mybatis-config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession(false);	//자동커밋 해제
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
	
	
	

	public Cafe selectOneCafe(Cafe c) {
		SqlSession session = getSqlSession();
		
		Cafe cafe = new CafeDao().selectOneCafe(session,c);
		session.close();
		return cafe;
	}




	public int insertCafe(Cafe cafe) {
		SqlSession session = getSqlSession();
		
		int result = new CafeDao().insertCafe(session,cafe);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();;
		}
		session.close();
		return result;
	}




	public ArrayList<Cafe> allCafe() {
		SqlSession session = getSqlSession();
		
		ArrayList<Cafe> list = new CafeDao().allCafe(session);
		session.close();
		return list;
	}





}
