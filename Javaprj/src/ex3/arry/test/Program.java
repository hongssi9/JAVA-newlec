package ex3.arry.test;

public class Program {

	public static void main(String[] args) {
		// 1. 정수 10개짜리 nums 배열을 생성한다.
		int[] nums = new int[10];

		// 2. nums에 숫자를 2,4,5,6... 처럼 짝수로 10개를 채우는 반복문을 작성한다.
		for (int i = 0; i < 10; i++)
			nums[i] = 2 * (i + 1);

		// 2. nums에 숫자를 1,2,3,1,2,3,1,2,3,1 처럼 1,2,3이 순환되는 값으로 채우는 반복문
//		for(int i=0;i<10;i++)
//			nums[i] = i%3+1;

		// 3.num을 출력하는 코드를 작성한다
		// 출력하는 모양은 다음과 같다.
		// 2,3,4,5,6,7,9,...20
		for (int i = 0; i < 10; i++) {
			System.out.printf("%d", nums[i]);

			if (i < 9)
				System.out.print(",");
		}
	}
}