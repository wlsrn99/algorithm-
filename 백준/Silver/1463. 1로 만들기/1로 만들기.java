

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 연산을 사용하는 횟수의 최솟값
 * 시간 0.15초 -> dp
 *
 * arr[n+1] 배열을 생성, arr[0]은 사용하지 않음
 * 최솟값
 *
 * arr[1] = 1
 * arr[2] = 1
 * arr[3] = 1
 *
 * x > 3
 * arr[4] = arr[1] + arr[3] -> arr[x] = arr[x-3] + arr[x-1]
 * arr[5] = arr[2] + arr[3] -> arr[x] = arr[x-3] + arr[x-2]
 * arr[6] = arr[3] + arr[3] -> arr[x] = arr[x-3] + arr[x-3]
 *
 * arr[7] = arr[1] + arr[6] -> arr[x] = arr[x-6] + arr[x-1]
 * arr[8] = arr[2] + arr[6] -> arr[x] = arr[x-6] + arr[x-2]
 *
 * ---------------------------------------------------------
 * 잘못생각함
 *
 * 1을 빼는 연산을 전부 수행시키기
 * 2로 나누어 떨어질 때 dp[x/2] + 1
 * 3으로 나누어 떨어질 때 dp[x/3] + 1
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if (n == 1) { //1일때는 수행횟수 0
			System.out.println(0);
		} else if (n == 2 || n == 3) {
			System.out.println(1);
		} else {
			int[] dp = new int[n + 1];
			dp[2] = 1;
			dp[3] = 1;
			for (int i = 2; i < n + 1; i++) {
				dp[i] = dp[i - 1] + 1; // 1을 빼는 경우 전부 수행

				if (i % 2 == 0) {
					dp[i] = Math.min(dp[i], dp[i / 2] + 1);
				}

				if (i % 3 == 0) {
					dp[i] = Math.min(dp[i], dp[i / 3] + 1);
				}
			}

			System.out.println(dp[n]);
		}
	}
}

