/**
 * 
 */
package com.trans.delegate;

import java.util.ArrayList;

import com.trans.bean.BusScheduleBean;
import com.trans.bean.CityBean;
import com.trans.bean.CityFareBean;
import com.trans.bean.CityTransportsBean;
import com.trans.bean.RoadWorkBean;
import com.trans.bean.TransportBean;
import com.trans.bean.EduInfoBean;
import com.trans.exception.ConnectionException;
import com.trans.exception.DataNotFoundException;
import com.trans.servicei.CityInfoServicei;
import com.trans.serviceimpl.CityInfoServiceimpl;

/**
 * @author JAVAPROJECTS
 *
 */
public class CityInfoMgrDelegate {
	CityInfoServicei cis=new CityInfoServiceimpl();
	public boolean addCity(String State,String city)
	{
		return cis.addCity(State,city);
	}
	public ArrayList<CityBean> viewCity()throws DataNotFoundException
	{
		return cis.viewCity();
	}
	public ArrayList<CityTransportsBean> viewCityTransports()
	{
		return cis.viewCityTransports();
	}
	public boolean deleteCity(int cityid)
	{
		return cis.deleteCity(cityid);
	}
	public boolean deleteFeedBack(int fid)
	{
		return cis.deleteCity(fid);
	}
	public boolean addTransports(TransportBean tb)throws ConnectionException
	{
		return cis.addTransports(tb);
	}
	public boolean addTrafficInfo(RoadWorkBean tb)throws ConnectionException
	{
		return cis.addTrafficInfo(tb);
	}
	public boolean addEduInfo(EduInfoBean tb)throws ConnectionException
	{
		return cis.addEduInfo(tb);
	}
	
	public boolean addRoadWorkInfo(RoadWorkBean tb)throws ConnectionException
	{
		return cis.addRoadWorkInfo(tb);
	}
	
	public boolean addFare(CityFareBean cb)throws ConnectionException
	{
		return cis.addFare(cb);
	}
	public ArrayList<CityFareBean> viewCityFares(String city)
	{
		return cis.viewCityFares(city);
	}
	public ArrayList<EduInfoBean> viewEduInfo()
	{
		return cis.viewEduInfo();
	}
	public ArrayList<RoadWorkBean> viewRoadWorkInfo()
	{
		return cis.viewRoadWorkInfo();
	}
	public ArrayList<RoadWorkBean> viewTrafficInfo(String city)
	{
		return cis.viewTrafficInfo(city);
	}
}
