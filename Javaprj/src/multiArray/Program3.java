package multiArray;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) throws IOException {
		String[][] rows;
		int count = 0;
		// 레코드 개수를 알아내는 코드 (count)
		{
			FileInputStream text = new FileInputStream("res/covid.txt");
			Scanner sc = new Scanner(text);
			String line = sc.nextLine();

			// while 반복하면서 count++연산을한다 ->마지막 줄을 만날 때까지
			while (sc.hasNext()) {
				line = sc.nextLine();
				count++;
			}

			System.out.printf("카운터 : %d\n", count);

		}

		
		// count에서 받은 값으로 총 몇줄인지 알았으니까 그것으로 배열에다가 값을 저장하는 코드
		{
			rows = new String[count][];
			FileInputStream text = new FileInputStream("res/covid.txt");
			Scanner sc = new Scanner(text);
			String line = sc.nextLine();

			for (int i = 0; i < count; i++) {
				line = sc.nextLine();
				rows[i] = line.split(",");
			}

		}

		// 배열에 저장된 값을 몇번째 항목인지 찾아서 그걸 합하는 코드
		{
			int total = 0;

			for (int i = 0; i < count; i++) {
				total += Integer.parseInt(rows[i][3]); // rows[i] 처음부터 끝까지 줄에 값을 더해야하니까 포분을 돌려주는거임
			}

			System.out.printf("검사진행자수 총 합: %d\n", total);

		}
		{
			// 가장 많은 검사수와 그 날자.
			int max = 0;
			int index = -1;
			for (int i = 0; i < count; i++) {
				if (Integer.parseInt(rows[i][3]) > max) {
					max = Integer.parseInt(rows[i][3]);
					index = i;
				}
			}
			System.out.printf("가장 많은 검사수 : %d\n", max);
			System.out.printf("검사수가 가장 많았던 날 : %s\n", rows[index][0]);
		}

		// 확진자 수가 늘어난 일자와 수를 출력하시오.
		{

			String dates = ""; // 날자는 문자열이니까 문자열을 담을 변수 선언
			int diff = 0; // 늘어난 수를 저장할 변수

			int old = 0; // 현재 확진자 수

			int index = 0;

			for (int i = 0; i < count; i++) {
				int currents = Integer.parseInt(rows[i][1]);

				if (old != currents) { // 확진자수와 입력받은 i열에 확진자수가 같지 않다면

					diff = currents - old;

					dates = rows[i][0]; // 날자

					old = currents;

					System.out.printf("%d : %s, %d\n", index++ + 1, dates, diff);
				}

			}
		}

		// 확진자 수가 늘어난 일자와 수를 다음 배열에 담아주시오.
		String[][] results;
		int resultcount = 0;

		{
			int old = 0;

			for (int i = 0; i < count; i++) {
				int currents = Integer.parseInt(rows[i][1]); // i번째 행의 확진자수

				// i번째 확진자(current)와 이전 확진자수(old)가 다르다면
				if (old != currents) {
					old = currents;
					resultcount++;
//					diff = currents - old;

				}

			}

			System.out.println(resultcount);

			results = new String[resultcount][];
			// 이름표 //공간(객체) 공간은 아직 할당x
			// 물리적으로는 이름도 공간이 있긴함 이름표도 주소를 저장해야하니까(4byte)
			String date = ""; // 날짜
			int diff = 0; // 증가수
			old = 0; // 담을 값
			int index = 0;

			for (int i = 0; i < count; i++) {
				int current = Integer.parseInt(rows[i][1]);
				if (old != current) {
					diff = current - old;
					old = current;
					date = rows[i][0];

					String[] row = new String[2];
					row[0] = date; // 날짜
					row[1] = String.valueOf(diff); // 늘어난 수 row에 넣어야하니까 row는 String으로 선언되었으니 형변환해줌

					results[index++] = row;

//					System.out.printf("%s %d\n",date,diff);
				}

			}
			for (int i = 0; i < resultcount; i++) {
				System.out.printf("%s %s\n", results[i][0], results[i][1]);
			}

		}
	}
}
