

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램
 *
 */
public class Main {
	static List<List<Integer>> nodeList = new ArrayList<>();
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //노드 개수
		arr = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 2; i <= n; i++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

			int v1 = input[0];
			int v2 = input[1];

			nodeList.get(v1).add(v2);
			nodeList.get(v2).add(v1);
		}

		solve(1);
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static void solve(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int root = queue.poll();
			List<Integer> list = nodeList.get(root);
			for (Integer i : list) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
					arr[i] = root;
				}
			}
		}
	}
}
