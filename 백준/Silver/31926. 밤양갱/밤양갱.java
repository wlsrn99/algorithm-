

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		/**
		 * n = 2일때
		 * 달디달고 달디달고 달디단
		 * daldi + dal + go + daldidalgo + daldida + n
		 * 5 + 1 + 2 + 1 + 1 + 1
		 *
		 * n = 10일때
		 *
		 */

		// 1번째 달디달고
		int firstCount = 8;
		int secondCount = 0;

		long daldidalgoCount = 1;
		while (daldidalgoCount < n) {
			daldidalgoCount += daldidalgoCount;

			secondCount++;
		}

		if (daldidalgoCount != n) {
			secondCount++;
		} else {
			secondCount += 2;
		}

		System.out.println(firstCount + secondCount);

	}
}
