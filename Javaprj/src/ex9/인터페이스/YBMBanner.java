package ex9.인터페이스;

public class YBMBanner implements Banner{ //인터페이스를 구현하기위해서는 extends가 아닌 implements를 쓴다.

	@Override
	public void print() {
		System.out.println("----------------------");
		System.out.println("       YBM 성적출력   	  ");
		System.out.println("----------------------");		
	}
	
	
	@Override
	public void printEnd() {
		System.out.println("------------------------");
	}
	
}
