

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N이 주어졌을 때, P(N)을 구하는 프로그램
 * P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
 *
 * arr[1] = 1
 * arr[2] = 1
 * arr[3] = 1
 * arr[4] = 2
 * arr[5] = 2
 * arr[6] = 3
 * arr[7] = 4 -> arr[4] + arr[5]
 * arr[8] = 5 -> arr[5] + arr[6]
 * arr[9] = 7 -> arr[6] + arr[7]
 * arr[10] = 9
 *
 * arr[i] = arr[i-3] + arr[i-2]
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 1 || n == 2) {
				sb.append("1").append("\n");
			} else {
				long[] dp = new long[n + 1];
				dp[1] = 1;
				dp[2] = 1;
				for (int j = 3; j < n + 1; j++) {
					dp[j] = dp[j - 3] + dp[j - 2];
				}
				sb.append(dp[n]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
