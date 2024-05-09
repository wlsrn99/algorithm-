

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static long[] arr;

	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int k = input[0];
		n = input[1];

		arr = new long[k];
		for (int i = 0; i < k; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(arr);

		long start = 1L;
		long end = arr[k - 1];
		long result = 0;

		while (start <= end) {
			long mid = (start + end) / 2;

			if (check(mid)) {
				end = mid - 1;
			} else {
				result = mid;
				start = mid + 1;
			}
		}

		System.out.println(result);
	}

	private static boolean check(long mid) {
		int sum = 0;
		for (long one : arr) {
			sum += one / mid;
		}

		if (sum < n) {
			return true;
		}
		return false;
	}

}
