var socket = new SockJS('/chat');
var stompClient = Stomp.over(socket);
const url = window.location.href;
const vals=url.split("/");
console.log(vals[vals.length-1]);
function connect(){
	stompClient.connect({} , function (frame) {
		
		console.log('Connected: '+ frame);
		stompClient.subscribe('/room/'+vals[vals.length-1],function(message){
			const textArea=document.getElementById('textArea');
			textArea.innerHTML+="<div><div class='message'>"+message.body+"</div></div>";
		});
	});
}

connect();


function send(){
	var message='<span style="color:blue;">'+userId+'</span>'+":";
	message+=document.getElementById('text').value;
	stompClient.send("/pub/send/"+vals[vals.length-1],{},message);
	document.getElementById('text').value='';
}

