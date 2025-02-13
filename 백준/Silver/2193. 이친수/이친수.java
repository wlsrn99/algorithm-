
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이친수는 0으로 시작하지 않는다.
 * 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다
 *
 * 101
 * 100
 * -> 첫번째 1, 두번째 0 고정
 *
 * -> 세번째가 1이라면 네번째는 0고정
 * -> 세번째가 0이라면 네번째는 1또는 0
 *
 * n= 3, 2
 * ----------------------------
 * 1010
 * 1001
 * 1000
 * n = 4, 3
 * -----------------
 * 10101
 * 10100
 *
 * 10010
 * 10000
 * 10001
 *
 * n = 5, 5
 *
 * i = [i-1] + [i-2]
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n == 1 || n == 2) {
			System.out.println(1);
		} else {
			long[] dp = new long[n + 1];
			dp[1] = 1;
			dp[2] = 1;
			for (int i = 3; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			System.out.println(dp[n]);
		}
	}
}
