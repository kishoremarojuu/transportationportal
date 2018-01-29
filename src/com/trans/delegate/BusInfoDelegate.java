package com.trans.delegate;

import java.util.ArrayList;

import com.trans.bean.BusBean;
import com.trans.bean.BusScheduleBean;
import com.trans.bean.TrainScheduleBean;
import com.trans.exception.ConnectionException;
import com.trans.exception.DataNotFoundException;
import com.trans.servicei.BusInfoServiceI;
import com.trans.serviceimpl.BusInfoServiceImpl;

public class BusInfoDelegate {
	
	BusInfoServiceI bsi=new BusInfoServiceImpl();
	public boolean addBusRoute(BusBean rb)throws ConnectionException{
		return bsi.addBusRoute(rb);
	}
	public boolean addTrainRoute(BusBean rb)throws ConnectionException{
		return bsi.addTrainRoute(rb);
	}
	public ArrayList<BusBean> viewBusRoute(){
		return bsi.viewBusRoute();
	}
	public ArrayList<BusBean> viewBusRoute(String city){
		return bsi.viewBusRoute(city);
	}
	public ArrayList<TrainScheduleBean> viewTrainSchedule(String city){
		return bsi.viewTrainSchedule(city);
	}
	public ArrayList<BusBean> viewTrainRoute(String city){
		return bsi.viewTrainRoute(city);
	}
	public ArrayList<BusBean> viewBusRouteInfo(){
		return bsi.viewBusRouteInfo();
	}
	public ArrayList<BusBean> viewBusRouteInfo(String city){
		return bsi.viewBusRouteInfo(city);
	}
	public ArrayList<BusScheduleBean> viewBusScheduleInfo(){
		return bsi.viewBusScheduleInfo();
	}
	
	public boolean addBusSchedule(BusScheduleBean rb)throws ConnectionException{
		return bsi.addBusSchedule(rb);
	}
	public boolean addTrainSchedule(TrainScheduleBean rb)throws ConnectionException{
		return bsi.addTrainSchedule(rb);
	}
	public boolean updateTrainSchedule(TrainScheduleBean rb)throws ConnectionException{
		return bsi.updateTrainSchedule(rb);
	}
	public boolean deleteTrainSchedule(TrainScheduleBean rb)throws ConnectionException{
		return bsi.deleteTrainSchedule(rb);
	}
}
