

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현
 * n을 최소 개수의 제곱수 합
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(calculate(n));
	}

	public static int calculate(int n) {
		if (isSquare(n)) {
			return 1;
		}

		// n에서 어떤 제곱수를 뺀 결과가 제곱수인 경우
		for (int i = 1; i * i <= n; i++) {
			if (isSquare(n - i * i)) {
				return 2;
			}
		}

		// n에서 어떤 두 제곱수를 뺀 결과가 제곱수인 경우
		for (int i = 1; i * i <= n; i++) {
			for (int j = 1; i * i + j * j <= n; j++) {
				if (isSquare(n - i * i - j * j)) {
					return 3;
				}
			}
		}

		// 해당하지 않으면 4개의 제곱수
		return 4;
	}

	public static boolean isSquare(int n) {
		int sqrt = (int)Math.sqrt(n);
		return sqrt * sqrt == n;
	}
}
