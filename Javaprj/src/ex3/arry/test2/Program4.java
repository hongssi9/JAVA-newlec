package ex3.arry.test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) throws IOException {
		
		//값을 저장하는 변수 : 값변수 - Value Type 기본형식
		//참조를 하는 변수 : 참조변수 - Ref Type 기본형식이 아닌 경우
		
		//값 변수와 참조 변수
		//값변수 - 담는 공간을 가지는 변수
		//참조 변수는 담을 공간이 없으며 객체를 가리키기 위한 변수
		
//		int x=3;
//		String s= "hello"; 실질적인 공간은 "hello"자체가 가지고 있고 변수 s는 헬로를 활용하기위한 캡슐 
		
		
		FileInputStream fis = new FileInputStream("res/covid.txt");
		Scanner scan = new Scanner(fis);
		
		String line = scan.nextLine();
		
		int total = 0;
		
		while(scan.hasNextLine()) {
		line = scan.nextLine();
		String[] data = line.split(",");

			System.out.println(data[3]);
			
			total += Integer.parseInt(data[3]);
		}
			
			System.out.printf("총합%d",total);
		
		
			fis.close();
			scan.close();
		}
		
	}


