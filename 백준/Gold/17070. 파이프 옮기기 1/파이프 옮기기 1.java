

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 새 집의 크기는 N×N의 격자판
 * 각각의 칸은 (r, c)로 나타낼 수 있다. 여기서 r은 행의 번호, c는 열의 번호이고, 행과 열의 번호는 1부터 시작한다
 * 파이프의 한쪽 끝을 (N, N)로 이동시키는 방법의 개수
 *
 * 파이프가 가로로 놓여진 경우에 가능한 이동 방법은 총 2가지, 세로로 놓여진 경우에는 2가지, 대각선 방향으로 놓여진 경우에는 3가지
 * 파이프는 항상 빈 칸만 차지해야 한다
 *
 * 가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로이다.
 */
public class Main {
	//가로이동인 경우
	//dx = {0}
	//dy = {1}
	//세로이동인 경우
	//dx = {1}
	//dy = {0}
	//대각선이동인 경우
	// dx = {0,1,1} {1}
	// dy = {1,1,0} {1}
	static int n;
	static int[][] arr;
	static int[][] dp;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
			for (int j = 1; j <= n; j++) {
				arr[i][j] = input[j - 1];
			}
		}

		dfs(1, 2, 0); // 가로 상태
		System.out.println(count);
	}

	// state : 0= 가로, 1 = 세로, 2 = 대각선
	private static void dfs(int x, int y, int state) {
		if (x == n && y == n) {
			count++;
			return;
		}

		// 대각선 이동
		if (isDiagonal(x, y)) {
			dfs(x + 1, y + 1, 2);
		}

		switch (state) {
			case 0: // 가로 상태인 경우
				if (isW(x, y)) {
					dfs(x, y + 1, 0);
				}
				break;
			case 1: // 세로 상태인 경우
				if (isL(x, y)) {
					dfs(x + 1, y, 1);
				}
				break;
			case 2: // 대각선 상태의 경우
				if (isW(x, y)) {
					dfs(x, y + 1, 0);
				}
				if (isL(x, y)) {
					dfs(x + 1, y, 1);
				}
				break;
		}

	}

	private static boolean isDiagonal(int x, int y) {
		return x + 1 <= n && y + 1 <= n && arr[x + 1][y] == 0 && arr[x][y + 1] == 0 && arr[x + 1][y + 1] == 0;
	}

	private static boolean isL(int x, int y) {
		return x + 1 <= n && arr[x + 1][y] == 0;
	}

	private static boolean isW(int x, int y) {
		return y + 1 <= n && arr[x][y + 1] == 0;
	}
}
