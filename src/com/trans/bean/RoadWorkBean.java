/**
 * 
 */
package com.trans.bean;

import java.io.Serializable;

/**
 * @author JAVAPROJECTS
 *
 */
public class RoadWorkBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int workid;
	private String workname;
	private String area;
	private String city;
	private String days;
	private int sno;
	private String rootid;
	private String busstopname;
	private int signals;
	private int flyover;
	private int kms;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getRootid() {
		return rootid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setRootid(String rootid) {
		this.rootid = rootid;
	}
	public String getBusstopname() {
		return busstopname;
	}
	public void setBusstopname(String busstopname) {
		this.busstopname = busstopname;
	}
	public int getSignals() {
		return signals;
	}
	public void setSignals(int signals) {
		this.signals = signals;
	}
	public int getFlyover() {
		return flyover;
	}
	public void setFlyover(int flyover) {
		this.flyover = flyover;
	}
	public int getKms() {
		return kms;
	}
	public void setKms(int kms) {
		this.kms = kms;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	private String worktype;
	private int workdays;
	public int getWorkdays() {
		return workdays;
	}
	public void setWorkdays(int workdays) {
	}
	public int getWorkid() {
		return workid;
	}
	public void setWorkid(int workid) {
		this.workid = workid;
	}
	public String getWorkname() {
		return workname;
	}
	public void setWorkname(String workname) {
		this.workname = workname;
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
	public String getWorktype() {
		return worktype;
	}
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}
	

}
