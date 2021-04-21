package ex8.추상화.재사용;

import java.util.Scanner;

public class YBMExamConsole extends ExamConsole{

	@Override
	protected void onPrint() {
		YBMExam exam = (YBMExam)getExam();
		System.out.printf("aa:%d\n",exam.getAa());
		System.out.printf("toeic:%d\n",exam.getToeic());
	}
	
	@Override
	public void input() {
		// TODO Auto-generated method stub
		super.input();
		Scanner scan = new Scanner(System.in);

		int toeic;
		int aa;
		
		System.out.print("toeic:");
		toeic = Integer.parseInt(scan.nextLine());
		System.out.print("aa:");
		aa = Integer.parseInt(scan.nextLine());
		
		YBMExam exam = (YBMExam)getExam();
		exam.setToeic(toeic);
		exam.setAa(aa);
		
	}
	
}
