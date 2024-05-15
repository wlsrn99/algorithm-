
/**
 *
 * 단지내 집의 수를 오름차순으로 정렬
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static boolean[][] visited;
	static int n;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				if (input[j].equals("0")) {
					visited[i][j] = true;
				}
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					count++;
					pq.add(bfs(i, j));
				}
			}
		}
		sb.append(count).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}

		System.out.println(sb);

	}

	private static int bfs(int i, int j) {
		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(new Coordinate(i, j));
		visited[i][j] = true;
		int count = 0;
		while (!queue.isEmpty()) {
			count++;
			Coordinate coordinate = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = coordinate.x + dx[k];
				int ny = coordinate.y + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Coordinate(nx, ny));
				}
			}
		}
		return count;
	}

	private static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
