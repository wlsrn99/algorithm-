

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = 666;

		int count = 0;
		boolean run = true;

		while (run) {
			String strNum = Integer.toString(num);
			if (strNum.contains("666")) {
				count++;
			}

			if (count == n) {
				break;
			}

			num++;
		}

		System.out.println(num);
	}
}
