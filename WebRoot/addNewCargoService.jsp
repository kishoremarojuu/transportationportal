
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
   <h3 >Add <c:out value="${sessionScope.CITY}"></c:out> City  Cargo TransPorts Details<br /></h3>
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
    <form action="<%=request.getContextPath() %>/AddTransportAction" name="addTransport" onsubmit="return validate()">
     <table>
      
          <tr><td><font color="#E6E6FA"size="4">TransportName</font></td><td><input type="text" name="name" /></td></tr>
          <tr><td><font color="#E6E6FA"size="4">PhoneNo</font></td><td><input type="text" name="phone"  /></td></tr>
          <tr><td><font color="#E6E6FA"size="4">Area</font></td><td><input type="text" name="area"/></td></tr>
          <tr><td><font color="#E6E6FA"size="4">City</font></td><td><input type="text" name="city" value="${sessionScope.CITY}" readonly="readonly"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4">AirWayService</font></td><td><input type="radio" name="air" value="YES" checked="checked"/>Yes <input type="radio" name="air" value="NO"/>No</td></tr>
           <tr><td><font color="#E6E6FA"size="4">SurfaceService</font></td><td><input type="radio" name="surface" value="YES" checked="checked"/>Yes <input type="radio" name="surface" value="NO"/>No</td></tr>
           <tr><td><font color="#E6E6FA"size="4">Water</font></td><td><input type="radio" name="water" value="YES" checked="checked"/>Yes <input type="radio" name="water" value="NO" />No</td></tr>
           <tr><td></td><td><input type="submit" value="Submit"/></td></tr>
     <tr><td></td><td></td></tr>
     </table>
    
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("addTransport");
   frmvalidator.addValidation("name","req","Please Transport Name");
   frmvalidator.addValidation("phone","req","Enetr Phone No");
  frmvalidator.addValidation("phone","maxlen=10");
  frmvalidator.addValidation("phone","numeric");
 frmvalidator.addValidation("phone","Phone");
     frmvalidator.addValidation("area","req","Please enter Area");
     frmvalidator.addValidation("city","req","Please enter City");
     frmvalidator.addValidation("air","req","Please Select Yes or No");
      frmvalidator.addValidation("surface","req","Please Select Yes or No");
       frmvalidator.addValidation("water","req","Please Select Yes or No");
   

   </script>
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
