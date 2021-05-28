window.addEventListener("load", function() {
	let section = document.querySelector("#dnd-box");
	let uploadBox = section.querySelector(".upload-box");
	let progressStatusDiv = document.querySelector(".progress-status");
	const fileInput = document.querySelectorAll(".form input[type='file']")[0];

	fileInput.oninput = function(e) {
		let file = fileInput.files[0];
		if (file.type.indexOf("image/") < 0)
			alert("이미지 형식만 사용할 수 있습니다.")

		var reader = new FileReader(); //리더기 선택한 파일을 읽어오게하기
		reader.onload = function(evt) { //읽어온다음 처리하기
			let img = document.createElement("img");
			img.src = evt.target.result;

			fileInput.insertAdjacentElement("afterend", img);
		};
		reader.readAsDataURL(file);

	}

	uploadBox.ondragenter = function() {
		console.log("enter");
	};

	uploadBox.ondragleave = function() {
		console.log("leave");
		uploadBox.classList.remove("valid");
		uploadBox.classList.remove("invalid");
	};

	uploadBox.ondragover = function(e) {
		e.preventDefault();
		let dt = e.dataTransfer;

		var valid = e.dataTransfer.types.indexOf("Files") >= 0;

		if (valid) {
			uploadBox.classList.add("valid");
		}
		else {
			uploadBox.classList.add("invalid");
		}

		console.log(dt.files.length);

		console.log("over");
	};

	uploadBox.ondrop = function(e) {
		e.preventDefault();

		uploadBox.classList.remove("valid");
		uploadBox.classList.remove("invalid");

		let dt = e.dataTransfer;
		if (dt.files.length > 1) {
			alert("파일은 하나씩만 전송이 가능합니다.");
			return;
		}

		if (dt.files[0].size > 500 * 1024 * 1024) {
			alert("죄송합니다. 파일 크기가 50MByte를 넘는 파일은 전송할 수 없습니다.");
			return;
		}

		let formData = new FormData();
		formData.append("p", "/upload/test");
		formData.append("f", dt.files[0]);

		let request = new XMLHttpRequest();
		request.onload = function() {
			console.log(request.responseText);
			let filepath = request.responseText;

			/*	let li = `<li>
							<a download href="${filepath}">
								${filepath}
							</a>
						   </li>`;*/

			let li = `<li><img src="${filepath}"></li>`;
			let ul = progressStatusDiv.lastElementChild;
			ul.insertAdjacentHTML("beforeend", li);
		};
		request.upload.onprogress = function(e) {
			console.log(`total:${e.total}, loaded:${e.loaded}`);
			let status = Math.round(e.loaded * 100 / e.total) + '%';

			let bar = progressStatusDiv.firstElementChild.firstElementChild;

			bar.innerText = status;
			bar.style.width = status;

			/*let a = progressStatusDiv.firstElementChild;
			a.firstElementChild.innerText = status;*/
		}

		request.open("POST", "/admin/uploader", true);
		request.send(formData);

		console.log(dt.files.length);
		console.log("drop");
	}

});