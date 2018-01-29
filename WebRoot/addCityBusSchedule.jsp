
<%@page import="java.util.ArrayList"%>
<%@page import="com.trans.bean.BusBean"%>
<%@page import="com.trans.delegate.BusInfoDelegate"%>
<%@page import="java.util.Iterator"%>
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
  
  <jsp:include page="cityempmenu.jsp"></jsp:include>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
   <h3 >Add <c:out value="${sessionScope.CITY}"></c:out> CityBus Schedule<br /></h3>
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
    <form action="<%=request.getContextPath() %>/AddBusScheduleAction" name="addBusSchedule" onsubmit="return validate()">
     <table>
      <tr><td><font color="#E6E6FA"size="4">Select Route</font></td><td><select name="route">
      <option value="select" selected="selected">
								--Select--
							</option>
     <%
			String city=(String)session.getAttribute("CITY");
			ArrayList<BusBean> al=new BusInfoDelegate().viewBusRoute(city);     
            Iterator<BusBean> it=al.iterator();
            BusBean bb;
            while(it.hasNext())
            {
             bb=(BusBean)it.next();
             System.out.println(bb.getFrom()+""+bb.getTo()+"  "+bb.getSno()+"  "+bb.getRootid());
             %>
           
              
							<option value="<%=bb.getSno()%>">
								<%= bb.getFrom() %> To <%=bb.getTo()%>(<%= bb.getRootid()%>)
							</option>

     
    
             
            <% 
            }
     
     
      %>
      </select> </td></tr>
          <tr><td><font color="#E6E6FA"size="4">StartingTime</font></td><td><input type="text" name="stime" value="00:00"/></td></tr>
          <tr><td><font color="#E6E6FA"size="4">ReachedTime</font></td><td><input type="text" name="rtime"  value="00:00"/></td></tr>
          <tr><td><font color="#E6E6FA"size="4">ServiceNo</font></td><td><input type="text" name="serviceno"/></td></tr>
          <tr><td><font color="#E6E6FA"size="4">Depot</font></td><td><input type="text" name="depot"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4">TripNo</font></td><td><input type="text" name="tripno"/></td></tr>
           <tr><td><input type="reset" value="Clear"/></td><td><input type="submit" value="Submit"/></td></tr>
     <tr><td></td><td></td></tr>
     </table>
    
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("addBusSchedule");
   frmvalidator.addValidation("route","req","Please Select Root");
   frmvalidator.addValidation("stime","req","Please enter Starting Time");
     frmvalidator.addValidation("rtime","req","Please enter Reached Time");
     frmvalidator.addValidation("serviceno","req","Please enter  ServicNo");
     frmvalidator.addValidation("depot","req","Please enter  Depot Name");
     frmvalidator.addValidation("tripno","req","Please enter  TripNo");

   </script>
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
