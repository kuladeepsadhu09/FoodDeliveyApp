package com.tap.model;
public class restaurant {
	private int restaurntId;
	private String restaurntName;
	private String deliverytime;
	private String cusineType;
	private String address;
	private double rating;
	private String isActive;
	private int adminId;
	private String imagepath;
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public restaurant() {
		super();
	}
	public restaurant(int restaurntId, String restaurntName,String deliverytime ,String cusineType, String address, double rating,
			String isActive, int adminId,String imagepath) {
		super();
		this.restaurntId = restaurntId;
		this.restaurntName = restaurntName;
		this.deliverytime=deliverytime;
		this.cusineType = cusineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this.adminId = adminId;
		this.imagepath=imagepath;
	}
	public restaurant(String restaurntName,String deliverytime, String cusineType, String address, double rating, String isActive,
			int adminId,String imagepath) {
		super();
		this.restaurntName = restaurntName;
		this.deliverytime=deliverytime;
		this.cusineType = cusineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this.adminId = adminId;
		this.imagepath=imagepath;
	}
	
	public String getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(String deliverytime) {
		this.deliverytime = deliverytime;
	}
	public int getRestaurntId() {
		return restaurntId;
	}
	public void setRestaurntId(int restaurntId) {
		this.restaurntId = restaurntId;
	}
	public String getRestaurntName() {
		return restaurntName;
	}
	public void setRestaurntName(String restaurntName) {
		this.restaurntName = restaurntName;
	}
	public String getCusineType() {
		return cusineType;
	}
	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "restaurant [restaurntId=" + restaurntId + ", restaurntName=" + restaurntName + ", deliverytime="
				+ deliverytime + ", cusineType=" + cusineType + ", address=" + address + ", rating=" + rating
				+ ", isActive=" + isActive + ", adminId=" + adminId + "]";
	}
	
	 	
	
}
