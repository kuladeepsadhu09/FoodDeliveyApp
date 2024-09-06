package com.tap.implem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.connec.dbutil;
import com.tap.daointerface.daointerfaceorder;
import com.tap.model.order;
import com.tap.model.restaurant;

public class orderDAOimpl implements daointerfaceorder {
	private Connection con;
	private PreparedStatement pstmt;
	private int statuss;
	private Statement stmt;
	private ResultSet res;
	private  order ord;
	ArrayList<order> al= new ArrayList<order>();
	private int x;
	private static final String ADD_ORDER="insert into `totalorder` (`resturantId`,`userId`,`totalAmount`,`status`)values(?,?,?,?)";
	private static final String GET_ALLOGERS="select * from `totalorder`";
	private static final String GET_SPECIFIC_RESTURANT="select * from totalorder where `orderId`=?";
	private static final String UPDATE_ORDER="update totalorder set `resturantId`=?,`userId`=?,totalAmount`=?,`status`=? where `orderId`=?";
	private static final String DELETE_ORDER="delete from totalorder where `orderId`=?";
	private static final String ORDER_ID="select max(`orderId`) from `totalorder`";
	
	
	public orderDAOimpl() {
		try {
			con=dbutil.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public int addorder(order ord) {
		try {
			pstmt=con.prepareStatement(ADD_ORDER);
			pstmt.setInt(1, ord.getResturantId());
			pstmt.setInt(2, ord.getUserId());
			pstmt.setDouble(3, ord.getTotalAmount());
			pstmt.setString(4,ord.getStatus());
			statuss=pstmt.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return statuss;
	}

	@Override
	public ArrayList<order> getllorders() {
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_ALLOGERS);
			al=extractuserlist(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public order getSpecfiRestaurant(int restaurantId) {
		try {
			pstmt=con.prepareStatement(GET_SPECIFIC_RESTURANT);
			pstmt.setInt(1,restaurantId);
			res=pstmt.executeQuery();
			al=extractuserlist(res);
			ord=al.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ord;
	}

	@Override
	public int updateRestaurant(order ord) {
		try {
			pstmt=con.prepareStatement(UPDATE_ORDER);
			pstmt.setInt(1, ord.getResturantId());
			pstmt.setInt(2, ord.getUserId());
			pstmt.setDouble(3, ord.getUserId());
			pstmt.setString(4,ord.getStatus());
			pstmt.setInt(5,ord.getOrderId());
			statuss=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statuss;
	}

	@Override
	public int deleteRestaurant(int orderID) {
		try {
			pstmt=con.prepareStatement(DELETE_ORDER);
			pstmt.setInt(1, orderID);
			statuss=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return statuss;
	}
	ArrayList<order> extractuserlist(ResultSet res) {
		try {
		while(res.next()) {
			al.add(	new order(res.getInt("orderId"),
					res.getInt("restaurntId"),
					res.getInt("userId"),
					res.getDouble("totalAmount"),
					res.getString("status")));
		}
	} 
	 catch (SQLException e) {
		e.printStackTrace();
	}
		return al;
	}
	public int getMaxorderId() {
	    int maxOrderId = 0;
	    try {
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("select max(`orderId`) from `totalorder`");
	        if (rs.next()) {
	            maxOrderId = rs.getInt(1); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return maxOrderId;
	}


}
