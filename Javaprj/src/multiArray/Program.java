package multiArray;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		
		String[][] rows = new String[2][];
		
		
		FileInputStream fis = new FileInputStream("res/covid.txt");
		Scanner sc = new Scanner(fis);
		
		String line;
		
		sc.nextLine();
					
		line = sc.nextLine();
		rows[0]=line.split(",");
		
		
		line = sc.nextLine();
		rows[1]=line.split(",");
		
		sc.close();
		fis.close();
		
		
		for(int i=0; i<10; i++) {
			System.out.printf("%s",rows[0][i]);
			
			if(i<9)
				System.out.printf(",");
		}
		
		System.out.println();
		
		for(int i=0; i<10; i++) {
			System.out.printf("%s",rows[1][i]);
			
			if(i<9)
				System.out.printf(",");
		}
		
		
		
		
}

}
