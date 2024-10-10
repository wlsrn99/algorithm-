

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * i에서 j로 가는 길이가 양수인 경로가 있는지 없는지
 * -> i에서 j로 갈 수 있는 경우가 존재하는지
 *
 */
public class Main {
	static List<List<Integer>> nodeList = new ArrayList<>();
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < n; j++) {
				if (input[j] == 1) { //1인 경우 간선이 존재 
					nodeList.get(i).add(j);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (bfs(i, j)) {// i에서 j로 갈 수 있는 경로가 있는지 bfs로 탐색
					sb.append(1).append(" ");
				} else {
					sb.append(0).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static boolean bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		boolean[] visited = new boolean[n];
		visited[start] = true;
		while (!queue.isEmpty()) {
			List<Integer> current = nodeList.get(queue.poll());
			for (Integer i : current) {
				if (!visited[i]) {
					visited[i] = true;
					queue.offer(i);
				}
				if (i == end) { //end를 방문하는 경우가 있다면 양수인 경로가 있는 것 
					return true;
				}
			}
		}
		return false;
	}

}
