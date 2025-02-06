
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		List<Integer> list = new ArrayList<>();

		for (int num : arr) {
			// 이분 탐색으로 num이 들어갈 위치를 찾음
			int idx = lowerBound(list, num);

			if (idx == list.size()) {
				// num이 가장 큰 값이라면 리스트에 추가
				list.add(num);
			} else {
				// num이 들어갈 위치에 기존 값을 대체
				list.set(idx, num);
			}
		}

		System.out.println(list.size());
	}

	private static int lowerBound(List<Integer> list, int target) {
		int start = 0;
		int end = list.size() - 1;

		int result = end + 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (list.get(mid) >= target) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return result;
	}
}
