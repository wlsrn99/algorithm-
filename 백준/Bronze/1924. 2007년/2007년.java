

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);

		LocalDate date = LocalDate.of(2007, x, y);

		/**
		 * 문자열 변환 후 DAY부분 짜르기
		 * ex) MONDAY -> MON
		 */
		System.out.println(date.getDayOfWeek().toString().substring(0, 3));
	}
}
