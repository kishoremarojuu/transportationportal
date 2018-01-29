/**
 * 
 */
package com.trans.bean;

import java.io.Serializable;

/**
 * @author JAVAPROJECTS
 *
 */
public class TransportBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String phone;
	private String area;
	private String city;
	private String air;
	private String surface;
	private String water;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAir() {
		return air;
	}
	public void setAir(String air) {
		this.air = air;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
