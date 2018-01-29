<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modelmenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="./menu/pro_dropdown_2/pro_dropdown_2.css" />

<script src="./menu/pro_dropdown_2/stuHover.js" type="text/javascript"></script>
  </head>
  
  <body>
    
<span class="preload1"></span>
<span class="preload2"></span>

<ul id="nav">
	<li class="top"><a href="<%=request.getContextPath() %>/adminhome.jsp" class="top_link"><span>Home</span></a></li>
	
	<li class="top"><a href="<%=request.getContextPath() %>/adminhome.jsp" id="services" class="top_link"><span class="down">City</span></a>
		<ul class="sub">
			<li><a href="<%=request.getContextPath() %>/addCity.jsp">AddCities</a></li>
			<li><a href="<%=request.getContextPath() %>/ViewCityAction">ViewCities</a></li>
		</ul>
	</li>
	<li class="top"><a href="<%=request.getContextPath() %>/adminhome.jsp" id="services" class="top_link"><span class="down">CityEmployees</span></a>
		<ul class="sub">
			<li><a href="<%=request.getContextPath() %>/addCityEmployees.jsp">AddCityEmployees</a></li>
			<li><a href="<%=request.getContextPath() %>/ViewCityEmployeesAction">ViewCityEmployees</a></li>
		</ul>
	</li>
	<li class="top"><a href="<%=request.getContextPath() %>/viewCityByAdmin.jsp?type=FeedBack" id="privacy" class="top_link"><span>ViewFeedBack</span></a></li>

	<li class="top"><a href="<%=request.getContextPath() %>/viewCityByAdmin.jsp?type=Suggestion" id="privacy" class="top_link"><span>ViewSuggestion</span></a></li>
	<li class="top"><a href="<%=request.getContextPath() %>/LogoutAction" id="privacy" class="top_link"><span>Logout</span></a></li>

</ul>
<p></p>
  </body>
</html>
