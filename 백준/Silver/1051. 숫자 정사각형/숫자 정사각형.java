

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형
 * 순서대로 일정 값 x를 더한 뒤 값이 같은지 비교
 * dx{x, 0, x }
 * dy{0, x, x}
 */
public class Main {
	static int[][] arr;
	static int count = 0;
	static int max = 0;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		n = input[0];
		m = input[1];
		// 정사각형이 될 수 있는 길이 
		int min = Math.min(n, m);

		arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(s[j - 1]);
			}
		}

		while (true) {
			boolean run = true;
			for (int i = 1; i <= n - count; i++) {
				if (!run) {
					break;
				}
				for (int j = 1; j <= m - count; j++) {
					if (isSquare(i, j, min)) {
						run = false;
						break;
					}
				}
			}
			count++;
			if (count == min) {
				break;
			}
		}

		System.out.println(max);
	}

	private static boolean isSquare(int x, int y, int min) {
		int vertex = 0;
		int[] dx = {count, 0, count};
		int[] dy = {0, count, count};
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx <= n && ny <= m && arr[nx][ny] == arr[x][y]) {
				vertex++;
			}
		}

		if (vertex == 3) {
			int len = count + 1;
			if (len <= min) {
				max = Math.max(max, len * len);
				return true;
			}
		}
		return false;
	}
}
