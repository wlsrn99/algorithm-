

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분해합은 N과 N을 이루는 각 자리수의 합
 * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자
 * 245의 분해합은 256(=245+2+4+5)
 *
 * 생성자가 없는 경우에는 0
 *
 *
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int num = input;

		int min = 0;

		while (num > 0) {
			num -= 1;

			int current = num;
			int sum = current;

			while (current > 0) {
				sum += current % 10;
				current /= 10;
			}

			if (sum == input) {
				min = num;
			}

			// if (sum < input) {
			// 	break;
			// }

		}
		System.out.println(min);
	}
}
