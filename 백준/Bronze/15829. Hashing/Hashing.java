import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();

		long sum = 0;
		long power = 1;
		final int MOD = 1234567891;
		final int BASE = 31;

		for (int i = 0; i < n; i++) {
			char one = input.charAt(i);
			int value = one - 'a' + 1;

			sum = (sum + (value * power) % MOD) % MOD;
			power = (power * BASE) % MOD;
		}
		System.out.println(sum);
	}
}
