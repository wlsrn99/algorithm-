
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 0 ≤ n ≤ 250
		BigInteger[] dp = new BigInteger[251];
		dp[0] = BigInteger.ONE; // dp[0] = 1
		dp[1] = BigInteger.ONE; // dp[1] = 1

		for (int i = 2; i <= 250; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.TWO));
		}

		StringBuilder sb = new StringBuilder();
		String input;

		while ((input = br.readLine()) != null) {
			int n = Integer.parseInt(input);
			sb.append(dp[n]).append("\n");
		}

		System.out.print(sb);

	}
}

