

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			/**
			 * 0 -> 0이 1
			 * 1 -> 1이 1
			 * 2 -> 1 + 0
			 * 3 -> 2 + 1
			 * 4 -> 3 + 2
			 * 5 -> 4 + 3
			 */
			if (n == 0) {
				sb.append(1).append(" ").append(0).append("\n");
			} else if (n == 1) {
				sb.append(0).append(" ").append(1).append("\n");
			} else {
				int[] dp0 = new int[n + 1];
				dp0[0] = 1;
				int[] dp1 = new int[n + 1];
				dp1[1] = 1;

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
