package ex7.ex7.상속;

/*
Has A ���
Is A ���
*/

public class Program {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.init();
		lotto.gen();
		LottoConsole.print(lotto);
	}

}
