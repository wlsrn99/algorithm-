

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 케빈 베이컨의 수가 가장 작은 사람
 * 케빈 베이컨 수는 모든 사람과 케빈 베이컨 게임을 했을 때, 나오는 단계의 합
 *
 *
 */
public class Main {
	static List<List<Integer>> nodeList = new ArrayList<>();
	static int[] person;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		int m = input[1];
		person = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 1; i <= m; i++) {
			input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

			int v1 = input[0];
			int v2 = input[1];
			nodeList.get(v1).add(v2);
			nodeList.get(v2).add(v1);
		}

		for (int i = 1; i <= n; i++) {
			bfs(i, n);
		}

		int min = Integer.MAX_VALUE;
		int idx = 101;
		for (int i = 1; i <= n; i++) {
			if (person[i] < min) {
				min = person[i];
				idx = i;
			}
		}
		System.out.println(idx);
	}

	private static void bfs(int start, int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		boolean[] visited = new boolean[n + 1];
		visited[start] = true;
		int[] distance = new int[n + 1];

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next : nodeList.get(current)) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
					distance[next] = distance[current] + 1;
					person[start] += distance[next];
				}
			}
		}
	}
}
