
/**
 *  가능한 한 최대의 총 예산
 *  특정한 정수 상한액을 계산 -> 이분탐색
 *
 *  상한액 - 배열의 합이 예산이 되는 상한 값 - 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();
		m = Integer.parseInt(br.readLine());

		int start = 0;
		int end = arr[n - 1];

		int max = upperbound(start, end, m);
		if (arr[n - 1] > max) { //배열의 최대 값이 상한값 보다 큰 경우 대체 되어야 한다
			max -= 1;
		} else { //아닌 경우 그대로 유지
			max = arr[n - 1];
		}

		System.out.println(max);
	}

	static int upperbound(int start, int end, int target) {

		while (start < end) {
			int mid = (start + end) / 2;
			int sum = getSum(mid);

			if (sum > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

	private static int getSum(int mid) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > mid) {
				sum += mid;
			} else {
				sum += arr[i];
			}
		}
		return sum;
	}
}
