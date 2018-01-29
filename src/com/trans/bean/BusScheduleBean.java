/**
 * 
 */
package com.trans.bean;

/**
 * @author JAVAPROJECTS
 *
 */
public class BusScheduleBean {
	private String from;
	private String to;
	private String stime;
	private String rtime;
	private int route;
	
	public int getRoute() {
		return route;
	}
	public void setRoute(int route) {
		this.route = route;
	}
	private String serviceno;
	private String depot;
	private String tripno;
	private String rootno;
	public String getRootno() {
		return rootno;
	}
	public void setRootno(String rootno) {
		this.rootno = rootno;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	
	public String getServiceno() {
		return serviceno;
	}
	public void setServiceno(String serviceno) {
		this.serviceno = serviceno;
	}
	public String getDepot() {
		return depot;
	}
	public void setDepot(String depot) {
		this.depot = depot;
	}
	public String getTripno() {
		return tripno;
	}
	public void setTripno(String tripno) {
		this.tripno = tripno;
	}

}
