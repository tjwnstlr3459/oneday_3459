package product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import product.model.vo.Product;

public class ProductDao {

	public ArrayList<Product> selectProductList(Connection conn, int end, int start) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		String query = "select * from (select rownum as rnum, p.* from (select * from product order by product_no desc)p) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = new Product();
				p.setFilename(rset.getString("filename"));
				p.setFilepath(rset.getString("filename"));
				p.setProductContent(rset.getString("product_contetnt"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductNo(rset.getInt("product_no"));
				p.setProductSpons(rset.getString("product_spons"));
				p.setProductTitle(rset.getString("product_title"));
				p.setRnum(rset.getInt("rnum"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
			
		}
		return list;
	}

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		String query = "select count(*) as cnt from product";
		int totalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return totalCount;
	}

	public int insertProduct(Connection conn, Product p) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into product values(pd_seq.nextval,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getProductTitle());
			pstmt.setString(2, p.getProductInfo());
			pstmt.setString(3, p.getFilename());
			pstmt.setString(4, p.getFilepath());
			pstmt.setString(5, p.getProductContent());
			pstmt.setString(6, p.getProductSpons());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Product selectOneProduct(Connection conn, int productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from product where product_no=?";
		Product p = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				p = new Product();
				p.setProductContent(rset.getString("product_contetnt"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductNo(rset.getInt("product_no"));
				p.setProductTitle(rset.getString("product_title"));
				p.setFilename(rset.getString("filename"));
				p.setFilepath(rset.getString("filepath"));
				p.setProductSpons(rset.getString("product_spons"));

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return p;
	}

	public int updateProduct(Connection conn, Product p) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update product set product_title=?,product_info=?,filename=?,filepath=?,product_contetnt=?,product_spons=? where product_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getProductTitle());
			pstmt.setString(2, p.getProductInfo());
			pstmt.setString(3, p.getFilename());
			pstmt.setString(4, p.getFilepath());
			pstmt.setString(5, p.getProductContent());
			pstmt.setString(6, p.getProductSpons());
			pstmt.setInt(7, p.getProductNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteProduct(Connection conn, int productNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from product where product_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int totalCountSpons(Connection conn , String spons) {
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		String query = "select count(*) as cnt from product where product_spons=?";
		int totalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, spons);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return totalCount;
	}

	public ArrayList<Product> selectSponsList(Connection conn, int end, int start, String spons) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		String query = "select * from (select rownum as rnum, s.* from (select * from product where product_spons = ? )s) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, spons);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = new Product();
				p.setFilename(rset.getString("filename"));
				p.setFilepath(rset.getString("filename"));
				p.setProductContent(rset.getString("product_contetnt"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductNo(rset.getInt("product_no"));
				p.setProductSpons(rset.getString("product_spons"));
				p.setProductTitle(rset.getString("product_title"));
				p.setRnum(rset.getInt("rnum"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
			
		}
		return list;
	}

}	
