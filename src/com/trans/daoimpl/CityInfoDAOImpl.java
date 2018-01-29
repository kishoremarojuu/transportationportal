/**
 * 
 */
package com.trans.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.trans.bean.CityBean;
import com.trans.bean.CityFareBean;
import com.trans.bean.CityTransportsBean;
import com.trans.bean.RoadWorkBean;
import com.trans.bean.TransportBean;
import com.trans.bean.EduInfoBean;
import com.trans.db.SqlConstants;
import com.trans.daoi.CityInfoDAOI;
import com.trans.db.ConnectionFactory;
import com.trans.exception.ConnectionException;
import com.trans.exception.DataNotFoundException;

/**
 * @author JAVAPROJECTS
 *
 */
public class CityInfoDAOImpl implements CityInfoDAOI{
	Connection con;
	PreparedStatement ps=null,ps1=null,pstm=null,pstm1=null;
	boolean flag=false;
	ResultSet rs;
	
	public boolean addCity(String State,String city){
	   
		try{
		con=ConnectionFactory.getConnection();
		System.out.println("Con....."+con);
		
		ps1=con.prepareStatement(SqlConstants._GET_STATEID);
		System.out.println(ps1);
		ps1.setString(1,State);
		rs=ps1.executeQuery();
		if(rs.next())
		{
			pstm=con.prepareStatement(SqlConstants._ADD_CITYY);
			pstm.setString(1,city);
			pstm.setInt(2,rs.getInt(1));
			 int rows=pstm.executeUpdate();
			    System.out.println(rows);
			    if(rows>0)
			    {
			    	flag=true;
			    }
			    else{
			    	con.rollback();
			    	
			    }
			
		}
		else{
		ps=con.prepareStatement(SqlConstants._ADD_STATE);
		pstm=con.prepareStatement(SqlConstants._ADD_CITY);
		ps.setString(1,State);
		int row=ps.executeUpdate();
		System.out.println(row);
		if(row>0)
		{
			pstm.setString(1,city);
		    int rows=pstm.executeUpdate();
		    System.out.println(rows);
		    if(rows>0)
		    {
		    	flag=true;
		    }
		    else{
		    	con.rollback();
		    	
		    }
		    ps.close();
		    pstm.close();
		    con.close();
		}
		}
	}catch (Exception e) {
		flag=false;
	}
	return flag;
	}
	public ArrayList<CityBean> viewCity()throws DataNotFoundException
	{
		ArrayList<CityBean> al=null;
		try{
			al=new ArrayList<CityBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._GET_CITY);
			rs=ps.executeQuery();
			CityBean cb;
			while(rs.next())
			{
				cb=new CityBean();
				cb.setStateid(rs.getInt(1));
				cb.setState(rs.getString(2));
				cb.setCityid(rs.getInt(3));
				cb.setCity(rs.getString(4));
				al.add(cb);
			}
		}catch (Exception e) {
			throw new DataNotFoundException("No Data....try later....");
		}
		return al;
	}
	public boolean deleteCity(int cityid){
		try{
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._DELETE_CITY);
			ps.setInt(1,cityid);
			int row=ps.executeUpdate();
			if(row>0)
			{
			    	flag=true;
	    	 }
			    ps.close();
			    ps.close();
			    con.close();

		}catch (Exception e) {
			flag=false;
		}
		return flag;
	}
	public ArrayList<CityTransportsBean> viewCityTransports()
	{
		ArrayList<CityTransportsBean> al=null;
		try{
			al=new ArrayList<CityTransportsBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_TRANSPORT);
			rs=ps.executeQuery();
			CityTransportsBean cb;
			while(rs.next())
			{
				cb=new CityTransportsBean();
				cb.setTno(rs.getInt(1));
				cb.setName(rs.getString(2));
				cb.setArea(rs.getString(3));
				cb.setPhone(rs.getString(4));
				cb.setSurface(rs.getString(5));
				cb.setAir(rs.getString(6));
				cb.setWater(rs.getString(7));
				cb.setCity(rs.getString(8));
				al.add(cb);
			}
		}catch (Exception e) {
			
		}
		return al;	
		
	}
	public boolean addTransports(TransportBean tb)throws ConnectionException
	{
		try{
			con=ConnectionFactory.getConnection();
			System.out.println("Con....."+con);
				pstm=con.prepareStatement(SqlConstants._ADD_TRANSPORT);
				pstm.setString(1,tb.getName());
				pstm.setString(2,tb.getArea());
				pstm.setString(3,tb.getPhone());
				pstm.setString(4,tb.getSurface());
				pstm.setString(5,tb.getAir());
				pstm.setString(6,tb.getWater());
				pstm.setString(7,tb.getCity());
				 int rows=pstm.executeUpdate();
				    System.out.println(rows);
				    if(rows>0)
				    {
				    	flag=true;
				    }
				    else{
				    	con.rollback();
				    	
				    }
				   
				    pstm.close();
				    con.close();
			}
      catch (Exception e) {
    	  e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	public ArrayList<CityFareBean> viewCityFares(String city) {
		
		ArrayList<CityFareBean> al=null;
		try{
			al=new ArrayList<CityFareBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_FARE);
			ps.setString(1,city);
			rs=ps.executeQuery();
			CityFareBean cb;
			while(rs.next())
			{
				cb=new CityFareBean();
				cb.setFareid(rs.getInt(1));
				cb.setFare(rs.getDouble(2));
				cb.setKm(rs.getInt(3));
				cb.setType(rs.getString(4));
				al.add(cb);
			}
		}catch (Exception e) {
			
		}
		return al;	
	}
	public boolean addFare(CityFareBean cb)throws ConnectionException
	{
		try{
			con=ConnectionFactory.getConnection();
			System.out.println("Con....."+con);
				pstm=con.prepareStatement(SqlConstants._ADD_FARE);
				pstm.setDouble(1,cb.getFare());
				pstm.setInt(2,cb.getKm());
				pstm.setString(3,cb.getType());
				pstm.setString(4,cb.getCity());
				 int rows=pstm.executeUpdate();
				    System.out.println(rows);
				    if(rows>0)
				    {
				    	flag=true;
				    }
				    else{
				    	con.rollback();
				    	
				    }
				   
				    pstm.close();
				    con.close();
			}
      catch (Exception e) {
    	  e.printStackTrace();
			flag=false;
		}
		return flag;
		
	}
	public ArrayList<EduInfoBean> viewEduInfo() {
		
		ArrayList<EduInfoBean> al=null;
		try{
			al=new ArrayList<EduInfoBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_EDU_INFO);
			rs=ps.executeQuery();
			EduInfoBean cb;
			while(rs.next())
			{
				cb=new EduInfoBean();
				cb.setName(rs.getString(1));
				cb.setArea(rs.getString(2));
				cb.setBusstop(rs.getString(3));
				cb.setCity(rs.getString(4));
				cb.setState(rs.getString(5));
				cb.setWebsite(rs.getString(6));
				cb.setPhone(rs.getString(7));
				cb.setEid(rs.getInt(8));
				al.add(cb);
			}
		}catch (Exception e) {
			
		}
		return al;	
	}
	public boolean addEduInfo(EduInfoBean tb)throws ConnectionException
	{
		try{
			con=ConnectionFactory.getConnection();
			System.out.println("Con....."+con);
				pstm=con.prepareStatement(SqlConstants._ADD_EDU_INFO);
				pstm.setString(1,tb.getName());
				pstm.setString(2,tb.getArea());
				pstm.setString(3,tb.getBusstop());
				pstm.setString(4,tb.getCity());
				pstm.setString(5,tb.getState());
				pstm.setString(6,tb.getWebsite());
				pstm.setString(7,tb.getPhone());
				 int rows=pstm.executeUpdate();
				    System.out.println(rows);
				    if(rows>0)
				    {
				    	flag=true;
				    }
				    else{
				    	con.rollback();
				    	
				    }
				   
				    pstm.close();
				    con.close();
			}
      catch (Exception e) {
    	  e.printStackTrace();
			flag=false;
		}
		return flag;
		
	}
	public ArrayList<RoadWorkBean> viewRoadWorkInfo() {
		
		ArrayList<RoadWorkBean> al=null;
		try{
			al=new ArrayList<RoadWorkBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_ROAD_WORK_INFO);
			rs=ps.executeQuery();
			RoadWorkBean cb;
			while(rs.next())
			{
				cb=new RoadWorkBean();
				cb.setWorkid(rs.getInt(1));
				cb.setWorkname(rs.getString(2));
				cb.setArea(rs.getString(3));
			    cb.setCity(rs.getString(4));
				cb.setWorktype(rs.getString(5));
				cb.setDays(Integer.toString(rs.getInt(6)));
				System.out.println(",.,.,..."+rs.getInt(6));
				al.add(cb);
			}
		}catch (Exception e) {
			
		}
		return al;	
	}
	
	public ArrayList<RoadWorkBean> viewTrafficInfo(String city){
		ArrayList<RoadWorkBean> al=null;
		try{
			al=new ArrayList<RoadWorkBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_TRAFFIC_INFO);
			ps.setString(1,city);
			rs=ps.executeQuery();
			RoadWorkBean cb;
			while(rs.next())
			{
				cb=new RoadWorkBean();
				cb.setSno(rs.getInt(1));
				cb.setBusstopname(rs.getString(2));
				cb.setSignals(rs.getInt(3));
			    cb.setFlyover(rs.getInt(4));
				cb.setKms(rs.getInt(5));
				cb.setRootid(rs.getString(6));
				al.add(cb);
				System.out.println(al.size());
			}
		}catch (Exception e) {
			
		}
		return al;	
	}
	public boolean addRoadWorkInfo(RoadWorkBean tb)throws ConnectionException
	{
		try{
			con=ConnectionFactory.getConnection();
			System.out.println("Con....."+con+"....."+tb.getDays());
			//int day=Integer.parseInt(tb.getDays());
				pstm=con.prepareStatement(SqlConstants._ADD_ROAD_WORK_INFO);
				pstm.setString(1,tb.getWorkname());
				pstm.setString(2,tb.getArea());
				pstm.setString(3,tb.getCity());
				pstm.setString(4,tb.getWorktype());
				System.out.println(tb.getDays());
				pstm.setInt(5,Integer.parseInt(tb.getDays()));
				 int rows=pstm.executeUpdate();
				    System.out.println(rows);
				    if(rows>0)
				    {
				    	flag=true;
				    }
				    else{
				    	con.rollback();
				    	
				    }
				   
				    pstm.close();
				    con.close();
			}
      catch (Exception e) {
    	  e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	public boolean addTrafficInfo(RoadWorkBean tb) throws ConnectionException {
		try{
			con=ConnectionFactory.getConnection();
			System.out.println("Con....."+con+"....."+tb.getSignals());
				pstm=con.prepareStatement(SqlConstants._ADD_TRAFFIC_INFO);
				pstm.setString(1,tb.getRootid());
				pstm.setString(2,tb.getCity());
				pstm.setString(3,tb.getBusstopname());
				pstm.setInt(4,tb.getSignals());
				pstm.setInt(5,tb.getFlyover());
				pstm.setInt(6,tb.getKms());
				 int rows=pstm.executeUpdate();
				    System.out.println(rows);
				    if(rows>0)
				    {
				    	flag=true;
				    }
				    else{
				    	con.rollback();
				    	
				    }
				   
				    pstm.close();
				    con.close();
			}
      catch (Exception e) {
    	  e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	public boolean deleteFeedBack(int fid) {
		try{
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._DELETE_FEEDBACK);
			ps.setInt(1,fid);
			int row=ps.executeUpdate();
			if(row>0)
			{
			    	flag=true;
	    	 }
			    ps.close();
			    ps.close();
			    con.close();

		}catch (Exception e) {
			flag=false;
		}
		return flag;
	}
}
