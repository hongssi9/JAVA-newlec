package test;

import java.util.Scanner;

public class scanner {

	public static void main(String[] args) {
		int kor, math, eng, total;
		double avg;
		Scanner sc = new Scanner(System.in); //System.in은 화면에서 출력을 받겠다는 뜻.
		
		System.out.println("-----------성적 입력-------------");
		System.out.println("국어점수");
		kor = sc.nextInt();
		System.out.println("수학점수");
		math = sc.nextInt();
		System.out.println("영어점수");
		eng = sc.nextInt();
		
		total = kor+math+eng;
		avg = total/3;
		
		
		System.out.println("-----------성적 출력-------------");
		System.out.printf("국어점수 : %d",kor);
		System.out.printf("수학점수 : %d",math);
		System.out.printf("영어점수 : %d",eng);
		System.out.printf("총합 : %d",total);
		System.out.printf("평균 : %s",avg);
		
		
		
		
		
		
	
		
		
		
	}

}
