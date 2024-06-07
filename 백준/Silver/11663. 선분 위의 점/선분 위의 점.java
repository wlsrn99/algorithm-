

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); // 점의 개수
		int m = Integer.parseInt(input[1]); // 선분의 개수

		target = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray(); // 점 배열을 정렬

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int count = countPointsInSegment(start, end);
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static int countPointsInSegment(int start, int end) {
		int left = lowerBound(target, start);
		int right = upperBound(target, end);
		return right - left;
	}

	private static int lowerBound(int[] array, int value) {
		int left = 0, right = array.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (array[mid] < value) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	private static int upperBound(int[] array, int value) {
		int left = 0, right = array.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (array[mid] <= value) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
