package free.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import free.model.dao.FreeDao;
import free.model.vo.Free;
import free.model.vo.FreeComment;
import free.model.vo.FreePageData;
import free.model.vo.FreeViewData;

public class FreeService {

	// 게시물 작성
	public int insertFree(Free f) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FreeDao().insertFree(conn, f);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}

	// 검색
	public FreePageData selectSearchList(int reqPage, String searchWhat, String searchContent) {
		Connection conn = JDBCTemplate.getConnection();
		// 페이지 당 게시물 수 설정
		int numPerPage = 10;
		// reqPage를 통해 조회할 시작/끝 게시물 설정
		int end = reqPage * numPerPage;
		int start = end - numPerPage + 1;
		// 요청한 페이지의 게시물 조회
		FreeDao dao = new FreeDao();
		ArrayList<Free> list = null;
		int totalCount = 0;

		// 검색 필터링
		if (searchWhat.equals("2")) {
			list = dao.selectWriterList(conn, start, end, searchContent); // 게시물 전체 조회
			totalCount = dao.totalCountWriter(conn, searchContent); // 게시물 수 조회
		} else if (searchWhat.equals("1")) {
			list = dao.selectTitleList(conn, start, end, searchContent); // 게시물 전체 조회
			totalCount = dao.totalCountTitle(conn, searchContent);
		}
		// 페이지 처리
		// 전체 페이지 수 계산
		int totalPage = (totalCount % numPerPage == 0) ? totalCount / numPerPage : (totalCount / numPerPage) + 1;

		// 보여줄 페이지 수
		int pageNaviSize = 5;
		// 페이지 번호
		int pageNo = 0;

		// 페이지 시작 번호 설정
		if (reqPage <= 3) { // 3페이지 이하인 경우 1
			pageNo = 1;
		} else { // 현제 페이지 -2 -> 현제 페이지 중앙처리
			pageNo = reqPage - 2;
		}

		// pageNavi 생성
		String pageNavi = "<ul class='pagination'>";

		// 이전 버튼 생성 - 현재 페이지가 1이 아닌경우
		if (reqPage != 1) {
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='/freeSearch?reqPage=" + (reqPage - 1) + "&searchWhat=" + searchWhat
					+ "&searchContent=" + searchContent + "'>&lt</a></li>";
		}
		// 페이지 숫자 생성
		for (int i = 0; i < pageNaviSize; i++) {
			// 현제 페이지가 요청한 페이지 인 경우
			if (pageNo == reqPage) { // active 효과 주기
				pageNavi += "<li class='page-item active'>";
			} else {
				pageNavi += "<li class='page-item'>";
			}
			pageNavi += "<a class='page-link' href='freeSearch?reqPage=" + pageNo + "&searchWhat=" + searchWhat
					+ "&searchContent=" + searchContent + "'>" + pageNo + "</a></li>";
			pageNo++; // 페이지 수 증가

			// 마지막 페이지 생성 후 for문 탈출
			if (pageNo > totalPage) {
				break;
			}
		}
		// 다음 버튼 생성 - 현재 페이지가 마지막 페이지가 아닌 경우
		if (reqPage < totalPage) {
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='freeSearch?reqPage=" + (reqPage + 1) + "&searchWhat=" + searchWhat
					+ "&searchContent=" + searchContent + "'>&gt</a></li>";
		}
		// pageNavi 종료
		pageNavi += "</ul>";

		JDBCTemplate.close(conn);

		// data 전송
		FreePageData fpd = new FreePageData(list, pageNavi);
		return fpd;
	}

	// 게시판 형식 view
	public FreePageData selectFreeList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		// 페이지 당 게시물 수 설정
		int numPerPage = 10;
		// reqPage를 통해 조회할 시작/끝 게시물 설정
		int end = reqPage * numPerPage;
		int start = end - numPerPage + 1;
		// 요청한 페이지의 게시물 조회
		FreeDao dao = new FreeDao();
		ArrayList<Free> list = dao.selectFreeList(conn, start, end);

		// 페이지 처리
		// 전체 게시물 수 조회
		int totalCount = dao.totalCount(conn);
		// 전체 페이지 수 계산
		int totalPage = (totalCount % numPerPage == 0) ? totalCount / numPerPage : (totalCount / numPerPage) + 1;

		// 보여줄 페이지 수
		int pageNaviSize = 5;
		// 페이지 번호
		int pageNo = 0;

		// 페이지 시작 번호 설정
		if (reqPage <= 3) { // 3페이지 이하인 경우 1
			pageNo = 1;
		} else { // 현제 페이지 -2 -> 현제 페이지 중앙처리
			pageNo = reqPage - 2;
		}

		// pageNavi 생성
		String pageNavi = "<ul class='pagination'>";

		// 이전 버튼 생성 - 현재 페이지가 1이 아닌경우
		if (reqPage != 1) {
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='/freeBoard?reqPage=" + (reqPage - 1) + "'>&lt</a></li>";
		}
		// 페이지 숫자 생성
		for (int i = 0; i < pageNaviSize; i++) {
			// 현제 페이지가 요청한 페이지 인 경우
			if (pageNo == reqPage) { // active 효과 주기
				pageNavi += "<li class='page-item active'>";
			} else {
				pageNavi += "<li class='page-item'>";
			}
			pageNavi += "<a class='page-link' href='freeBoard?reqPage=" + pageNo + "'>" + pageNo + "</a></li>";
			pageNo++; // 페이지 수 증가

			// 마지막 페이지 생성 후 for문 탈출
			if (pageNo > totalPage) {
				break;
			}
		}
		// 다음 버튼 생성 - 현재 페이지가 마지막 페이지가 아닌 경우
		if (reqPage < totalPage) {
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='freeBoard?reqPage=" + (reqPage + 1) + "'>&gt</a></li>";
		}
		// pageNavi 종료
		pageNavi += "</ul>";

		JDBCTemplate.close(conn);

		// data 전송
		FreePageData fpd = new FreePageData(list, pageNavi);
		return fpd;
	}

	// 게시물 및 댓글 불러오기
	public FreeViewData selectFreeView(int freeNo, String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		FreeDao dao = new FreeDao();

		// 게시물 전체 정보 및 좋아요 수 조회
		Free f = dao.selectOneFree(conn, freeNo);
		ArrayList<FreeComment> list = dao.selectFreeCommentList(conn, freeNo);

		// 해당 게시물 현재 로그인 한 회원의 좋아요 체크
		int result = dao.selectLike(conn, freeNo, memberId);

		JDBCTemplate.close(conn);

		FreeViewData fvd = new FreeViewData(f, list, result);
		return fvd;
	}

	// 조회수 증가
	public int updateReadCount(int freeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FreeDao().updateReadCount(conn, freeNo);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}

	// 좋아요 추가
	public int insertFreeLike(int freeNo, String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FreeDao().insertFreeLike(conn, freeNo, memberId);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}

	// 좋아요 삭제
	public int deleteFreeLike(int freeNo, String freeWriter) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FreeDao().deleteFreeLike(conn, freeNo, freeWriter);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}

	// 게시물 1개 조회
	public Free selectFree(int freeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Free f = new FreeDao().selectFree(conn, freeNo);

		JDBCTemplate.close(conn);
		return f;
	}

	// 게시물 수정
	public int updateFree(Free f) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FreeDao().updateFree(conn, f);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}

	// 게시물 삭제
	public int deleteFree(int freeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FreeDao().deleteFree(conn, freeNo);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}
}
