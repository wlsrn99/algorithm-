

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/**
	 *
	 * 각 문자에 31의 거듭제곱 후 더하기
	 * a의 아스키 값이 97, 각 문자에 96을 빼주면 주어진 숫자가 나온다
	 *
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();

		long sum = 0;
		for (int i = 0; i < n; i++) {
			char one = input.charAt(i);
			long sequence = one - 96;

			long square = (long)Math.pow(31, i);
			sum += sequence * square;
		}
		System.out.println(sum);

	}
}
