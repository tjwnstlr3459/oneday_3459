package main.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import donation.DonationList;
import free.model.vo.Free;
import main.model.dao.MainDao;
import product.model.vo.Product;


public class MainService {

	public ArrayList<Product> searchProduct(String search) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = new MainDao().searchProduct(conn,search);
		JDBCTemplate.close(conn);
		return list;	
	}

	public ArrayList<DonationList> searchDonationList(String search) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<DonationList> list = new MainDao().searchDonationList(conn,search);
		JDBCTemplate.close(conn);
		return list;	
	}
	
	public ArrayList<Free> likeList(String id) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Free> list = new MainDao().likeList(conn,id);
		JDBCTemplate.close(conn);
		return list;	
	}

	public ArrayList<Free> allList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Free> list = new MainDao().allList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> allGoodsProduct() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = new MainDao().allGoodsProduct(conn);
		JDBCTemplate.close(conn);
		return list;
	}

}
