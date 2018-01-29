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
<div id="Container">
  <div id="header_"> &nbsp;
   
  </div>
  <jsp:include page="rlyEmpMenu.jsp"></jsp:include>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
   <h3 >Add <c:out value="${sessionScope.CITY}"></c:out> MMTS Route</h3>
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
    <form action="<%=request.getContextPath() %>/AddTrainRouteAction" name="addBusRoute" onsubmit="return validate()">
     <table>
      <tr><td><font color="#E6E6FA"size="4">Train RouteNo</font></td><td><input type="text" name="rootid"/></td></tr>
       <tr><td><font color="#E6E6FA"size="4">From</font></td><td><input type="text" name="from"/></td></tr>
          <tr><td><font color="#E6E6FA"size="4">To</font></td><td><input type="text" name="to"/></td></tr>
          <th colspan="12" style="size: 16;color: blue;font:bold"> Enter 10  Station's Names Between Source and Destination</th>
          <tr><td><font color="#E6E6FA"size="4">Station1</font></td><td><input type="text" name="stop1"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4">Station2</font></td><td><input type="text" name="stop2"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4">Station3</font></td><td><input type="text" name="stop3"/></td></tr>
             <tr><td><font color="#E6E6FA"size="4">Station4</font></td><td><input type="text" name="stop4"/></td></tr>
              <tr><td><font color="#E6E6FA"size="4">Station5</font></td><td><input type="text" name="stop5"/></td></tr>
               <tr><td><font color="#E6E6FA"size="4">Station6</font></td><td><input type="text" name="stop6"/></td></tr>
                <tr><td><font color="#E6E6FA"size="4">Station7</font></td><td><input type="text" name="stop7"/></td></tr>
                 <tr><td><font color="#E6E6FA"size="4">Station8</font></td><td><input type="text" name="stop8"/></td></tr>
                  <tr><td><font color="#E6E6FA"size="4">Station9</font></td><td><input type="text" name="stop9"/></td></tr>
                   <tr><td><font color="#E6E6FA"size="4">Station10</font></td><td><input type="text" name="stop10"/></td></tr>
     <tr><td><input type="reset" value="Clear"/></td><td><input type="submit" value="Submit"/></td></tr>
     <tr><td></td><td></td></tr>
     </table>
    
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("addBusRoute");
   frmvalidator.addValidation("rootid","req","Please enter Route NO");
   frmvalidator.addValidation("from","req","Please enter Starting From");
     frmvalidator.addValidation("To","req","Please enter Last Station");
     frmvalidator.addValidation("stop1","req","Please enter  Station 1");
     frmvalidator.addValidation("stop2","req","Please enter  Station 2");
     frmvalidator.addValidation("stop3","req","Please enter  Station 3");
     frmvalidator.addValidation("stop4","req","Please enter  Station 4");
     frmvalidator.addValidation("stop5","req","Please enter  Station 5");
    frmvalidator.addValidation("stop6","req","Please enter  Station 6");
    frmvalidator.addValidation("stop7","req","Please enter  Station 7");
    frmvalidator.addValidation("stop8","req","Please enter  Station 8");
    frmvalidator.addValidation("stop9","req","Please enter  Station 9");
     frmvalidator.addValidation("stop10","req","Please enter  Station 10");
   </script>
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
