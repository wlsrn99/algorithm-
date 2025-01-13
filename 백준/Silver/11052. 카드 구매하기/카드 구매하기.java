
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 민규는 돈을 최대한 많이 지불해서 카드 N개 구매하려고 한다.
 *
 * 인덱스 = 들어있는 카드의 개수
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cost = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int[] dp = new int[n + 1]; // i개의 카드를 살 때의 최대 비용

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				// j개 카드팩을 사고 남은 카드에 대한 최대 비용을 더함
				dp[i] = Math.max(dp[i], cost[j - 1] + dp[i - j]);
			}
		}

		System.out.println(dp[n]);
	}
}
