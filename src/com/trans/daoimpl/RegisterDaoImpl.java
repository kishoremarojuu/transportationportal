/**
 * 
 */
package com.trans.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trans.bean.CityBean;
import com.trans.bean.FeedBackBean;
import com.trans.bean.RegisterBean;
import com.trans.db.SqlConstants;
import com.trans.daoi.RegisterDaoI;
import com.trans.db.ConnectionFactory;
import com.trans.exception.ConnectionException;
import com.trans.exception.DataNotFoundException;
import com.trans.util.DateWrapper;

/**
 * @author JAVAPROJECTS
 *
 */
public class RegisterDaoImpl implements RegisterDaoI {
	Connection con;
	PreparedStatement ps=null,ps1=null,pstm=null,pstm1=null;
	boolean flag=false;
	ResultSet rs;
	
	public boolean checkAvailability(String userid)throws ConnectionException{
		
		try{
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._CHECK_AVAILABILITY);
    		ps.setString(1,userid);
    		rs=ps.executeQuery();
    		if(rs.next()){
    			flag=true;
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    

    finally
	{
	 try{
		 if(con!=null)
			 con.close();				 
	 }
	 catch(SQLException e){
		 
		 e.printStackTrace();
	 }
	}
     return flag;
	}
	public boolean registerEmployee(RegisterBean rb)throws ConnectionException{
		try{
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._INSERT_USERS);
			ps.setString(1,rb.getUserName());
			ps.setString(2,rb.getPassword());
			ps.setString(3,rb.getRole());
			ps.setString(4,rb.getName());
			ps.setString(5,DateWrapper.parseDate(rb.getDob()));
			ps.setString(6,rb.getGender());
			ps.setString(7,rb.getMail());
			ps.setString(8,rb.getPhone());
			ps.setString(9,rb.getDesignation());
			ps.setString(10,rb.getDno());
			ps.setString(11,rb.getArea());
			ps.setString(12,rb.getCity());
			ps.setString(13,rb.getState());
			int rows=ps.executeUpdate();
			System.out.println(rows);
			if(rows>0)
			{
				flag=true;
				con.commit();
			}
		}
		catch (Exception e) {
			
			throw new ConnectionException("Some Technical Pb occured Try later ...");
		}
		return flag;
	}
	public ArrayList<RegisterBean> viewEmployee()throws DataNotFoundException{
		
		ArrayList<RegisterBean> al=null;
		try{
			al=new ArrayList<RegisterBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_EMPLYEE);
			rs=ps.executeQuery();
			RegisterBean rb;
			while(rs.next())
			{
				rb=new RegisterBean();
				rb.setName(rs.getString(1));
				rb.setRole(rs.getString(2));
				rb.setDesignation(rs.getString(3));
				rb.setPhone(rs.getString(4));
				rb.setCity(rs.getString(5));
				rb.setState(rs.getString(6));
				rb.setUserName(rs.getString(7));
				al.add(rb);
			}
			
		}catch (Exception e) {
			
		}
		return al;
	}
	public boolean deleteEmployee(String user)
	{
		try{
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._DELETE_EMPLOYEE);
			ps.setString(1,user);
			int row=ps.executeUpdate();
			if(row>0)
			{
			    	flag=true;
	    	 }
			   
			    ps.close();
			    con.close();

		}catch (Exception e) {
			flag=false;
		}
		finally{
			try{
			 ps.close();
			    con.close();
			}catch (Exception e) {
				flag=false;
			}
			
		}
		return flag;
	}
	public RegisterBean roleCheck(String username,String password)
	{
		RegisterBean rb=null;
		try{
		con=ConnectionFactory.getConnection();
		System.out.println(con);
		ps=con.prepareStatement(SqlConstants._VIEW_EMPLYEE_ROLE);
		ps.setString(1,username);
		ps.setString(2,password);
		rs=ps.executeQuery();
		rb=new RegisterBean();
		if(rs.next())
		{
			
			rb.setRole(rs.getString(1));
			rb.setCity(rs.getString(2));	
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
	return rb;
	}
	public ArrayList<RegisterBean> viewProfile(String user) throws DataNotFoundException {
		ArrayList<RegisterBean> al=null;
		try{
			al=new ArrayList<RegisterBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_CITIZEN);
			ps.setString(1,user);
			rs=ps.executeQuery();
			RegisterBean rb;
			while(rs.next())
			{
				rb=new RegisterBean();
				rb.setName(rs.getString(1));
		
				rb.setDesignation(rs.getString(2));
				rb.setPhone(rs.getString(3));
				rb.setCity(rs.getString(4));
				rb.setState(rs.getString(5));
				rb.setUserName(rs.getString(6));
				rb.setPassword(rs.getString(7));
				rb.setMail(rs.getString(8));
				al.add(rb);
				System.out.println(al.size());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return al;
	}
	public boolean updateProfile(RegisterBean rb) {
		
		try{
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._UPDATE_PROFILE);
			ps.setString(6,rb.getUserName());
			ps.setString(1,rb.getPassword());
			ps.setString(2,rb.getName());
		
			ps.setString(3,rb.getMail());
			ps.setString(4,rb.getPhone());
			ps.setString(5,rb.getDesignation());
			
			int rows=ps.executeUpdate();
			System.out.println(rows);
			if(rows>0)
			{
				flag=true;
				con.commit();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return flag;
	}
	public boolean addFeedBack(RegisterBean rb) throws ConnectionException {
		try{
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._INSERT_FEEDBACK);
			ps.setString(7,rb.getRole());
			ps.setString(1,rb.getName());

			ps.setString(2,rb.getCity());
			ps.setString(3,rb.getState());
			ps.setString(4,rb.getMail());
			ps.setString(5,rb.getPhone());
			ps.setString(6,rb.getArea());
			int rows=ps.executeUpdate();
			System.out.println(rows);
			if(rows>0)
			{
				flag=true;
				con.commit();
			}
		}
		catch (Exception e) {
			
			throw new ConnectionException("Some Technical Pb occured Try later ...");
		}
		return flag;
	}
	public ArrayList<FeedBackBean> viewFeedBack(String city, String type)
			throws DataNotFoundException {
		ArrayList<FeedBackBean> al=null;
		try{
			al=new ArrayList<FeedBackBean>();
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(SqlConstants._VIEW_FEEDBACK);
			ps.setString(1,city);
			ps.setString(2,type);
			rs=ps.executeQuery();
			FeedBackBean rb;
			while(rs.next())
			{
				rb=new FeedBackBean();
				rb.setFid(rs.getInt(1));
				rb.setName(rs.getString(2));
				rb.setCity(rs.getString(3));
				rb.setState(rs.getString(4));
				rb.setMail(rs.getString(5));
				rb.setPhone(rs.getString(6));
				rb.setComment(rs.getString(7));
				rb.setType(rs.getString(8));
				rb.setCommentDate(rs.getString(9));
				al.add(rb);
			}
			
			rs.close();
			ps.close();
			con.close();
		}catch (Exception e) {
			
		}
		return al;
	}
}

