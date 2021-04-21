package ex3.arry.test2;

import java.util.Random;

public class Program2 {

	public static void main(String[] args) {
	
		String[] names = {"강호동","유재석","하하","김지호","김현준","김태희","박민정"};
		
		
//		String n1 = "홍길동";
//		String n2 = "홍길동";
//		String n3 = new String("홍길동");
//		String n4 = new String("홍길동");
//		
//		System.out.println(n1 == n2); 
//		System.out.println(n1.equals(n2));
//		System.out.println(n3 == n4); //문자열이 아닌 객체를 비교한다.
//		System.out.println(n3.equals(n4)); //equals객체끼리 내용을 비교할 수 있게해준다.
//		
//		String fileName = "photo.jpg";
//		System.out.println(fileName.length()); //문자열 길이를 보여줌
//		System.out.println(fileName.indexOf(".")); // "." 나오기전이 몇개인지 보여ㅕ줌
//		System.out.println(fileName.substring(3)); //3번째 제외하고 보여줌
//		System.out.println(fileName.substring(3,5)); //3번째 제외하고 5번째 까지 보여줌
//		
//		int pos = fileName.indexOf("."); //indexOf()는 특정 문자나 문자열이 앞에서부터 처음 발견되는 문자열까지를 찾는다.
//		System.out.println(fileName.substring(0,pos)); //제외없이 처음부터 pos-> .이 찍히기 전까지 출력
//		
//		System.out.println(fileName.compareTo("ohoto.jpg") > 0);
		//photo.jpg보다 fuleName이 하나 더 크다 fileName크면 + photo가 더 크면 -
		//문자열은 전체가 아닌 첫글자 크기만 비교한다.
		
		//--------문자열을 랜덤으로 정렬-----------------------------------------------
		Random rd = new Random();

		for (int i = 0; i < 100; i++) {
			int idx1 = rd.nextInt(7);
			int idx2 = rd.nextInt(7);
			//System.out.printf("idx1 : %d, idx2 : %d\n", idx1, idx2);

			
			String temp;
			temp = names[idx1];
			names[idx1] = names[idx2];
			names[idx2] = temp;
		}
		
		for(int i=0; i<7; i++) {
			System.out.printf("\"%s\"",names[i]);
			
			if(i<6)   //(i<7-1)
				System.out.print(",");
			
		}
		System.out.println();
		
		
		
		//-----------------------큰 값으로 정렬----------------------------
		for(int j=0; j<6-1; j++)
			for(int i=0;i<7-1-j; i++)
				if(names[i].compareTo(names[i+1]) > 0) {
				String temp;
				temp = names[i];
				names[i] = names[i+1];
				names[i+1] = temp;
			}
		
		for(int i=0; i<7; i++) {
			System.out.printf("\"%s\"",names[i]);
			

			if(i<7)   //(i<7-1)
				System.out.print(",");
		}
		System.out.println();
	}

}
