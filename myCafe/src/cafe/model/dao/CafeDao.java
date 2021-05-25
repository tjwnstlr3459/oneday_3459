package cafe.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import cafe.model.vo.Cafe;

public class CafeDao {

	public Cafe selectOneCafe(SqlSession session, Cafe c) {
		Cafe cafe = session.selectOne("cafe.selectOneCafe",c);
		return cafe;
	}

	public int insertCafe(SqlSession session, Cafe cafe) {
		int result = session.insert("cafe.insertCafe",cafe);
		return result;
	}

	public ArrayList<Cafe> allCafe(SqlSession session) {

		List<Cafe> list =  session.selectList("cafe.allCafe");
		return (ArrayList<Cafe>)list;
	}

}
