window.addEventListener("load", function(){
    var section = document.querySelector("#ex12");
    var tbody = section.querySelector("tbody");
    var requestButton = section.querySelector(".btn-request");
    var pager = section.querySelector(".pager");
 	var submitButton = section.querySelector(".search-form input[type=submit]");
	var fieldInput = section.querySelector(".search-form select");
	var queryInput = section.querySelector(".search-form input[name=q]");
	var pageElement = pager.querySelector("a");

	submitButton.onclick = function(e){
		e.preventDefault();
		console.log("test");
		
		var field = fieldInput.value;
		var query = queryInput.value;
		
		bind(`../api/notice/list?f=${field}&q=${query}`);
	};
   
   function bind(url){
      var request = new XMLHttpRequest();      
      request.onload = function(){
	
		tbody.innerHTML = ""; //tbody에 있는 텍스트가 전부 지워진다. 새로운 목록으로tbody가 채워짐
         var list = JSON.parse(request.responseText);//새로운 목록으로 tbody를 채우는 코드         
		         
        /* var trEmpty = tbody.querySelector(".empty");
         if(list.length > 0 && trEmpty != null)
            trEmpty.remove();*/
         
         for(var i=0; i<list.length; i++){
            var tr = `<tr>
                          <td>`+list[i].id+`</td>
                         <td>${list[i].title}</td>
                       </tr>`;
         
            tbody.insertAdjacentHTML("beforeend", tr);
         }
		//2. 창과 아이콘을 제거한다.
		screen.remove();	
      };

	request.onabort = function(){
		console.log("aborted");
		screen.remove();
	}
	
        request.open("GET", url, true);
        request.send(null);

		//1. 창과 아이콘을 띄운다.
	var screen = document.createElement("div");
    
    screen.style.width = "100%";
    screen.style.height = "100%";
    screen.style.backgroundColor = "black";
    screen.style.position = "fixed";
    screen.style.top = "0px";
    screen.style.left = "0px"
    screen.style.opacity = 0;
    screen.style.transition = ".5s";

	screen.style.display = "flex";
	screen.style.alignItems = "center";
	screen.style.justifyContent = "center";
	
	var img = document.createElement("img");
	img.src = "../images/ajax-loader.gif";
	screen.append(img);
	
	var closeButton = document.createElement("input");
	closeButton.value="취소";
	closeButton.type="button";
	closeButton.style.alignSelf = "flex-start";
	closeButton.style.position="absolute";
	closeButton.style.right = "0px";
	screen.append(closeButton);
	
	closeButton.onclick = function(){
		request.abort();
	}

    setTimeout(function () {
        screen.style.opacity = 0.7;
    }, 0);

    section.append(screen);
   }

   pager.onclick = function(e){
      e.preventDefault();
      
      if(e.target.tagName != "A")
         return;
      
     var page = e.target.innerText;
      
      // "http://localhost:8080/api/notice/list?p=2"
      // "http://localhost:8080/js/ex1.html"
      bind(`../api/notice/list?p=${page}`); //클릭한 페이지 정보를 보낸다.
	  console.log(`../api/notice/list?p=${page}`); 

/*103~106 5개를 모두찾아 누르기 이전꺼를 지우는 방법 - 비효율적
	var as = pager.querySelectorAll("a");
	for(var i=0; i<as.length;i++)
		as[i].classList.remove("text-strong");
	e.target.classList.add("text-strong"); //누르는거에 text-strong스타일주기 */  
	
		
/*2번째 방법 110~113 */
	pageElement.classList.remove("text-strong");
	e.target.classList.add("text-strong");
	pageElement = e.target; //pageElement=a태그
		

   };

    //requestButton.onclick = function(e){
        bind("http://localhost:8080/api/notice/list");
    //}
    
});




// -----------------------------------------------------------------
window.addEventListener("load", function() {
	var section = document.querySelector("#ex11");

	var uploadBox = section.querySelector(".upload-box");
	var selButton = section.querySelector(".btn-sel");
	var fileButton = section.querySelector(".btn-file");

	uploadBox.ondragenter = function(e) {
		console.log("enter");
		e.preventDefault();
	}

	uploadBox.ondragover = function(e) { //드래그하면 계속 올라감
		// console.log("over");
		e.preventDefault();

		var valid = e.dataTransfer.types.indexOf("Files") >= 0; //indexOf:
		console.log(valid);

		if (!valid) //파일형식일때만 초록 아니면 빨강
			uploadBox.style.backgroundColor = "red";
		else
			uploadBox.style.backgroundColor = "green";

	}


	uploadBox.ondragleave = function(e) {
		uploadBox.style.backgroundColor = "white";
		console.log("leave");
		e.preventDefault();
	}

	uploadBox.ondrop = function(e) {
		uploadBox.style.backgroundColor = "white";
		e.preventDefault();
		console.log("drop");
		// e.files[0];

		console.log(e.dataTransfer.files[0].size); //파일용량이 무엇인지 확인하기...ondrop에서!

		for (var attr in e.dataTransfer.files[0]) //뭐가들었는지 확인해보기~
			console.log(attr);                    //for in문을 쓰면 파일 속성명을 확인할 수 있다

		console.log(e.dataTransfer.files[0].name); //파일명이 뭔지 확인하기~



		fileButton.oninput = function(e) { //input방식이 빠르다?
			// for(var k in fileButton.files[0])
			//     console.log(k); //이벤트 관련된 속성 확인하기
			// console.log("file button inp...");

			console.log(fileButton.files[0]); //결론 파일 정보를 전송하는 방법(통째로!!)
		};

		// for (var k in [10, 2, 30]) //for in문 예제
		//     console.log(k);
	}



	selButton.onclick = function(e) {
		var event = new MouseEvent("click", { //바꿔치기~
			'view': window,
			'bubbles': true,
			'cancelable': true
		});


		fileButton.dispatchEvent(event);
	}
});




window.addEventListener("load", function() {
	var section = document.querySelector("#ex10");

	var product = section.querySelector(".product");

	product.onclick = function(e) { //target과 item차이
		var target = e.target;
		if (!target.classList.contains("up") &&
			!target.classList.contains("down") &&
			!target.classList.contains("current"))
			return;

		if (target.classList.contains("up")) {
			var input = target.parentNode.querySelector("input");
			input.value = parseInt(input.value) + 1;
		}
		else if (target.classList.contains("down")) {
			var input = target.parentElement.querySelector("input");
			input.value = parseInt(input.value) - 1;
		}
		else if (target.classList.contains("current")) {
			// item.parentElement.style.border="2px dotted #000";
			target.parentElement.classList.toggle
		}
	}
});





window.addEventListener("load", function() {
	var section = document.querySelector("#ex9");

	var accordion = section.querySelector(".accordion");

	var selected = null;
	accordion.onclick = function(e) {
		console.log("test");
		//1. title이 아니면 return
		if (!e.target.classList.contains("title"))
			return;

		//2. target 의 동생의 d-none을 빼자
		e.target.nextElementSibling.classList.toggle("d-none"); //nextsibling:
		//toggle방식 숙지


	}
});




window.addEventListener("load", function() {
	var section = document.querySelector("#ex8");

	var container = section.querySelector(".container");


	var add = section.querySelector(".btn-add");
	var del = section.querySelector(".btn-del");
	var clone = section.querySelector(".btn-clone");
	var change = section.querySelector(".btn-change");

	var selected = null;

	container.onclick = function(e) {  //버블링 공부하기 //이벤트객체 정보를 e란 함수에다 넣어준다.
		//박스가 선택되지 않았다면 실행을 끝내주는 조건문
		if (!e.target.classList.contains("box"))
			return;

		// console.log(e.target);  //target 클릭되는놈을 알 수 있다.
		// selected = e.target;

		if (selected != null && selected != e.target)
			selected.classList.remove("selected");

		//선택된 박스 -> toggle하면 눌렀다 취소했다 할 수 있다.
		selected = e.target;
		selected.classList.toggle("selected"); //클래스 생성

		console.log(e.target)

		// selected.style.border="2px solid red"; //복잡한 코드이다
	};

	// var boxes = container.querySelectorAll(".box");

	// boxes[0].onclick = function(){
	//     console.log("box");
	// }

	//Closure : 아웃터 영역의 자원이 해제될 수 있게 하는 키를 가지는 함수
	//     for(let i=0; i<boxes.length; i++){
	//     boxes[i].onclick = function(){ //로직이 똑같은것이 3개가 만들어짐
	//         selected = boxes[i];
	//         console.log(selected);
	//         console.log(i); //3에서 계속 멈춰있음

	//         //let -> 참조변수가 아닌 값 변수로 만들어준다.....
	//     }
	// }



	del.onclick = function() {
		console.log("test");
		if (selected != null)
			selected.remove();
	}

});





window.addEventListener("load", function() {
	var section = document.querySelector("#ex7");

	var container_ = section.querySelector(".container");

	var add = section.querySelector("input[value='추가']");
	var del = section.querySelector("input[value='삭제']");
	var clone = section.querySelector("input[value='복제']");
	var text_id = section.querySelector(".id-input");
	var text_color = section.querySelector(".color-input");
	var change = section.querySelector(".btn-change");

	// var boxes = document.querySelectorAll(".box");

	add.onclick = function() {
		console.log("추가");
		// 1. 엘리먼트 객체를 생성하기
		// var img = document.createElement("img");
		// var txt = document.createTextNode("1");
		var div = document.createElement("div"); //태그 네임을 지정해준다.


		// 2. 엘리먼트 객체의 속성 설정하기
		// img.src = "../images/1.jpg";
		div.style.background = text_color.value;  //색상 텍스트에 값으로 스타일을 지정해준다.
		div.style.width = "100px";
		div.style.height = "100px";
		div.style.borderRadius = "50px";
		div.style.textAlign = "center";
		div.style.color = "blue";
		div.style.lineHeight = "100px";

		// div.appendChild(txt);
		// div.append("1");
		// div.innerText = "1";
		div.append(text_id.value);   //div에다 text_id 값을 넣어준다.
		//이해하기 어렵지만 다시한번.... 엘리먼트 객체 div를 위에서 만들어 줬으니까 그 객체 안에다가 적을? 값이나 문자열을 넣을 수 있다.
		//그니까 div안에 들어갈 내용?을 정하는 거


		// 3.엘리먼트 객체를 문서에 추가하기
		// container_.appendChild(img); //부모 노드에 자식 노드를 추가한다..?
		// container_.appendChild(div);
		container_.append(div); //div class="container" 에다가 만든 div를 넣어주는거다!
		//div안에 들어갈 내용을 위에서 정했으면 그걸 장소에 넣어준다.

	};

	del.onclick = function() {
		console.log("삭제");
		var div = container_.querySelector("div:first-child");
		div.remove();
		// container_.removeChild(div);


	};

	clone.onclick = function() {
		console.log("복제");
		var div = container_.querySelector("div:first-child");
		var clone = div.cloneNode();
		container_.append(clone);
	};

	change.onclick = function() {
		console.log("바꾸기");
		var ex = container_.querySelectorAll("div");
		var e1 = ex[0];
		var e2 = ex[1];
		// var e1 = container_.querySelector("div:first-child");
		// var e2 = container_.querySelector("div:last-child");

		var old = container_.replaceChild(e1, e2);
		// container_.insertBefore(old, e1); 옛날방법
		e1.insertAdjacentElement('beforebegin', old);

	};

});



window.addEventListener("load", function() {
	var section = document.querySelector("#ex6");

	var container_ = section.querySelector(".container");
	var boxes = section.querySelectorAll(".box"); //All은 목록으로
	var button = section.querySelector("input[value='click']");
	var stop = section.querySelector("input[value='stop']");

	var tid;

	button.onclick = function() {
		var box = boxes[0]
		let boxStyle = window.getComputedStyle(box);

		//자동으로 "12px" -> "12" -> 12 로 변환시켜준다.

		var left = parseInt(boxStyle.getPropertyValue("left"));

		tid = window.setInterval(function() {
			if (left >= 400)
				clearInterval(tid);

			left++;
			box.style.left = left + "px";
		}, 17);

		// var tid = window.setInterval(function () {
		//     if (left <= 400) {
		//         boxes[0].style.left = left + "px";
		//         left++;
		//     }
		//     else{
		//         clearInterval(tid);
		//     }
		//     console.log(left);

		// }, 17);
	}

	stop.onclick = function() {
		clearInterval(tid);
	}
});

// window.addEventListener("load", function () {
//     var section = document.querySelector("#ex6");

//     var container_ = section.querySelector(".container");
//     var boxes = section.querySelectorAll(".box"); //All은 목록으로
//     var button = section.querySelector("input[value='click']");
//     var stop = section.querySelector("input[value='stop']");

//     var px_c = 0;
//     var move;

//     button.onclick = function () {

//         var test = "test";
//         move = window.setInterval(function () { //변수 대입??
//             px_c += 1;
//             if (px_c <= 400) {
//                 boxes[0].style.left = px_c + "px";
//                 console.log(test);
//             }
//         }, 10); //깃 오류
//     };

//     stop.onclick = function () {
//         console.log("stop");
//         clearInterval(move); //변수를 만들어서 넣어주는생각을 못함 앞으로 변수 함수 활용 연습 할것
//     }
// });


// addEventListener 여러개의 이벤트 핸들러를 등록할 수 있다.
window.addEventListener("load", function() {
	var section = document.querySelector("#ex5");

	var span_ = section.querySelector(".span");
	var btn = section.querySelector(".btn");

	btn.onclick = function() {

		window.setInterval(function() {  //setInterval 누르면 1초마다 계속 실행...
			var count = parseInt(span_.innerText); //1.증감식을 어디서 가져올지..
			count--; //2.1씩 --
			span_.innerText = count; //3. 증감식을 다시 뿌려줘야 감소가 된다.
			console.log("test");
		}, 1000);   //윈도우 기능중 시간을 설정할 수 있는...
	}
});







// -------3번째--------------chiledNodees를 이용한 노드 선택-------------------------
window.addEventListener("load", function() {
	var section4 = document.querySelector("#section4");
	var box = section4.querySelector(".box");
	// section4 는 document객체를 사용하여 id section4에 공간을 가져왔다
	// document로 이미 웹페이지 자체가 되었으니 section4변수에있는 공간에서 class.box값을 가져 올 수 있다.

	var input1 = box.children[0]; //box에 있는 자식 0번째를.. //자식을 찾을수 있는..             
	var input2 = box.children[1]; //childNodes 빈공백이 들어가면 그 빈 공간도 자식으로....
	//chtledren은 태그형태로 된것만 자식으로 본다.
	input1.value = "hello";
	input2.value = "okay";

});



//------------------------------선택------------------------------
//window.onload = function(){ //정해진 함수명?
window.addEventListener("load", function() {
	var section = document.getElementById("ex3");
	var x_ = document.querySelector("input[name='text-x']"); //다른 방법 input태그에 name이 text-x라는걸...
	var y_ = document.querySelector(".text-y");//All은 여러개를 찾을때
	var sum_ = document.querySelector(".text-sum");
	var btn_ = document.querySelector(".submit-btn");
	//Document : 웹페이지 그 자체 HTML접근하려면 document객체부터..

	btn_.onclick = function() {

		var x = parseInt(x_.value); //x 변수에 값을 정수형으로 변환하여 넣어준다
		var y = parseInt(y_.value);

		//sum_.innerText = x+y; //텍스트를 바꿀때는 innerText
		sum_.value = x + y;

	};
});




// ---------------------------------------------------------------
// window.onload = function(){ //정해진 함수?
//    var section = document.getElementById("ex2");
//    var x_ = section.getElementsByClassName("text-x")[0];
//    var y_ = section.getElementsByClassName("text-y")[0];
//    var sum_ = section.getElementsByClassName("text-sum")[0];
//    var btn_ = section.getElementsByClassName("submit-btn")[0];


//   btn_.onclick = function(){

//        var x = parseInt(x_.value); //x 변수에 값을 정수형으로 변환하여 넣어준다
//        var y = parseInt(y_.value);

//        //sum_.innerText = x+y; //텍스트를 바꿀때는 innerText
//        sum_.value = x+y;

//     };
// };

// ------------------------------------내가한거-------------------------------
window.addEventListener("load", function() {
	var section = document.querySelector("#ex2");
	var x_ = section.querySelector(".text-x");
	var y_ = section.querySelector(".text-y");
	var btn = section.querySelector(".submit-btn");
	var sum_ = section.querySelector(".text-sum");

	btn.onclick = function() {
		var x = parseInt(x_.value);
		var y = parseInt(y_.value);
		sum_.value = x + y;
	};
});



// window.onload = function () { //로드되었을때...

//     var section = document.getElementById("ex1"); //ID로 찾겠다
//     var btn = section.getElementsByClassName("btn")[0]; //클래스명으로 찾겠다 //document와 section구별...->어느 지역에서 찾을건지...


//     btn.onclick = function () {
//         console.log("test");
//     }
// };


//질문1 getElementById("ex2"); ex2로 해도 ex3섹션이 실행된다.  해결-> ex2를 지정한 section변수를 활용하지않아서 그럼 document로 전체를 불러오니 
//질문2 이미 document로 가져온 섹션으로 selec하면 다른이유