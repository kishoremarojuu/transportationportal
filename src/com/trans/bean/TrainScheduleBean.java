/**
 * 
 */
package com.trans.bean;

import java.io.Serializable;

/**
 * @author JAVAPROJECTS
 *
 */
public class TrainScheduleBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int tripid;
	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	private String route;
	private String fromtime;
	private String s1time;
	private String s2time;
	private String s3time;
	private String s4time;
	private String s5time;
	private String s6time;
	private String s7time;
	private String s8time;
	private String s9time;
	private String s10time;
	private String totime;
	private int tripno;
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getFromtime() {
		return fromtime;
	}
	public void setFromtime(String fromtime) {
		this.fromtime = fromtime;
	}
	public String getS1time() {
		return s1time;
	}
	public void setS1time(String s1time) {
		this.s1time = s1time;
	}
	public String getS2time() {
		return s2time;
	}
	public void setS2time(String s2time) {
		this.s2time = s2time;
	}
	public String getS3time() {
		return s3time;
	}
	public void setS3time(String s3time) {
		this.s3time = s3time;
	}
	public String getS4time() {
		return s4time;
	}
	public void setS4time(String s4time) {
		this.s4time = s4time;
	}
	public String getS5time() {
		return s5time;
	}
	public void setS5time(String s5time) {
		this.s5time = s5time;
	}
	public String getS6time() {
		return s6time;
	}
	public void setS6time(String s6time) {
		this.s6time = s6time;
	}
	public String getS7time() {
		return s7time;
	}
	public void setS7time(String s7time) {
		this.s7time = s7time;
	}
	public String getS8time() {
		return s8time;
	}
	public void setS8time(String s8time) {
		this.s8time = s8time;
	}
	public String getS9time() {
		return s9time;
	}
	public void setS9time(String s9time) {
		this.s9time = s9time;
	}
	public String getS10time() {
		return s10time;
	}
	public void setS10time(String s10time) {
		this.s10time = s10time;
	}
	public String getTotime() {
		return totime;
	}
	public void setTotime(String totime) {
		this.totime = totime;
	}
	public int getTripno() {
		return tripno;
	}
	public void setTripno(int tripno) {
		this.tripno = tripno;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
