package com.trans.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trans.delegate.CityInfoMgrDelegate;
import com.trans.util.UtilConstants;

public class AddCityAction extends HttpServlet {

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
        String State=request.getParameter("state");
        String city=request.getParameter("city");
        String path="";
        boolean flag=false;
        try{
        	flag=new CityInfoMgrDelegate().addCity(State,city);
        	System.out.println(flag);
        	if(flag)
        	{
        		path=UtilConstants._ADMIN_HOME;
        		request.setAttribute("status",UtilConstants._ADDED);
        	}
        	else
        	{
        		path=UtilConstants._ADMIN_HOME;
        		request.setAttribute("status",UtilConstants._ADDED_FAILED);
        	}
        	
        }catch (Exception e) {
        	path=UtilConstants._ADMIN_HOME;
    		request.setAttribute("status",UtilConstants._ADDED_FAILED);
			
		}finally{
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
		
		}
		
	}

}
