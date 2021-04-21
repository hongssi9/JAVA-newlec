package ex7.상속.IS_A;

public class Exam {
	
	public int kor; //인스턴스화 하면 자동으로 데이터형으로 초기화가 되지만
					 // private로 막아 초기화가 되지않음
	private int eng;
	private int math;
	
	//기본 생성자
	public Exam() { //생성자, 생성자는 이름을 갖고있지 않다. 다른객체를 통해 불러올수없음
					//맨 처음 초기화를 해주기 위해서,한번만
					//인스턴스가 생성될 때 호출되는 인스턴스 초기화 메서드
					//생성자는 클래스의 이름과 같아야한다.
					//인스턴스 변수 지역변수를 초기화 하기 위해
//		kor = 10;
//		eng = 10;
//		math = 10;
		
		this(20,20,20); //아래 인자값이 3개인 함수를 참조한다.
	}
	
	//오버로드 생성자
	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	
	}
	
	

	public int total() {
		return this.kor+eng+math;
		
	}
	
	public int total(int ext) {		//함수는 인자값이 달라지면 별개로 사용할 수 있다.
		return this.kor+eng+math;	//오버로드는 먼저 원래 메서드가 존재하고 새로만든 메서드에 인자값을 적재해야 오버로드가 된다.
									//과적재
		
	}
	
					

	public float avg() {
		return this.total() / 3.0f;
		
	}

}
