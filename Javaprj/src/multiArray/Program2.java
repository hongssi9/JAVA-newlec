package multiArray;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) throws IOException {

		String[][] rows = new String[2][];

		FileInputStream fis = new FileInputStream("res/covid.txt");
		Scanner sc = new Scanner(fis);

		String line;

		sc.nextLine();

		for (int i = 0; i < 2; i++) {
			line = sc.nextLine();
			rows[i] = line.split(",");
		}

		sc.close();
		fis.close();

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 10; i++) {
				System.out.printf("%s", rows[j][i]);

				if (i < 9)
					System.out.printf(",");
			}

			System.out.println();

		}

	}

}
