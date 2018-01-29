/**
 * 
 */
package com.trans.serviceimpl;

import java.util.ArrayList;

import com.trans.bean.CityBean;
import com.trans.bean.CityFareBean;
import com.trans.bean.CityTransportsBean;
import com.trans.bean.RoadWorkBean;
import com.trans.bean.TransportBean;
import com.trans.bean.EduInfoBean;
import com.trans.daoi.CityInfoDAOI;
import com.trans.daoimpl.CityInfoDAOImpl;
import com.trans.exception.ConnectionException;
import com.trans.exception.DataNotFoundException;
import com.trans.servicei.CityInfoServicei;

/**
 * @author JAVAPROJECTS
 *
 */
public class CityInfoServiceimpl implements CityInfoServicei{
	
	CityInfoDAOI cdaoi=new CityInfoDAOImpl();
	public boolean addFare(CityFareBean cb)throws ConnectionException
	{
		return cdaoi.addFare(cb);
	}
	public boolean addCity(String State,String city)
	{
		return cdaoi.addCity(State,city);
	}
	public ArrayList<CityBean> viewCity()throws DataNotFoundException
	{
		return cdaoi.viewCity();
	}
	public boolean deleteCity(int cityid)
	{
		return cdaoi.deleteCity(cityid);
	}
	public ArrayList<CityTransportsBean> viewCityTransports()
	{
		return cdaoi.viewCityTransports();
    }
	public boolean addTransports(TransportBean tb)throws ConnectionException
	{
		
		return cdaoi.addTransports(tb);
	}
	public ArrayList<CityFareBean> viewCityFares(String city)
	{
		return cdaoi.viewCityFares(city);
	}
	public ArrayList<EduInfoBean> viewEduInfo()
	{
		return cdaoi.viewEduInfo();
	}
	public boolean addEduInfo(EduInfoBean tb)throws ConnectionException
	{
		return cdaoi.addEduInfo(tb);
	}
	public ArrayList<RoadWorkBean> viewRoadWorkInfo() {
		
		return cdaoi.viewRoadWorkInfo();
	}
	public boolean addRoadWorkInfo(RoadWorkBean tb)throws ConnectionException
	{
		return cdaoi.addRoadWorkInfo(tb);
	}
	public ArrayList<RoadWorkBean> viewTrafficInfo(String city){
		return cdaoi.viewTrafficInfo(city);
	}
	public boolean addTrafficInfo(RoadWorkBean tb)throws ConnectionException
	{
		return cdaoi.addTrafficInfo(tb);
	}
	public boolean deleteFeedBack(int fid) {
		return cdaoi.deleteFeedBack(fid);
	}
}