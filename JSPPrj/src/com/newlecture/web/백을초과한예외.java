package com.newlecture.web;

public class 백을초과한예외 extends RuntimeException { //Exception, RuntimeException 상황에따라 선택(찾아보기)

	public String getMessage() {
		return "add 메소드의 첫 번째 입력 값은 100을 넘을 수 없습니다."; //예외처리에서 보여질 메시지를 정할수도 있다.

	}

}
