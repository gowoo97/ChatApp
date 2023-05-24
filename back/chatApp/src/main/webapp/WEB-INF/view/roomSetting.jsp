<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="../resources/css/roomReg.css" rel="stylesheet"  />
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div id="container">
	
	<form  method="POST" action="/room/reg">
	<div id="content">
		<h1>방 만들기</h1>
		
		<label>
			title
		</label>
			<input type="text" name="title"/>
		
		<br/>
			
			<div id="friedns">
				
				<c:forEach var="item" items="${ friends }">
					<div>
						<span>${ item }</span>
						<input type="checkbox" value="${ item }" name="participant" />
					</div>
				</c:forEach>
			
			</div>
		
		<br/>
		
		
			<input type="submit" value="제출"/>
		
		
	</div>
	</form>
	</div>
	
</body>
</html>