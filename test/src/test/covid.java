package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class covid {

	public static void main(String[] args) throws IOException {

		// 4번째 컬럼의 총 합을 구하시오. -> "제주 검사진행자수" 컬럼의 총 합을 구하시오.(문제)

		// 값을 저장하는 변수 : 값변수 - Value Type 기본형식
		// 참조를 하는 변수 : 참조변수 - Ref Type 기본형식이 아닌 경우

		// 값 변수와 참조 변수
		// 값변수 - 담는 공간을 가지는 변수
		// 참조 변수는 담을 공간이 없으며 객체를 가리키기 위한 변수

		// int x = 3;
		// String s = "hello"; //->new String("hello");

		// 정수를 문자열로
//		String.valueOf(28); // ->"28"
//		String.format("[%d]", 28); // ->"[28]"

		// 문자열을 정수로 : Wrapper 클래스를 이용한다.
//	      int = Integer;
//	      double = Double;
//	      float = Float;
//	      char = Char
//	      boolean = Boolean

//		Integer.parseInt("28"); // ->28
//		Double.parseDouble("29.34"); // ->29.34

		FileInputStream fis = new FileInputStream("res/covid.txt"); 
		Scanner scan = new Scanner(fis); //

		int total = 0; //더미값이 생기니까 0으로 초기화

		String line = scan.nextLine();// nextLine()한줄 데이터를 가져오는데 엔터를 치면 그전까지를 한줄이라고 입력받는다.
										// 1.txt에서 한줄을 먼저 읽어온다
										// scan.nextLine() -> 공간을 갖는다.

		while (scan.hasNextLine()) { // hasNextLine()은 다음에 읽을 값이 있는지 확인하는 불린타입의 메소드로 값이 있으면 트루를 반환한다.
			line = scan.nextLine(); // 위에서 읽어온 첫번째줄은 이미 읽었으니까 그 다음 두번째 줄을 읽어온다.
			String[] data = line.split(","); // 가져온 line을 구분자 (",")로 쪼개주겠다
												// 쪼개준 문자열을 String[] data에 배열로 넣겠다 라는 뜻

			System.out.println(data[3]); // data라는 배열에서 [3] 3번째 문자열을 뽑겠다.

			total += Integer.parseInt(data[3]); // total에 정수형 data를 더한다 (기존값에 우측항의 값을 더함)
		}

		System.out.printf("총합 : %d", total);

		fis.close();
		scan.close();
	}

}
