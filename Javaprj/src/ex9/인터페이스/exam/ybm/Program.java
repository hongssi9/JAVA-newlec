package ex9.인터페이스.exam.ybm;

//import ex9.인터페이스.exam.ybm.YBMExamConsole.XXX;

public class Program {

	public static void main(String[] args) {
		YBMExam exam = new YBMExam(1,1,1,1,1);
		YBMExamConsole console = new YBMExamConsole();
//		console.setBanner(console);
		console.setExam(exam);
		YBMExamConsole.XXX x = console.new XXX();
		console.setBanner(x);
		
		console.input();
		console.print();
	}

}
