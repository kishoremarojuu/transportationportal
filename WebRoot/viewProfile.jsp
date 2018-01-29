
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
  
  </center>
  <center>
  Profile
  <form action="<%=request.getContextPath()%>/UpadateActon" name="update">
      <table>
         <tr><td><hr/></td><td><hr/></td></tr>
     <c:if test="${not empty profile}">
					<c:forEach var="profile" items="${profile}">


						<tr>
							<td align="center">
								UserName :
							</td>
							<td><input type="text" name="userName" value="${profile.userName}" readonly="readonly"/> </td>
							
							
						</tr>
						<tr>
							<td align="center">
								Password :
							</td>
							<td><input type="text" name="password" value="${profile.password}" /> </td>
							
							
						</tr>
						<tr>
							<td align="center">
								Name :
							</td>
							<td><input type="text" name="name" value="${profile.name}" /> </td>
							
							
						</tr>
						<tr>
							<td align="center">
								Occupation :
							</td>
							<td><input type="text" name="designation" value="${profile.designation}" /> </td>
							
							
						</tr>
						<tr>
							<td align="center">
								Email :
							</td>
							<td><input type="text" name="mail" value="${profile.mail}" /> </td>
							
							
						</tr>
						<tr>
							<td align="center">
								Phone :
							</td>
							<td><input type="text" name="phone" value="${profile.phone}" /> </td>
							
							
						</tr>
						<tr>
							<td align="center">
								City :
							</td>
							<td><input type="text" name="city" value="${profile.city}" readonly="readonly"/> </td>
							
							
						</tr>
						<tr>
							<td align="center">
								State :
							</td>
							<td><input type="text" name="state" value="${profile.state}" readonly="readonly"/> </td>
							
							
						</tr>
						<tr>
							<td align="center">
								
							</td>
							<td><input type="submit"  value="update" /> </td>
							
							
						</tr>
					</c:forEach>
				</c:if>
     </table> 
     </form>
     <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("update");
  
  frmvalidator.addValidation("userName","req","Please enter your Username");
   frmvalidator.addValidation("password","req","Please enter your Password");

    frmvalidator.addValidation("name","req","Please enter your Full Name");
  frmvalidator.addValidation("name","maxlen=40",	"Max length for FirstName is 40");
   frmvalidator.addValidation("designation","req","Please enter Employee Designation"); 
     frmvalidator.addValidation("mail","maxlen=50");
  frmvalidator.addValidation("mail","req");
  frmvalidator.addValidation("mail","email");

  frmvalidator.addValidation("phone","req");
  frmvalidator.addValidation("phone","maxlen=10");
  frmvalidator.addValidation("phone","numeric");
 frmvalidator.addValidation("phone","Phone");
 
 frmvalidator.addValidation("city","req","Please enter your city Name");
    frmvalidator.addValidation("state","req","Please enter your State Name");
   
  
 </script>
   
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
