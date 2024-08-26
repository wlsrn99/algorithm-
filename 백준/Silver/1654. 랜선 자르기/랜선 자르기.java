

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static long[] arr;
	static int k, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		k = input[0];
		n = input[1];

		arr = new long[k];
		for (int i = 0; i < k; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(arr);

		long start = 1;
		long end = arr[k - 1];
		long result = 0;

		while (start <= end) {
			long mid = start + (end - start) / 2; // 오버플로우 방지

			if (check(mid)) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(result);
	}

	private static boolean check(long mid) {
		long sum = 0;
		for (long one : arr) {
			sum += one / mid;
		}

		return sum >= n; // 조건 변경
	}
}