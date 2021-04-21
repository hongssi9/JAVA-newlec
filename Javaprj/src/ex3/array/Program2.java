package ex3.array;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 문자 10개를 저장하기 위한 문자배열 chs를 만드시오
		char[] chs = new char[10];
		
		//2. chs 배열에 문자 'A'를 모두 채우시오
		for(int i=0;i<10;i++)
			chs[i] = (char)('A');
		
		//3.chs배열에 담겨진 값들을 모두 출력하시오
		for(int i=0;i<10;i++) 		
			System.out.printf("%c ",chs[i]);
		System.out.println("");
		
			
		//J부터 A까지 채우는 코드를 작성하시오
		for(int i=0; i<10; i++)
			chs[i] =(char) ('J'-i);
				
		
		//배열에 담겨진 값을 출력하는 코드를 작성하시오
		for(int i =0; i<10; i++)
			System.out.printf("%c ",chs[i]);
		System.out.println("");
		
//	-------------------------------------------------------
		
		//A와 Z의 자리를 바꾸자
		for(int i=0; i<10; i++)
			chs[i] =(char) ('A'+i);
//		chs[0]='J';
//		chs[9]='A';
//		

		for(int i=0; i<10; i++)
		System.out.printf("%c " , chs[i]);
		System.out.println();
		
		//--------------------------------------------------
//		char temp;
//		temp = chs[0];
//		chs[0] = chs[9];
//		chs[9] = temp;
//		
//		for(int i=0; i<10; i++)
//			chs[i]=(char) (temp-i);
//		
//		
//		for(int i=0; i<10; i++)
//			System.out.printf("%c " , chs[i]);
		
		//--------------------정답-----------------------------
		char temp;
		
		for(int i=0; i<5; i++) {
			temp = chs[i];
			chs[i] = chs[9-i];
			chs[9-i] = temp;
		}
		for(int i=0; i<10; i++)
			System.out.printf("%c " , chs[i]);
		//----------------------------------------------------
		
		
			
		
		
	}

}
