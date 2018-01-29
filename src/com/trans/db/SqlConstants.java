package com.trans.db;

public class SqlConstants {
	
	public static final String _ADD_CITY="INSERT INTO CITY VALUES((select nvl(max(CITYID),100)+1 from CITY),?,(SELECT MAX(STATEID) FROM STATE))";
	public static final String _ADD_STATE="INSERT INTO STATE values((select nvl(max(STATEID),100)+1 from STATE),?)";
	public static final String _GET_STATEID="SELECT STATEID FROM STATE WHERE STATENAME=?";
	public static final String _ADD_CITYY="INSERT INTO CITY VALUES((select nvl(max(CITYID),100)+1 from CITY),?,?)";
	public static final String _GET_CITY="select s.stateid,s.statename,c.cityid,c.cityname from state s,city c where s.stateid=c.stateid";
	public static final String _DELETE_CITY="DELETE FROM CITY WHERE CITYID=?";
	public static final String _DELETE_FEEDBACK="DELETE FROM FEEDBACK WHERE FID=?";
	public static final String _DELETE_EMPLOYEE="DELETE FROM LOGINDATA WHERE LOGINID=?";
	public static final String _VIEW_EMPLYEE="select NAME,TYPE,OCCUPATION,PHONE,CITY,STATE,loginid from LOGINDATA where type!='admin' and type!='citizen'";
	public static final String _VIEW_EMPLYEE_ROLE="select TYPE,CITY from LOGINDATA where loginid=? and password=?";
	public static final String _ADD_BUS_ROUTE="INSERT INTO CITYBUSROUTE VALUES((select nvl(max(sno),100)+1 from CITYBUSROUTE),(select cityid from city where cityname=?),?,?,?)";
	public static final String _ADD_BUS_SCHEDULE="INSERT INTO CITYBUSINFORMATION VALUES(?,(select starting from CITYBUSROUTE where sno=?),(select ending from CITYBUSROUTE where sno=?),?,?,?,?,?)";
	public static final String _VIEW_TRANSPORT="select * from GOODSTRANSPORT order by TID";
	public static final String _VIEW_FARE="select * from CITY_FARES where CITY_FARES.CITYID=(select cityid from city where cityname=?) order by FAREID";
	public static final String _ADD_FARE="INSERT INTO CITY_FARES VALUES((select nvl(max(fareid),100)+1 from CITY_FARES),?,?,?,(select cityid from city where cityname=?))";
	public static final String _ADD_TRANSPORT="INSERT INTO GOODSTRANSPORT VALUES((select nvl(max(tid),100)+1 from GOODSTRANSPORT),?,?,?,?,?,?,?)";
	public static final String _VIEW_EDU_INFO="select * from EDUCATION_INSTITUTES order by EID";
	public static final String _ADD_EDU_INFO="insert into EDUCATION_INSTITUTES values(?,?,?,?,?,?,?,(select nvl(max(eid),100)+1 from EDUCATION_INSTITUTES))";
	public static final String _ADD_ROAD_WORK_INFO="insert into ROADWORK values((select nvl(max(WORKID),100)+1 from ROADWORK),?,?,?,?,?,sysdate)";
	public static final String _ADD_TRAFFIC_INFO="insert into TRAFICANALIZER values((select sno from CITYBUSROUTE where routeid=? and cityid=(select cityid from city where cityname=?)),?,?,?,?)";
	public static final String _VIEW_CITIZEN="select NAME,OCCUPATION,PHONE,CITY,STATE,loginid,password,email from LOGINDATA where type='citizen' and loginid=?";
	public static final String _VIEW_FEEDBACK="SELECT FID,NAME,CITY,STATE,EMAIL,PHONE,COMMENTS,TYPE,TO_CHAR(COMMENTDATE) FROM FEEDBACK WHERE CITY=? AND TYPE=?";
	public static final String _ADD_BUS_STOPS="insert into CITYBUSSTOP values((select max(sno) from CITYBUSROUTE),?,?,?,?,?,?,?,?,?,?)";
	public static final String _VIEW_BUS_ROUTE="select * from CITYBUSROUTE order by routeid";
	 public static final String _CHECK_AVAILABILITY="select loginid from logindata where loginid=?";
	 public static final String _INSERT_USERS="insert into logindata values((select nvl(max(loginno),1000)+1 from logindata),?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
	 public static final String _INSERT_FEEDBACK="insert into feedback values((select nvl(max(fid),1000)+1 from feedback),?,?,?,?,?,?,?,sysdate)";  
	 
	 public static final String _INSERT_ADDRESS="insert into address values((select max(userid) from userdetails),(select nvl(max(addressid),1000)+1 from address),?,?,?,?,?,?,?,?)";
	 public static final String _RECOVER_PASSWORD="select password from userdetails where loginid=? and forgotquestion=? and forgotanswer=?";
	 public static final String _CHECK_USER="select role from userdetails where loginid=? and password=?";
	 public static final String _VIEW_ROAD_WORK_INFO="select * from ROADWORK order by WORKID";
	 public static final String _VIEW_TRAFFIC_INFO="select snoref,busstopname,signalpoints,flyover,kilometers,routeid from TRAFICANALIZER,CITYBUSROUTE where  CITYBUSROUTE.sno=TRAFICANALIZER.snoref and CITYBUSROUTE.CITYID=(select cityid from city where cityname=?)";
	 public static final String _VIEW_BUS_ROUTE_INFO="select * from CITYBUSROUTE,CITYBUSSTOP where CITYBUSROUTE.SNO=CITYBUSSTOP.SNOREF  order by routeid";
	 public static final String _VIEW_BUS_ROUTE_INFO_BY_CITY="select * from CITYBUSROUTE,CITYBUSSTOP where CITYBUSROUTE.SNO=CITYBUSSTOP.SNOREF and CITYBUSROUTE.CITYID=(select cityid from city where cityname=?) order by routeid";
	 public static final String _VIEW_BUS_SCHEDULE_INFO="select startingfrom,destination,startingtime,reachedtime,serviceno,depot,tripno,routeid from CITYBUSINFORMATION,CITYBUSROUTE where CITYBUSINFORMATION.SNOREF=CITYBUSROUTE.sno order by snoref";
	 public static final String _VIEW_BUS_ROUTE_BY_CITY="select * from CITYBUSROUTE WHERE CITYBUSROUTE.CITYID=(SELECT CITYID FROM CITY WHERE CITYNAME=?) order by routeid";
	 public static final String _VIEW_TRAIN_SCHEDULE_BY_CITY="select * from MMTSSCHEDULE where routeid in(select routeid from mmtsstation where city=?)";
	 public static final String _VIEW_TRAIN_ROUTE_BY_CITY="select * from mmtsstation where city=? order by routeid";
	 public static final String _UPDATE_PROFILE="update logindata set password=?,name=?,email=?,phone=?,OCCUPATION=? where loginid=?";
	 public static final String _ADD_TRAIN_ROUTE="INSERT INTO MMTSSTATION VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	 public static final String _ADD_TRAIN_SCHEDULE="INSERT INTO MMTSSCHEDULE VALUES((select nvl(max(TRIPID),1000)+1 from MMTSSCHEDULE),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	 public static final String _UPDATE_TRAIN_SCHEDULE="UPDATE MMTSSCHEDULE SET timesource=?,times1=?,time2=?,time3=?,time4=?,time5=?,time6=?,time7=?,time8=?,time9=?,time10=?,timedest=?,tripno=? where tripno=? and routeid=?";
	 public static final String _DELETE_TRAIN_SCHEDULE="DELETE MMTSSCHEDULE WHERE routeid=? and tripno=?";
}
