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

import com.trans.bean.FeedBackBean;
import com.trans.bean.RegisterBean;
import com.trans.delegate.RegisterMgrDelegate;
import com.trans.exception.DataNotFoundException;
import com.trans.util.UtilConstants;

public class ViewFeedbackAction extends HttpServlet {

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
		ArrayList<FeedBackBean> al;
		HttpSession session=request.getSession();
		String city=(String)session.getAttribute("CITY");
		String role=(String)session.getAttribute("role");
		if(role.equalsIgnoreCase(UtilConstants._TRAFFICEMPLOYEE))
		{
			path=UtilConstants._TRAFFICEMPLOYEE_HOME;	
		}
		else
			path=UtilConstants._RAILWAYEMPLOYEE_HOME;
		String type=request.getParameter("type");
		try
		{
			al=new RegisterMgrDelegate().viewFeedBack(city, type);
			if(!al.isEmpty())
			{ if(type.equalsIgnoreCase("FeedBack"))
				path=UtilConstants._VIEW_FEEDBACK;
			else 
				path=UtilConstants._VIEW_SUGGESTION;
				request.setAttribute("feedback",al);
				
			}
			else
			{
				
				request.setAttribute("status",UtilConstants._NODATA);
			}
		}
		catch(DataNotFoundException e)
		{
			
			request.setAttribute("status",e.getMessage());
		}
		
		catch (Exception e) {
			
			request.setAttribute("status",UtilConstants._NODATA);
		}
		finally
		{
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
		
		}
	}

}
