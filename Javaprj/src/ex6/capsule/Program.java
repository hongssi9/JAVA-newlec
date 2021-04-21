package ex6.capsule;

public class Program {
	static void print(int[] lotto) {
		for (int i = 0; i < 6; i++) {
			System.out.printf("[" + "%d" + "] ", lotto[i]);
		}

	}

	public static void main(String[] args) {

	
		int[] lotto;
		// 로또를 만들자
		
		lotto = Lotto.gen();
		// 로또를 출력하자
		print(lotto);
		
		System.out.println();
		System.out.println("───────────after sort─────────── ");

		// 로또를 정렬하자
		Lotto.sort(lotto);

		// 로또를 출력하자
		print(lotto);
	}

}
