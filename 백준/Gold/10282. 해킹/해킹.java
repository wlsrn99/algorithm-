

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 컴퓨터 b가 감염되면 컴퓨터 a도 감염
 * 그래프의 방향 b -> a
 */
public class Main {
	static List<ArrayList<Computer>> nodeList;
	static boolean[] visited;
	static int[] dist;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//컴퓨터 개수
			int n = input[0];
			//의존성 개수 - 간선, 단방향
			int d = input[1];
			// 해킹당한 컴퓨터 번호
			int c = input[2];

			nodeList = new ArrayList<>();
			for (int i = 0; i < n + 1; i++) {
				nodeList.add(new ArrayList<>());
			}

			for (int i = 0; i < d; i++) {
				// b -> a time = s
				input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int a = input[0];
				int b = input[1];
				int s = input[2];

				nodeList.get(b).add(new Computer(a, s));
			}
			dijkstra(n, c);
			int count = 0;
			for (int i = 1; i < n + 1; i++) {
				if (visited[i]) {
					count++;
				}
			}

			int max = Arrays.stream(dist)
				.filter(item -> item != Integer.MAX_VALUE)
				.max()
				.getAsInt();
			sb.append(count).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra(int n, int start) {
		visited = new boolean[n + 1];
		dist = new int[n + 1];
		int max = Integer.MAX_VALUE;

		Arrays.fill(dist, max);
		dist[start] = 0;

		PriorityQueue<Computer> pq = new PriorityQueue<>(((o1, o2) -> o1.time - o2.time));
		pq.offer(new Computer(start, 0));

		while (!pq.isEmpty()) {
			int current = pq.poll().computerNum;

			if (visited[current]) {
				continue;
			}

			visited[current] = true;

			for (Computer next : nodeList.get(current)) {
				if (dist[next.computerNum] > dist[current] + next.time) {
					dist[next.computerNum] = dist[current] + next.time;

					pq.offer(new Computer(next.computerNum, dist[next.computerNum]));
				}
			}

		}
	}

	private static class Computer {
		int computerNum;
		int time;

		Computer(int computerNum, int time) {
			this.computerNum = computerNum;
			this.time = time;
		}
	}
}
