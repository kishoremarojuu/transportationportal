package com.trans.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trans.delegate.RegisterMgrDelegate;
import com.trans.util.UtilConstants;

public class CheckuserAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        HttpSession session=request.getSession();
        String role=(String)session.getAttribute("role");
        String target="./Registration.jsp";
        if(role!=null){
        if(role.equalsIgnoreCase("ADMIN"))
        {
        	target="./addCityEmployees.jsp";
        }
        
        }
		boolean flag=false;
		
		try{
			String userid=request.getParameter("userName");
			flag=new RegisterMgrDelegate().checkAvailability(userid);
			System.out.println(flag);
			if(flag==false){
				
				request.setAttribute("status",UtilConstants._USER_AVAILABLE);
			
			}
			else
			{
				
              request.setAttribute("status", UtilConstants._USER_NOT_AVAILABLE);
			
			}
			}
		catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("status", "Sorry.. Try again ...");

		}
		finally{
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);	
	}
	}
}
