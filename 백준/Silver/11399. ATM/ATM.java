

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값
 *  오름차순 정렬 후 더하기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();

		for (int i = 1; i < n; i++) {
			arr[i] = arr[i] + arr[i - 1];
		}
		
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		System.out.println(sum);
	}
}
