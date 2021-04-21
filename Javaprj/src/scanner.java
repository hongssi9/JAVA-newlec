import java.util.Scanner;
//java.utill패키지 내에 존재함으로 임폴트시켜 꺼내 사용

public class scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int kor;
		int eng;
		int math;
		int total;
		double avg;
		String str;
		
		Scanner sc = new Scanner(System.in);
		//Scanner 화면으로부터 데이터를 입력받는 기능을 제공하는 클래스
		//객체 생성
		
		System.out.println("입력란");
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		
		str = sc.nextLine();
		//Stirng str = sc.nextLine(); 변수선언?
		
		// String next() 다음 토큰을 문자열로 리턴 
		// int nextInt() 다음 토큰을 int 타입으로 리턴
		//String nextLine()  ' \n '을 포함하는 한 라인을 읽고 ' \n '을 버린 나머지만 리턴 
		
		System.out.printf("국어점수 : %d\n",kor); 
		System.out.printf("영어점수 : %d\n",eng);
		System.out.printf("수학점수 : %d\n",math); //ctr+art 복사
		
		System.out.printf("문자열 출력 : %s\n",str);
		
		total = kor+eng+math;
		avg = total/3.0;
		
		System.out.printf("총점 %d\n",total);
		System.out.printf("평균 %f\n",avg);
		
		
	}

}
