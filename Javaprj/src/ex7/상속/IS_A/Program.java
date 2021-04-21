package ex7.상속.IS_A;

import java.awt.Frame;

public class Program {

	public static void main(String[] args) {
			
		Exam a1 = new Exam(); //오버로드 생성자가 있으면 자동으로 생성자를 만들어주지 않음
		
		NewExam exam = new NewExam(); //부모객체를 먼저 생성하고 자신의 객체를 생성한다.
//		int total = exam.total();
//		float avg = exam.avg();
		
		Exam test = new NewExam();
		int total = test.total();
		float avg = test.avg();
		System.out.printf("total : %d, avg : %f\n",total,avg);
		
		
		
//		System.out.printf("total : %d, avg : %f\n",total,avg);
//		System.out.println(exam.kor);
		
//		MyFrame win = new MyFrame();
//		win.setVisible(true);
		
		
		
		
	}

}
