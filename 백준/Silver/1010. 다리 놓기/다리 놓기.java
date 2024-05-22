

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int n = input[0];
			int m = input[1];

			dp = new int[m + 1][n + 1];
			System.out.println(combination(m, n));
		}
	}

	static int combination(int n, int r) {
		// 0개 또는 n개를 선택하는 경우
		if (r == 0 || n == r)
			return 1;

		// 이미 계산된 값이 있다면 그 값을 반환
		if (dp[n][r] != 0)
			return dp[n][r];

		return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}
}
