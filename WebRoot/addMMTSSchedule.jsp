
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
  
  <jsp:include page="rlyEmpMenu.jsp"></jsp:include>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
   <h3 >Add <c:out value="${sessionScope.CITY}"></c:out> MMTS Schedule Timings<br /></h3>
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
    <form action="<%=request.getContextPath() %>/AddTrainScheduleAction" name="addTrainSchedule" onsubmit="return validate()">
     <table>
      

     <%
     		String route=request.getParameter("route");
			String city=(String)session.getAttribute("CITY");
			ArrayList<BusBean> al=new BusInfoDelegate().viewTrainRoute(city);     
            Iterator<BusBean> it=al.iterator();
            BusBean bb;
            while(it.hasNext())
            {
             bb=(BusBean)it.next();
             if(route.equalsIgnoreCase(bb.getRootid())){
             System.out.println(bb.getFrom()+""+bb.getTo()+"  "+bb.getStop1()+"  "+bb.getRootid());
             %>
           
              
			<tr><td><font color="#E6E6FA"size="4">Route</font></td><td><input type="text" name="route" value="<%=bb.getRootid() %>" readonly="readonly"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4"><%=bb.getFrom()%></font></td><td><input type="text" name="fromtime" value="00:00"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4"><%=bb.getStop1()%></font></td><td><input type="text" name="s1time" value="00:00"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4"><%=bb.getStop2()%></font></td><td><input type="text" name="s2time" value="00:00"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4"><%=bb.getStop3()%></font></td><td><input type="text" name="s3time" value="00:00"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4"><%=bb.getStop4()%></font></td><td><input type="text" name="s4time" value="00:00"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4"><%=bb.getStop5()%></font></td><td><input type="text" name="s5time" value="00:00"/></td></tr>
                 <tr><td><font color="#E6E6FA"size="4"><%=bb.getStop6()%></font></td><td><input type="text" name="s6time" value="00:00"/></td></tr>
                  <tr><td><font color="#E6E6FA"size="4"><%=bb.getStop7()%></font></td><td><input type="text" name="s7time" value="00:00"/></td></tr>
                   <tr><td><font color="#E6E6FA"size="4"><%=bb.getStop8()%></font></td><td><input type="text" name="s8time" value="00:00"/></td></tr>
                    <tr><td><font color="#E6E6FA"size="4"><%=bb.getStop9()%></font></td><td><input type="text" name="s9time" value="00:00"/></td></tr>
                     <tr><td><font color="#E6E6FA"size="4"><%=bb.getStop10()%></font></td><td><input type="text" name="s10time" value="00:00"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4"><%=bb.getTo()%></font></td><td><input type="text" name="totime"  value="00:00"/></td></tr>
          
           <tr><td><font color="#E6E6FA"size="4">TripNo</font></td><td><input type="text" name="tripno"/></td></tr>
    
             
            <% 
            }
     
     }
      %>
     
          
           <tr><td><input type="reset" value="Clear"/></td><td><input type="submit" value="Submit"/></td></tr>
     <tr><td></td><td></td></tr>
     </table>
    
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("addTrainSchedule");
   frmvalidator.addValidation("route","req","Please Select Root");
   frmvalidator.addValidation("fromtime","req","Please enter Starting Time");
     
     frmvalidator.addValidation("s1time","req","Please enter Arrival Time");
     frmvalidator.addValidation("s2time","req","Please enter Arrival Time");
     frmvalidator.addValidation("s3time","req","Please enter Arrival Time");
     frmvalidator.addValidation("s4time","req","Please enter Arrival Time");
     frmvalidator.addValidation("s5time","req","Please enter Arrival Time");
     frmvalidator.addValidation("s6time","req","Please enter Arrival Time");
     frmvalidator.addValidation("s7time","req","Please enter Arrival Time");
     frmvalidator.addValidation("s8time","req","Please enter Arrival Time");
     frmvalidator.addValidation("s9time","req","Please enter Arrival Time");
     frmvalidator.addValidation("s10time","req","Please enter Arrival Time");
     frmvalidator.addValidation("totime","req","Please enter Reached Time");
     frmvalidator.addValidation("tripno","req","Please enter  TripNo");

   </script>
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
