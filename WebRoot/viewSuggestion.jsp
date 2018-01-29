
<%@page import="java.util.ArrayList"%>
<%@page import="com.trans.bean.BusBean"%>
<%@page import="com.trans.delegate.BusInfoDelegate"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.trans.delegate.CityInfoMgrDelegate"%>
<%@page import="com.trans.bean.CityTransportsBean"%>
<%@page import="com.trans.bean.CityFareBean"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 
 <c:if test="${sessionScope.role!='null'}">
		<c:choose>
      <c:when test="${sessionScope.role=='TrafficEmployee'}">
      <jsp:include page="cityempmenu.jsp"></jsp:include>
      </c:when>
                        
       <c:otherwise>
                 <jsp:include page="rlyEmpMenu.jsp"></jsp:include>
      </c:otherwise>
    </c:choose>
  </c:if>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
   <h3 >View <c:out value="${sessionScope.CITY}"></c:out> City Suggestions<br /></h3>
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
   
     <table>
      
    
			<tr><td><font color="#E6E6FA"size="4">Name</font></td><td><font color="#E6E6FA"size="4">Suggestion</font></td><td><font color="#E6E6FA"size="4">SuggestionDate</font></td><td><font color="#E6E6FA"size="4">Phone</font></td><td><font color="#E6E6FA"size="4">Email</font></td></tr>
			<tr><td><font color="#E6E6FA"size="4">--------------------</font></td><td><font color="#E6E6FA"size="4">-------------</font></td><td><font color="#E6E6FA"size="4">-------------</font></td><td><font color="#E6E6FA"size="4">-------------</font></td><td><font color="#E6E6FA"size="4">-------------</font></td></tr>
			<c:if test="${not empty feedback}">
					<c:forEach var="feedback" items="${feedback}">
		
           
              
			<tr><td><font color="#E6E6FA"size="4">${feedback.name}</font></td><td><font color="#E6E6FA"size="4">${feedback.comment}</font></td><td><font color="#E6E6FA"size="4">${feedback.commentDate}</font></td><td><font color="#E6E6FA"size="4">${feedback.phone}</font></td><td><font color="#E6E6FA"size="4">${feedback.mail}</font></td></tr>
  </c:forEach>
				</c:if>
     </table>
    
   
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
