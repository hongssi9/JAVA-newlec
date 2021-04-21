package 캡슐화로또;

import java.util.Random;

public class Program {
	
	
	//------------------------------출력----------------------------------
	static void print(Lotto lotto) {
		for (int i = 0; i < Lotto.getSize(lotto); i++) {
			System.out.printf("[" + "%d" + "] ", Lotto.getNum(lotto, i));
		}

		System.out.println();
	}
	//프린트 함수니까 반환값이 없으니 메인함수 위에 메서드를 만들었다.
	
	

	public static void main(String[] args) {
	
		//1. lotto 객체를 생성
		Lotto lotto = new Lotto();  //인스턴스화
					
		
		//2. 초기화
		Lotto.init(lotto);  //선언부  //반환타입.메서드이름(전달하려는 매개변수)

		
		//3. 로또를 만들자
		lotto = Lotto.gen(lotto); //Lotto의 인스턴스(객체)를 만드는 함수다.
		
		
		//4. 로또를 출력하자
		print(lotto);
		//lotto.print()
		
		
		//5. 정렬
		Lotto.sort(lotto);  //얘도 공유한다.  //정렬한다->로또를 Lotto안에 있는 sort함수를 이용해서
		//lotto.sort();
		
		
		//6. 다시 출력
		print(lotto);

	}


}


