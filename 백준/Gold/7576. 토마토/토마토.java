

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미
 */
public class Main {
	static int n, m;
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		n = input[0]; //가로
		m = input[1]; //세로

		arr = new int[m][n];

		Queue<Coordinate> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					queue.add(new Coordinate(i, j));
				}
			}
		}

		System.out.println(bfs(queue));

	}

	private static int bfs(Queue<Coordinate> queue) {
		int day = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Coordinate current = queue.poll();
				for (int j = 0; j < 4; j++) {
					int nx = current.x + dx[j];
					int ny = current.y + dy[j];
					if (nx >= 0 && ny >= 0 && nx < m && ny < n && arr[nx][ny] == 0) {
						arr[nx][ny] = 1;
						queue.add(new Coordinate(nx, ny));
					}
				}
			}
			day++;
		}

		if (!isAll()) {
			day = -1;
		}

		return day;
	}

	private static boolean isAll() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
