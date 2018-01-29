/**
 * 
 */
package com.trans.bean;

import java.io.Serializable;

/**
 * @author JAVAPROJECTS
 *
 */
public class CityTransportsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String area;
	private String phone;
	private String surface;
	private String air;
	private String water;
	private String city;
	private int tno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public String getAir() {
		return air;
	}
	public void setAir(String air) {
		this.air = air;
	}
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
