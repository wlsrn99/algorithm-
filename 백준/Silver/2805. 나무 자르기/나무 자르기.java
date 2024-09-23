

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 절단기에 높이 H를 지정
 * 나무의 높이의 합은 항상 M보다 크거나 같다
 * 높이는 1,000,000,000 -> 높이의 합 = long
 *
 * M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값
 * 톱날이 땅으로부터 H미터 위
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		int m = input[1];

		int[] tree = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();

		int start = 0;
		int end = tree[n - 1];

		int result = binarysearch(start, end, n, tree, m);
		System.out.println(result);
	}

	private static int binarysearch(int start, int end, int n, int[] tree, int m) {
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2; //나무의 길이가 될 수 있는 후보들
			long sum = 0;

			for (int i = 0; i < n; i++) {
				if (tree[i] > mid) {//설정한 길이보다 큰 나무만 자르기
					sum += tree[i] - mid;
				}
			}

			if (sum >= m) { //계산한 나무의 합이 필요한 나무의 길이와 크다면 설정한 높이를 높이기
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return end;
	}
}