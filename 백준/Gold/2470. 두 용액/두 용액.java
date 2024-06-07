

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();

		int startPoint = 0;
		int endPoint = n - 1;

		int resultStart = 0;
		int resultEnd = n - 1;

		int resultSum = Integer.MAX_VALUE;
		while (startPoint < n - 1) {
			endPoint = lowerbound(startPoint + 1, n, -arr[startPoint]);

			// Check candidates around the found lowerbound position
			if (endPoint < n && endPoint > startPoint) {
				int currentSum = arr[startPoint] + arr[endPoint];
				if (Math.abs(currentSum) < Math.abs(resultSum)) {
					resultSum = currentSum;
					resultStart = startPoint;
					resultEnd = endPoint;
				}
			}

			if (endPoint - 1 > startPoint) {
				int currentSum = arr[startPoint] + arr[endPoint - 1];
				if (Math.abs(currentSum) < Math.abs(resultSum)) {
					resultSum = currentSum;
					resultStart = startPoint;
					resultEnd = endPoint - 1;
				}
			}

			startPoint++;
		}

		System.out.println(arr[resultStart] + " " + arr[resultEnd]);
	}

	static int lowerbound(int start, int end, int target) {
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
}
