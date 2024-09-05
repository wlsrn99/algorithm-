

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		n = input[0]; // n개의 자연수
		m = input[1]; // m개를 고른 수열
		visited = new boolean[n];

		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();

		int[] result = new int[m];
		calculate(result, 0);
		System.out.println(sb);
	}

	private static void calculate(int[] result, int count) {
		if (count == m) {
			for (int i : result) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
					continue; // 같은 레벨에서 이전 숫자와 같고, 이전 숫자를 사용하지 않았다면 스킵
				}
				visited[i] = true;
				result[count] = arr[i];
				calculate(result, count + 1);
				visited[i] = false;
			}
		}
	}
}