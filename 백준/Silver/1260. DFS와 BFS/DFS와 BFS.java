

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static List<ArrayList<Integer>> nodeList = new ArrayList<>();

	static StringBuilder sb = new StringBuilder();
	static boolean dfsVisited[];

	static boolean bfsVisited[];

	static int m, v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		m = input[1];
		v = input[2];

		dfsVisited = new boolean[n + 1];
		bfsVisited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			nodeList.get(input[0]).add(input[1]);
			nodeList.get(input[1]).add(input[0]);
		}

		for (int i = 0; i < n + 1; i++) {
			Collections.sort(nodeList.get(i));
		}

		sb.append(v).append(" ");
		dfs(v);
		sb.append("\n").append(v).append(" ");
		bfs(v);
		System.out.println(sb);

	}

	private static void dfs(int start) {
		dfsVisited[start] = true;
		for (int current : nodeList.get(start)) {
			if (!dfsVisited[current]) {
				sb.append(current).append(" ");
				dfs(current);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		bfsVisited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : nodeList.get(current)) {
				if (!bfsVisited[next]) {
					bfsVisited[next] = true;
					queue.offer(next);
					sb.append(next).append(" ");
				}
			}
		}
	}
}
