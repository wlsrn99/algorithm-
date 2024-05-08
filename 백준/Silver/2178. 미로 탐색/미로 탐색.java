

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static boolean[][] visited;

	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		n = input[0];
		m = input[1];

		visited = new boolean[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			for (int j = 1; j < m + 1; j++) {
				if (input[j - 1] == 0) {
					visited[i][j] = true;
				}
			}
		}

		visited[1][1] = true;
		System.out.println(bfs(1, 1, 1));
	}

	private static int bfs(int i, int j, int count) {
		Queue<Coordinate> queue = new LinkedList<>();
		queue.offer(new Coordinate(i, j, count));
		int result = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Coordinate current = queue.poll();
			if (current.x == n && current.y == m) {
				result = Math.min(result, current.count);
			} else {
				for (int k = 0; k < 4; k++) {
					int nX = current.x + dx[k];
					int nY = current.y + dy[k];
					int nCount = current.count;

					if (idxCheck(nX, nY) && !visited[nX][nY]) {
						visited[nX][nY] = true;
						queue.offer(new Coordinate(nX, nY, nCount + 1));
					}
				}
			}
		}
		return result;
	}

	private static boolean idxCheck(int nX, int nY) {
		return nX > 0 && nX <= n && nY > 0 && nY <= m;
	}

	private static class Coordinate {
		int x;
		int y;

		int count;

		public Coordinate(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
