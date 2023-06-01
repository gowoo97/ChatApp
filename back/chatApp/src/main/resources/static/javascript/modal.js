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