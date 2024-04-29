

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;

		while (n >= 0) {
			if (n % 5 == 0) {
				count += n / 5;
				System.out.println(count);
				break;
			}
			n -= 3;
			count += 1;
		}
		if (n < 0) {
			System.out.println(-1);
		}

	}
}
