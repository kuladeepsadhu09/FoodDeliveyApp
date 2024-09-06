package com.tap.daointerface;

import java.util.ArrayList;

import com.tap.model.orderitem;

public interface daointerfaceorderitem {
	int addOrderItem(orderitem orderItem);
	ArrayList<orderitem>getspecificorder(int resturantid);

}
