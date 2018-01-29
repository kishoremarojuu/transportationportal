/**
 * 
 */
package com.trans.daoi;

import java.util.ArrayList;

import com.trans.bean.BusBean;
import com.trans.bean.BusScheduleBean;
import com.trans.bean.TrainScheduleBean;
import com.trans.exception.ConnectionException;

/**
 * @author JAVAPROJECTS
 *
 */
public interface BusInfoDAOI {
	public boolean addBusRoute(BusBean rb)throws ConnectionException;

	public ArrayList<BusBean> viewBusRoute();
	
	public boolean addBusSchedule(BusScheduleBean rb)throws ConnectionException;
	
	public ArrayList<BusBean> viewBusRouteInfo();
	
	public ArrayList<BusScheduleBean> viewBusScheduleInfo();
	
	public ArrayList<BusBean> viewBusRoute(String city);
	
	public ArrayList<BusBean> viewBusRouteInfo(String city);
	
	public boolean addTrainRoute(BusBean rb)throws ConnectionException;
	
	public ArrayList<BusBean> viewTrainRoute(String city);
	
	public boolean addTrainSchedule(TrainScheduleBean rb)throws ConnectionException ;
	
	public ArrayList<TrainScheduleBean> viewTrainSchedule(String city);
	
	public boolean updateTrainSchedule(TrainScheduleBean rb)throws ConnectionException;
	
	public boolean deleteTrainSchedule(TrainScheduleBean rb)throws ConnectionException;
	
}
