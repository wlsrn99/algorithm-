

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
		while (startPoint < endPoint) {
			int currentSum = arr[startPoint] + arr[endPoint];
			
			if (Math.abs(currentSum) < Math.abs(resultSum)) {
				resultSum = currentSum;
				resultStart = startPoint;
				resultEnd = endPoint;
			}

			// 현재 합이 0보다 크면 endPoint를 감소시켜야 함
			if (currentSum > 0) {
				endPoint--;
			} else {
				startPoint++;
			}
		}

		System.out.println(arr[resultStart] + " " + arr[resultEnd]);
	}
}
