package ex9.인터페이스;

import java.awt.Frame;

public class Program {
	
	//인터페이스란? : 두 사물 또는 세계가 간접적으로 만들 수 있게 해주는 도구 또는 접점
	// 함수 인터페이스 : 
	//자바 인터페이스란? : 객체 간의 조립관계를 간접적으로 HAS A 상속을 하게 해주는 접점 또는 도구
	
	
	public static void main(String[] args) {
			
		Exam exam = new YBMExam(1,1,1,1,1);
		
		//3. 인터페이스를 구현하기
		
		YBMBanner ybmBanner = new YBMBanner(); //4. 구현체를 생성하기
			
		YBMExamConsole ybmConsole = new YBMExamConsole();
		ybmConsole.setExam(exam);
		ybmConsole.setBanner(ybmBanner); //4. 구현체를 꽂아주기
		
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
