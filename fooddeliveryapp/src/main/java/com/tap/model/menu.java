package com.tap.model;

public class menu {
	private int menuId;
	private int resturantId;
	private String  menuName;
	private double price;
	private String descrption;
	private String isAvailable;
	private String imgPath;
	public menu() {
		super();
	}
	public menu(int menuId, int resturantId, String menuName, double price, String descrption, String isAvailable,
			String imgPath) {
		super();
		this.menuId = menuId;
		this.resturantId = resturantId;
		this.menuName = menuName;
		this.price = price;
		this.descrption = descrption;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	}
	public menu(int resturantId, String menuName, double price, String descrption, String isAvailable, String imgPath) {
		super();
		this.resturantId = resturantId;
		this.menuName = menuName;
		this.price = price;
		this.descrption = descrption;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getResturantId() {
		return resturantId;
	}
	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "menu [menuId=" + menuId + ", resturantId=" + resturantId + ", menuName=" + menuName + ", price=" + price
				+ ", descrption=" + descrption + ", isAvailable=" + isAvailable + ", imgPath=" + imgPath + "]";
	}
	
}
