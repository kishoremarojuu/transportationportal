
<%@page import="java.util.ArrayList"%>
<%@page import="com.trans.bean.BusBean"%>
<%@page import="com.trans.delegate.BusInfoDelegate"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.trans.bean.TrainScheduleBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Travelling Train</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="./templet/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=request.getContextPath()+"/scripts/gen_validatorv31.js"%>" type="text/javascript"></script>
  <script language="JavaScript" type="text/javascript"
		src="<%=request.getContextPath()+"/scripts/ts_picker.js"%>"></script>
   <script type="text/javascript" src="scripts/image.js"> </script>
</head>
<body>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<jsp:include page="Header.jsp"></jsp:include>
<div id="Container">
  
 <c:if test="${sessionScope.role!='null'}">
		<c:choose>
      <c:when test="${sessionScope.role=='RailwayEmployee'}">
      <jsp:include page="rlyEmpMenu.jsp"></jsp:include>
      </c:when>
                        
       <c:otherwise>
                 <jsp:include page="citizenmenu.jsp"></jsp:include>
      </c:otherwise>
    </c:choose>
  </c:if>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
   <h3 >View <c:out value="${sessionScope.CITY}"></c:out> MMTS Routes<br /></h3>
  </center>
  <center>
   <font color="red"><b>
   
		 <c:if test="${requestScope.status!='null'}">
					 
                          <c:out value="${requestScope.status}"></c:out> 
                          </c:if>
                          </b>
                          </font>
                         
                           </center>
  <center>
    <form action="<%=request.getContextPath() %>/viewMMTSTimings.jsp" name="root">
     <table>
      <tr><td><font color="#E6E6FA"size="4">Select Route</font></td><td><select name="route" onchange="javascript:if(document.root.route.value==''){alert('Select Route');}  {location.href='./MmtsRoutes.jsp?route='+document.root.route.value;}">
      <%
      String root=request.getParameter("route");
      if(request.getParameter("route")!=null)
      {
       %>
       <option value="<%=request.getParameter("route")%>"><%=request.getParameter("route")%>
								
							</option>
							<%} 
							else
							{
							%>
       
       
      
      <option value="select" selected="selected">
								--Select--
							</option>
     <%
			String city=(String)session.getAttribute("CITY");
			ArrayList<BusBean> al=new BusInfoDelegate().viewTrainRoute(city);     
            Iterator<BusBean> it=al.iterator();
            BusBean bb;
            while(it.hasNext())
            {
             bb=(BusBean)it.next();
             System.out.println(bb.getFrom()+""+bb.getTo()+"  "+bb.getStop1()+"  "+bb.getRootid());
             %>
           
              
							<option value="<%=bb.getRootid()%>">
								<%= bb.getFrom() %> To <%=bb.getTo()%>(<%= bb.getRootid()%>)
							</option>

     
    
             
            <% 
            }
     
     }
      %>
      </select> </td></tr>
         <tr><td><font color="#E6E6FA"size="4">Select TripNo</font></td><td><select name="tripno">
      <option value="select" selected="selected">
								--Select--
							</option>
     <%
     String city=(String)session.getAttribute("CITY");
     System.out.println(".....ssss...."+root+",.,.."+city);
         if(request.getParameter("route")!=null)
         {
             String route=request.getParameter("route");

			System.out.println(".....ssss"+route);
			ArrayList<TrainScheduleBean> al=new BusInfoDelegate().viewTrainSchedule(city);     
            Iterator<TrainScheduleBean> it=al.iterator();
            TrainScheduleBean bb;
            while(it.hasNext())
            {
             bb=(TrainScheduleBean)it.next();
             if(route.equalsIgnoreCase(bb.getRoute()))
             {
             System.out.println(bb.getFromtime()+""+bb.getTotime()+"  "+bb.getS10time()+"  "+bb.getRoute());
             %>
           
              
							<option value="<%=bb.getTripno()%>">
								<%= bb.getTripno() %> 
							</option>

     
    
             
            <% 
            }
     }
     }
      %>
      </select> </td></tr> 
          
          
           <tr><td></td><td><input type="submit" value="Next"/></td></tr>
     <tr><td></td><td></td></tr>
     </table>
    
    </form>
   
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
