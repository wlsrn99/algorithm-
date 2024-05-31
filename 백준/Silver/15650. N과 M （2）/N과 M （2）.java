

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n, m;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		n = input[0];
		m = input[1];

		int[] sequence = new int[m]; //크기 m의 수열을 담을 배열

		visited = new boolean[n + 1];
		findSequence(0, sequence);
		System.out.println(sb);
	}

	static void findSequence(int idx, int[] sequnce) {
		if (idx == m) { // 주어진 수열의 크기만큼 수를 선택했을 때
			for (int i = 0; i < m; i++) {
				sb.append(sequnce[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sequnce[idx] = i; // 선택된 숫자를 수열에 추가
				findSequence(idx + 1, sequnce); // 다음 숫자를 선택하기 위해 재귀 호출
				for (int j = i + 1; j <= n; j++) {
					visited[j] = false; // 재귀가 종료되면 해당 숫자를 다시 선택 가능하도록 해제
				}
			}
		}
	}
}

