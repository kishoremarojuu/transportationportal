package com.trans.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trans.bean.CityBean;
import com.trans.delegate.CityInfoMgrDelegate;
import com.trans.exception.DataNotFoundException;
import com.trans.util.UtilConstants;

public class ViewCityByAdminAction extends HttpServlet {

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

		String path="";
		ArrayList<CityBean> al;
		try
		{
			al=new CityInfoMgrDelegate().viewCity();
			if(!al.isEmpty())
			{
				path=UtilConstants._VIEW_CITY_BY_ADMIN;
				request.setAttribute("city",al);
				
			}
			else
			{
				path=UtilConstants._ADMIN_HOME;
				request.setAttribute("status",UtilConstants._NODATA);
			}
		}
		catch(DataNotFoundException e)
		{
			path=UtilConstants._ADMIN_HOME;
			request.setAttribute("status",e.getMessage());
		}
		
		catch (Exception e) {
			path=UtilConstants._ADMIN_HOME;
			request.setAttribute("status",UtilConstants._NODATA);
		}
		finally
		{
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
		
		}
	}

}
