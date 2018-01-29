package com.trans.serviceimpl;

import java.util.ArrayList;

import com.trans.bean.BusBean;
import com.trans.bean.BusScheduleBean;
import com.trans.bean.TrainScheduleBean;
import com.trans.daoi.BusInfoDAOI;
import com.trans.daoimpl.BusInfoDAOImpl;
import com.trans.exception.ConnectionException;
import com.trans.servicei.BusInfoServiceI;

public class BusInfoServiceImpl implements BusInfoServiceI {
	
	BusInfoDAOI bdaoi=new BusInfoDAOImpl();
	public boolean addBusRoute(BusBean rb)throws ConnectionException{
		
		return bdaoi.addBusRoute(rb);
	}
	public ArrayList<BusBean> viewBusRoute()
	{
		return bdaoi.viewBusRoute();
	}
	public boolean addBusSchedule(BusScheduleBean bb)throws ConnectionException
	{
		return bdaoi.addBusSchedule(bb);
	}
	public ArrayList<BusBean> viewBusRouteInfo() {
		
		return bdaoi.viewBusRouteInfo();
	}
	public ArrayList<BusScheduleBean> viewBusScheduleInfo()
	{
		return bdaoi.viewBusScheduleInfo();
	}
	public ArrayList<BusBean> viewBusRoute(String city) {
		return bdaoi.viewBusRoute(city);
	}
	public ArrayList<BusBean> viewBusRouteInfo(String city) {
		return bdaoi.viewBusRouteInfo(city);
	}
	public boolean addTrainRoute(BusBean rb) throws ConnectionException {
		
		return bdaoi.addTrainRoute(rb);
	}
	public ArrayList<BusBean> viewTrainRoute(String city) {
	
		return bdaoi.viewTrainRoute(city);
	}
	public boolean addTrainSchedule(TrainScheduleBean rb)
			throws ConnectionException {
        return 	bdaoi.addTrainSchedule(rb);
 }
	public ArrayList<TrainScheduleBean> viewTrainSchedule(String city) {
		
		return bdaoi.viewTrainSchedule(city);
	}
	public boolean updateTrainSchedule(TrainScheduleBean rb)throws ConnectionException
	{
		return bdaoi.updateTrainSchedule(rb);
	}
	public boolean deleteTrainSchedule(TrainScheduleBean rb)throws ConnectionException
	{
		return bdaoi.deleteTrainSchedule(rb);
	}
}
