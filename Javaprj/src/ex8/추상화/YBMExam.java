package ex8.추상화;

public class YBMExam extends Exam{

	private int toeic;
	private int aa;
	
	public YBMExam() {
		
	}
	
	public YBMExam(int kor, int eng, int math, int toeic, int aa) { //생성자에 매개변수4개
		super(kor,eng,math); //부모클래스에있는 변수들을 super을 통해 가져와서 매개변수로 초기화시킴
		this.toeic = toeic; //넘겨진 인자값을 받아 생성자로 동시에 초기화 시켜버림
		this.aa = aa;  //this 이 클래스에 선언된 aa변수로 초기화 시켜줌
	}

	
	@Override
	public int total() {
		// TODO Auto-generated method stub
		return super.total() + toeic + aa;
	}
	
	
	@Override
	public float avg() {
		// TODO Auto-generated method stub
		return this.total() / 5.0f;
	}
	
}
