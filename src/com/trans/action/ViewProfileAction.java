package com.trans.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trans.bean.CityBean;
import com.trans.bean.RegisterBean;
import com.trans.delegate.CityInfoMgrDelegate;
import com.trans.delegate.RegisterMgrDelegate;
import com.trans.exception.DataNotFoundException;
import com.trans.util.UtilConstants;

public class ViewProfileAction extends HttpServlet {

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
		ArrayList<RegisterBean> al;
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("username");
		try
		{
			al=new RegisterMgrDelegate().viewProfile(user);
			if(!al.isEmpty())
			{
				path=UtilConstants._VIEW_PROFILE;
				request.setAttribute("profile",al);
				
			}
			else
			{
				path=UtilConstants._CITIZEN_HOME;
				request.setAttribute("status",UtilConstants._NODATA);
			}
		}
		catch(DataNotFoundException e)
		{
			path=UtilConstants._CITIZEN_HOME;
			request.setAttribute("status",e.getMessage());
		}
		
		catch (Exception e) {
			path=UtilConstants._CITIZEN_HOME;
			request.setAttribute("status",UtilConstants._NODATA);
		}
		finally
		{
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
		
		}
	}

}
