package com.trans.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trans.bean.BusBean;
import com.trans.bean.BusScheduleBean;
import com.trans.bean.TrainScheduleBean;
import com.trans.daoi.BusInfoDAOI;
import com.trans.db.ConnectionFactory;
import com.trans.db.SqlConstants;
import com.trans.exception.ConnectionException;

public class BusInfoDAOImpl implements BusInfoDAOI {
	
	Connection con;
	PreparedStatement ps=null,ps1=null,pstm=null,pstm1=null;
	boolean flag=false;
	ResultSet rs;
	public boolean addBusRoute(BusBean rb) throws ConnectionException {
		
		try{
			System.out.println(rb.getCity());
			con=ConnectionFactory.getConnection();
			System.out.println(con);
			ps=con.prepareStatement(SqlConstants._ADD_BUS_ROUTE);
			ps.setString(1,rb.getCity());
			ps.setString(2,rb.getRootid());
			ps.setString(3,rb.getFrom());
			ps.setString(4,rb.getTo());
			int row=ps.executeUpdate();
			if(row>0)
			{
			pstm=con.prepareStatement(SqlConstants._ADD_BUS_STOPS);
			pstm.setString(1,rb.getStop1());
			pstm.setString(2,rb.getStop2());
			pstm.setString(3,rb.getStop3());
			pstm.setString(4,rb.getStop4());
			pstm.setString(5,rb.getStop5());
			pstm.setString(6,rb.getStop6());
			pstm.setString(7,rb.getStop7());
			pstm.setString(8,rb.getStop8());
			pstm.setString(9,rb.getStop9());
			pstm.setString(10,rb.getStop10());
			int rows=pstm.executeUpdate();
			if(rows>0)
			{
				flag=true;
				
			}
			else
			{
				con.rollback();
			}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean addBusSchedule(BusScheduleBean rb)throws ConnectionException
	{
		try{
			
			con=ConnectionFactory.getConnection();
			System.out.println(con+"...."+rb.getRoute());
			ps=con.prepareStatement(SqlConstants._ADD_BUS_SCHEDULE);
			ps.setInt(1,rb.getRoute());
			ps.setInt(2,rb.getRoute());
			ps.setInt(3,rb.getRoute());
			ps.setString(4,rb.getStime());
			ps.setString(5,rb.getRtime());
			ps.setString(6,rb.getServiceno());
			ps.setString(7,rb.getDepot());
			ps.setInt(8,Integer.parseInt(rb.getTripno()));
			int row=ps.executeUpdate();
			
			if(row>0)
			{
				flag=true;
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
	public ArrayList<BusBean> viewBusRoute()
	{
		ArrayList<BusBean> al=null;
		try{
			al=new ArrayList<BusBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_BUS_ROUTE);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BusBean bb=new BusBean();
				bb.setSno(rs.getInt(1));
				bb.setRootid(rs.getString(3));
				bb.setFrom(rs.getString(4));
				bb.setTo(rs.getString(5));
				al.add(bb);
				
			}
			
		}catch (Exception e) {
			
		}
		
		return al;
	}
	public ArrayList<BusBean> viewBusRoute(String city)
	{
		ArrayList<BusBean> al=null;
		try{
			al=new ArrayList<BusBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_BUS_ROUTE_BY_CITY);
			ps.setString(1,city);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BusBean bb=new BusBean();
				bb.setSno(rs.getInt(1));
				bb.setRootid(rs.getString(3));
				bb.setFrom(rs.getString(4));
				bb.setTo(rs.getString(5));
				al.add(bb);
				
			}
			
		}catch (Exception e) {
			
		}
		
		return al;
	}
	
	
	public ArrayList<BusBean> viewBusRouteInfo() {
		ArrayList<BusBean> al=null;
		try{
			al=new ArrayList<BusBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_BUS_ROUTE_INFO);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BusBean bb=new BusBean();
				bb.setSno(rs.getInt(1));
				bb.setRootid(rs.getString(3));
				bb.setFrom(rs.getString(4));
				bb.setTo(rs.getString(5));
				bb.setStop1(rs.getString(7));
				bb.setStop2(rs.getString(8));
				bb.setStop3(rs.getString(9));
				bb.setStop4(rs.getString(10));
				bb.setStop5(rs.getString(11));
				bb.setStop6(rs.getString(12));
				bb.setStop7(rs.getString(13));
				bb.setStop8(rs.getString(14));
				bb.setStop9(rs.getString(15));
				bb.setStop10(rs.getString(16));
				al.add(bb);
				
			}
			
		}catch (Exception e) {
			
		}
		
		return al;
	}
	public ArrayList<BusScheduleBean> viewBusScheduleInfo()
	{
		ArrayList<BusScheduleBean> al=null;
		try{
			al=new ArrayList<BusScheduleBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_BUS_SCHEDULE_INFO);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BusScheduleBean bb=new BusScheduleBean();
				bb.setFrom(rs.getString(1));
				bb.setTo(rs.getString(2));
				bb.setStime(rs.getString(3));
				bb.setRtime(rs.getString(4));
				bb.setServiceno(rs.getString(5));
				bb.setDepot(rs.getString(6));
				bb.setTripno(rs.getString(7));
				bb.setRootno(rs.getString(8));
				al.add(bb);
				
			}
			
		}catch (Exception e) {
			
		}
		
		return al;
	}

	public ArrayList<BusBean> viewBusRouteInfo(String city) {
		ArrayList<BusBean> al=null;
		try{
			al=new ArrayList<BusBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_BUS_ROUTE_INFO_BY_CITY);
			ps.setString(1,city);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BusBean bb=new BusBean();
				bb.setSno(rs.getInt(1));
				bb.setRootid(rs.getString(3));
				bb.setFrom(rs.getString(4));
				bb.setTo(rs.getString(5));
				bb.setStop1(rs.getString(7));
				bb.setStop2(rs.getString(8));
				bb.setStop3(rs.getString(9));
				bb.setStop4(rs.getString(10));
				bb.setStop5(rs.getString(11));
				bb.setStop6(rs.getString(12));
				bb.setStop7(rs.getString(13));
				bb.setStop8(rs.getString(14));
				bb.setStop9(rs.getString(15));
				bb.setStop10(rs.getString(16));
				al.add(bb);
				
			}
			
		}catch (Exception e) {
			
		}
		
		return al;
	}

	public boolean addTrainRoute(BusBean rb) throws ConnectionException {
		try{
			System.out.println(rb.getCity());
			con=ConnectionFactory.getConnection();
			System.out.println(con);
			ps=con.prepareStatement(SqlConstants._ADD_TRAIN_ROUTE);
			
			ps.setString(1,rb.getRootid());
			ps.setString(2,rb.getFrom());
			ps.setString(3,rb.getStop1());
			ps.setString(4,rb.getStop2());
			ps.setString(5,rb.getStop3());
			ps.setString(6,rb.getStop4());
			ps.setString(7,rb.getStop5());
			ps.setString(8,rb.getStop6());
			ps.setString(9,rb.getStop7());
			ps.setString(10,rb.getStop8());
			ps.setString(11,rb.getStop9());
			ps.setString(12,rb.getStop10());
			ps.setString(13,rb.getTo());
			ps.setString(14,rb.getCity());
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				flag=true;
				
			}
			else
			{
				con.rollback();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}

	public ArrayList<BusBean> viewTrainRoute(String city) {
		
		ArrayList<BusBean> al=null;
		try{
			al=new ArrayList<BusBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_TRAIN_ROUTE_BY_CITY);
			ps.setString(1,city);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BusBean bb=new BusBean();
				bb.setRootid(rs.getString(1));
				bb.setFrom(rs.getString(2));
				bb.setStop1(rs.getString(3));
				bb.setStop2(rs.getString(4));
				bb.setStop3(rs.getString(5));
				bb.setStop4(rs.getString(6));
				bb.setStop5(rs.getString(7));
				bb.setStop6(rs.getString(8));
				bb.setStop7(rs.getString(9));
				bb.setStop8(rs.getString(10));
				bb.setStop9(rs.getString(11));
				bb.setStop10(rs.getString(12));
				bb.setTo(rs.getString(13));
				al.add(bb);
				
			}
			
		}catch (Exception e) {
			
		}
		
		return al;
	}

public boolean addTrainSchedule(TrainScheduleBean rb)throws ConnectionException {
		
try{
			
			con=ConnectionFactory.getConnection();
			System.out.println(con+"...."+rb.getRoute());
			ps=con.prepareStatement(SqlConstants._ADD_TRAIN_SCHEDULE);
			ps.setString(1,rb.getRoute());
			ps.setString(2,rb.getFromtime());
			ps.setString(3,rb.getS1time());
			ps.setString(4,rb.getS2time());
			ps.setString(5,rb.getS3time());
			ps.setString(6,rb.getS4time());
			ps.setString(7,rb.getS5time());
			ps.setString(8,rb.getS6time());
			ps.setString(9,rb.getS7time());
			ps.setString(10,rb.getS8time());
			ps.setString(11,rb.getS9time());
			ps.setString(12,rb.getS10time());
			ps.setString(13,rb.getTotime());
			ps.setInt(14,(rb.getTripno()));
			int row=ps.executeUpdate();
			
			if(row>0)
			{
				flag=true;
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return flag;
	}

public ArrayList<TrainScheduleBean> viewTrainSchedule(String city) {
	
	ArrayList<TrainScheduleBean> al=null;
	try{
		System.out.println("update");
		al=new ArrayList<TrainScheduleBean>();
		con=ConnectionFactory.getConnection();
		ps=con.prepareStatement(SqlConstants._VIEW_TRAIN_SCHEDULE_BY_CITY);
		ps.setString(1,city);
		rs=ps.executeQuery();
		while(rs.next())
		{
			TrainScheduleBean bb=new TrainScheduleBean();
			bb.setTripid(rs.getInt(1));
			bb.setRoute(rs.getString(2));
			bb.setFromtime(rs.getString(3));
			bb.setS1time(rs.getString(4));
			bb.setS2time(rs.getString(5));
			bb.setS3time(rs.getString(6));
			bb.setS4time(rs.getString(7));
			bb.setS5time(rs.getString(8));
			bb.setS6time(rs.getString(9));
			bb.setS7time(rs.getString(10));
			bb.setS8time(rs.getString(11));
			bb.setS9time(rs.getString(12));
			bb.setS10time(rs.getString(13));
			bb.setTotime(rs.getString(14));
			bb.setTripno(rs.getInt(15));
			al.add(bb);
			
		}
		
	}catch (Exception e) {
		
	}
	
	return al;
}
public boolean updateTrainSchedule(TrainScheduleBean rb)throws ConnectionException
{
	try{
		
		con=ConnectionFactory.getConnection();
		System.out.println(con+"...."+rb.getRoute());
		ps=con.prepareStatement(SqlConstants._UPDATE_TRAIN_SCHEDULE);
		
		ps.setString(1,rb.getFromtime());
		ps.setString(2,rb.getS1time());
		ps.setString(3,rb.getS2time());
		ps.setString(4,rb.getS3time());
		ps.setString(5,rb.getS4time());
		ps.setString(6,rb.getS5time());
		ps.setString(7,rb.getS6time());
		ps.setString(8,rb.getS7time());
		ps.setString(9,rb.getS8time());
		ps.setString(10,rb.getS9time());
		ps.setString(11,rb.getS10time());
		ps.setString(12,rb.getTotime());
		ps.setInt(13,(rb.getTripno()));
		ps.setInt(14, rb.getTripid());
		ps.setString(15,rb.getRoute());
		int row=ps.executeUpdate();
		
		if(row>0)
		{
			flag=true;
			
		}
		
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	try {
		ps.close();
		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	return flag;
}
public boolean deleteTrainSchedule(TrainScheduleBean rb)throws ConnectionException
{
try{
		System.out.println("900900");
		con=ConnectionFactory.getConnection();
		System.out.println(con+"...."+rb.getRoute()+"trip"+rb.getTripno());
		ps=con.prepareStatement(SqlConstants._DELETE_TRAIN_SCHEDULE);
		ps.setString(1,rb.getRoute());
		ps.setInt(2,(rb.getTripno()));
		System.out.println("........");
		int row=ps.executeUpdate();
		System.out.println(row);
		if(row>0)
		{
			flag=true;
			
		}
		
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	try {
		ps.close();
		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	return flag;
}

}
