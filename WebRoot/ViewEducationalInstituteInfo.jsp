
<%@page import="java.util.ArrayList"%>
<%@page import="com.trans.bean.BusBean"%>
<%@page import="com.trans.delegate.BusInfoDelegate"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.trans.delegate.CityInfoMgrDelegate"%>
<%@page import="com.trans.bean.CityTransportsBean"%>
<%@page import="com.trans.bean.CityFareBean"%>
<%@page import="com.trans.bean.EduInfoBean"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  
  <jsp:include page="citizenmenu.jsp"></jsp:include>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
   <h3 >View <c:out value="${sessionScope.CITY}"></c:out> Educational Institute's Information<br /></h3>
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
			ArrayList<EduInfoBean> al=new CityInfoMgrDelegate().viewEduInfo();  
			if(!al.isEmpty()) {
			%>
			<tr><td><font color="#E6E6FA"size="4">Name</font></td><td><font color="#E6E6FA"size="4">Area</font></td><td><font color="#E6E6FA"size="4">NearestBusStop</font></td><td><font color="#E6E6FA"size="4">City</font></td><td><font color="#E6E6FA"size="4">State</font></td><td><font color="#E6E6FA"size="4">PhoneNo</font></td><td><font color="#E6E6FA"size="4">WebSite</font></td></tr>
			<tr><td><font color="#E6E6FA"size="4">---------</font></td><td><font color="#E6E6FA"size="4">-------------</font></td><td><font color="#E6E6FA"size="4">-------------</font></td><td><font color="#E6E6FA"size="4">----------------</font></td><td><font color="#E6E6FA"size="4">-----------</font></td><td><font color="#E6E6FA"size="4">-------------</font></td><td><font color="#E6E6FA"size="4">--------</font></td></tr>
			
			<%
            Iterator<EduInfoBean> it=al.iterator();
           EduInfoBean bb;
            while(it.hasNext())
            {
             bb=(EduInfoBean)it.next();
             if(city.equalsIgnoreCase(bb.getCity())){
             System.out.println(bb.getEid()+""+bb.getName());
             %>
           
              
			<tr><td><font color="#E6E6FA"size="4"><%=bb.getName() %></font></td><td><font color="#E6E6FA"size="4"><%=bb.getArea() %></font></td><td><font color="#E6E6FA"size="4"><%=bb.getBusstop()%></font></td><td><font color="#E6E6FA"size="4"><%=bb.getCity() %></font></td><td><font color="#E6E6FA"size="4"><%=bb.getState() %></font></td><td><font color="#E6E6FA"size="4"><%=bb.getPhone()%></font></td><td><font color="#E6E6FA"size="4"><%=bb.getWebsite() %></font></td></tr>
    <%}
    }
    } %>
           
     </table>
    
   
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
