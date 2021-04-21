package ex3.array;

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
		int size = 0;
		
		byte[]buf = new byte[1000];
		
		while((size = fis.read(buf)) != -1) {		// ! <- 부정 연산자 넣으면 자동으로 연산자 속성이 바뀜 	
			fos.write(buf); 					// != 같지 않다, -1이 될때까지 파일을 계속 읽는다(읽을 파일이 없으면 read가 -1로 읽어온다-더이상 읽을게 없기 때문에)
		//배열을 이용한다면 반복문을 사용할 때 더 빠르다.
			
			
		}
		//3. 2번을 더 이상 읽어들인 값이 없을 때까지 반복한다.
		
		//4. 모든 스트림 객체를 닫는다.
		fis.close();
		fos.close();
		
		System.out.println("복사완료");
	}

}
