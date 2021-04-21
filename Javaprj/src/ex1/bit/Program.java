package ex1.bit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

//import java.io.FileInputStream;


public class Program {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
				

		FileInputStream fis = new FileInputStream("res/img.bmp");
		//이미지 파일을 읽기 위해 파일입력 스트림을 fis로 생성
		int b;
		//2바이트
		b = fis.read();
		b = fis.read();
		
		int b1 = fis.read();
		int b2 = fis.read();
		int b3 = fis.read();
		int b4 = fis.read();

	
		
		int fileSize = 0;
		fileSize = b1; // [0][0][0][b1]
		fileSize = b2; // [0][0][0][b2]
		fileSize = b3; // [0][0][0][b3]
 		fileSize = b4; // [0][0][0][b4]
 		
 		fileSize = b4<<24|b3<<16|b2<<8|b1;
		
		//10진수 : 23
		//8진수 : 023
		//2진수 : 0b10
		//16진수 : 0x00 
		
		//2진수 -> 1비트
		//4진수 -> 2비트
		//8진수 -> 3비트
		//16진수 -> 4비트
		
		
		fileSize = (b4&0x000000ff) <<8*3 |  //[b4][ ][ ][ ]
				   (b3&0x000000ff) <<8*2 |  //[ ][b3][ ][ ]
				   (b2&0x000000ff) <<8*1 |  //[ ][ ][b4][ ]
				   (b1&0x000000ff);         //[ ][ ][ ][b1]
		
		System.out.println(Integer.toBinaryString(b4));
		System.out.println(Integer.toBinaryString(b3));
		System.out.println(Integer.toBinaryString(b2));
		System.out.println(Integer.toBinaryString(b1));
		
		
		
		
		System.out.printf("file size : %d\n ",fileSize);
		
		fis.close();
		
	

		
		//		int kor, eng, math;
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("점수를 입력하시오");
//		
//		kor = sc.nextInt();
//		eng = sc.nextInt();
//		math = sc.nextInt();
//		
//		System.out.printf("국어 : %d 영어 : %d 수학 : %d ",kor, eng, math);
//		
//		FileOutputStream fos = new FileOutputStream("C:\\2021-02-19\\workspace\\Javaprj\\data.txt");
//		PrintStream ps = new PrintStream(fos);
//		
//		ps.printf("%d %d %d",kor, eng, math);
		
		
		
		
		
		
		
	}
	

}
