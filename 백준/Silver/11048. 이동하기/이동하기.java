
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 준규는 현재 (1, 1)에 있고
 * 준규가 (r, c)에 있으면, (r+1, c), (r, c+1), (r+1, c+1)로 이동할 수 있고
 * 각 방을 방문할 때마다 방에 놓여져있는 사탕을 모두 가져갈 수 있다
 *
 * bfs + dp
 */
public class Main {

	static int[] dx = {1, 0, 1};
	static int[] dy = {0, 1, 1};
	static int n, m;
	static int[][] score;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		n = input[0];
		m = input[1];
		score = new int[n][m];
		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			score[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		}

		dp[0][0] = score[0][0];
		for (int j = 1; j < m; j++) {
			dp[0][j] = dp[0][j - 1] + score[0][j];
		}

		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + score[i][0];
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1])) + score[i][j];
			}
		}
		System.out.println(dp[n - 1][m - 1]);
	}

	/*
	메모리 초과
	 */
	// private static class Coordinate {
	// 	int x;
	// 	int y;
	//
	// 	public Coordinate(int x, int y) {
	// 		this.x = x;
	// 		this.y = y;
	// 	}
	// }
	//
	// private static void bfs(int startX, int startY) {
	// 	Queue<Coordinate> queue = new LinkedList<>();
	// 	queue.add(new Coordinate(startX, startY));
	// 	while (!queue.isEmpty()) {
	// 		Coordinate current = queue.poll();
	// 		for (int i = 0; i < 3; i++) {
	// 			int nx = current.x + dx[i];
	// 			int ny = current.y + dy[i];
	// 			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
	// 				int num = dp[current.x][current.y] + score[nx][ny];
	// 				dp[nx][ny] = Math.max(dp[nx][ny], num);
	// 				queue.add(new Coordinate(nx, ny));
	// 			}
	// 		}
	// 	}
	// }
}
