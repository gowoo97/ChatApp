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
			
			<c:choose>
				<c:when test="${ userId != null }">
					<div id="profile">
				
					</div>
				<h5 style="text-align:center; margin:0;">${ userId }</h5>
					
				<div class="rooms" style="overflow-y:scroll;">
				
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
		<button onclick="toggle();">목록</button>
		<button onclick="getFriendReq();">친구요청</button>
		
		<div class="list">
			
		</div>
		<button onclick="closeModal();">창닫기</button>
		</div>
		
		
	</div>
	
</body>
<script>
var httpRequest=new XMLHttpRequest();
var list=document.getElementsByClassName("list");
var search=document.getElementById("modalInput");
	var reqList=false;

	var toggle=()=> {
		list[0].innerHTML="";
			reqList=false;
		
	}
	
	var closeModal=function(){
		var modal=document.getElementsByClassName("modal");
		modal[0].style.zIndex=-1;
		list[0].innerHTML="";
	}
	
	var openModal=function(){
		var modal=document.getElementsByClassName("modal");
		modal[0].style.zIndex=1000;
		list[0].innerHTML="";
	}
	
	
	
	//친구요청 보내기
	var sendFriendReq=(id) => {
		var url="/friendShip/${ userId }/"+id.value;
		httpRequest.open("POST",url);
		httpRequest.onload = () => {
			if (httpRequest.readyState === httpRequest.DONE) {
  	  if (httpRequest.status === 200) {
		
		console.log("친구요청 보냄");
  	  }
  	}
	}
httpRequest.send();	
	};



	//리스트 목록 불러오기
	var listChange=function(){
		
		//현재 토글이 요청목록(true) 이라면
		if(reqList==true){
			return;
		}
		
		if(search.value ==  ""){
			list[0].innerHTML="";
			return;
		}
		var url="/member/"+search.value;
		httpRequest.open("GET",url);
		httpRequest.onload = () => {
 	 if (httpRequest.readyState === httpRequest.DONE) {
  	  if (httpRequest.status === 200) {
		var rst=JSON.parse(httpRequest.responseText);
		list[0].innerHTML="";
		
		for(var i=0;i<rst.members.length;i++){
			rst.members[i].memberId
			list[0].innerHTML+="<div><span>"+rst.members[i].memberId+"</span>"+"<button value='"+ rst.members[i].memberId +"' onclick='sendFriendReq(this);'>친구요청</button>";
		}
      
    }
  }
};
		httpRequest.send();
	
}
	
	//친구요청 받기
	var getFriendReq=() => {
		
		reqList=true;
		
		//리스트 초기화
		list[0].innerHTML="";
		var content="";
		var url="/friendShip/receiver/"+`${ userId }`;
		httpRequest.open("GET",url);
		httpRequest.onload= ()=>{
			if (httpRequest.readyState === httpRequest.DONE) {
			  	  if (httpRequest.status === 200) {
					var rst=JSON.parse(httpRequest.responseText);

					for(var i=0;i<rst.friendShip.length;i++){
						if(rst.friendShip[i].accept == true){
							continue;
						}
						content+="<div>";
						content+=rst.friendShip[i].sender;
						content+="<button value="+rst.friendShip[i].sender+" onclick='acceptFriendReq(this);'>수락</button>";
						content+="<button value="+rst.friendShip[i].sender+" onclick='deleteFriendReq(this)'>거절</button>";
						content+="</div>";
						
					}
					
					list[0].innerHTML=content;
			      
			    }
			  }
		}
		
		httpRequest.send();
	}
	
	//친구 수락
	var acceptFriendReq=(id)=>{
		var url="/friendShip/"+id.value+"/"+`${ userId }`;
		httpRequest.open("PUT",url);
		httpRequest.onload= ()=>{
			if (httpRequest.readyState === httpRequest.DONE) {
			  	  if (httpRequest.status === 200) {
					id.parentNode.remove();
			      
			    }
			  }
		}
		httpRequest.send();
		
	}
	
	//친구 거절
	var deleteFriendReq=(id)=>{
		var url="/friendShip/"+id.value+"/"+`${ userId }`;
		httpRequest.open("DELETE",url);
		httpRequest.onload= ()=>{
			if (httpRequest.readyState === httpRequest.DONE) {
			  	  if (httpRequest.status === 200) {
					id.parentNode.remove();
			      
			    }
			  }
		}
		httpRequest.send();
	}
	
</script>
</html>