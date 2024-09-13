

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수
 * 2x1 = a, 1x2 = b
 * n이 1일때 a 한가지
 * n이 2일때 2a, 2b 두가지
 * n이 3일때 a + 2b, 3a, 2b + a 세가지
 * n이 4일때 2a + b + b, b + 2a + b, b + b + 2a, 4b, 4a 5가지
 *				1			2			3		4	5
 *
 * dp[i] = dp[i-1] + dp[i-2]
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		final int CONDITION = 10007; // 나머지 연산 조건

		if (n == 1) {
			System.out.println(1);
		} else {
			dp[0] = 1;
			dp[1] = 1;
			for (int i = 2; i < n + 1; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % CONDITION;
			}

			System.out.println(dp[n]);

		}
	}
}
