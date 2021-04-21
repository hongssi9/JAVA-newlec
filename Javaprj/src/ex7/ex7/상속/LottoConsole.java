package ex7.ex7.상속;

public class LottoConsole {
	public static void print(Lotto lotto) {
		
		for (int i = 0; i < /*Lotto.getSize(lotto)*/ lotto.getSize() ; i++) {
			System.out.printf("[" + "%d" + "] ", /*Lotto.getNum(lotto, i)*/lotto.getNum(i));
			//System.out.printf("[" + "%d" + "] ", lotto.nums[i]);
		}
		
		System.out.println();		
	}
}
