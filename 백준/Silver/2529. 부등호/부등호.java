

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] visited;
	static String[] sign;

	static int k;

	static long min = 9876543210L;

	static long max = 0L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		sign = br.readLine().split(" ");
		visited = new boolean[10];

		for (int i = 0; i < 10; i++) {
			visited[i] = true;
			bfs(0, "" + i, i);
			visited[i] = false;
		}
		String maxResult = "" + max;
		String minResult = "" + min;

		if (maxResult.length() < k + 1) {
			maxResult = "0" + max;
		}

		if (minResult.length() < k + 1) {
			minResult = "0" + min;
		}

		System.out.println(maxResult);
		System.out.println(minResult);
	}

	private static void bfs(int depth, String candidateNum, int num) {
		if (depth == k) {
			long result = Long.parseLong(candidateNum);
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		boolean direction = false;
		if (sign[depth].equals("<")) {
			direction = true;
		}

		for (int i = 0; i < 10; i++) {
			if (!visited[i]) {
				calculate(depth, candidateNum, num, direction, i);
			}
		}
	}

	private static void calculate(int depth, String candidateNum, int num, boolean direction, int i) {
		if (direction) {
			if (num < i) {
				visited[i] = true;
				bfs(depth + 1, candidateNum + i, i);
				visited[i] = false;
			}
		} else {
			if (num > i) {
				visited[i] = true;
				bfs(depth + 1, candidateNum + i, i);
				visited[i] = false;
			}
		}
	}
}
