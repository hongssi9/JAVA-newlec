package ex3.array;

import java.util.Random;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		//1. kors라는 이름의 정수 6개짜리 배열을 생성해주시오.
		int[] kors = new int[6];
		
		//2. kors의 3번째 방에 36을 담고 싶습니다.
		kors[2] = 36; //0부터 시작인걸 기억하자
		
		//Random 객체
		for(int i=0;i<6;i++)
			kors[i]=rand.nextInt(45)+1;
		
		
		
//		for(int i=0; i<6; i++)
//			System.out.printf("%d",i);
			
		
		
		
		System.out.printf("%d\n",kors[2]);
	}

}
