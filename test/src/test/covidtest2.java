package test;

import java.awt.print.PrinterGraphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class covidtest2 {

	public static void main(String[] args) throws IOException {
		String[][] rows;
		int count = 0;
		// 레코드 개수를 알아내는 코드 (count)
		{
			FileInputStream text = new FileInputStream("res/covid.txt");
			Scanner sc = new Scanner(text);
			String line = sc.nextLine();
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				count++;
			}
			System.out.println(count);

		}

		// count에서 받은 값으로 총 몇줄인지 알았으니까 그것으로 배열에다가 값을 저장하는 코드 *
		{
			rows = new String[count][];
			FileInputStream text = new FileInputStream("res/covid.txt");
			Scanner sc = new Scanner(text);
			String line = sc.nextLine();

			for (int i = 0; i < count; i++) {
				line = sc.nextLine();
				rows[i] = line.split(",");
			}

		}

		// 검사 진행자수 총합
		{
			int total = 0;

			for (int i = 0; i < count; i++) {
				total += Integer.parseInt(rows[i][3]);
			}

			System.out.println(total);

		}

		{
			// 일별 가장 많은 검사수와 그 날자 *
			int max = 0;
			String day = "";
			int box = 0;
			for(int i=0; i<count; i++) {
				box = Integer.parseInt(rows[i][3]);
				if(max < box) {
					max = box;
					day = rows[i][0];
				}
			}
			System.out.printf("%s %d\n",day,max);

		}

		// 확진자 수가 늘어난 일자와 수를 출력하시오.
		{
			int box = 0;
			int sum = 0;
			int index = 0;
			String day = "";
			for (int i = 0; i < count; i++) {
				int move = Integer.parseInt(rows[i][1]);
				if (box != move) {
					sum = move - box;
					box = move;
					day = rows[i][0];
					index++;
					System.out.printf("%d일자:%s 늘어난수:%d\n ", index, day, sum);
				}
			}

		}

		String[][] newarr;
		int count2 = 0;
		{
			// 확진자 수가 늘어난 일자와 수를 다음 배열에 담아주시오.
			int box = 0;
			int sum = 0;
			int index = 0;
			String day = "";
			for (int i = 0; i < count; i++) {
				int move = Integer.parseInt(rows[i][1]);
				if (box != move) {
					sum = move - box;
					box = move;
					day = rows[i][0];
					count2++;

				}
			}

			System.out.println(count2);
			newarr = new String[count2][];

			box = 0;
			sum = 0;
			index = 0;
			day = "";
			for (int i = 0; i < count; i++) {
				int move = Integer.parseInt(rows[i][1]);
				if (box != move) {
					sum = move - box;
					box = move;
					day = rows[i][0];
					
					String[] arr = new String[2];
					arr[0] = day;
					arr[1] = String.valueOf(sum);
					
					newarr[index++] = arr; 

				}

			}
			for(int i=0;i<count2;i++) {
				System.out.printf("날자%s 숫자%s\n",newarr[i][0],newarr[i][1]);
			}

		}
	}
}
