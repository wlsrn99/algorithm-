

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = input[0];
		int m = input[1];

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		//DP배열
		int[] dp = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			dp[i] = dp[i - 1] + arr[i - 1];
		}

		StringBuilder sb = new StringBuilder();
		for (int nCase = 0; nCase < m; nCase++) {
			String[] range = br.readLine().split(" ");

			int i = Integer.parseInt(range[0]);
			int j = Integer.parseInt(range[1]);

			// 범위의 합 = 0 ~ j 까지에서 0 ~ i - 1까지를 뺀 거
			int sum = dp[j] - dp[i - 1];
			sb.append(sum).append("\n");
		}

		System.out.println(sb);
	}
}
