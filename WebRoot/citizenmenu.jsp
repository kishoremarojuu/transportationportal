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
	<li class="top"><a href="<%=request.getContextPath() %>/citizenhome.jsp" class="top_link"><span>Home</span></a></li>
	
	<li class="top"><a href="<%=request.getContextPath() %>/citizenhome.jsp" id="services" class="top_link"><span class="down">CityBusInfo</span></a>
		<ul class="sub">
			<li><a href="<%=request.getContextPath() %>/ViewCitizenCityBusRoutes.jsp">ViewCityBusRoutes</a></li>
			<li><a href="<%=request.getContextPath() %>/ViewCityBusSchedules.jsp">ViewCityBusSchedules</a></li>
		</ul>
	</li>
	<li class="top"><a href="<%=request.getContextPath() %>/citizenhome.jsp" id="services" class="top_link"><span class="down">MMTSInfo</span></a>
		<ul class="sub">
			<li><a href="<%=request.getContextPath() %>/MmtsRoutes.jsp">ViewMMTSTimings</a></li>
		    <li><a href="<%=request.getContextPath() %>/Map.jsp">ViewMap</a></li>
		</ul>
	</li>

	<li class="top"><a href="<%=request.getContextPath() %>/citizenhome.jsp" id="services" class="top_link"><span class="down">CityInfo</span></a>
		<ul class="sub">
			<li><a href="<%=request.getContextPath() %>/ViewRoadworksInfo.jsp">ViewRoadworksInfo</a></li>
			<li><a href="<%=request.getContextPath() %>/ViewFares.jsp">ViewFares</a></li>
			<li><a href="<%=request.getContextPath() %>/ViewCitizenCargoInfo.jsp">ViewCargoServices</a></li>
			<li><a href="<%=request.getContextPath() %>/ViewCitizenTrafficRoute.jsp">ViewSignalsAndRoutes</a></li>
			<li><a href="<%=request.getContextPath() %>/ViewEducationalInstituteInfo.jsp">ViewEducationalInstituteInfo</a></li>
		</ul>
	</li>
	<li class="top"><a href="<%=request.getContextPath() %>/citizenhome.jsp" id="products" class="top_link"><span class="down">FeedBack</span></a>
		<ul class="sub">
			<li><a href="<%=request.getContextPath() %>/FeedBack.jsp?type=FeedBack" >FeedBack</a></li>
			<li><a href="<%=request.getContextPath() %>/FeedBack.jsp?type=Suggestion">Suggestion</a></li>
		</ul>
	</li>
	<li class="top"><a href="<%=request.getContextPath() %>/citizenhome.jsp" id="contacts" class="top_link"><span class="down">Profile</span></a>
		<ul class="sub">
			<li><a href="<%=request.getContextPath() %>/ViewProfileAction">ViewProfile</a></li>
			
		</ul>
	</li>
	
	<li class="top"><a href="<%=request.getContextPath() %>/LogoutAction" id="privacy" class="top_link"><span>Logout</span></a></li>

</ul>
<p></p>
  </body>
</html>
