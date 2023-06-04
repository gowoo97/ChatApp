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
			const jsonMessage=JSON.parse(message.body);
			textArea.innerHTML+="<div><div class='messageSender'>";
			textArea.innerHTML+=jsonMessage.sender;
			textArea.innerHTML+="</div><div class='messageContent'>";
			textArea.innerHTML+=jsonMessage.text;
			textArea.innerHTML+="</div></div>";
			
			const messageContent=document.getElementsByClassName("messageContent");
			messageContent[messageContent.length-1].style.backgroundColor='#87CEFA';
		});
	});
}

connect();


function send(){
	var message=document.getElementById('text').value;
	stompClient.send("/pub/send/"+vals[vals.length-1],{},JSON.stringify({'sender':userId ,'text':message,'roomNo':vals[vals.length-1]}));
	document.getElementById('text').value='';
}

