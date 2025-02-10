
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 종료 날짜를 기준으로 최댓값 비교 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] period = new int[n + 1]; // 상담 기간
		int[] cost = new int[n + 1]; // 상담 금액
		
		// 7일에 1일짜리 상담을 할 수도 있으므로 n+2로 설정
		int[] dp = new int[n + 2];

		for (int i = 1; i <= n; i++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

			period[i] = input[0];
			cost[i] = input[1];
		}

		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);

			int end = i + period[i] - 1; // 종료 날짜
			if (end <= n) {
				// 종료날짜 기준으로 비교 
				dp[end + 1] = Math.max(dp[end + 1], dp[i] + cost[i]);
			}
		}

		System.out.println(Math.max(dp[n], dp[n + 1]));
	}
}
