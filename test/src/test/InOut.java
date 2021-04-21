package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class InOut {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream text = new FileInputStream("res/names.txt");
		Scanner name = new Scanner(text);
		String line = name.nextLine();
		
		String[] names = line.split(",");
		
		System.out.println(names[2]);
		
		
			
	}
}

