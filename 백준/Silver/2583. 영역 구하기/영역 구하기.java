
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 */
public class Main {
	static boolean[][] arr;
	static int m, n;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		m = input[0];
		n = input[1];
		arr = new boolean[m][n];

		int k = input[2];
		for (int i = 0; i < k; i++) {
			int[] coordinate = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int y1 = coordinate[0];
			int x1 = coordinate[1];
			int y2 = coordinate[2] - 1;
			int x2 = coordinate[3] - 1;

			for (int y = y1; y <= y2; y++) {
				for (int x = x1; x <= x2; x++) {
					arr[x][y] = true;
				}
			}
		}

		Queue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!arr[i][j]) {
					pq.offer(bfs(i, j));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append(" ");
		}
		System.out.println(sb);
	}

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		arr[x][y] = true;
		queue.offer(new int[] {x, y});

		int extent = 0;
		while (!queue.isEmpty()) {
			extent++;
			int[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				if (nx < m && nx >= 0 && ny < n && ny >= 0 && !arr[nx][ny]) {
					arr[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
		return extent;
	}
}
