
<%@page import="java.util.ArrayList"%>
<%@page import="com.trans.bean.BusBean"%>
<%@page import="com.trans.delegate.BusInfoDelegate"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.trans.delegate.CityInfoMgrDelegate"%>
<%@page import="com.trans.bean.CityTransportsBean"%>
<%@page import="com.trans.bean.CityFareBean"%>
<%@page import="com.trans.bean.EduInfoBean"%>
<%@page import="com.trans.bean.CityBean"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   <h3 ><br /></h3>
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
    <form action="<%=request.getContextPath()%>/ViewFeedBackByAdminAction">
     <table>
       <tr><td><input type="hidden" name="type" value="<%=request.getParameter("type")%>"/> </td></tr>
     <%
    
			ArrayList<CityBean> al=new CityInfoMgrDelegate().viewCity();
			
             %>
           <tr><td>Select City<br /></td><td><select name="city">
					<option value="">--choose---[State]</option>
					<%
						if(!al.isEmpty()) {
			
            Iterator<CityBean> it=al.iterator();
           CityBean bb;
            while(it.hasNext())
            {
             bb=(CityBean)it.next();
             System.out.println(bb.getCityid()+"...."+bb.getState());
					%>
					<option value="<%=bb.getCity()%>"><%=bb.getCity()%>[<%=bb.getState()%>] </option>
				
			
    <%}
    }
    %>
    </select> </td><td><input type="submit" value="Next"/></td></tr>
  
         
         
     </table>
   </form>
   
  </center>
  </div>
  <div id="footer3_"> &nbsp;</div>
</div>
</body></html>
