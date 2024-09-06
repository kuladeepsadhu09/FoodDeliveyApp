package com.tap.daointerface;

import java.util.ArrayList;

import com.tap.model.order;

public interface daointerfaceorder {
	int addorder(order ord);
	ArrayList<order>getllorders();
	order getSpecfiRestaurant(int restaurantId);
	int updateRestaurant(order ord);
	int deleteRestaurant(int orderID);
	 int getMaxorderId();
}
