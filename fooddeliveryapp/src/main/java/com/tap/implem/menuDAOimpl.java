package com.tap.implem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.connec.dbutil;
import com.tap.daointerface.daointerfacemenu;
import com.tap.model.menu;
import com.tap.model.order;

public class menuDAOimpl implements daointerfacemenu {
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet res;
	private menu men;
	ArrayList<menu>al= new ArrayList<menu>();
	private static final String ADD_MENU="inssert into menu (`resturantId`,`menuName`,`price`,`descrption`,`isAvailable`,`imgPath`)values(?,?,?,?,?,?)";
	private static final String GET_MENU="select * from menu";
	private static final String GET_SPRCIFIC_MENU="select * from menu where `restaurntId`=?";
	private static final String UPDATE_MENU="update order set `resturantId`=?,menuName`=?,`price`=?,`descrption`=?,isAvailable`=?,`imgPath`=? where `menuId=?`";
	private static final String DELE_MENU="delete from order where `menuId`=?";
	private static final String GET_SPRCIFIC_MENU_item="select * from menu where `menuId`=?";
	public menuDAOimpl() {
		try {
			con=dbutil.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addmenu(menu men) {
		try {
			pstmt=con.prepareStatement(ADD_MENU);
			pstmt.setInt(1,men.getResturantId());
			pstmt.setString(2,men.getMenuName());
			pstmt.setDouble(3,men.getPrice());
			pstmt.setString(4,men.getDescrption());
			pstmt.setString(5,men.getIsAvailable());
			pstmt.setString(4,men.getImgPath());
			status=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<menu> getmenu() {
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_MENU);
			al=extractuserlist(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public ArrayList<menu> getSpecfimenu(int restaurantId) {
		try {
			pstmt=con.prepareStatement(GET_SPRCIFIC_MENU);
			pstmt.setInt(1,restaurantId);
			res=pstmt.executeQuery();
			al=extractuserlist(res);
			men=al.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public int updatemenu(menu me) {
		try {
			pstmt=con.prepareStatement(UPDATE_MENU);
			pstmt.setInt(1,me.getResturantId());
			pstmt.setString(2,me.getMenuName());
			pstmt.setDouble(3,me.getPrice());
			pstmt.setString(4,me.getDescrption());
			pstmt.setString(5,me.getIsAvailable());
			pstmt.setString(6,me.getImgPath());
			pstmt.setInt(6, me.getMenuId());
			status=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deletemenu(int menuId) {
		try {
			pstmt=con.prepareStatement(DELE_MENU);
			pstmt.setInt(1, menuId);
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	ArrayList<menu> extractuserlist(ResultSet res) {
		try {
		while(res.next()) {
			al.add(	new menu(res.getInt("menuId"),
					res.getInt("restaurntId"),
					res.getString("menuName"),
					res.getDouble("price"),
					res.getString("descrption"),
					res.getString("isAvailable"),
					res.getString("imgPath")));
		}
	} 
	 catch (SQLException e) {
		e.printStackTrace();
	}
		return al;
	}

	@Override
	public menu getspecficmenuitem(int menuItemId) {
		try {
			al.clear();
			pstmt=con.prepareStatement(GET_SPRCIFIC_MENU_item);
			pstmt.setInt(1,menuItemId);
			res=pstmt.executeQuery();
			al=extractuserlist(res);
			
			men=al.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return men;
	}


}
