package 시험;

import java.util.Random;
import java.util.Scanner;

public class array {

	public static void main(String[] args) {
		Random random = new Random();
		
		int size = 0;					
		int[] nums;						
			
		Scanner sc = new Scanner(System.in);

		System.out.print("size:");
		size = sc.nextInt();
		nums = new int[size];
		
		
		for (int i = 0; i < size; i++) {
			nums[i] = random.nextInt(100) + 1;
		
		}
		
		for (int i = 0; i < size; i++) {
			System.out.printf("[" + "%d" + "] ", nums[i]);
		}
		
		

}
}