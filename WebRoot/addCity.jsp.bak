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
  
  <jsp:include page="adminmenu.jsp"></jsp:include>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
   <h3>Add City</h3>
  </center>
  <center>
    <form action="<%=request.getContextPath() %>/AddCityAction" name="addCity" onsubmit="return validate()">
     <table>
     <tr><td><font color="#E6E6FA"size="4">StateName</font></td><td><select name="state">
     <option value="select" selected="selected">
								--Select--
							</option>
							<option value="AndhraPradesh">
								AndhraPradesh
							</option>
    <option value="WestBengal">
								WestBengal
							</option>
							<option value="UttarPradesh">
								UttarPradesh
							</option>
     
     </select> </td></tr>
      <tr><td><font color="#E6E6FA"size="4">CityName</font></td><td><input type="text" name="city"/></td></tr>
     <tr><td><input type="reset" value="Clear"/></td><td><input type="submit" value="Submit"/></td></tr>
     <tr><td></td><td></td></tr>
     </table>
    
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("addCity");
  
   frmvalidator.addValidation("state","req","Please enter State name");
   frmvalidator.addValidation("city","req","Please enter City Name");
    
   </script>
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
