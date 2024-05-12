

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int m = input[0];
		int n = input[1];

		StringBuilder sb = new StringBuilder();

		if (m == 1) {
			m++;
		}

		while (m <= n) {
			if (m == 2) {
				sb.append(m).append("\n");
				m++;
				continue;
			}

			if (isPrime(m)) {
				sb.append(m).append("\n");
			}

			m++;
		}

		System.out.println(sb);
	}

	private static boolean isPrime(int n) {
		int newN = (int)Math.sqrt(n) + 1;
		for (int i = 2; i < newN; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}
