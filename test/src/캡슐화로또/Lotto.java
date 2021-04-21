package 캡슐화로또;

import java.util.Random;

//재사용
public class Lotto {
	private int[] nums; // 로또 번호를 정의함
	private int size;

	
	//---------------------------초기화------------------------------------------
	public static void init(Lotto lotto) { // 반환 없는 함수 //구현부
		lotto.size = 6;
		lotto.nums = new int[lotto.size];
	}
	
	
	
	//-----------------------------랜덤으로 숫자 생성-----------------------------------------
		static Lotto gen(Lotto lotto) {
//			Lotto lotto = new Lotto(); // 4byte 이 객체를 프로그램 클래스에서 공유한다
//			lotto.nums = new int[6]; // 24byte

			Random rand = new Random();

			for (int i = 0; i < lotto.size; i++) {
				lotto.nums[i] = rand.nextInt(45) + 1;

			}

			return lotto;
		}
		
		
		//-------------------------------------------정렬--------------------------------------
		public static void sort(Lotto lotto) {

			for (int j = 0; j < 5; j++) {
				for (int i = 0; i < 5 - j; i++) {
					int compare;
					if (lotto.nums[i] > lotto.nums[i + 1]) {
						compare = lotto.nums[i];
						lotto.nums[i] = lotto.nums[i + 1];
						lotto.nums[i + 1] = compare;
					}
				}
			}
		}
	
	

	//-------------------------------for문에 돌릴 사이즈-------------------------------
	public static int getSize(Lotto lotto) {
		return lotto.size;
	}
	
	
	
//-------------------------------------------------------------------
	// static 은 함수를 만들때
	public static int getNum(Lotto lotto, int i) {
		int num = lotto.nums[i];

		return num;
	}
	
	
	


}
