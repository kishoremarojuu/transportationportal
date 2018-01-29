/**
 * 
 */
package com.trans.servicei;

import java.util.ArrayList;

import com.trans.bean.CityBean;
import com.trans.bean.CityFareBean;
import com.trans.bean.CityTransportsBean;
import com.trans.bean.RoadWorkBean;
import com.trans.bean.TransportBean;
import com.trans.bean.EduInfoBean;
import com.trans.exception.ConnectionException;
import com.trans.exception.DataNotFoundException;

/**
 * @author JAVAPROJECTS
 *
 */
public interface CityInfoServicei {
	public boolean addCity(String State,String city);
	public ArrayList<CityBean> viewCity()throws DataNotFoundException;
	public boolean deleteCity(int cityid);
	public ArrayList<CityTransportsBean> viewCityTransports();
	public boolean addTransports(TransportBean tb)throws ConnectionException;
	public ArrayList<CityFareBean> viewCityFares(String city);
	public boolean addFare(CityFareBean cb)throws ConnectionException;
	public ArrayList<EduInfoBean> viewEduInfo();
	public boolean addEduInfo(EduInfoBean tb)throws ConnectionException;
	public ArrayList<RoadWorkBean> viewRoadWorkInfo();
	public boolean addRoadWorkInfo(RoadWorkBean tb)throws ConnectionException;
	public ArrayList<RoadWorkBean> viewTrafficInfo(String city);
	public boolean addTrafficInfo(RoadWorkBean tb)throws ConnectionException;
	public boolean deleteFeedBack(int fid);
	
}
