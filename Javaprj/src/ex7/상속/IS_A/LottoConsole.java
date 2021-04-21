package ex7.상속.IS_A;

import ex7.ex7.상속.Lotto;

public class LottoConsole {
	
	//객체가 다른 객체를 자신의 멤버로 Has 하고 그것을 이용하면 그것 Has A 상속이라고 한다.
	private Lotto lotto; //LottoConsole은 Lotto를 상속(제공) 받아서 멤버 함수를 구현한다.
	
	public LottoConsole(Lotto lotto) {
		this.lotto = lotto;
	}
	
	public void print() {
		for (int i = 0; i < this.lotto.getSize(); i++) {
			System.out.printf("[" + "%d" + "] ", this.lotto.getNum(i));
		}

		System.out.println();
	}

}
