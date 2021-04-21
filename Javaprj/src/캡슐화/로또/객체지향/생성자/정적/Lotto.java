package 캡슐화.로또.객체지향.생성자.정적;

import java.util.Random;

//재사용
public class Lotto {
	private int[] nums; // 인스턴스 변수
	private static int size; //전역 변수
	
	static {
		size=6;
	}

	
	
	//---------------------------초기화------------------------------------------
	// 초기화는 단 한번만 실행되길 바란다.
	// 초기화는 속성이 사용되기 전에만 실행되길 바란다.
	// =: 다른 어떤 로직보다 가장 먼저 실행되길 바란다.
	// 위의 두 조건을 만족하는 도구 => Constructor(생성자)
	
	//앞으로 초기화를 하려면 Constructor를 사용해서 해주자
	public Lotto() { //이름이 없는 함수 이름대신 Lotto라는 형식에 개체
//		this.size = 6;
		nums = new int[size];
		//this는 인스턴스의 자기 자신
	}
	
	
	
	//-----------------------------랜덤으로 숫자 생성-----------------------------------------
		public void gen() {
//			Lotto lotto = new Lotto(); // 4byte 이 객체를 프로그램 클래스에서 공유한다
//			lotto.nums = new int[6]; // 24byte

			Random rand = new Random();

			for (int i = 0; i < this.size; i++) {
				nums[i] = rand.nextInt(45) + 1;

			}

			
		}
		
		
		//-------------------------------------------정렬--------------------------------------
		public void sort() { 

			for (int j = 0; j < size-1; j++) {
				for (int i = 0; i < this.size-1-j; i++) {
					int compare;
					if (nums[i] > nums[i + 1]) {
						compare = nums[i];
						nums[i] = nums[i + 1];
						nums[i + 1] = compare;
					}
				}
			}
		}
	
	

	//-------------------------------for문에 돌릴 사이즈-------------------------------
	public int getSize() {
		return this.size;
	}
	
	
	
//-------------------------------------------------------------------
	// static 은 함수를 만들때
	public int getNum(int i) {
		int num = nums[i];

		return num;
	}



	
	
	
	


}
