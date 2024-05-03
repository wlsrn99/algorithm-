

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n == 1) {
				System.out.println(1);
			} else if (n == 2) {
				System.out.println(2);
			} else if (n == 3) {
				System.out.println(4);
			} else {
				int[] arr = new int[n + 1];
				arr[1] = 1;
				arr[2] = 2;
				arr[3] = 4;

				for (int j = 4; j < n + 1; j++) {
					arr[j] = arr[j - 3] + arr[j - 2] + arr[j - 1];
				}

				System.out.println(arr[n]);
			}

		}
	}
}
