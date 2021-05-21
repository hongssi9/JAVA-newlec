package com.newlecture.web;

public class Calculator {

	public static int add(int x, int y) throws 백을초과한예외, 음수를입력한예외 { //예외처리를 던졌다. exceptionProgram으로
		
		if(x > 100) //업무적으로 정해준다. ex 너 100값보다 많이 썼다.
			throw new 백을초과한예외();
			
		if(y < 0)
			throw new 음수를입력한예외();
		
		int result = x + y;
		return result;
	}

	public static int sub(int x, int y) throws 음수를입력한예외 {
		
		if(y < 0)
			throw new 음수를입력한예외();
		
		int result = x - y;
		return result;
	}

	public static int multi(int x, int y) {
		int result = x * y;
		return result;
	}

}
