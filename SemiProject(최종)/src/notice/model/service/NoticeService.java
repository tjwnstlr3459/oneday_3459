package notice.model.service;

 

import notice.model.vo.NoticePageData;
import notice.model.vo.NoticeViewData;

import java.sql.Connection;

import java.util.ArrayList;

 

import common.JDBCTemplate;

import notice.model.dao.NoticeDao;


import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
 

public class NoticeService {

 

	public NoticePageData selectNoticeList(int reqPage) {

		Connection conn = JDBCTemplate.getConnection();

		int numPerPage = 10; 

		int end = reqPage * numPerPage; 

		int start = end-numPerPage+1;

		//게시물을 조회

		NoticeDao dao = new NoticeDao();

		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn, start, end);	

		//페이지 네비게이션

		int totalCount = dao.totalCount(conn);

		//전체 페이지수 계산

		int totalPage = 0;

		if(totalCount%numPerPage==0) {

			totalPage = totalCount/numPerPage; 

		}else {

			totalPage = totalCount/numPerPage+1;

		}

		//페이지 네비 길이지정

		int pageNaviSize = 5; 

		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;

		String pageNavi = "<ul class=\"pagination justify-content-center\">";

		if(pageNo !=1) { //'<'로하고싶으면 &lt

			pageNavi +="<li class='page-item'>";

			pageNavi += "<a class='page-link' href='supportList?reqPage="+(pageNo-1)+"'>&lt</a></li>";

		}

		//페이지 숫자 생성

		for(int i=0; i<pageNaviSize; i++) {

			if(pageNo == reqPage) {		

				pageNavi += "<li class='page-item'>";

				pageNavi +="<a class='page-link' href='/supportList?reqPage="+pageNo+"'>"+pageNo+"</a></li>";

			}else {

				pageNavi += "<li class='page-item'>";

				pageNavi +="<a class='page-link' href='/supportList?reqPage="+pageNo+"'>"+pageNo+"</a></li>";

			}

			pageNo++;

			if(pageNo > totalPage) {

				break; //나가나가

			}

		}

		//다음버튼 

		if(pageNo <= totalPage) {

			pageNavi +="<li class='page-item'>";

			pageNavi += "<a class='page-link' href='supportList?reqPage="+(pageNo)+"'>&gt;</a></li>"; //'<'로하고싶으면 &lt

			

		}

		pageNavi +="</ul>";

		JDBCTemplate.close(conn);

		NoticePageData npd = new NoticePageData(list,pageNavi);

		return npd;

	}
	public int insertNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().insertNotice(conn,n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Notice selectOneNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeDao dao = new NoticeDao();
		Notice n = dao.selectOneNotice(conn,noticeNo);		
		JDBCTemplate.close(conn);
		return n;
	}
	public NoticeViewData selectNoticeView(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeDao dao = new NoticeDao();
		Notice n = dao.selectOneNotice(conn,noticeNo);
		ArrayList<NoticeComment> list = dao.selectNoticeCommentList(conn,noticeNo);
		JDBCTemplate.close(conn);
		NoticeViewData nvd = new NoticeViewData(n, list);
		return nvd;
	}

	public int deleteNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteNotice(conn,noticeNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateNotice(Notice n) {		
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().updateNotice(conn,n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertComment(NoticeComment nc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().insertComment(conn,nc);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateNoticeComment(int ncNo, String ncContent) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().updateNoticeComment(conn,ncNo,ncContent);
		if(result>0) {
			JDBCTemplate.commit(conn);			
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteNoticeComment(int ncNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteNoticeComment(conn,ncNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	}