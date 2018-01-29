/**
 * 
 */
package com.trans.bean;

import java.io.Serializable;

/**
 * @author JAVAPROJECTS
 *
 */
public class CityFareBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private int fareid;
	private double fare;
	private int km;
	private int cityid;
	private String city;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getFareid() {
		return fareid;
	}
	public void setFareid(int fareid) {
		this.fareid = fareid;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String type;

}
