

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 이다
 * 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = 666;

		int count = 0;

		while (true) {
			String strNum = Integer.toString(num);
			if (strNum.contains("666")) {
				count++;
			}

			if (count == n) {
				break;
			}

			num++;
		}

		System.out.println(num);
	}
}
