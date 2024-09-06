package com.tap.implem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.print.attribute.PrintServiceAttribute;

import com.tap.connec.dbutil;
import com.tap.daointerface.daointerfaceuser;
import com.tap.model.usermodel;

public class UserDaoImpl implements daointerfaceuser{
	private Connection con;
	private PreparedStatement pstmt;
	private int status=0;
	private Statement stmt;
	private ResultSet res;
	ArrayList<usermodel> al= new ArrayList<usermodel>();
	private usermodel user;
	private static final String ADD_USER="insert into user(username,email,phoneNumber,password,address)values(?,?,?,?,?)";
	private static final String SELECT_ALL="select * from user";
	private static final String SELECT_user="select * from user where email=?";
	private static final String update_ON_EMAIL="update user set username=?,phoneNumber=?,password=?,address=? where email=?";
	private static final String DELETE_user="delete from user where email=?";
	public UserDaoImpl() {
		try {
			con=dbutil.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int adduser(usermodel u) {
		try {
			pstmt = con.prepareStatement(ADD_USER);
			pstmt.setString(1, u.getUserName());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPhoneNumber());
			pstmt.setString(4,u.getPassword());
			pstmt.setString(5, u.getAddress());
			status =pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public ArrayList<usermodel> getallusers() {
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(SELECT_ALL);
			al=extractuserlist(res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
		
		
	}
	@Override
	public usermodel getuser(String email) {
		try {
			pstmt=con.prepareStatement(SELECT_user);
			pstmt.setString(1,email);
			res=pstmt.executeQuery();
			//System.out.println(res);
			al=extractuserlist(res);
			user=al.get(0);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	@Override
	public int updateuser(usermodel u) {
		try {
			System.out.println("update user");
			pstmt=con.prepareStatement(update_ON_EMAIL);
			pstmt.setString(1, u.getUserName());
			pstmt.setString(5, u.getEmail());
			pstmt.setString(2, u.getPhoneNumber());
			pstmt.setString(3,u.getPassword());
			pstmt.setString(4, u.getAddress());
			status =pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public int deleteuser(String email) {
		try {
			pstmt=con.prepareStatement(DELETE_user);
			pstmt.setString(1,email);
			status=pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	ArrayList<usermodel> extractuserlist(ResultSet res) {
		try {
		while(res.next()) {
			al.add(	new usermodel(res.getInt("userId"),
					res.getString("userName"),
					res.getString("email"),
					res.getString("phoneNumber"),
					res.getString("password"),
					res.getString("address")));
		}
	} 
	 catch (SQLException e) {
		e.printStackTrace();
	}
		return al;
	}
	
}
