

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * N개의 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순
 * 수열은 사전 순으로 증가하는 순서로 출력
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		n = input[0];
		m = input[1];
		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.distinct()
			.toArray();
		n = arr.length;

		int[] sequence = new int[m];
		findSequence(0, sequence);
		System.out.println(sb);
	}

	private static void findSequence(int idx, int[] sequence) {
		if (idx == m) {
			for (int i : sequence) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		/**
		 * 1. 현재 숫자와 같거나 큰 숫자
		 */
		for (int i = 0; i < n; i++) {
			if (idx > 0 && sequence[idx - 1] > arr[i]) {
				continue;
			}
			sequence[idx] = arr[i];
			findSequence(idx + 1, sequence);
		}
	}
}
