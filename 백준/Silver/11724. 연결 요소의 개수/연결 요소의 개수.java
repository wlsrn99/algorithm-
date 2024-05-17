

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static boolean[] visited;
	static List<ArrayList<Integer>> nodeList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		int m = input[1];

		visited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			nodeList.get(input[0]).add(input[1]);
			nodeList.get(input[1]).add(input[0]);
		}

		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				count++;
				bfs(i);
			}
		}

		System.out.println(count);

	}

	private static void bfs(int i) {
		Queue<ArrayList> queue = new LinkedList<>();
		visited[i] = true;
		queue.add(nodeList.get(i));

		while (!queue.isEmpty()) {
			ArrayList<Integer> current = queue.poll();
			for (int next : current) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(nodeList.get(next));
				}
			}
		}
	}
}
