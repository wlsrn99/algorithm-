

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * M과 N보다 작거나 같은 두 개의 자연수 x, y를 가지고 각 년도를 <x:y>와 같은 형식으로 표현
 * x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1
 *
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

			int m = input[0];
			int n = input[1];
			int x = input[2];
			int y = input[3];

			int result = findYear(m, n, x, y);
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}

	private static int findYear(int m, int n, int x, int y) {
		// m과 n의 최소공배수를 계산하여 최대 가능한 연도 설정
		int maxYear = findLCM(m, n);
		int year = x;

		while (year <= maxYear) {
			// 현재 연도가 x와 y 조건을 모두 만족하는지 확인
			if ((year - y) % n == 0) {
				return year;
			}
			// x 조건을 만족하는 다음 연도로 이동
			year += m;
		}

		// 조건을 만족하는 연도를 찾지 못한 경우 -1 반환
		return -1;
	}

	// 최소공배수(LCM) 계산
	private static int findLCM(int a, int b) {
		return a * b / findGCD(a, b);
	}

	// 최대공약수(GCD) 계산 - 유클리드 알고리즘 사용
	private static int findGCD(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}
