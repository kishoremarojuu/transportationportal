package com.trans.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.trans.bean.BusBean;
import com.trans.delegate.BusInfoDelegate;
import com.trans.util.UtilConstants;

public class AddTrainRouteAction extends HttpServlet {

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

		 HttpSession session=request.getSession();
	        String city=(String)session.getAttribute("CITY");
			boolean flag=false;
			String path="";
			BusBean bb=new BusBean();
			try{
				Map map = request.getParameterMap();
				BeanUtils.populate(bb, map);
				bb.setCity(city);
			flag=new BusInfoDelegate().addTrainRoute(bb);
			if(flag)
			{
				path=UtilConstants._RAILWAYEMPLOYEE_HOME;
				request.setAttribute("status",UtilConstants._ADDED);
			}
			else
			{
				path=UtilConstants._RAILWAYEMPLOYEE_HOME;
				request.setAttribute("status",UtilConstants._ADDED_FAILED);
			}
			}catch (Exception e) {
				path=UtilConstants._RAILWAYEMPLOYEE_HOME;
				request.setAttribute("status",UtilConstants._ADDED_FAILED);
				
			}
			finally{
				RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request, response);
			}
		}

	}