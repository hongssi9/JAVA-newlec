package test;

public class whilefor {

	public static void main(String[] args) {

			int tree = 0;
			
			while(tree < 10) { //10보다 작으면 계속 실행
				tree++;
				System.out.printf("나무를 %d 번 찍는중입니다.\n",tree);
				
				if(tree == 10) {
					System.out.println("나무가 넘어갑니다");
				}
			}
		
	}

}
