

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 부모 노드부터 시작해서 갈 수 있는 모든 방향으로 깊이 탐색을 시작 -> dfs
 * 거리는 모두 1로 같으므로 1번의 탐색이 끝날 때 count를 증가시키고 count를 비교시켜서 최댓값을 구하면 될 것 같다
 * 아니면 깊이를 이용하면 될 것 같다
 * -> 생각을 잘못했다 bfs로 푸는 문제였다
 *
 * 각 칸에 안전거리를 저장하는 배열 생성
 */
public class Main {
	static int[][] arr; //상어칸

	static int n, m;
	static int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
	static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				//상어 있는 부분 -1로 설정
				int shark = Integer.parseInt(input[j]);
				if (shark == 1) {
					shark = -1;
				}
				arr[i][j] = shark;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 상어가 있을때 bfs의 시작노드
				if (arr[i][j] == -1) {
					bfs(i, j);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, arr[i][j]);
			}
		}
		System.out.println(max);
	}

	private static void bfs(int x, int y) {
		Queue<OneSquare> queue = new LinkedList<>();
		queue.offer(new OneSquare(x, y, 0));
		boolean[][] visited = new boolean[n][m];
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			OneSquare oneSquare = queue.poll();
			int cx = oneSquare.x;
			int cy = oneSquare.y;
			int distance = oneSquare.distance;

			for (int direction = 0; direction < 8; direction++) {
				int nx = cx + dx[direction];
				int ny = cy + dy[direction];

				if (checkPosition(nx, ny, visited)) {
					if (arr[nx][ny] == -1) {
						visited[nx][ny] = true;
						continue;
					} else {
						visited[nx][ny] = true;
						if (arr[nx][ny] == 0 || arr[nx][ny] > distance + 1) {
							arr[nx][ny] = distance + 1;
						}
						queue.offer(new OneSquare(nx, ny, distance + 1));
					}
				}
			}
		}
	}

	// x,y값이 인덱스에 들어갈 수 있는 값인지 확인
	private static boolean checkPosition(int x, int y, boolean[][] visited) {
		// x,y값이 배열의 범위를 벗어나는 경우
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}
		// 이미 방문한 노드인 경우
		if (visited[x][y]) {
			return false;
		}
		return true;
	}

	private static class OneSquare {
		int x;
		int y;
		int distance;

		OneSquare(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
}
