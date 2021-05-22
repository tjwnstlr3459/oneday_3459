package free.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import free.model.vo.Free;
import free.model.vo.FreeComment;

public class FreeDao {
	// 게시물 작성
	public int insertFree(Connection conn, Free f) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into free values(free_seq.nextval, ?, ?, ?, to_char(sysdate, 'yyyy-mm-dd'), ?, 0)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, f.getFreeTitle());
			pstmt.setString(2, f.getFreeWriter());
			pstmt.setString(3, (f.getFreeContent() == "") ? "내용 없음" : f.getFreeContent());
			pstmt.setString(4, f.getFilepath());
			System.out.println("게시물 작성 : " + f.getFilepath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 게시물 전체 조회 + 좋아요 조회
	public ArrayList<Free> selectFreeList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROWNUM AS RNUM, F.*, (SELECT COUNT(*) AS CNT FROM FREE_LIKE WHERE FREE_REF = F.FREE_NO) AS LIKE_COUNT FROM (SELECT * FROM FREE ORDER BY FREE_NO DESC) F) WHERE RNUM BETWEEN ? AND ?";
		ArrayList<Free> list = new ArrayList<Free>();

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(setFree(rset, "조회"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	// 게시물 총 갯수 조회
	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as cnt from free";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 게시물 1개 정보 조회
	public Free selectFree(Connection conn, int freeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM FREE WHERE FREE_NO = ?";
		Free f = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				f = setFree(rset, "");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return f;
	}

	// 게시물 상세페이지 조회
	public Free selectOneFree(Connection conn, int freeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT F.*, (SELECT COUNT(*) AS CNT FROM FREE_LIKE WHERE FREE_REF = F.FREE_NO) AS LIKE_COUNT FROM (SELECT * FROM FREE WHERE FREE_NO = ?) F";
		Free f = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				f = setFree(rset, "상세");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return f;
	}

	// 게시물 저장용
	private Free setFree(ResultSet rset, String test) {
		Free f = new Free();

		try {
			f.setFilepath(rset.getString("filepath"));
			f.setFreeContent(rset.getString("free_content"));
			f.setFreeDate(rset.getString("free_date"));
			f.setFreeNo(rset.getInt("free_no"));
			f.setFreeTitle(rset.getString("free_title"));
			f.setFreeWriter(rset.getString("free_writer"));
			f.setReadCount(rset.getInt("read_count"));

			// 게시판 전체 조회
			if (test.equals("조회")) {
				f.setRnum(rset.getInt("rnum"));
				f.setLikeCount(rset.getInt("like_count"));
			}
			// 게시물 상세페이지
			if (test.equals("상세")) {
				f.setLikeCount(rset.getInt("like_count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	// 댓글 불러오기
	public ArrayList<FreeComment> selectFreeCommentList(Connection conn, int freeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FreeComment> list = new ArrayList<FreeComment>();
		String query = "select * from free_comment where free_ref = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNo);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(setFreeComment(rset));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	// 댓글 저장용
	private FreeComment setFreeComment(ResultSet rset) {
		FreeComment fc = new FreeComment();

		try {
			fc.setFcContent(rset.getString("fc_content"));
			fc.setFcDate(rset.getString("fc_date"));
			fc.setFcNo(rset.getInt("fc_no"));
			fc.setFcRef(rset.getInt("fc_ref")); // 널인 경우 0으로 넣어줌
			fc.setFcWriter(rset.getString("fc_writer"));
			fc.setFreeRef(rset.getInt("free_ref"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fc;
	}

	// 좋아요 check
	public int selectLike(Connection conn, int freeNo, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from free_like where free_ref = ? and member_id = ?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNo);
			pstmt.setString(2, memberId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 좋아요 추가
	public int insertFreeLike(Connection conn, int freeNo, String freeWriter) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO FREE_LIKE VALUES(LIKE_SEQ.NEXTVAL, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNo);
			pstmt.setString(2, freeWriter);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 좋아요 삭제
	public int deleteFreeLike(Connection conn, int freeNo) {
		PreparedStatement pstmt = null;
		String query = "delete from free_like where free_ref = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 게시글 삭제
	public int deleteFreeLike(Connection conn, int freeNo, String freeWriter) {
		PreparedStatement pstmt = null;
		String query = "delete from free_like where free_ref = ? and member_id = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNo);
			pstmt.setString(2, freeWriter);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 조회수 증가
	public int updateReadCount(Connection conn, int freeNo) {
		PreparedStatement pstmt = null;
		String query = "update free set read_count = read_count + 1 where free_no = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 게시물 수정
	public int updateFree(Connection conn, Free f) {
		PreparedStatement pstmt = null;
		String query = "update free set free_title = ?, free_content = ?, filepath = ? where free_no = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, f.getFreeTitle());
			pstmt.setString(2, f.getFreeContent());
			pstmt.setString(3, f.getFilepath());
			pstmt.setInt(4, f.getFreeNo());
			System.out.println("게시물 수정 : " + f.getFilepath());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 게시물 삭제
	public int deleteFree(Connection conn, int freeNo) {
		PreparedStatement pstmt = null;
		String query = "delete from free where free_no = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 작성자 검색
	public ArrayList<Free> selectWriterList(Connection conn, int start, int end, String searchContent) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROWNUM AS RNUM, F.*, (SELECT COUNT(*) AS CNT FROM FREE_LIKE WHERE FREE_REF = F.FREE_NO) AS LIKE_COUNT FROM (SELECT * FROM FREE WHERE FREE_WRITER = ? ORDER BY FREE_NO DESC) F) WHERE RNUM BETWEEN ? AND ?";
		ArrayList<Free> list = new ArrayList<Free>();

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchContent);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(setFree(rset, "조회"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	// 작성자 검색 게시물 수
	public int totalCountWriter(Connection conn, String searchContent) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as cnt from free where free_writer = ?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchContent);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 제목 검색
	public ArrayList<Free> selectTitleList(Connection conn, int start, int end, String searchContent) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROWNUM AS RNUM, F.*, (SELECT COUNT(*) AS CNT FROM FREE_LIKE WHERE FREE_REF = F.FREE_NO) AS LIKE_COUNT FROM (SELECT * FROM FREE WHERE FREE_TITLE LIKE ? ORDER BY FREE_NO DESC) F) WHERE RNUM BETWEEN ? AND ?";
		ArrayList<Free> list = new ArrayList<Free>();

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchContent + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(setFree(rset, "조회"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	// 제목 검색 게시물 수
	public int totalCountTitle(Connection conn, String searchContent) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as cnt from free where free_title like ?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchContent + "%");

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}