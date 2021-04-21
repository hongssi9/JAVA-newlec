package 캡슐화.로또.객체지향;

import java.util.Random;

//재사용
public class Lotto {
	private int[] nums; // 로또 번호를 정의함
	private int size;

	
	//---------------------------초기화------------------------------------------
	public void init() { // 반환 없는 함수 //구현부
		this.size = 6;
		this.nums = new int[this.size];
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
	
	public void setSize(int size) {
		this.size = size; //이때는 this를 생략 불가능함 지역변수 size로 다 넣어주기때문
	
	
	}
	
	
//-------------------------------------------------------------------
	// static 은 함수를 만들때
	public int getNum(int i) {
		int num = nums[i];

		return num;
	}



	
	
	
	


}
