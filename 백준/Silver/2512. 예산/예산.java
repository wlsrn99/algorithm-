
/**

 가능한 한 최대의 총 예산
 특정한 정수 상한액을 계산 -> 이분탐색
 365
 255
 127
 예산 정렬 후 현재 요청한 예산과 다음 요청한 예산의 합이 현재 예산보다 클 경우 상한값을 정하기
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
		if (arr[n - 1] > max) {
			max -= 1;
		} else {
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
