/**
 * 
 */
package com.trans.serviceimpl;

import java.util.ArrayList;

import com.trans.bean.CityBean;
import com.trans.bean.FeedBackBean;
import com.trans.bean.RegisterBean;
import com.trans.daoi.RegisterDaoI;
import com.trans.daoimpl.RegisterDaoImpl;
import com.trans.exception.ConnectionException;
import com.trans.exception.DataNotFoundException;
import com.trans.servicei.RegisterServiceI;

/**
 * @author JAVAPROJECTS
 *
 */
public class RegisterServiceImpl implements RegisterServiceI {
	RegisterDaoI rdao=new RegisterDaoImpl();
	public boolean checkAvailability(String userid)throws ConnectionException{
		return rdao.checkAvailability(userid);
	}
	public boolean registerEmployee(RegisterBean rb)throws ConnectionException{
		return rdao.registerEmployee(rb);
	}
	public ArrayList<RegisterBean> viewEmployee()throws DataNotFoundException
	{
		return rdao.viewEmployee();
	}
	public boolean deleteEmployee(String user)
	{
		return rdao.deleteEmployee(user);
	}
	public RegisterBean roleCheck(String username,String password)
	{
		return rdao.roleCheck(username,password);
	}
	public ArrayList<RegisterBean> viewProfile(String user)throws DataNotFoundException
	{
		return rdao.viewProfile(user);
	}
	public boolean updateProfile(RegisterBean rb) {
		return rdao.updateProfile(rb);
	}
	public boolean addFeedBack(RegisterBean rb)throws ConnectionException
	{
		return rdao.addFeedBack(rb);
	}
	public ArrayList<FeedBackBean> viewFeedBack(String city, String type)
			throws DataNotFoundException {
		
		return rdao.viewFeedBack(city,type);
	}
}
