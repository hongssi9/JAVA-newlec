package ex5.fnc;

public class Program {
	
	
	static void print(int x) { //반환값이 필요없는, 그냥 출력만 하는거면 void를 써준다
		System.out.println(x);
	}

	static int add(int x, int y) {
		return x+y; //return으로 값이 반환디어 아래 함수에 넘겨준다.
	}
	
	static void printsum(int x , int length) {
		
		if(length <=0) {
			System.out.println("length에 잘못된 값을 입력하셨습니다.");
			return;
		}
		
		int sum=0;
		
		for(int i=0; i<length; i++)
			sum += x+i;
		
		for(int i=0; i<length; i++) {
			System.out.printf("%d",x+i);
			
			if(i < length-1)
				System.out.print("+");		 
		}
		System.out.print("=");
		System.out.printf("%d\n",sum);

	}
	
	
	public static void main(String[] args) {
		
		//7:14 수정한 텍스트 1줄
		//7:19 수정한 텍트스 2줄
		//7:19 수정한 텍트스 3줄
		
		int z = add(3,4); //리턴으로 넘겨받으면 7이남고 안받으면?? void를 써준다
		
		System.out.println(add(5,3));
		
		print(30);
		
		printsum(3,2);
		
		
		
		
		
		
		
		

	}

}
