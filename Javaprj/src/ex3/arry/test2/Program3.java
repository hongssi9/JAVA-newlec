package ex3.arry.test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fis = new FileInputStream("res/names.txt");
		Scanner fscan = new Scanner(fis);
		
		String line = fscan.nextLine();
		
		String[] names = line.split(",");
		
		//강호동,유재석,하하,김지호,김현준,김태희,박민정
		
		System.out.println(names[1]);
		
		fscan.close();
		fis.close();
	}

}
