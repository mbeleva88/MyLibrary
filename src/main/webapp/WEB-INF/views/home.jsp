<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Library</title>
</head>
<body style="background-color:#F0E68C">
	<h1><b>Welcome To My Library!</b></h1>
	<P>
		<a href="<c:url value='/authors/' />">Show All Authors</a>
	</P>
</body>
</html>
