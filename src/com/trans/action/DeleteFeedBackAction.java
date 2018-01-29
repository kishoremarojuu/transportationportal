package com.trans.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trans.delegate.CityInfoMgrDelegate;
import com.trans.util.UtilConstants;

public class DeleteFeedBackAction extends HttpServlet {

	
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
		boolean flag=false;
		try
		{
			int fid=Integer.parseInt(request.getParameter("fid"));
			System.out.println(fid+"....");
			flag=new CityInfoMgrDelegate().deleteFeedBack(fid);
			System.out.println("flag...."+flag);
			if(flag)
			{
				path=UtilConstants._ADMIN_HOME;
				request.setAttribute("status",UtilConstants._DELETED);
				
			}
			else
			{
				path=UtilConstants._ADMIN_HOME;
				request.setAttribute("status",UtilConstants._DELETION_FAILED);
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
			path=UtilConstants._ADMIN_HOME;
			request.setAttribute("status",UtilConstants._DELETION_FAILED);
		}
		finally
		{
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
		
		}
	}

}
