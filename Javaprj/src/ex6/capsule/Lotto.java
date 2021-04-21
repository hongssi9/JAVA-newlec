package ex6.capsule;

import java.util.Random;
//재사용
public class Lotto {
	public static void sort(int[] lotto) {
		for (int j = 0; j < 5 + 4 + 3 + 2 + 1; j++) {
			for (int i = 0; i < 5; i++) {
				int compare;
				if (lotto[i] > lotto[i + 1]) {
					compare = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = compare;
				}

			}
		}

	}

	public static int[] gen() {
		int[] lotto = new int[6];
		
		Random rand = new Random();
		
		for (int i = 0; i < 6; i++) {
			lotto[i] = rand.nextInt(45) + 1;
		}

		return lotto;
	}
}
