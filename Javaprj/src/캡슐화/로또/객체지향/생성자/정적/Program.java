package 캡슐화.로또.객체지향.생성자.정적;

import java.util.Random;

public class Program {
	
	
	//------------------------------출력----------------------------------
//	static void print(Lotto lotto) {
//		for (int i = 0; i < lotto.getSize(); i++) {
//			System.out.printf("[" + "%d" + "] ", lotto.getNum(i));
//		}
//
//		System.out.println();
//	}
	//프린트 함수니까 반환값이 없으니 메인함수 위에 메서드를 만들었다.
	
	

	public static void main(String[] args) {
	
		Lotto lotto = new Lotto();
		
		lotto.gen();
		
		//6. 다시 출력
		LottoConsole.print(lotto);
		
		LottoConsole.print(lotto);

	}


}


