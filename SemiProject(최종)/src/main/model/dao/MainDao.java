package main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import donation.DonationList;
import free.model.vo.Free;
import free.model.vo.FreeLike;
import product.model.vo.Product;

public class MainDao {

	public ArrayList<Product> searchProduct(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from product where product_title like '%"+search+"%' or product_info like '%"+search+"%' or product_spons like '%"+search+"%'";
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = new Product();
				p.setProductNo(rset.getInt("product_no"));
				p.setProductTitle(rset.getString("product_title"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductContent(rset.getString("product_contetnt"));
				p.setFilepath(rset.getString("filepath"));
				p.setFilename(rset.getString("filename"));
				p.setProductSpons(rset.getString("product_spons"));
				
				list.add(p);
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

	public ArrayList<DonationList> searchDonationList(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from donation_list where dona_title like '%"+search+"%' or dona_writer like '%"+search+"%' or dona_content like '%"+search+"%'";
		ArrayList<DonationList> list = new ArrayList<DonationList>();
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				DonationList d = new DonationList();
				d.setDona_no(rset.getInt("dona_no"));
				d.setDona_title(rset.getString("dona_title"));
				d.setDona_writer(rset.getString("dona_writer"));
				d.setDona_content(rset.getString("dona_content"));

				list.add(d);
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

	public ArrayList<Free> likeList(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="select * from free f join free_like f1 on f.free_no=f1.free_ref where f1.member_id=?";
		ArrayList<Free> list = new ArrayList<Free>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Free f = new Free();
				f.setFreeTitle(rset.getString("free_title"));
				f.setFreeContent(rset.getString("free_content"));
				f.setFreeWriter(rset.getString("free_writer"));
				f.setFreeDate(rset.getString("free_date"));
				f.setReadCount(rset.getInt("read_count"));
				f.setFreeNo(rset.getInt("free_no"));
				list.add(f);
				
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

	public ArrayList<Free> allList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="select * from free order by free_no desc";
		ArrayList<Free> list = new ArrayList<Free>();
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Free f = new Free();
				f.setFreeTitle(rset.getString("free_title"));
				f.setFreeContent(rset.getString("free_content"));
				f.setFreeWriter(rset.getString("free_writer"));
				f.setFreeDate(rset.getString("free_date"));
				f.setReadCount(rset.getInt("read_count"));
				f.setFreeNo(rset.getInt("free_no"));
				f.setFilepath(rset.getString("filepath"));
				list.add(f);
				
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

	public ArrayList<Product> allGoodsProduct(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from product";
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = new Product();
				p.setProductNo(rset.getInt("product_no"));
				p.setProductTitle(rset.getString("product_title"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductContent(rset.getString("product_contetnt"));
				p.setFilepath(rset.getString("filepath"));
				p.setFilename(rset.getString("filename"));
				p.setProductSpons(rset.getString("product_spons"));
				
				list.add(p);
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

}
