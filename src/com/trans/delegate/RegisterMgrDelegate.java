/**
 * 
 */
package com.trans.delegate;

import java.util.ArrayList;

import com.trans.bean.CityBean;
import com.trans.bean.FeedBackBean;
import com.trans.bean.RegisterBean;
import com.trans.exception.ConnectionException;
import com.trans.exception.DataNotFoundException;
import com.trans.servicei.RegisterServiceI;
import com.trans.serviceimpl.RegisterServiceImpl;

/**
 * @author JAVAPROJECTS
 *
 */
public class RegisterMgrDelegate {
	
	RegisterServiceI rsi=new RegisterServiceImpl();
	public boolean checkAvailability(String userid)throws ConnectionException{
		return rsi.checkAvailability(userid);
	}
	public boolean registerEmployee(RegisterBean rb)throws ConnectionException{
		return rsi.registerEmployee(rb);
	}
	public boolean addFeedBack(RegisterBean rb)throws ConnectionException{
		return rsi.addFeedBack(rb);
	}
	
	public ArrayList<RegisterBean> viewEmployee()throws DataNotFoundException
	{
		return rsi.viewEmployee();
	}
	public ArrayList<FeedBackBean> viewFeedBack(String city,String type)throws DataNotFoundException
	{
		return rsi.viewFeedBack(city,type);
	}
	public boolean deleteEmployee(String user)
	{
		return rsi.deleteEmployee(user);
	}
	public RegisterBean roleCheck(String username,String password)
	{
		return rsi.roleCheck(username,password);
	}
	public ArrayList<RegisterBean> viewProfile(String user)throws DataNotFoundException
	{
		return rsi.viewProfile(user);
	}
	public boolean updateProfile(RegisterBean rb)
	{
		return rsi.updateProfile(rb);
	}
	
}
