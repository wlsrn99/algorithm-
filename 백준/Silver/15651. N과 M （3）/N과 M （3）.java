

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		n = input[0];
		m = input[1];

		int[] arr = new int[m];
		dfs(0, arr);

		System.out.println(sb);
	}

	private static void dfs(int idx, int[] arr) {
		if (idx == m) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			arr[idx] = i;
			dfs(idx + 1, arr);
		}
	}
}
