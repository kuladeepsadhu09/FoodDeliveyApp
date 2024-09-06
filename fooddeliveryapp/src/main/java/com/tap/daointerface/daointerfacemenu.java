package com.tap.daointerface;

import java.util.ArrayList;

import com.tap.model.menu;
public interface daointerfacemenu {
	int addmenu(menu men);
	ArrayList<menu>getmenu();
	ArrayList<menu> getSpecfimenu(int restaurantId);
	menu getspecficmenuitem(int menuItemId);
	int updatemenu(menu me);
	int deletemenu(int menuId);
	
}
