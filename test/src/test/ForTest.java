package test;

import java.util.Scanner;

public class ForTest {

	public static void main(String[] args) {
		
//		String[] name = {"재홍", "경원", "홍길동"};
//		
//		for(int i=0; i<name.length; i++) {
//			System.out.println(name[i]); //name[0] -> 첫번째 문자열인 "재홍"을 보여줄것임
//		}
		
//  총 5명의 학생이 시험을 보았는데 시험점수가 60점이 넘으면 합격이고 그렇지 않으면 불합격이다. 합격인지 불합격인지에 대한 결과를 보여준다.”
		
//		int[] test = {90,25,67,45,80};
//		
//		for(int i=0; i<test.length; i++) {
//			
//			if(test[i] >=60) {
//				System.out.printf("%d번째 학생은 합격입니다\n",i+1);
//			}
//			else {
//				System.out.printf("%d번째 학생은 불합격입니다\n",i+1);
//			}
//		}
//		
		
		
		
		int[] test = {90,25,67,45,80};
		
		for(int i=0; i<test.length; i++) {
			if(test[i] >= 60) {
				System.out.printf("%d번째 학생은 합격입니다\n",i+1);
			}
			else {
				System.out.printf("%d번째 학생은 불합격입니다\n",i+1);
			}
				
		}
		
	}

}
