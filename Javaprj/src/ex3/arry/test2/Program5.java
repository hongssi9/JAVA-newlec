package ex3.arry.test2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program5 {

	public static void main(String[] args) throws IOException {
		
			
		
			String[] row1 = new String[10]; //10개 배열 생성
			String[] row2 = new String[10];
			
			FileInputStream fis = new FileInputStream("res/covid.txt");
			Scanner sc = new Scanner(fis);
			
			String line; //문자열 line 변수 생성
			
			sc.nextLine(); //입력받아온 sc에서 한줄을 읽어옴
						
			line = sc.nextLine(); //문자열 변수 line에 또다시 한번 한줄을 읽어온다 (첫째줄은 버림)
			row1=line.split(","); //배열 row1에 split","으로 나눠줌 
			
			line = sc.nextLine();
			row2=line.split(",");
			
			sc.close();
			fis.close();
			
			for(int i=0; i<10; i++) {
				System.out.printf("%s",row1[i]);
				
				if(i<9)
					System.out.printf(",");
			}
			
			System.out.println();
			
			for(int i=0; i<10; i++) {
				System.out.printf("%s",row2[i]);
				
				if(i<9)
					System.out.printf(",");
			}
			
			
			
			
	}

}
