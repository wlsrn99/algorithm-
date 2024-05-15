import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] stairs = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = stairs[1];
		if (n >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}

		for (int i = 3; i <= n; i++) {
            //첫번째 && 세번째
            //두번째 && 세번째
			dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
		}

		System.out.println(dp[n]);

	}
}
