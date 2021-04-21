package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Structarr {

	public static void main(String[] args) throws IOException {

		int count = 0;
//      Covid19[] list; //전역변수로 미리 이름만을 선언할수있다.
		// ---------------------------------------------------------
		// 레코드 개수를 알아내는 코드
		{
			FileInputStream fis = new FileInputStream("res/covid.txt");
			Scanner fscan = new Scanner(fis);

			// while 반복을 하면서 count++ 연산을 한다. 마지막 줄을 만날 때까지
			while (fscan.hasNextLine()) {
				fscan.nextLine();
				count++;
			}

			fscan.close();
			fis.close();

			count--;

			System.out.println(count);
		}
		// --------------------------------------------------------
		// Covid19를 로드하는 코드
		Covid19[] list = new Covid19[count]; //미리선언한 이름을 new연산자로 선언하거나 새롭게 만들수도있다.
		{
			FileInputStream fis = new FileInputStream("res/covid.txt");
			Scanner fscan = new Scanner(fis);

			String line; //문자열 변수 선언

			fscan.nextLine(); //첫번째줄을 읽어서 버림
			
			
			
			//1. 몇번을 도는 포문을 만들어줌
			//2. 줄을 읽을 함수를 선언
			//3. 한줄에 몇개의 저장할 문장이 있는지 배열을 만듦
			//4. 참조할 객체를 선언
			//5. 객체에 담을 문장을 넣어줌
			//6. 참조변수를 담을 배열을 선언해줌

			for (int i = 0; i < count; i++) {
				line = fscan.nextLine();  //한줄 읽은걸 다른 배열이나 조건문에 넣기위해 문자열 변수에다가 값을 넣어준거(다른곳에 쓰기위해서)
				String[] tokens = line.split(","); //배열 tokens에다가 line에서 한줄 읽어온 값을 split을 이용하여 , 로 구분하면 10개가 나옴
													//목록이 기준일자부터 데이터기준일자까지 총 10개가 있음 10개 크기를 갖는 배열을 선언해준거다.
				Covid19 covid = new Covid19(); //다른 클래스 Covid19를 new 연산자로 선언해서 coivd 객체를 만들었다.
				covid.date = tokens[0]; //클래스에있는 date에 tokens[0]번째에 저장된 값을 넣어준다?? 가르킨다
				covid.cases = Integer.parseInt(tokens[1]);
				covid.death = Integer.parseInt(tokens[2]);
				covid.tests = Integer.parseInt(tokens[3]);
				covid.selfIsolation = Integer.parseInt(tokens[4]);
				covid.release = Integer.parseInt(tokens[5]);
				covid.recover = Integer.parseInt(tokens[6]);
				covid.selfQuarantineDomestic = Integer.parseInt(tokens[7]);
				covid.selfQuarantineImported = Integer.parseInt(tokens[8]);
				covid.pubDate = tokens[9];
				//covid.test = tokens[10]; //배열이 10개까지만 만들어졌다.

				list[i] = covid;

			}

			fscan.close();
			fis.close();
		}
		{
			System.out.println(list[34].cases); //34줄에 있는 두번째 값인 제주 확진자가 나왔다.
		}

		for(int i=0; i<count; i++) {
			System.out.printf("%s,",list[i].date);
			System.out.printf("%d,",list[i].cases);
			System.out.printf("%d,",list[i].death);
			System.out.printf("%s,",list[i].tests);
			System.out.printf("%s,",list[i].selfIsolation);
			System.out.printf("%s,",list[i].release);
			System.out.printf("%s,",list[i].recover);
			System.out.printf("%s,",list[i].selfQuarantineDomestic);
			System.out.printf("%s,",list[i].selfQuarantineImported);
			System.out.printf("%s",list[i].pubDate);
			
			System.out.println();
			
			
			
		}
		
		System.out.printf("--------------------------------------------------------");
		System.out.println();
		
		for(int i=0; i<count; i++) {
			Covid19 covid = list[i];	
			System.out.printf("%s,%d,%d,%d,%d,%d,%d,%d,%d,%s\n",
									covid.date,
									covid.cases,
									covid.death,
									covid.tests,
									covid.selfIsolation,
									covid.release,
									covid.recover,
									covid.selfQuarantineDomestic,
									covid.selfQuarantineImported,
									covid.pubDate);
					
			
			
			
			
		}

	}
}
//      String[] row1 = new String[3];
//      row1[0] = "2020-10-01";
//      row1[2] = "30";
//      row1[1] = "30";
//      row1[3] = "23";
//      
//      Covid19 row2 = new Covid19();
//      row2.date = "2020-10-01";
//      row2.deaths = 30;
//      row2.cases = 30;
//      row2.tests = 23;
//      
//      Covid19[] list = new Covid19[10];
//      //---------------------------------
//      list[0] = new Covid19();
//      list[0].date = "";
//      list[0].deaths = 12;
//      //---------------------------------
//      list[1] = new Covid19();
//      list[1].date = "";
//      list[1].deaths = 12;
//            
//      Covid19 row;
//      //---------------------------------
//      row = new Covid19();
//      row.date = "2020";
//      row.deaths = 20;
//      
//      list[0] = row;
//      //----------------------------------
//      row = new Covid19();
//      row.date = "2020";
//      row.deaths = 20;
//      
//      list[1] = row;
