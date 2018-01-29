
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
  
  <jsp:include page="adminmenu.jsp"></jsp:include>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
  
  </center>
  <center>
      <table>
     <tr><td style="size:5;color: blue">StateName</td><td style="size:5;color: blue">CityName</td></tr>
     <tr><td><hr/></td><td><hr/></td></tr>
     <c:if test="${not empty city}">
					<c:forEach var="state" items="${city}">


						<tr>
							<td align="center">
								${state.state}
							</td>
							<td align="center">
								${state.city}
							</td>
							
							<td align="center"><a href="<%=request.getContextPath()%>/DeleteCityAction?cityid=${state.cityid}">Delete</a></td>
						</tr>
					</c:forEach>
				</c:if>
     </table> 
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
