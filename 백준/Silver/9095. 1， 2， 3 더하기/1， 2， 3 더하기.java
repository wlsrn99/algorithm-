

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n을 1, 2, 3의 합으로 나타내는 방법의 수
 * 1 -> 1가지
 * 2 -> 2가지
 * 3 -> 1 + 1 + 1
 *      1 + 2
 *      2 + 1
 *      3
 *      4가지
 *
 * 4 -> 1 + 1 + 1 + 1
 *      1 + 1 + 2
 *      1 + 2 + 1
 *      1 + 3
 *      2 + 1 + 1
 *      3 + 1
 *      1+3
 *      7가지
 *
 * 5 -> 1 + 1 + 1 + 1 + 1
 *      1 + 1 + 1 + 2
 *      1 + 1 + 2 + 1
 *      1 + 2 + 1 + 1
 *      2 + 1 + 1 + 1
 *      1 + 2 + 2
 *      2 + 1 + 2
 *      2 + 2 + 1
 *      1 + 1 + 3
 *      1 + 3 + 1
 *      3 + 1 + 1
 *      2 + 3
 *      3 + 2
 *
 *      13가지
 *
 *  i = [i - 1] + [i - 2] + [i - 3]
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 1) {
				sb.append("1").append("\n");
			} else if (n == 2) {
				sb.append("2").append("\n");
			} else if (n == 3) {
				sb.append("4").append("\n");
			} else {
				int[] dp = new int[n + 1];
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;

				for (int j = 4; j < n + 1; j++) {
					dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
				}

				sb.append(dp[n]).append("\n");
			}
		}
		System.out.println(sb);
	}
}

