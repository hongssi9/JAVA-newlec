package com.newlecture.web;

public class ExceptionProgram {

	public static void main(String[] args) { // 여기서도 예외를 처리하지 않겠다면 똑같이 던지면 된다.

		int result = 0;

		try {// 예외가 발생하면 실행되지 않고 건너뛰는 공간
			result = Calculator.add(30, 40); // 여기서 해결할 권한이 없으니 메시지는 예외처리 클래스에서 만든다.
			System.out.printf("add result : %d\n", result); // try문 밖에두면 rsult값이 0으로 나옴-> 예외처리시키고 보이지 않게 하고싶다 -> try문에
															// 넣어준다
			result = Calculator.sub(300, -2);
			System.out.printf("sub result : %d\n", result); // 이미 같은 예외처리를 쓰고 있어서 중복으로 사용할 수 있음.

		} catch (백을초과한예외 e) {
			System.out.println("죄송합니다. 예기치 않은 오류가 발생하였습니다");
			System.out.println("첫 번째 인자에 100을 넘는 일이 발생하였습니다.");

		} catch (Exception e) { // 모든 문구를 하나로 묶어서 예외처리한다.
			System.out.println("죄송합니다. 예기치 않은 오류가 발생하였습니다");
		}

//		} catch (백을초과한예외 e) {
//			
//			System.out.println("죄송합니다. 예기치 않은 오류가 발생하였습니다");
//			System.out.println("첫 번째 인자에 100을 넘는 일이 발생하였습니다.");
//			
//		} catch (음수를입력한예외 e) {
//			System.out.println("죄송합니다. 예기치 않은 오류가 발생하였습니다.");
//			System.out.println("두 번째 인자에 음수를 입력하는 일이 발생하였습니다.");
//		}

		System.out.println("Bye~~");

	}

}
