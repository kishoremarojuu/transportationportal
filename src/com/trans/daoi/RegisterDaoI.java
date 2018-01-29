/**
 * 
 */
package com.trans.daoi;

import java.util.ArrayList;

import com.trans.bean.CityBean;
import com.trans.bean.FeedBackBean;
import com.trans.bean.RegisterBean;
import com.trans.exception.ConnectionException;
import com.trans.exception.DataNotFoundException;

/**
 * @author JAVAPROJECTS
 *
 */
public interface RegisterDaoI {
	public boolean checkAvailability(String userid)throws ConnectionException;

	public boolean registerEmployee(RegisterBean rb)throws ConnectionException;
	
	public ArrayList<RegisterBean> viewEmployee()throws DataNotFoundException;
	
	public boolean deleteEmployee(String user);
	
	public RegisterBean roleCheck(String username,String password);
	
	public ArrayList<RegisterBean> viewProfile(String user)throws DataNotFoundException;
	
	public boolean updateProfile(RegisterBean rb);
	
	public boolean addFeedBack(RegisterBean rb)throws ConnectionException;
	
	public ArrayList<FeedBackBean> viewFeedBack(String city,String type)throws DataNotFoundException;
}
