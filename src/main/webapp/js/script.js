function changeStatus(id, event){
	var oReq = new XMLHttpRequest();
	var type = event.parentNode.parentNode.getAttribute("id");
	oReq.addEventListener("load", function(){
		if(this.responseText === "success"){
			var insert = event.parentNode;
			if(type == "TODO"){
				type = "DOING";	
			}else{	
				type = "DONE";
				insert.removeChild(event);
			}
			var list = document.querySelector("div[id=" + type + "]");
			list.appendChild(insert);
		}
	});
	oReq.open("GET", "./TodoTypeServlet?id="+id+"&type="+type);
	oReq.send();
}