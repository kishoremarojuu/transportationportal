
<%@page import="java.util.ArrayList"%>
<%@page import="com.trans.bean.BusBean"%>
<%@page import="com.trans.delegate.BusInfoDelegate"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.trans.delegate.CityInfoMgrDelegate"%>
<%@page import="com.trans.bean.CityTransportsBean"%>
<%@page import="com.trans.bean.CityFareBean"%>
<%@page import="com.trans.bean.EduInfoBean"%>
<%@page import="com.trans.bean.RoadWorkBean"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  
  <jsp:include page="cityempmenu.jsp"></jsp:include>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
   <h3 >Add <c:out value="${sessionScope.CITY}"></c:out> Road Work Information<br /></h3>
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
    
     <table>
      
     <%
              String city=(String)session.getAttribute("CITY");
			ArrayList<RoadWorkBean> al=new CityInfoMgrDelegate().viewRoadWorkInfo();  
			if(!al.isEmpty()) {
			%>
			<tr><td><font color="#E6E6FA"size="4">WorkName</font></td><td><font color="#E6E6FA"size="4">Area</font></td><td><font color="#E6E6FA"size="4">City</font></td><td><font color="#E6E6FA"size="4">WorkType</font></td><td><font color="#E6E6FA"size="4">WorkToBeComplete(Days)</font></td></tr>
			<tr><td><font color="#E6E6FA"size="4">----------------</font></td><td><font color="#E6E6FA"size="4">-------------</font></td><td><font color="#E6E6FA"size="4">-------------</font></td><td><font color="#E6E6FA"size="4">----------------</font></td><td><font color="#E6E6FA"size="4">-----------</font></td></tr>
			
			<%
            Iterator<RoadWorkBean> it=al.iterator();
           RoadWorkBean bb;
            while(it.hasNext())
            {
             bb=(RoadWorkBean)it.next();
             if(city.equalsIgnoreCase(bb.getCity())){
             System.out.println(bb.getWorkid()+"...."+bb.getWorkdays());
             %>
           
              
			<tr><td><font color="#E6E6FA"size="4"><%=bb.getWorkname() %></font></td><td><font color="#E6E6FA"size="4"><%=bb.getArea() %></font></td><td><font color="#E6E6FA"size="4"><%=bb.getCity()%></font></td><td><font color="#E6E6FA"size="4"><%=bb.getWorktype() %></font></td><td><font color="#E6E6FA"size="4"><%=bb.getDays()%></font></td></tr>
    <%}
    }
    } %>
          <tr><td><font color="#E6E6FA"size="4"></font></td><td><a href="<%=request.getContextPath()%>/AddNewRoadWorkInfo.jsp">AddNewRoadWorkInfo</a></td></tr>
         
     </table>
    
   
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
