package ex2.control;

import java.util.Scanner;

public class Program {

   public static void main(String[] args) {
	   
	 //scan 이라는 이름으로 Scanner 객체를 생성하고
//		Scanner scan = new Scanner(System.in);
//		
//		//scan을 이용해서 정수값을 입력 받아 변수 ans에 담는다
//		int ans = scan.nextInt();
//		
//		//ans 값이 3보다 크면 2를 거짓이면 3을 x 변수에 담아서
//		int x = (ans > 3) ? 2:3; //ans가 3보다 크면? 이라는 조건을 걸어 크면 = 참 작으면 = 거짓
//		
//		//x 변수의 값을 출력한다
//		System.out.println(x);
//-----------------------------------------------------------------
	      
	   
      // 기본형식 : primitive type
      int kor, eng;
      int math;
      int total;
      float avg;

      kor = 0;
      eng = 0;
      math = 0;
      
      boolean more = true; //불리언(부울) 자료형에 대입되는 값은 참 또는 거짓만 가능하다
      
      while(more) //조건식
      {
      // 여기에 성적을 입력하는 코드를 작성하시오.
      Scanner scan = new Scanner(System.in);

      System.out.println("┌────────────────────┐");
      System.out.println("│      　성적 입력      │");
      System.out.println("└────────────────────┘");


      System.out.printf("국어 : ");
      kor = Integer.parseInt(scan.nextLine());
      System.out.printf("영어 : ");
      eng = Integer.parseInt(scan.nextLine());
      System.out.printf("수학 : ");
      math = Integer.parseInt(scan.nextLine());

      total = kor + eng + math;
      avg = total / 3.0f;

      System.out.println("┌───────────────────────────────┐");
      System.out.println("│             성적 출력           │");
      System.out.println("└───────────────────────────────┘");

      System.out.printf("국어 : %d\n", kor);
      System.out.printf("영어 : %d\n", eng);
      System.out.printf("수학 : %d\n", math);

      System.out.printf("총점 : %2d\n", total);
      System.out.printf("평균 : %26.2f\n", avg);
      
      System.out.print("계속할까요?(true/false)");
      more = scan.nextBoolean();
      }
   }

}