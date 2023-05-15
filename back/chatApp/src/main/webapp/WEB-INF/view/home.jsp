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
			
			
			<div class="buttons">
				
				<c:choose>
					<c:when test="${ userId == null }">
						<button onclick="location.href='/signIn';">로그인</button>
						<button onclick="location.href='/signUp'">회원가입</button>
					</c:when>
					<c:otherwise>
						<button onclick="location.href='/logout.do'">로그아웃</button>
						<button>친구 목록</button>
					</c:otherwise>
				</c:choose>
				
					
				
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
	
	<div class="modal show">
		<div class="modal_content">
		<input type="text" id="modalInput" oninput="listChange();"/>
		<button>전송</button>
		<br/>
		<button>목록</button>
		<button>친구요청</button>
		
		<div class="list">
			
		</div>
		<button onclick="closeModal();">창닫기</button>
		</div>
		
		
	</div>
	
</body>
<script>
	var closeModal=function(){
		var modal=document.getElementsByClassName("modal");
		modal[0].style.zIndex=-1;
	}
	
	var listChange=function(){
		var list=document.getElementsByClassName("list");
		var search=document.getElementById("modalInput");
		
		console.log(search.value);

	}
</script>
</html>