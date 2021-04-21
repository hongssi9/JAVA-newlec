package ex2.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyProgram {

	public static void main(String[] args) throws IOException {
		//1. res/img.bmp 파일을 읽기 위한 FileInputStream 객체 fis를 생성하고
		//	 res/img_copy.bmp 파일로 쓰기 위한 FileOutputStream객체 fos를 생성한다
		FileInputStream fis = new FileInputStream("res/img.bmp");
		FileOutputStream fos = new FileOutputStream("res/img_copy.bmp");
		
		
		//2. fis를 통해ㅓ 1바이트를 읽어서 byte 변수 b에 담는다.
		int b = 0;
		
		while((b = fis.read()) != -1) {		// ! <- 부정 연산자 넣으면 자동으로 연산자 속성이 바뀜 	
			           // .read는 문자를 하나씩 읽어오는 메소드인데 이걸 반복문으로 실행했으니까 계속 읽어오는거임
			           
			fos.write(b); 					// != 같지 않다, -1이 될때까지 파일을 계속 읽는다(읽을 파일이 없으면 read가 -1로 읽어온다-더이상 읽을게 없기 때문에)
		
		}
		//3. 2번을 더 이상 읽어들인 값이 없을 때까지 반복한다.
		
		//4. 모든 스트림 객체를 닫는다.
		fis.close();
		fos.close();
		
		System.out.println("복사완료");
	}

}
