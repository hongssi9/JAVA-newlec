package ex2.control;

import java.util.Scanner;

public class ProgramWithmenuUsingSwith2 {

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
      Scanner scan = new Scanner(System.in);
      
      EXIT:
      while(more)
      {
      int menu;
      System.out.println("┌────────────────────┐");
      System.out.println("│      　메인 메뉴      │");
      System.out.println("└────────────────────┘");
      
      System.out.println("1. 성적입력 : ");
      System.out.println("2. 성적출력 : ");
      System.out.println("3. 종료 : ");
      System.out.println(">");
      menu = Integer.parseInt(scan.nextLine()); //값이 int인지 검사한다
             //Integer.parseInt -> 문자열을 숫자로 변환시키는 함수
      		 //nextLine -> 엔터를 치기 전까지 쓴 문자열
             //next -> 스페이스, 공백 전까지 입력받은 문자열
      		 //nextInt -> 스페이스, 공백 전까지 입력받은 숫자
      
      
      //menu = scan.nextInt();//System.in -> [4913 ]
      //scan.nextLine() 값을 비워줌
      //1. [13        ] 버퍼가 비어있어야 읽는데 더미값이 남아서 
      
      
      switch(menu) {
      
      case 1:
    	  //menu값이 1이라면
    	  
      System.out.println("┌────────────────────┐");
      System.out.println("│      　성적 입력      │");
      System.out.println("└────────────────────┘");

      
//      System.out.printf("국어 : ");
//      kor = Integer.parseInt(scan.nextLine());
      //kor의 값이 유효범위 내에 있지 않다면 입력 범위 : 0~100 범위의 값만 입력할 수 있습니다.
      
      //if(!0<=kor && kor <= 100)
      
//      if(kor < 0 || 100 < kor)  
      
      do {
    	  System.out.printf("국어 : ");
    	  kor = Integer.parseInt(scan.nextLine());
    	  
    	  if(kor <0 || 100 <kor)
    		  System.out.println("입력 범위 : 0~100 범위의 값만 입력할 수 있습니다.");    
    		  
      }
      while(kor < 0 || 100 < kor);  //while문은 이 조건이 완료될때까지 계속 무한이 반복한다.
      
      
      System.out.printf("영어 : ");
      eng = Integer.parseInt(scan.nextLine());
      System.out.printf("수학 : ");
      math = Integer.parseInt(scan.nextLine());
      break;
      
      
      case 2:
    	  //menu값이 2이라면

      total = kor + eng + math;
      avg = total / 3.0f;

      System.out.println("┌───────────────────────────────┐");
      System.out.println("│             성적 출력           │");
      System.out.println("└───────────────────────────────┘");
      
      int i=0;
      while(i<3){ 	  
      
      System.out.printf("국어 : %d\n", kor);
      System.out.printf("영어 : %d\n", eng);
      System.out.printf("수학 : %d\n", math);

      System.out.printf("총점 : %2d\n", total);
      System.out.printf("평균 : %-6.2f\n", avg);  
      
      i++;
      }
      //more = scan.nextBoolean();
      //break;
      
      case 3:
    	  //more = false;
    	  break EXIT;
      
    	  
      }
	

   }
      System.out.println("END");
   }
}