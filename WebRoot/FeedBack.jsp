
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
  
  <jsp:include page="citizenmenu.jsp"></jsp:include>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
  
  <center>
 <%=request.getParameter("type") %> <c:out value="${requestScope.type}"></c:out>
  <form action="<%=request.getContextPath()%>/FeedbackActon" name="update">

      <table>
         <tr><td><hr/></td><td><hr/></td></tr>
    
						<tr>
							<td align="center">
							<font color="#E6E6FA"size="4">	Name :</font>
							</td>
							<td><input type="text" name="name" value="" /> </td>
							
							
						</tr>
						<tr>
							<td align="center">
							<font color="#E6E6FA"size="4">	Email :</font>
							</td>
							<td><input type="text" name="mail" value="" /> </td>
							
							
						</tr>
						<tr>
							<td align="center">
							<font color="#E6E6FA"size="4">	Phone :</font>
							</td>
							<td><input type="text" name="phone" value="" /> </td>
							
							
						</tr>
						<tr>
							<td align="center">
							<font color="#E6E6FA"size="4">	City :</font>
							</td>
							<td><input type="text" name="city" value="${sessionScope.CITY}" /> </td>
							
							
						</tr>
						<tr>
							<td align="center">
							<font color="#E6E6FA"size="4">	State :</font>
							</td>
							<td><input type="text" name="state" value="" /> </td>
							
							
						</tr>
						<tr>
							<td align="center">
							<font color="#E6E6FA"size="4">	u R  <%=request.getParameter("type") %>:</font>
							</td>
							<td><textarea rows="" cols="" name="area"></textarea> </td>
							
							
						</tr>
						<tr>
							<td align="center">
								
							</td>
							<td><input type="hidden" name="role" value="<%=request.getParameter("type") %>" /> </td>
							
							
						</tr>
						
						
						<tr>
							<td align="center">
								
							</td>
							<td><input type="submit"  value="Submit" /> </td>
							
							
						</tr>
					
     </table> 
     </form>
     <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("update");
  
  

    frmvalidator.addValidation("name","req","Please enter your Full Name");
  frmvalidator.addValidation("name","maxlen=40",	"Max length for FirstName is 40");

     frmvalidator.addValidation("mail","maxlen=50");
  frmvalidator.addValidation("mail","req");
  frmvalidator.addValidation("mail","email");

  frmvalidator.addValidation("phone","req");
  frmvalidator.addValidation("phone","maxlen=10");
  frmvalidator.addValidation("phone","numeric");
 frmvalidator.addValidation("phone","Phone"); 
   frmvalidator.addValidation("city","req","Please enter your city Name");
   frmvalidator.addValidation("state","req","Please enter your State Name");
   frmvalidator.addValidation("area","req","Please enter Area");
 </script>
   
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
