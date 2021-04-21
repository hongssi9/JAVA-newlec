package ex8.추상화;

public class NewExam extends Exam {
	private int com;

	public NewExam() {
		//super(); 아무것도 없으면 이클립스에서 자동으로 super()생성
//		com = 10;
		this(10,10,10,10 ); //인자값이 4개인 아래 함수로 넘어감
	}

	public NewExam(int kor, int eng, int math, int com) {
		//super();
		super(kor,eng,math);
		this.com = com;
	}

	@Override
	public int total() {
		return super.total() + com; // super를 생략하게 되면 자동으로 this.total로 바뀌게 된다
									// 서로를 호출하는 무한루프로 빠져버린다.
//	super 키워드는 부모 클래스로부터 상속받은 필드나 메소드를 자식 클래스에서 참조하는 데 사용하는 참조 변수입니다.
	}

	@Override
	public float avg() {
//	return super.avg() / 4.0f; //틀린거
		return this.total() / 4.0f; // 과목수를 맞춰야 하니까 위에 오버라이드 된 total값을 가져와야한다.
	}

}
