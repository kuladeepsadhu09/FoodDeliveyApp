package com.tap.implem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.connec.dbutil;
import com.tap.daointerface.daointerfaceorderitem;
import com.tap.model.menu;
import com.tap.model.orderitem;

public class orderItemDAOimpl implements daointerfaceorderitem {
	private Connection con;
	private Statement stmt;
	private int status;
	private PreparedStatement pstmt;
	private ResultSet res;
	private ArrayList< orderitem> al= new ArrayList<orderitem>();
	private static final String ADD_ORDER_ITEM="insert into `orderitem`(`orderid`,`menuid`,`quantity`,`subtotal`)values(?,?,?,?)";
	private static final String GET_SPECIFIC_ORDER="select * from `orderitem` where `orderId`=?";
	public orderItemDAOimpl() {
		try {
			con=dbutil.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addOrderItem(orderitem orderItem) {
		 try {
			pstmt= con.prepareStatement(ADD_ORDER_ITEM);
			pstmt.setInt(1, orderItem.getOrderId());
			pstmt.setInt(2, orderItem.getMenuId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setDouble(4, orderItem.getSubTotal());
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
	}

	@Override
	public ArrayList<orderitem> getspecificorder(int resturantid) {
		try {
			pstmt=con.prepareStatement(GET_SPECIFIC_ORDER);
			pstmt.setInt(1, resturantid);
			res=pstmt.executeQuery();
			al=extractuserlist(res);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return al;
	}
	ArrayList<orderitem> extractuserlist(ResultSet res) {
		try {
			while(res.next()) {
			al.add(new orderitem(res.getInt("orderId"),
					res.getInt("menuId"),
					res.getInt("quantity"),
					res.getDouble("subTotal")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
