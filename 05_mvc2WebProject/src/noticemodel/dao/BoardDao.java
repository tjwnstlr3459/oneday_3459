package noticemodel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import common.JDBCTemplate;
import notice.model.vo.Notice;

public class BoardDao {

	public ArrayList<Notice> selectNoticeList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ArrayList<Notice> list = new ArrayList<>();
		ResultSet rset = null;
		String query="SELECT * FROM(SELECT ROWNUM AS RNUM, N.*FROM(SELECT * FROM BOARD ORDER BY BOARD_NO DESC)N) WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice();
				n.setFilename(rset.getString("filename"));
				n.setFilepath(rset.getString("filepath"));
				n.setNoticContent(rset.getString("board_content"));
				n.setNoticeDate(rset.getString("board_date"));
				n.setNoticeNo(rset.getInt("board_no"));
				n.setNoticeTitle(rset.getString("board_title"));
				n.setNoticeWriter(rset.getString("board_writer"));
				n.setRnum(rset.getInt("rnum"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as cnt from board";
		int result = 0;
		
		try {
			pstmt=conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result= rset.getInt("cnt");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}












