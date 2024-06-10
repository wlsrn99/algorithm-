

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 노드의 위치 정보와 거리 정보를 가지고 있는 클래스를 생성
 * 그 클래스로 그래프를 구성하면 될 것 같다
 *
 * 반환값이 있으면 좋을 것 같아서 bfs가 더 좋을 것 같다
 */
public class Main {
	static ArrayList<ArrayList<NodeInfo>> nodeList = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		visited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			input = br.readLine().split(" ");
			int node1 = Integer.parseInt(input[0]);
			int node2 = Integer.parseInt(input[1]);
			int distance = Integer.parseInt(input[2]);

			nodeList.get(node1).add(new NodeInfo(node2, distance));
			nodeList.get(node2).add(new NodeInfo(node1, distance));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);

			sb.append(bfs(start, end)).append("\n");
			Arrays.fill(visited, false);
		}

		System.out.println(sb);
	}

	private static int bfs(int start, int end) {
		Queue<NodeInfo> queue = new LinkedList<>();
		queue.add(new NodeInfo(start, 0));
		visited[start] = true;
		while (!queue.isEmpty()) {
			NodeInfo current = queue.poll();
			if (current.node == end) {
				return current.distance;
			}
			for (NodeInfo next : nodeList.get(current.node)) {
				if (!visited[next.node]) {
					visited[next.node] = true;
					queue.add(new NodeInfo(next.node, current.distance + next.distance));
				}
			}
		}
		return -1;
	}

	private static class NodeInfo {
		int node;
		int distance;

		public NodeInfo(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}
}
