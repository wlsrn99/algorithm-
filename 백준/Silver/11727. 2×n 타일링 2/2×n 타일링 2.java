

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1x2 = a, 2x1 = b, 2x2 = c
 * n = 1
 * b 1가지 -> 2x1 사각형
 *
 * n = 2
 * 2a, 2b, c 3가지 -> 2x2사각형
 *
 * n = 3 2x3
 * 3b, 2a + b, b + 2a, c + b, b+c  5가지
 *
 * dp[3] = dp[2] + 2*dp[1] = 3 + 2 = 5
 *
 * 2x2 + 2x1
 * 3 * 1 + 1 * 3 = 6 - 1
 *
 * n = 4 2x4
 * 2x2 2개, 2x2 1개 + 2x1 2개
 * 3 * 3, 3 * 1 -> 12 - 1가지
 * 11
 * dp[4] = dp[3] + 2*dp[2] = 5 + 6 = 11
 *
 * dp[n] = dp[n-1] + 2*dp[n-2]
 */
public class Main {
	static final int divide = 10007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % divide;
		}
		System.out.println(dp[n]);
	}
}
