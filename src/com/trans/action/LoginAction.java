package com.trans.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trans.bean.RegisterBean;
import com.trans.delegate.RegisterMgrDelegate;
import com.trans.util.UtilConstants;

public class LoginAction extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
	
	     String username=request.getParameter("userName");
	     String password=request.getParameter("password");
	     String target="";
	     String role="",city="";
	     RegisterBean rb=null;
	    try{	 
	           rb=new RegisterMgrDelegate().roleCheck(username,password);
	           System.out.println(rb);
	           role=rb.getRole();
	           city=rb.getCity();
	          
	           System.out.println("in LoginAction Role is.........."+role+"city"+city);
	           
	           if (role.equalsIgnoreCase(UtilConstants._ADMIN))
	       	{
	       		
	       		request.setAttribute("status","Welcome "+ username);
	       		
	       		target = UtilConstants._ADMIN_HOME;
	       		
	       		session.setAttribute(UtilConstants._USERNAME,username );
	       		session.setAttribute(UtilConstants._ROLE,role);
	       		session.setAttribute(UtilConstants._CITY,city);
	       		session.setAttribute(UtilConstants._PASSWORD,password);
	       		
	       	}
	           else if (role.equalsIgnoreCase(UtilConstants._TRAFFICEMPLOYEE))
		       	{
		       		
		       		request.setAttribute("status","Welcome "+ username);
		       		
		       		target = UtilConstants._TRAFFICEMPLOYEE_HOME;
		       		
		       		session.setAttribute(UtilConstants._USERNAME, username );
		       		session.setAttribute(UtilConstants._ROLE, role);
		       		session.setAttribute(UtilConstants._CITY,city);
		       		session.setAttribute(UtilConstants._PASSWORD,password);
		       		
		       	}
	           else if (role.equalsIgnoreCase(UtilConstants._RAILWAYEMPLOYEE))
		       	{
		       		
		       		request.setAttribute("status","Welcome "+ username);
		       		
		       		target = UtilConstants._RAILWAYEMPLOYEE_HOME;
		       		
		       		session.setAttribute(UtilConstants._USERNAME, username );
		       		session.setAttribute(UtilConstants._ROLE, role);
		       		session.setAttribute(UtilConstants._CITY,city);
		       		session.setAttribute(UtilConstants._PASSWORD,password);
		       		
		       	}
	           else if (role.equalsIgnoreCase(UtilConstants._CITIZEN))
		       	{
		       		
		       		request.setAttribute("status","Welcome "+ username);
		       		
		       		target = UtilConstants._CITIZEN_HOME;
		       		
		       		session.setAttribute(UtilConstants._USERNAME, username );
		       		session.setAttribute(UtilConstants._ROLE, role);
		       		session.setAttribute(UtilConstants._CITY,city);
		       		session.setAttribute(UtilConstants._PASSWORD,password);
		       		
		       	}
	         
	       	
	       	else
	       	{
	       		System.out.println("Role"+role);
	       		
	       		
	       	request.setAttribute("status",UtilConstants._INVALID);
	       		
	       	 target=UtilConstants._LOGIN_PAGE;
	       	}
	    
	}
     catch (Exception e) {
    	 e.printStackTrace();
	
	 request.setAttribute("status",UtilConstants._SERVER_BUSY);	
  	 target=UtilConstants._LOGIN_PAGE;
		
		}
	finally{

	RequestDispatcher rd = request.getRequestDispatcher(target);
	rd.forward(request, response);
	}	

}
}