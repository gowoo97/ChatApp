<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"  href="resources/css/home.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<section id="nav">
			<div id="profile">
				
			</div>
			<div id="menu">
				<div class="menus">
					HOME
				</div>
				<div class="menus">
					MY PAGE
				</div>
			</div>
			<div class="buttons">
				
				<c:choose>
					<c:when test="${ userId == null }">
						<button onclick="location.href='/signIn';">로그인</button>
					</c:when>
					<c:otherwise>
						<button onclick="location.href='/logout.do'">로그아웃</button>
					</c:otherwise>
				</c:choose>
				<button onclick="location.href='/signUp'">회원가입</button>
					
				
			</div>
		</section>
		<section id="content"> 
			<div id="textArea">
			dsfsdfsd
			</div>
			<div id="typeArea">
				<input type="text" />
				<input type="button"  value="전송"/>
			</div>
		</section>
	</div>
</body>

</html>