

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();

			if (input.equals("0")) {
				break;
			}

			boolean check = true;
			int len = input.length();

			for (int i = 0; i < len / 2; i++) {
				if (input.charAt(i) != input.charAt(len - 1 - i)) {
					check = false;
					break;
				}
			}

			sb.append(check ? "yes" : "no").append("\n");
		}

		System.out.print(sb);
	}
}