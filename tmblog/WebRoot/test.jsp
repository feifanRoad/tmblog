<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/common/taglib.jsp"%>
<%@taglib prefix="tm" uri="/WEB-INF/tld/tm.tld"%>
<tm:permissions/>
<!doctype html>
<html>
 <head>
  <title> New Document </title>
  <meta charset="UFT-8">
  <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
 </head>
 <body>
	
	<c:forEach items="${permissionList[0]}" var="pl">
		${pl}
	</c:forEach>
	
	
 </body>
</html>
