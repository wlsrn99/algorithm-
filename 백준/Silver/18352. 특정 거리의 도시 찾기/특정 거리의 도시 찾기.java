

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * X로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시들의 번호를 출력
 * -> x부터 시작하는 bfs k번
 */

public class Main {
	static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
	static int[] distance;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int n = input[0]; // 도시의 개수
		int m = input[1]; // 도로의 개수
		int k = input[2]; // 거리 정보
		int x = input[3]; // 출발도시의 번호

		distance = new int[n + 1];
		Arrays.fill(distance, -1);
		for (int i = 0; i <= n; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			nodeList.get(input[0]).add(input[1]);
		}

		bfs(x, k);

		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (distance[i] == k) {
				result.add(i);
			}
		}

		if (result.isEmpty()) {
			System.out.println(-1);
		} else {
			result.sort(Integer::compareTo);
			for (int city : result) {
				sb.append(city).append("\n");
			}
			System.out.println(sb);
		}
	}

	private static void bfs(int x, int k) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		distance[x] = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : nodeList.get(current)) {
				if (distance[next] == -1) {
					distance[next] = distance[current] + 1;
					queue.offer(next);
				}
			}
		}
	}
}
