package photo.medel.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import photo.medel.dao.PhotoDao;
import photo.medel.vo.Photo;

public class PhotoService {

	public int totalCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int totalCount = new PhotoDao().totalCount(conn);
		
		JDBCTemplate.close(conn);
		
		return totalCount;
	}

	public int insertPhoto(Photo p) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new PhotoDao().insertPhoto(conn,p);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Photo> morePhoto(int start) {
		Connection conn = JDBCTemplate.getConnection();
		//5개씩 사진 가져올거라서
		int length = 5;
		int end = start+length-1;
		
		ArrayList<Photo> list = new PhotoDao().morePhoto(conn,start,end);
		JDBCTemplate.close(conn);
		
		return list;
	}
}












