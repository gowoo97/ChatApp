<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"  href="${path}/resources/css/home.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script> 
<script src="${path}/resources/javascript/ajax.js"></script>
<script src="${path}/resources/javascript/modal.js"></script>
<script src="${path}/resources/javascript/socket.js"></script>
</head>
<body>

	<div class="container">
		<section id="nav">
			
			<c:choose>
				<c:when test="${ userId != null }">
				<div id="status">
					<div id="profile">
				
					</div>
					<div id="user">
						${ userId }
					</div>
				</div>
				<hr/>
					
				<div class="rooms" style="overflow-y:scroll;">
				<c:if test="${ titles != null }" >
					<c:forEach var="item" items="${ titles }">
						<div>
							<a href="/room/${ item.seq }"> ${ item.title } </a> 
						</div>
					</c:forEach>
				</c:if>
					
				</div>
				</c:when>
			</c:choose>
			
			
			
			<div class="buttons">
				
				<c:choose>
					<c:when test="${ userId == null }">
						<button onclick="location.href='/signIn';">로그인</button>
						<button onclick="location.href='/signUp'">회원가입</button>
					</c:when>
					<c:otherwise>
						<button onclick="location.href='/logout.do'">로그아웃</button>
						<button onclick="location.href='/room/reg'">방 만들기</button>
						<button onclick="openModal();">친구 목록</button>
					</c:otherwise>
				</c:choose>
				
					
				
			</div>
		</section>
		<section id="content"> 
			<div id="textArea">
				
				<c:forEach items="${ messages }" var="item">
					<div>
						<div class="messageSender">
							${ item.sender }
						</div>
						<div class="messageContent">
							${ item.text }
						</div>
					</div>
				</c:forEach>
				
				
			</div>
			<div id="typeArea">
				<input type="text" id="text"/>
				<input type="button"  value="전송" id="sendBtt" onclick="send();" />
			</div>
		</section>
	</div>
	
	<div class="modal show">
		<div class="modal_content">
		<input type="text" id="modalInput" oninput="listChange();"/>
		<button>전송</button>
		<br/>
		<button onclick="toggle();">목록</button>
		<button onclick="getFriendReq();">친구요청</button>
		
		<div class="list">
			
		</div>
		<button onclick="closeModal();">창닫기</button>
		</div>
		
		
	</div>
	
</body>
<script>

var userId='${userId}';
var search=document.getElementById('modalInput');

</script>
</html>