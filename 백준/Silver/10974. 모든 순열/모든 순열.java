

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] arr;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if (depth == n) {
			for (int i = 0; i < n; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
