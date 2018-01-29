
<%@page import="java.util.ArrayList"%>
<%@page import="com.trans.bean.BusBean"%>
<%@page import="com.trans.delegate.BusInfoDelegate"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.trans.delegate.CityInfoMgrDelegate"%>
<%@page import="com.trans.bean.CityTransportsBean"%>
<%@page import="com.trans.bean.CityFareBean"%>
<%@page import="com.trans.bean.EduInfoBean"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   <h3 >View Bus Route Information<br /></h3>
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
      
     <%
           String route=request.getParameter("route");
     
			ArrayList<BusBean> al=new BusInfoDelegate().viewBusRouteInfo();  
			
             %>
           
					
					<%
						if(!al.isEmpty()) {
			
            Iterator<BusBean> it=al.iterator();
           BusBean bb;
            while(it.hasNext())
            {
             bb=(BusBean)it.next();
             System.out.println(bb.getRootid()+""+bb.getFrom());
             if(route.equalsIgnoreCase(bb.getRootid()))
             {
					%>
					
				<tr><td>RootNo</td><td><%=bb.getRootid() %></td></tr>
				<tr><td>From</td><td><%=bb.getFrom() %></td></tr>
				<tr><td>Stop1</td><td><%=bb.getStop1() %></td></tr>
                <tr><td>Stop2</td><td><%=bb.getStop2() %></td></tr>
                <tr><td>Stop3</td><td><%=bb.getStop3() %></td></tr>
                <tr><td>Stop4</td><td><%=bb.getStop4() %></td></tr>
                <tr><td>Stop5</td><td><%=bb.getStop5() %></td></tr>
                <tr><td>Stop6</td><td><%=bb.getStop6() %></td></tr>
                <tr><td>Stop7</td><td><%=bb.getStop7() %></td></tr>
                <tr><td>Stop8</td><td><%=bb.getStop8() %></td></tr>
                <tr><td>Stop9</td><td><%=bb.getStop9() %></td></tr>
                <tr><td>Stop10</td><td><%=bb.getStop10() %></td></tr>
                <tr><td>LastStop</td><td><%=bb.getTo() %></td></tr>
			    <%}}
    }
    %>
    
  
     </table>

  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
