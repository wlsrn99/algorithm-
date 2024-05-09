

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int m, n, k;

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tCase = 0; tCase < t; tCase++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			m = input[0];
			n = input[1];
			k = input[2];
			visited = new boolean[m][n];
			int count = 0;

			for (int i = 0; i < k; i++) {
				input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

				visited[input[0]][input[1]] = true;
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}

	}

	private static void bfs(int i, int j) {
		visited[i][j] = false;
		Queue<Coordinate> queue = new LinkedList<>();
		queue.offer(new Coordinate(i, j));

		while (!queue.isEmpty()) {
			Coordinate current = queue.poll();
			for (int c = 0; c < 4; c++) {
				int nx = current.x + dx[c];
				int ny = current.y + dy[c];

				if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
					if (visited[nx][ny]) {
						visited[nx][ny] = false;
						queue.offer(new Coordinate(nx, ny));
					}
				}
			}
		}

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
