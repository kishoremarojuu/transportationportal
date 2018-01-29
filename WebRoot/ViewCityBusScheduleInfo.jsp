
<%@page import="java.util.ArrayList"%>
<%@page import="com.trans.bean.BusBean"%>
<%@page import="com.trans.delegate.BusInfoDelegate"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.trans.delegate.CityInfoMgrDelegate"%>
<%@page import="com.trans.bean.CityTransportsBean"%>
<%@page import="com.trans.bean.CityFareBean"%>
<%@page import="com.trans.bean.EduInfoBean"%>
<%@page import="com.trans.bean.BusScheduleBean"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
      <c:when test="${sessionScope.role=='TrafficEmployee'}">
      <jsp:include page="cityempmenu.jsp"></jsp:include>
      </c:when>
                        
       <c:otherwise>
                 <jsp:include page="citizenmenu.jsp"></jsp:include>
      </c:otherwise>
    </c:choose>
  </c:if>
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
   <h3 >View <c:out value="${sessionScope.CITY}"></c:out> Bus Route Information<br /></h3>
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
    
     <table border="2">
      
     <%
           String route=request.getParameter("route");
     
			ArrayList<BusScheduleBean> al=new BusInfoDelegate().viewBusScheduleInfo();  
			
             %>
           <tr bgcolor="white"><td>RootNo</td>
				<td>From</td>
				<td>Destination</td>
                <td>StartTime</td>
                <td>ReachedTime</td>
                <td>Depot</td>
                <td>ServiceNo</td>
                <td>TripNo</td>
               </tr>
                
					
					<%
						if(!al.isEmpty()) {
			
            Iterator<BusScheduleBean> it=al.iterator();
           BusScheduleBean bb;
            while(it.hasNext())
            {
             bb=(BusScheduleBean)it.next();
             System.out.println(bb.getRootno()+""+bb.getFrom());
             if(route.equalsIgnoreCase(bb.getRootno()))
             {
					%>
					
				<tr><td><%=bb.getRootno() %></td>
				<td><%=bb.getFrom() %></td>
				<td><%=bb.getTo() %></td>
				<td><%=bb.getStime() %></td>
                <td><%=bb.getRtime() %></td>
                <td><%=bb.getDepot() %></td>
                <td><%=bb.getServiceno() %></td>
                <td><%=bb.getTripno() %></td>
              </tr>
			    <%}}
    }
    %>
    
  
     </table>

  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
