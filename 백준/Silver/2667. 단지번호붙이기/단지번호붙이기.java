

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1은 집이 있는 곳을, 0은 집이 없는 곳
 * 연결된 집의 모임
 *
 * 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우
 *
 * 첫 번째 줄에는 총 단지수
 * 단지내 집의 수를 오름차순으로 정렬
 */

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int total = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n][n];
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(""))
				.mapToInt(Integer::parseInt).toArray();
		}

		StringBuilder sb = new StringBuilder();
		PriorityQueue pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == false && arr[i][j] == 1) {
					pq.offer(bfs(i, j));
				}
			}
		}
		sb.append(total).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int x, int y) {
		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(new Coordinate(x, y));
		visited[x][y] = true;
		int count = 0;
		while (!queue.isEmpty()) {
			Coordinate current = queue.poll();
			count++;
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && arr[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.add(new Coordinate(nx, ny));
				}
			}
		}
		total++;
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
