package com.trans.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.trans.bean.EduInfoBean;
import com.trans.bean.TransportBean;
import com.trans.delegate.CityInfoMgrDelegate;
import com.trans.util.UtilConstants;

public class AddEduInfoAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean flag=false;
		String path="";
		EduInfoBean tb=new EduInfoBean();
		try{
			Map map = request.getParameterMap();
			BeanUtils.populate(tb, map);
		flag=new CityInfoMgrDelegate().addEduInfo(tb);
		if(flag)
		{
			path=UtilConstants._TRAFFICEMPLOYEE_HOME;
			request.setAttribute("status",UtilConstants._ADDED);
		}
		else
		{
			path=UtilConstants._TRAFFICEMPLOYEE_HOME;
			request.setAttribute("status",UtilConstants._ADDED_FAILED);
		}
		}catch (Exception e) {
			path=UtilConstants._TRAFFICEMPLOYEE_HOME;
			request.setAttribute("status",UtilConstants._ADDED_FAILED);
			
		}
		finally{
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}

}
