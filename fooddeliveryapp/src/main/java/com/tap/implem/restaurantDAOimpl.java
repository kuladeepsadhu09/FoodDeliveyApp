package com.tap.implem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.connec.dbutil;
import com.tap.daointerface.daointerfaceresturant;
import com.tap.model.restaurant;
import com.tap.model.usermodel;

public class restaurantDAOimpl implements daointerfaceresturant{
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	ArrayList<restaurant> al= new ArrayList<restaurant>();
	private Statement stmt;
	private ResultSet res;
	private restaurant rest;
	private static final String ADD_RESTURANT="insert into restaurnt(`restaurntName`,`deliveryTime`,`cusineType`,`address`,`rating`,`isActive`,`adminId`)values(?,?,?,?,?,?)";
    private static final String GET_ALLRESTURANT="select * from restaurnt";
    private static final String GET_SPECIF_USER="select * from resturant where `restaurntID`=?";
    private static final String UPDATE_RESTARUNT="update resturant set `restaurntName`=?,`deliveryTime`=?,`cusineType`=?,`address`=?,`rating`=?,`isActive`=?,`adminId`=? where `restaurntID`=?";
    private static final String DELETE_USER="delete from user where `restaurantId`=?";
	public restaurantDAOimpl() {
		try {
			con=dbutil.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addResturant(restaurant rest) {
		try {
			pstmt=con.prepareStatement(ADD_RESTURANT);
			pstmt.setString(1, rest.getRestaurntName());
			pstmt.setString(2, rest.getDeliverytime());
			pstmt.setString(3, rest.getCusineType());
			pstmt.setString(4, rest.getAddress());
			pstmt.setDouble(5, rest.getRating());
			pstmt.setString(6, rest.getIsActive());
			pstmt.setInt(7, rest.getAdminId());
			pstmt.setInt(8, rest.getRestaurntId());
			status=pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<restaurant> getAllRestaurants() {
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_ALLRESTURANT);
			al=extractuserlist(res);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	@Override
	public restaurant getSpecfiRestaurant(int restaurantId) {
		try {
			pstmt=con.prepareStatement(GET_SPECIF_USER);
			pstmt.setInt(1,restaurantId);
			res=pstmt.executeQuery();
			al=extractuserlist(res);
			rest=al.get(0);
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		
		return rest;
	}

	@Override
	public int updateRestaurant(restaurant rest) {
		try {
			pstmt=con.prepareStatement(UPDATE_RESTARUNT);
			pstmt.setString(1, rest.getRestaurntName());
			pstmt.setString(2, rest.getDeliverytime());
			pstmt.setString(3, rest.getCusineType());
			pstmt.setString(4, rest.getAddress());
			pstmt.setDouble(5, rest.getRating());
			pstmt.setString(6, rest.getIsActive());
			pstmt.setInt(7, rest.getAdminId());
			status=pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteRestaurant(int restaurantID) {
		try {
			pstmt=con.prepareStatement(DELETE_USER);
			pstmt.setInt(1, restaurantID);
			status=pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	ArrayList<restaurant> extractuserlist(ResultSet res) {
		try {
		while(res.next()) {
			al.add(	new restaurant(res.getInt("restaurntId"),
					res.getString("restaurntName"),
					res.getString("deliverytime"),
					res.getString("cusineType"),
					res.getString("address"),
					res.getDouble("rating"),
					res.getString("isActive"),
					res.getInt("adminId"),
					res.getString("imgaepath")));
		}
	} 
	 catch (SQLException e) {
		e.printStackTrace();
	}
		return al;
	}

}
