package ex2.control;

import java.util.Scanner;

public class IfProgram {

	public static void main(String[] args) {
		//1. 사용자로부터 정수 값을 입력 받아서 변수 x에 저장한다.
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("정수를 입력하시오",sc);
		int x = sc.nextInt();
		
		
		//1-1 만약 그 값이 3보다 크면 "큰 값" 이라는 문자열을 출력한다.
	    if( x % 2 == 0) {
	    	System.out.print("짝수");
	    System.out.println(" 값");
	    }
	    if ( x % 2 == 1) {
	    System.out.print("홀수");
	    System.out.println(" 값");
	    }
	    System.out.println("프로그램 끝!");
	    
		
		
	}

}
