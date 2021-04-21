package ex9.인터페이스.exam.ybm;

import java.util.Scanner;

import ex9.인터페이스.exam.Banner;
import ex9.인터페이스.exam.ExamConsole;

public class YBMExamConsole extends ExamConsole /*implements Banner*/ /*인터페이스는 다른 클래스에서 정의할 수있지만 문제가...발생*/{

	private int a = 5;
	
	public YBMExamConsole() {
	XXX x = new XXX();
	setBanner(x);
	}
	
	@Override
	protected void onPrint() {
		
		YBMExam exam = (YBMExam)getExam();
		System.out.printf("toeic:%d\n",exam.getToeic());
		System.out.printf("aa:%d\n",exam.getAa());
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
	
	public class XXX implements Banner /*위에 인터페이스를 정의하면 문제가 생기니 이제 클래스안에 클래스가 정의될수있게 클래스를 만들어줬다.*/{
		private int a; //클래스안에 멤버도 this로 호출가능
		
		public XXX() {
			a = 4;
		}
	
	//Banner의 기능을 구현하려 하였으나
	//현실은 ExamConsole의 print를 재정의 해버렸다.
	@Override
	public void print() {
		
		System.out.println("----------------------");
		System.out.println("		성적출력  Banner 	  ");
		System.out.println("----------------------");
		System.out.println(YBMExamConsole.this.a); //밖에있는 a
		System.out.println(this.a); //자기자신에있는 a
									//밖에있는 a를 가져오고싶다면?
	}
	
	@Override
	public void printEnd() {
		System.out.println("----------------------");
		
	}
	}
	
}
