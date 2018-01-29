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
  
		<script type="text/javascript" src="scripts/image.js"> </script>
		 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>
<script language="JavaScript" src="scripts/javascripts.js"></script>
		<script language="JavaScript" src="scripts/pop-closeup.js"></script>	<script>
//var x_win = window.self; 

function goOn() {


var userName=document.register.userName.value;
var role=document.register.role.value;
window.location.href='<%=request.getContextPath()%>/CheckuserAction?userName='+userName+'&role='+role;

} 
</script>
</head>
<body>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<jsp:include page="Header.jsp"></jsp:include>
<div id="Container">
  
  <jsp:include page="visitormenu.jsp"></jsp:include>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
   <h3>Citizen Registration Form</h3>
  </center>
  <center>
    <form action="<%=request.getContextPath() %>/AddEmployeeAction" name="register" onsubmit="return validate()">
     <table>
      <tr><td><font color="#E6E6FA"size="4">UserName&nbsp;&nbsp; <br /></font></td><td><input type="text" name="userName" value="<%if(request.getParameter("userName")!=null)out.print(request.getParameter("userName")); %>" onblur="goOn()"/>
      <font color="red">
				
				${requestScope.status }
				
				</font>
      </td></tr>
       
       <tr><td><font color="#E6E6FA"size="4">Password</font></td><td><input type="password" name="password"/></td></tr>
         <tr><td><font color="#E6E6FA"size="4">Role</font></td><td><select name="role">
     <option value="select" selected="selected">
								--Select--
							</option>
							
    <option value="citizen">
								Citizen
							</option>
							
     
     </select> </td></tr>
        <tr><td><font color="#E6E6FA"size="4">FullName</font></td><td><input type="text" name="name"/></td></tr>
         <tr><td><font color="#E6E6FA"size="4">DOB</font></td><td> <input type="text" name="dob" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.register.dob', document.register.dob.value);"> <img src="<%=request.getContextPath()+"/images/cal.gif"%>" alt="a" width="18" height="18" border="0"/></a>    </td></tr>
         
          <tr><td><font color="#E6E6FA"size="4">Gender</font></td><td><select name="gender">
     <option value="select" selected="selected">
								--Select--
							</option>
							<option value="male">
								Male
							</option>
    <option value="female">
								Female
							</option>
							
     
     </select></td></tr>
           <tr><td><font color="#E6E6FA"size="4">Email</font></td><td><input type="text" name="mail"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4">PhoneNo</font></td><td><input type="text" name="phone"/></td></tr>
             <tr><td><font color="#E6E6FA"size="4">Designation</font></td><td><input type="text" name="designation"/></td></tr>
              <tr><td><font color="#E6E6FA"size="4">DoorNo</font></td><td><input type="text" name="dno"/></td></tr>
              <tr><td><font color="#E6E6FA"size="4">Area</font></td><td><input type="text" name="area"/></td></tr>
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
  var frmvalidator  = new Validator("register");
  
  frmvalidator.addValidation("userName","req","Please enter your Username");
   frmvalidator.addValidation("password","req","Please enter your Password");
  frmvalidator.addValidation("role","req","Please Select Role");
    frmvalidator.addValidation("name","req","Please enter your Full Name");
  frmvalidator.addValidation("name","maxlen=40",	"Max length for FirstName is 40");
   frmvalidator.addValidation("dob","req","Please enter your DOB"); 
    frmvalidator.addValidation("gender","dontselect=0");
     frmvalidator.addValidation("mail","maxlen=50");
  frmvalidator.addValidation("mail","req");
  frmvalidator.addValidation("mail","email");

  frmvalidator.addValidation("phone","req");
  frmvalidator.addValidation("phone","maxlen=10");
  frmvalidator.addValidation("phone","numeric");
 frmvalidator.addValidation("phone","Phone");
 frmvalidator.addValidation("designation","req","Please enter Employee Designation"); 
  frmvalidator.addValidation("dno","req","Please enter your Door Number"); 
   frmvalidator.addValidation("area","req","Please enter Area");
    frmvalidator.addValidation("state","req","Please enter your State Name");
   frmvalidator.addValidation("city","req","Please enter your city Name");
  
 </script>
   
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
