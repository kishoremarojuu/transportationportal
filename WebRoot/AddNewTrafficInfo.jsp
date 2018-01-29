
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
   <h3 >Add <c:out value="${sessionScope.CITY}"></c:out> City  Traffic Details<br /></h3>
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
    <form action="<%=request.getContextPath() %>/AddTrafficInfoAction" name="addTrafficInfo" onsubmit="return validate()">
     <table>
      
          
          <tr><td><font color="#E6E6FA"size="4">RouteNo</font></td><td><input type="text" name="rootid"  /><input type="hidden" name="city" value="${sessionScope.CITY}"/></td></tr>
          <tr><td><font color="#E6E6FA"size="4">BusStopName</font></td><td><input type="text" name="busstopname"/></td></tr>
          <tr><td><font color="#E6E6FA"size="4">No of Signals</font></td><td><input type="text" name="signals"/></td></tr>
          <tr><td><font color="#E6E6FA"size="4">No of FlyOvers</font></td><td><input type="text" name="flyover"/></td></tr>
          <tr><td><font color="#E6E6FA"size="4">No of KM</font></td><td><input type="text" name="kms"/></td></tr>
         
           <tr><td></td><td><input type="submit" value="Submit"/></td></tr>
     <tr><td></td><td></td></tr>
     </table>
    
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("addTrafficInfo");
   frmvalidator.addValidation("rootid","req","Please Enter bus Root No");
   frmvalidator.addValidation("busstopname","req","Enetr Bus Stop Name");
     frmvalidator.addValidation("signals","req","Please enter No of Signals from Previous BusStop");
       frmvalidator.addValidation("flyover","req","Please No of FlyOver from Previous BusStop");
     frmvalidator.addValidation("kms","req","Please enter No of KMs from Previous BusStop");
     
   </script>
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
