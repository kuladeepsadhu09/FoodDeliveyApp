package com.tap.daointerface;

import java.util.ArrayList;

import com.tap.model.orderhistory;

public interface daointerfaceorderhistory {
	int addhistory(orderhistory ordh);
	ArrayList<orderhistory>getorderhistory();
	ArrayList<orderhistory> getspecifichistory(int userid);
}
