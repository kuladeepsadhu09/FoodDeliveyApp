package com.tap.daointerface;

import java.util.ArrayList;

import com.tap.model.restaurant;

public interface daointerfaceresturant {
	int addResturant(restaurant rest);
	ArrayList<restaurant>getAllRestaurants();
	restaurant getSpecfiRestaurant(int restaurantId);
	int updateRestaurant(restaurant rest);
	int deleteRestaurant(int restaurantID);
}
