package ex6.capsule2;

import java.util.Random;

public class Program {
	static void print(Lotto lotto) {
		for (int i = 0; i < 6; i++) {
			System.out.printf("[" + "%d" + "] ", lotto.nums[i]);
		}

	}

	public static void main(String[] args) {

		Lotto lotto; //Lotto클래스를 사용함
		
		
//		int[] lotto;
		// 로또를 만들자

//		lotto = Lotto.gen();
		lotto = gen();
		
//		// 로또를 출력하자
		print(lotto);
//		
//		System.out.println();
//		System.out.println("───────────after sort─────────── ");
//
//		// 로또를 정렬하자
//		Lotto.sort(lotto);
//
//		// 로또를 출력하자
//		print(lotto);
	}

	static Lotto gen() {
		Lotto lotto = new Lotto();
		lotto.nums = new int[6];
		
		Random rand = new Random();
		
		for (int i = 0; i < 6; i++) {
			lotto.nums[i] = rand.nextInt(45) + 1;
			//테스트 새로운 커밋
			//이메일설정
		}

		return lotto;
	}
}


