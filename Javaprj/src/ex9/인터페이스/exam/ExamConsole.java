package ex9.인터페이스.exam;

import java.util.Scanner;

public class ExamConsole {
	private Exam exam;
	
	private Banner banner;
	
	
	public ExamConsole() {
		
	}
	
	public ExamConsole(Exam exam) {
	super();
	this.exam=exam;
	}
	

	public void setBanner(Banner banner) {
		this.banner = banner;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}


	protected void onPrint(){
		
	}

	protected Exam getExam() {
		return exam;
	}

	public void print() {
//		System.out.println("----------------------");
//		System.out.println("		성적출력   	");
//		System.out.println("----------------------");
		
		
		//2. 인터페이스를 이용하여 제품 마감처리하기
		banner.print();
		
		System.out.printf("kor:%d\n",exam.getKor());
		System.out.printf("eng:%d\n",exam.getEng());
		System.out.printf("math:%d\n",exam.getMath());
		
		onPrint();
		System.out.printf("total:%d\n",exam.total());
		System.out.printf("avg:%f\n",exam.avg());
		banner.printEnd();
		//System.out.println("---------------------------");
	}
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		
		int kor;
		int eng;
		int math;
		
		System.out.print("kor:");
		kor = Integer.parseInt(scan.nextLine());
		
		System.out.print("eng:");
		eng = Integer.parseInt(scan.nextLine());
		
		System.out.print("math:");
		math = Integer.parseInt(scan.nextLine());
		
		exam.setKor(kor);
		exam.setEng(eng);
		exam.setMath(math);
		
	}
	
}
