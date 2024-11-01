

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 0.5 초 (추가 시간 없음) -> dp
 *
 * 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
 * N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
 * i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] cost;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		cost = new int[n][3];
		dp = new int[n][3];

		for (int i = 0; i < n; i++) {
			cost[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		}

		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		for (int i = 1; i < n; i++) {
			dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		
		int min = Arrays.stream(dp[n - 1]).min().getAsInt();
		System.out.println(min);
	}
}
