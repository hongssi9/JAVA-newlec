import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner; //패키지명 네임스페이스 

import javax.imageio.stream.FileImageInputStream;

class Hello {
	public static void main(String[] args) throws IOException {
		int kor;
		int eng;
		int math;
		int total;
		double avg;
			

		kor = 0;
		eng = 0;
		math = 0;
		
		//--------------------------------------------
		FileInputStream fi = new FileInputStream("C:\\2021-02-19\\workspace\\Javaprj//data.txt");
		//파일 입력 스트림 객체를 fi라는 이름으로 만듦
		//파일로부터 입력을 받는 클래스 (메모장에서 읽어옴)
		Scanner sc2 = new Scanner(fi);
		// fis를 Scanner로 포장해서 사용
		kor = sc2.nextInt();
		eng = sc2.nextInt();
		math = sc2.nextInt();
		fi.close(); //사용후 닫아줘야 충돌을 막는다
		sc2.close();
		
		FileOutputStream fos = new FileOutputStream("C:\\2021-02-19\\workspace\\Javaprj//data.txt");
		//출력을 내보내는 클래스(입력받은 값을 메모장으로 내보냄)
		PrintStream fout = new PrintStream(fos);//System.out이 PrintStream의 객체임
		kor++;
		eng++;
		
		fout.printf("%d %d %d",kor, eng, math);
		fout.close();
		fos.close();
	
	
		//--------------------------------------------
		/*
		 * System.out.print("국어 입력 : "); String line = sc.next(); line = sc.next();
		 * System.out.printf("국어 = %s\n", line);
		 * 
		 * System.out.print("영어 입력 : "); line = sc.next();
		 * System.out.printf("영어 입력 = %s\n", line);
		 * 
		 * System.out.printf("수학 입력 : "); line = sc.next();
		 * System.out.printf("수학 = %s\n", line);
		 * 
		 * 
		 * System.out.println("국어"); kor = sc.nextInt(); System.out.println("영어"); eng =
		 * sc.nextInt(); System.out.println("수학"); math = sc.nextInt();
		 * 
		 * System.out.printf("국어 : %d\n",kor); System.out.printf("영어 : %d\n",eng);
		 * System.out.printf("수학 : %d\n",math);
		 */
		
		//----------------------------------------------------
		
				
		
		

		total = kor + eng + math;
		avg = total / 3.0;  //자료값이 다른걸 연산할수는 없음 자바가 같은 형식으로 바꿔서 형변환하여 연산하기 때문임
		                  //평균 : 72.000 
							//오른쪽을 먼저 계산을 하고 avg 
		
		//avg = total / 3; 으로 하게되면 형변환으로 바꿔주지만 정확한 결과가 잘려서 나옴?
		//평균 : 72.667 
		
		
		
		
		  System.out.println("┌──────────────────┐");
		  System.out.println("│ 성적 출력           ");
		  System.out.println("└──────────────────┘");
		  
		  System.out.printf("국어 : %d\n",kor); System.out.printf("영어 : %d\n",eng);
		  System.out.printf("수학 : %d\n",math);
		  
		  
		  System.out.printf("총점 : %d\n",total);
		  System.out.printf("평균 : %-10.5f\n",avg);
		 
		
		
		//--------------------------------------------------------------
		/*
		 * Scanner scan = new Scanner(System.in); //Scanner 를 new를 통해 만드는...
		 * 
		 * 
		 * System.out.print("국어 점수를 입력하시오 : ");
		 * 
		 * String line = scan.next(); //변수 선언 System.out.printf("line = %s\n", line);
		 * 
		 * line = scan.next(); //next 공백(스페이스바)만나는 지점까지 출력
		 * System.out.printf("line = %s\n", line);
		 * 
		 * kor = scan.nextInt(); System.out.printf("kor =  %s\n",kor);
		 */
		//------------------------------------------------------------------
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//-------------------------------------------------------------
		//System.out.printf("%2$d, %2$d, %2$d, \n", 1, 30);
		
	/*
	 
	 * 
	 * int code1 = System.in.read(); System.out.printf("code is : %d \n",code1-48);
	 * System.out.printf("code is : %c \n",code1);
	 * 
	 * int code2 = System.in.read(); System.out.printf("code is : %d \n",code2-48);
	 * System.out.printf("code is : %c \n",code2);
	 * 
	 * System.out.printf("국어성정 = %d\n", (code1-48)*10+(code2-48));
	 * 
	 */		
//------------------------------------------------------------------
		
		
		

		
		
		
		
		
	}
}