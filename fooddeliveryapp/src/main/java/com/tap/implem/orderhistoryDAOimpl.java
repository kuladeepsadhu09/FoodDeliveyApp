package com.tap.implem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.tap.connec.dbutil;
import com.tap.daointerface.daointerfaceorder;
import com.tap.daointerface.daointerfaceorderhistory;
import com.tap.model.order;
import com.tap.model.orderhistory;

public class orderhistoryDAOimpl implements daointerfaceorderhistory{
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet res;
	ArrayList<orderhistory>al= new ArrayList<orderhistory>();
	private orderhistory his;
	private static final String ADD_ORDER="insert into orderhistory(`orderId`,`userId`,`totalAmount`,`status`)values(?,?,?,?)";
	private static final String GET_HISTORY="select * from orderhistory";
	private static final String GET_Specific_HISTORY="select * from `orderhistory` where `userId`=?";
	public orderhistoryDAOimpl() {
		try {
			con=dbutil.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addhistory(orderhistory ordh) {
		try {
			pstmt=con.prepareStatement(ADD_ORDER);
			pstmt.setInt(1,ordh.getOrderId());
			pstmt.setInt(2,ordh.getUserId());
			pstmt.setDouble(3,ordh.getTotalAmount());
			pstmt.setString(4,ordh.getStatus());
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<orderhistory> getorderhistory() {
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_HISTORY);
			al=extractuserlist(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	ArrayList<orderhistory> extractuserlist(ResultSet res) {
		try {
		while(res.next()) {
			Timestamp orderDateTs = res.getTimestamp("orderDate");
			String orderDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderDateTs);

			al.add(	new orderhistory(res.getInt("orderhistoryId"),
					res.getInt("orderId"),
					res.getInt("userId"),
					res.getDouble("totalAmount"),
					res.getString("status"),
					orderDateStr
					));
		}
	} 
	 catch (SQLException e) {
		e.printStackTrace();
	}
		return al;
	}

	@Override
	public ArrayList<orderhistory> getspecifichistory(int userid) {
		try {
			pstmt=con.prepareStatement(GET_Specific_HISTORY);
			pstmt.setInt(1,userid);
			res=pstmt.executeQuery();
			al=extractuserlist(res);
//			his=al.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}

}
