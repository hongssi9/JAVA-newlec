package 캡슐화.로또.객체지향;

public class LottoConsole {
	public static void print(Lotto lotto) {
		for (int i = 0; i < lotto.getSize(); i++) {
			System.out.printf("[" + "%d" + "] ", lotto.getNum(i));
		}

		System.out.println();
	}

}
