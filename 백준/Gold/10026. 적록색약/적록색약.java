
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 적록색약이 아닌 사람 -> 빨강 초록 파랑 3개
 * 적록색약인 사람 -> 빨강과 초록을 똑같이, 파랑 2개
 * 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역
 *
 *
 * 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램
 */
public class Main {
	static int n;
	static char[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited;

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
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		int count1 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					count1++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}
		visited = new boolean[n][n];
		int count2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					count2++;
				}
			}
		}

		System.out.println(count1 + " " + count2);
	}

	private static void bfs(int x, int y) {
		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(new Coordinate(x, y));
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			Coordinate coordinate = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nX = coordinate.x + dx[i];
				int nY = coordinate.y + dy[i];
				if (nX >= 0 && nX < n && nY >= 0 && nY < n && !visited[nX][nY] && arr[nX][nY] == arr[x][y]) {
					visited[nX][nY] = true;
					queue.add(new Coordinate(nX, nY));
				}
			}
		}
	}
	
}
