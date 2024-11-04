

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때,
 * 이제까지 선택된 수의 합이 최대가 되는 경로
 *
 * 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택
 *
 * 맨 아래 0번째 인덱스부터 시작해서 2개씩 비교한 뒤 큰 값을 위에있는 배열에 저장
 *
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] triangle;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		triangle = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			triangle[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		}
		dp[n - 1] = triangle[n - 1];

		// n(1 ≤ n ≤ 500)
		if (n == 1) { // n이 1일때 예외
			System.out.println(triangle[0][0]);
		} else {
			for (int i = n - 2; i >= 0; i--) {
				for (int j = 0; j <= i; j++) {
					dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
				}
			}
			// int max = Math.max(dp[1][0], dp[1][1]);
			System.out.println(dp[0][0]);
		}

	}
}
