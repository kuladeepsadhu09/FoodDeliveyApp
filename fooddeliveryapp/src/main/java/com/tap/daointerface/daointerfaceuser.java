package com.tap.daointerface;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.tap.model.usermodel;

public interface daointerfaceuser {
	int adduser(usermodel u);
	ArrayList<usermodel> getallusers();
	usermodel getuser(String email);
	int updateuser(usermodel u);
	int deleteuser(String email);
	
}
