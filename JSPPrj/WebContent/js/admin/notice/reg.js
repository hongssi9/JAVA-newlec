/**
 * 
 */
window.addEventListener("load", function(){
	let section = document.querySelector("#dnd-box");
	let uploadBox = section.querySelector(".upload-box");
	
	uploadBox.ondragenter = function(){
		console.log("enter");
	};
	
	uploadBox.ondragleave = function(){
		console.log("leave");
		uploadBox.classList.remove("valid");
		uploadBox.classList.remove("invalid");
	};
	
	uploadBox.ondragover = function(e){
		e.preventDefault();
		let dt = e.dataTransfer;
		
		var valid = e.dataTransfer.types.indexOf("Files") >= 0;
		
		if(valid){
			uploadBox.classList.add("valid");
		}
		else{
			uploadBox.classList.add("invalid");
		}
		
		console.log(dt.files.length);
		
		console.log("over");
	};
	
	uploadBox.ondrop = function(e){
		e.preventDefault();
		
		uploadBox.classList.remove("valid");
		uploadBox.classList.remove("invalid");
		
		let dt = e.dataTransfer;
		if(dt.files.length >1){
			alert("파일은 하나씩만 전송이 가능합니다.");
			return;
		}
		
		if(dt.files[0].size > 500*1024*1024){
			alert("죄송합니다. 파일 크기가 50MByte를 넘는 파일은 전송할 수 없습니다.");
			return;
		}
		
		let formData = new FormData();
		formData.append("title", "hello");
		formData.append("f",dt.files[0]);
		
		let request = new XMLHttpRequest();
		request.onload = function(){
			console.log("완료");
		};
		request.upload.onprogress = function(){
			console.log(`total:${e.total}, loaded:${e.loaded}`);
		}
		
		request.open("POST", "/admin/uploader",true);
		request.send(formData);
		
		console.log(dt.files.length);
		console.log("drop");
	}
	
});