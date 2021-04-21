package ex3.arry.test2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 1.문자열 10개 짜리 names 배열을 생성한다.
		String[] names = new String[10];

		// 2. 파일에서 이름들을 읽어와서 names 배열에 대입한다.
		FileInputStream fis = new FileInputStream("res/names.txt");
		Scanner fscan = new Scanner(fis);

		int index = 0;
		while (fscan.hasNextLine()) {
			String name = fscan.nextLine();
			names[index++] = name;
		}

		fscan.close();
		fis.close();

//		for (int i = 0; i < 7; i++) {
//			System.out.printf("%s", names[i]);
//
//			if (i < 6)
//				System.out.print(",");
//			
//			
//			
//
//			for(int j=0; j<i; j++) {
//				System.out.printf("%s",names[j]);
//				
//				if(j<i-1)
//					System.out.print(",");
//			}

//		}

		// 3. names 배열의 이름을 다음처럼 콘솔에 출력한다.

	}

}
