

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

		long start = 0;  // 0부터 시작
		long end = arr[k - 1] + 1;  // 상한을 위해 +1

		long result = upperbound(start, end);

		System.out.println(result - 1);  // 결과는 상한 - 1
	}

	private static long upperbound(long start, long end) {
		while (start < end) {
			long mid = start + (end - start) / 2;

			if (check(mid)) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
	}

	private static boolean check(long mid) {
		if (mid == 0)
			return true;  // 0으로 나누는 것 방지
		long sum = 0;
		for (long one : arr) {
			sum += one / mid;
		}
		return sum >= n;
	}
}