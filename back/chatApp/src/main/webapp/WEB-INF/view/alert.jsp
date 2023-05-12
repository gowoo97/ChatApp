<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>alert</title>
</head>
<body>
	<script>
		alert(`${ msg }`);
		location.href=`${ url }`;
	</script>
</body>
</html>