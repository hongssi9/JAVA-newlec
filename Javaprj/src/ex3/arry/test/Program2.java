package ex3.arry.test;

import java.util.Random;

public class Program2 {

	public static void main(String[] args) {
		// 1. 정수 10개짜리 nums 배열을 생성한다. 단 1,2,3,4,~~10
		// 배열 초기화

		// int nums1[] = new int[] {1,2,3,4,5,6,7,8,9,10}; 잘못된 선언
		// int[] nums2 = new int[] {1,2,3,4,5,6,7,8,9,10}; 이렇게 선언할수도있음
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// 랜덤값을 얻는다
		Random rd = new Random();

		for (int i = 0; i < 100; i++) {
			int idx1 = rd.nextInt(10); // 0~9
			int idx2 = rd.nextInt(10); // 0~9
			System.out.printf("idx1 : %d, idx2 : %d\n", idx1, idx2);

			// 두 인덱스 위치의 값을 바꿔라
			// {1,2,6,4,5,3,7,8,9,10}
			int temp;
			temp = nums[idx1];
			nums[idx1] = nums[idx2];
			nums[idx2] = temp;
		}

		// 13째 줄부터 18번째까지를 100번 반복하라

		// nums 배열을 출력하시오. 출력형식은 이전과 같다.
//		for (int i = 0; i < 10; i++) {
//			System.out.print(nums[i]);
//			if (i < 9)
//				System.out.print(",");
//		}

		// 정렬
		// [2][6][1][2][5]
		int[] num = { 2, 6, 1, 2, 5 };

		// 제일 큰 값을 찾아 맨 뒤로 밀어내기
		// 1.만약 nums의 0번째 값이 1번째 값보다 크다면 두 위치의 값을 바꾼다.
//		int temp;
//		temp = nums[0];
//		nums[0] = nums[1];
//		nums[1] = temp;
		// 2.만약 nums의 1번째 값이 2번째 값보다 크다면 두 위치의 값을 바꾼다.
		// 3.만약 nums의 2번째 값이 3번째 값보다 크다면 두 위치의 값을 바꾼다.
		// 4.만약 nums의 3번째 값이 4번째 값보다 크다면 두 위치의 값을 바꾼다.

		for (int j=0; j<9-1; j++)
			for (int i = 0; i < 10-1-j; i++)
				if (nums[i] > nums[i + 1]) {
					int temp;
					temp = nums[i];
					nums[i] = nums[i];
					nums[i+1] = temp;
				}

		for (int i = 0; i < 10; i++) {
			System.out.print(nums[i]);
			if (i < 9)
				System.out.print(",");

		}
	}
}
