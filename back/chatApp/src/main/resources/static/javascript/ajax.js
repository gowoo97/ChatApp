var httpRequest=new XMLHttpRequest();

	//친구요청 보내기
	var sendFriendReq=(id) => {
		var url="/friendShip/"+userId+"/"+id.value;
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
		var url="/friendShip/receiver/"+userId;
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
		var url="/friendShip/"+id.value+"/"+userId;
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
		var url="/friendShip/"+id.value+"/"+userId;
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