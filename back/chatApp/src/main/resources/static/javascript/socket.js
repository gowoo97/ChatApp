var socket = new SockJS('/chat');
var stompClient = Stomp.over(socket);
const url = window.location.href;
const vals=url.split("/");
console.log(vals[vals.length-1]);
function connect(){
	stompClient.connect({} , function (frame) {
		
		console.log('Connected: '+ frame);
		stompClient.subscribe('/room/'+vals[vals.length-1],function(message){
			console.log(message);
			var textArea=document.getElementById('textArea');
			var jsonMessage=JSON.parse(message.body);
			var element="";
			element+="<div> <div class='messageSender'>";
			element+=jsonMessage.sender.id;
			element+="</div> <div class='messageContent'>";
			element+=jsonMessage.text;
			element+="</div> </div>";
			
			textArea.innerHTML+=element;
			
		
		});
	});
}

connect();


function send(){
	var message=document.getElementById('text').value;
	stompClient.send("/pub/send/"+vals[vals.length-1],{},JSON.stringify({'sender':userId ,'text':message,'roomNo':vals[vals.length-1]}));
	document.getElementById('text').value='';
}

