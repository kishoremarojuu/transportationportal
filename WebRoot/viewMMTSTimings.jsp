
<%@page import="java.util.ArrayList"%>
<%@page import="com.trans.bean.BusBean"%>
<%@page import="com.trans.delegate.BusInfoDelegate"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.trans.bean.TrainScheduleBean"%>
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
  
 <c:if test="${sessionScope.role!='null'}">
		<c:choose>
      <c:when test="${sessionScope.role=='RailwayEmployee'}">
      <jsp:include page="rlyEmpMenu.jsp"></jsp:include>
      </c:when>
                        
       <c:otherwise>
                 <jsp:include page="citizenmenu.jsp"></jsp:include>
      </c:otherwise>
    </c:choose>
  </c:if>
 
  
  <div id="footer1_"> &nbsp;</div>
  <div id="footer2_">
   
   <center>
   <h3 >View <c:out value="${sessionScope.CITY}"></c:out> MMTS Schedule Timings<br /></h3>
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
    <form action="<%=request.getContextPath() %>/UpdateTrainScheduleAction" name="UpdateTrainSchedule" onsubmit="return validate()">
     <table>
      

     <%
     		String route=request.getParameter("route");
     		String tripno=request.getParameter("tripno");
			String city=(String)session.getAttribute("CITY");
			String from=null,to=null,s1=null,s2=null,s3=null,s4=null,s5=null,s6=null,s7=null,s8=null,s9=null,s10=null;
			ArrayList<BusBean> al=new BusInfoDelegate().viewTrainRoute(city);     
            Iterator<BusBean> it=al.iterator();
            BusBean bb;
            while(it.hasNext())
            {
             bb=(BusBean)it.next();
             if(route.equalsIgnoreCase(bb.getRootid())){
             System.out.println(bb.getFrom()+" ..trtr...."+bb.getTo()+"  "+bb.getStop1()+"  "+bb.getRootid());
             from=bb.getFrom();
             to=bb.getTo();
             s1=bb.getStop1();
             s2=bb.getStop2();
             s3=bb.getStop3();
             s4=bb.getStop4();
             s5=bb.getStop5();
             s6=bb.getStop6();
             s7=bb.getStop7();
             s8=bb.getStop8();
             s9=bb.getStop9();
             s10=bb.getStop10();
            }
     
     }
     
            ArrayList<TrainScheduleBean> alt=new BusInfoDelegate().viewTrainSchedule(city);     
            Iterator<TrainScheduleBean> i=alt.iterator();
            TrainScheduleBean tb;
            while(i.hasNext())
            {
             tb=(TrainScheduleBean)i.next();
            System.out.println("mmmm"+tb.getFromtime()+""+tb.getTotime()+"  "+tb.getS10time()+"  "+tb.getRoute());
            
             if((route.equalsIgnoreCase(tb.getRoute()))&&(tripno.equalsIgnoreCase(Integer.toString(tb.getTripno()))))
             {
             System.out.println(tb.getFromtime()+""+tb.getTotime()+"  "+tb.getS10time()+"  "+tb.getRoute());
             %>
           
              
			<tr><td><font color="#E6E6FA"size="4">Route</font></td><td><input type="text" name="route" value="<%=tb.getRoute() %>" readonly="readonly"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4"><%=from %></font></td><td><input type="text" name="fromtime" value="<%=tb.getFromtime()%>"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4"><%=s1%></font></td><td><input type="text" name="s1time" value="<%=tb.getS1time()%>"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4"><%=s2%></font></td><td><input type="text" name="s2time" value="<%=tb.getS2time()%>"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4"><%=s3%></font></td><td><input type="text" name="s3time" value="<%=tb.getS3time()%>"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4"><%=s4%></font></td><td><input type="text" name="s4time" value="<%=tb.getS4time()%>"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4"><%=s5%></font></td><td><input type="text" name="s5time" value="<%=tb.getS5time()%>"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4"><%=s6%></font></td><td><input type="text" name="s6time" value="<%=tb.getS6time()%>"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4"><%=s7%></font></td><td><input type="text" name="s7time" value="<%=tb.getS7time()%>"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4"><%=s8%></font></td><td><input type="text" name="s8time" value="<%=tb.getS8time()%>"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4"><%=s9%></font></td><td><input type="text" name="s9time" value="<%=tb.getS9time()%>"/></td></tr>
           <tr><td><font color="#E6E6FA"size="4"><%=s10%></font></td><td><input type="text" name="s10time" value="<%=tb.getS10time()%>"/></td></tr>
            <tr><td><font color="#E6E6FA"size="4"><%=to%></font></td><td><input type="text" name="totime"  value="<%=tb.getTotime()%>"/></td></tr>
         
           <tr><td><font color="#E6E6FA"size="4">TripNo</font></td><td><input type="text" name="tripno" value="<%=tripno%>"/></td></tr>
     <tr><td></td><td><input type="hidden" name="tripid" value="<%=tripno%>"/></td></tr>
     
     <c:if test="${sessionScope.role!='null'}">
		<c:choose>
      <c:when test="${sessionScope.role=='RailwayEmployee'}">
       <tr><td></td><td><a href="<%=request.getContextPath()%>/DeleteMMTSScheduleAction?route=<%=tb.getRoute() %>&tripno=<%=tb.getTripno() %>">Delete</a></td></tr>
      </c:when>
                        
       <c:otherwise>
                <br/>
      </c:otherwise>
    </c:choose>
  </c:if>

    
    
             
            <% 
            }
     }
      %>
 
     <c:if test="${sessionScope.role!='null'}">
		<c:choose>
      <c:when test="${sessionScope.role=='RailwayEmployee'}">
      <tr><td><input type="submit" name="update" value="Update" /></td></tr>
      </c:when>
                        
       <c:otherwise>
                <br/>
      </c:otherwise>
    </c:choose>
  </c:if>
          
          
     <tr><td></td><td></td></tr>
     </table>
    
    </form> 
    
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
