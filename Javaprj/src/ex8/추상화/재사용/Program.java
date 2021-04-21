package ex8.추상화.재사용;

import java.awt.Frame;

public class Program {

	public static void main(String[] args) {
			
		Exam exam = new YBMExam(2,2,2,2,2);
		
		YBMExamConsole ybmConsole = new YBMExamConsole();
		ybmConsole.setExam(exam); //Setter는 Main 함수에서 인스턴스 필드에 접근해서 사용하는 함수입니다. 매개변수로 멤버 변수를 초기화합니다.
		
		ybmConsole.input();
		ybmConsole.print();
		
		//도형
		//네모, 세모, 원, 선
		
		//성적
		//뉴렉고등학교, YBN고등학교,..
		
		//추상화로 만들어진 클래스의 특징
		//1. 추상 클래스는 뼈대이므로 절대로 실체화 되어서는 안됨.
		//2. 추상 클래스느 뼈대이므로 절대로 사용해서는 안되는 메소드를 가질 수 있다.
		//3. 추상 클래스는 뼈대이므로 반드시 재정의해야 하는 메소드가 있다
		
//		Exam exam = new Exam(10,20,30); //추상클래스는 실체화 할 수 없어서 오류가 뜸
		
//		Exam exam = new YBMExam();
//		System.out.println(exam.total());
		
//		Exam[] exams = new Exam[2];
//		
//		exams[0] = new YBMExam(1,1,1,1,1);
//		exams[1] = new NewExam(1,2,3,4);
//		
//		for(int i=0; i<2; i++)
//			System.out.println(exams[i].avg());
		
		
		
		
		
	}

}
