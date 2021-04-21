package ex6.캡슐화.코로나;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import ex4.struct.Covid19;

public class Program {

	public static void main(String[] args) throws IOException {

		int count = 0;
//      Covid19[] list; //전역변수로 미리 이름만을 선언할수있다.
		// ---------------------------------------------------------
		// 레코드 개수를 알아내는 코드
		{
			FileInputStream fis = new FileInputStream("res/covid.txt");
			Scanner fscan = new Scanner(fis);

			// while 반복을 하면서 count++ 연산을 한다. 마지막 줄을 만날 때까지
			while (fscan.hasNextLine()) {
				fscan.nextLine();
				count++;
			}

			fscan.close();
			fis.close();

			count--;

			System.out.println(count);
		}
		// --------------------------------------------------------
		// Covid19를 로드하는 코드
		Covid19[] list = new Covid19[count]; //미리선언한 이름을 new연산자로 선언하거나 새롭게 만들수도있다.
		{
			FileInputStream fis = new FileInputStream("res/covid.txt");
			Scanner fscan = new Scanner(fis);

			String line; //문자열 변수 선언

			fscan.nextLine(); //첫번째줄을 읽어서 버림
			
			


					
			
			
			
			
		}

	}
}

