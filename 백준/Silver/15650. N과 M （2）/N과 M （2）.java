

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다
 */
public class Main {
	static int n, m;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		n = input[0];
		m = input[1];

		int[] arr = new int[m];

		visited = new boolean[n + 1];
		findSequence(0, arr);
		System.out.println(sb);
	}

	static void findSequence(int idx, int[] arr) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[idx] = i; // 선택된 숫자를 수열에 추가
				findSequence(idx + 1, arr); // 다음 숫자를 선택하기 위해 재귀 호출
				for (int j = i + 1; j <= n; j++) {
					visited[j] = false;
				}
			}
		}
	}
}

