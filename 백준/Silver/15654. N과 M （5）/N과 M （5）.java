

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * N개의 자연수 중에서 M개를 고른 수열
 *
 *  N개의 자연수는 모두 다른 수이다.
 *
 *  수열은 사전 순으로 증가하는 순서로 출력
 */
public class Main {
	static int[] arr;
	static int n, m;
	static boolean[] visited;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		n = input[0];
		m = input[1];
		visited = new boolean[n];

		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();

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

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sequence[idx] = arr[i];
				findSequence(idx + 1, sequence);
				visited[i] = false;
			}
		}
	}
}
