

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * fibonacci(1)과 fibonacci(0)이 출력되는 횟수
 * 
 * 0 -> f(0) 
 * 1 -> f(1)
 * 2 -> f(1) + f(0) / 1 1
 * 3 -> f(2) + f(1) = 2f(1) + f(0) / 2 1
 * 4 -> f(3) + f(2) = 3f(1) + 2f(0)
 * 5 -> f(4) + f(3) = 5f(1) + 3f(0)
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				sb.append(1).append(" ").append(0).append("\n");
			} else if (n == 1) {
				sb.append(0).append(" ").append(1).append("\n");
			} else {
				int[] dp0 = new int[n + 1];
				dp0[0] = 1; // fibonacci(0)
				int[] dp1 = new int[n + 1];
				dp1[1] = 1; // fibonacci(1)

				for (int j = 2; j <= n; j++) {
					dp0[j] = dp0[j - 1] + dp0[j - 2];
					dp1[j] = dp1[j - 1] + dp1[j - 2];
				}

				sb.append(dp0[n]).append(" ").append(dp1[n]).append("\n");
			}

		}
		System.out.println(sb);
	}
}
