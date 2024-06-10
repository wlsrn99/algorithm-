

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 첫 시작한 노드의 간선과 연결되어 있는 모든 노드가 감염된다
 * dfs,bfs아무거나 써도 될 것 같다
 *
 */
public class Main {
	static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int node = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());

		visited = new boolean[node + 1];
		for (int i = 0; i < node + 1; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < edge; i++) {
			String[] input = br.readLine().split(" ");
			int node1 = Integer.parseInt(input[0]);
			int node2 = Integer.parseInt(input[1]);

			nodeList.get(node1).add(node2);
			nodeList.get(node2).add(node1);
		}

		int result = bfs(1);
		System.out.println(result);

	}

	private static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		int count = 0;

		while (!queue.isEmpty()) {
			for (int next : nodeList.get(queue.poll())) {
				if (!visited[next]) {
					queue.offer(next);
					visited[next] = true;
					count++;
				}
			}
		}
		return count;
	}
}
