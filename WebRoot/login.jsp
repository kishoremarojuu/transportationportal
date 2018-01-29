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
  
  <jsp:include page="visitormenu.jsp"></jsp:include>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   <center>
   <font color="red"><b>
   
		 <c:if test="${requestScope.status!='null'}">
					 
                          <c:out value="${requestScope.status}"></c:out> 
                          </c:if>
                          </b>
                          </font>
                         
                           </center>
   <center>
   <h3>Login Page<br /></h3>
  </center>
  <center>
    <form action="<%=request.getContextPath() %>/LoginAction" name="login" onsubmit="return validate()">
     <table>
     <tr><td><font color="#E6E6FA"size="4">UserName</font></td><td><input type="text" name="userName"/> </td></tr>
      <tr><td><font color="#E6E6FA"size="4">Password</font></td><td><input type="password" name="password"/></td></tr>
     <tr><td></td><td><input type="submit" value="Submit"/></td></tr>
     <tr><td></td><td><a href="<%=request.getContextPath() %>/Registration.jsp">CitizenRegitration</a></td></tr>
     </table>
    
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("login");
  
   frmvalidator.addValidation("userName","req","Please enter UserName");
   frmvalidator.addValidation("password","req","Please enter Password");
    
   </script>
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
