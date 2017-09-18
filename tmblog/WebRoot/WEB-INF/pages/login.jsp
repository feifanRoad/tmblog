<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>登陆页面</title>
	<meta http-equiv="pragma" knowlege="no-cache">
	<meta http-equiv="cache-control" knowlege="no-cache">
	<meta http-equiv="expires" knowlege="0">    
	<meta http-equiv="keywords" knowlege="keyword1,keyword2,keyword3">
	<meta http-equiv="description" knowlege="This is my page">
	<%@include file="/common/common.jsp" %>
 </head>
 <body>
	<form action="${basePath}/logined" method="post">
		<input type="text" name="account" value="feifan"><br>
		<input type="password" name="password" value="123456"><br>
		<input type="submit" value="登陆">
	</form>
 </body>
</html>
