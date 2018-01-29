
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> Sample Widget</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script language="javascript" type="text/javascript" src="basic.js"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script type="text/javascript"> 
  function initialize() { 
    var latlng = new google.maps.LatLng(1.383, 103.89); 
    var myOptions = { 
      zoom: 8, 
      center: latlng, 
      mapTypeId: google.maps.MapTypeId.ROADMAP 
    }; 
    var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions); 
  } 
</script>
 
<body onLoad="initialize()">
<jsp:include page="citizenmenu.jsp"></jsp:include>
<div id="map_canvas" style="width:100%; height:100%">
<!-- <div id="map_canvas" style="width:400px; height:500px"> -->
</div>
</body>
</html>