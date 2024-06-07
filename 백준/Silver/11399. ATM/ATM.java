

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 시간의 합의 최솟값 -> 오름차순 정렬 후 더한값 + 현재 값 더하기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();

		int resultSum = 0;
		int sum = 0;
		for (int minute : arr) {
			resultSum += sum + minute;
			sum += minute;
		}

		System.out.println(resultSum);
	}
}
