/**
 * 
 */
package com.trans.bean;

import java.io.Serializable;

/**
 * @author JAVAPROJECTS
 *
 */
public class EduInfoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int eid;
	private String name;
	private String area;
	private String busstop;
	public String getBusstop() {
		return busstop;
	}
	public void setBusstop(String busstop) {
		this.busstop = busstop;
	}
	private String city;
	private String state;
	private String website;
	private String phone;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
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
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
