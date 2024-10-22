

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 정사각형은 서로 겹치면 안 된다.
 * 도형은 모두 연결되어 있어야 한다.
 * 정사각형의 변끼리 연결되어 있어야 한다
 * -> 폴리오미노
 *
 * 정사각형 4개를 이어 붙인 폴리오미노
 * -> 테트로미노
 *
 * 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대
 *
 * 1)
 * dy = {0, 0, 0}
 * dx = {1, 2, 3}
 * -> dy + 3 
 *
 * 2)
 * dy = {1, 0, 1}
 * dx = {0, 1, 1}
 * -> dy + 2
 * -> dx + 2
 * 3)
 * dy = {0, 0, 1}
 * dx=  {1, 2, 2}
 * -> dy + 1
 * -> dx + 2
 * 4)
 * dy = {0, 1, 1}
 * dx = {1, 1, 2}
 * -> dy + 1
 * -> dx + 2
 * 5)
 * dy = {1,1,2}
 * dx = {0,1,0}
 * -> dy + 2
 * -> dx + 1
 */
public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int max = 0;
	static int n, m;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		n = input[0]; //세로
		m = input[1]; //가로
		arr = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, arr[i][j]);
				visited[i][j] = false;
				calculate(i, j);
			}
		}

		System.out.println(max);
	}

	private static void dfs(int x, int y, int depth, int sum) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])
				continue;

			visited[nx][ny] = true;
			dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
			visited[nx][ny] = false;
		}
	}

	private static void calculate(int x, int y) {
		// ㅜ
		if (x + 1 < n && y + 2 < m) {
			max = Math.max(max, arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x + 1][y + 1]);
		}
		// ㅗ
		if (x > 0 && y + 2 < m) {
			max = Math.max(max, arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x - 1][y + 1]);
		}
		// ㅏ
		if (x + 2 < n && y + 1 < m) {
			max = Math.max(max, arr[x][y] + arr[x + 1][y] + arr[x + 2][y] + arr[x + 1][y + 1]);
		}
		// ㅓ
		if (x + 2 < n && y > 0) {
			max = Math.max(max, arr[x][y] + arr[x + 1][y] + arr[x + 2][y] + arr[x + 1][y - 1]);
		}
	}
}
