

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수

수열은 사전 순으로 증가하는 순서로 출력
 */
public class Main {
	static int n, m;

	static StringBuilder sb = new StringBuilder();

	static boolean[] visited;

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		// N개의 자연수
		n = input[0];
		// M개를 고름
		m = input[1];

		visited = new boolean[n];

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);

		int[] comArr = new int[m];

		doCalculate(m, 0, 0, comArr);

		System.out.println(sb);
	}

	private static void doCalculate(int r, int startIdx, int idx, int[] comArr) {
		if (r == 0) {
			// 수열 출력
			for (int result : comArr) {
				sb.append(result).append(" ");
			}
			sb.append("\n");
			return;
		}

		if (startIdx == n) {
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					comArr[idx] = arr[i];
					doCalculate(r - 1, startIdx + 1, idx + 1, comArr);
					visited[i] = false;
				}
			}
		}
	}
}
