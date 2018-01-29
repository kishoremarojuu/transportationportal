package com.trans.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trans.bean.FeedBackBean;
import com.trans.delegate.RegisterMgrDelegate;
import com.trans.exception.DataNotFoundException;
import com.trans.util.UtilConstants;

public class ViewFeedBackByAdminAction extends HttpServlet {

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
		String city=request.getParameter("city");
		String type=request.getParameter("type");
		System.out.println(city+"...."+type);
		try
		{
			al=new RegisterMgrDelegate().viewFeedBack(city,type);
			if(!al.isEmpty())
			{ if(type.equalsIgnoreCase("FeedBack"))
				path=UtilConstants._VIEW_FEEDBACK_BY_ADMN;
			else 
				path=UtilConstants._VIEW_SUGGESTION_BY_ADMIN;
				request.setAttribute("feedback",al);
				
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

