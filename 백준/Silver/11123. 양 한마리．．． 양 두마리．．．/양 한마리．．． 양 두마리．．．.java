
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static char[][] arr;
	static boolean[][] visited;
	static int h, w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

			h = input[0]; //0 < H
			w = input[1]; //W ≤ 100

			arr = new char[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && arr[i][j] == '#') {
						count++;
						bfs(i, j);
					}
				}
			}

			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int i, int j) {
		Queue<Coordinate> queue = new LinkedList<>();
		visited[i][j] = true;
		queue.add(new Coordinate(i, j));
		while (!queue.isEmpty()) {
			Coordinate current = queue.poll();
			int x = current.x;
			int y = current.y;
			for (int z = 0; z < 4; z++) {
				int nx = x + dx[z];
				int ny = y + dy[z];
				if (nx >= 0 && ny >= 0 && nx < h && ny < w && arr[nx][ny] == '#' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Coordinate(nx, ny));
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
