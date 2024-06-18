
/**
 * 점수의 합이 최대
 * 두 스티커 (100과 70)은 변을 공유하기 때문에, 동시에 뗄 수 없다.
 * 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			map = new int[2][n + 1];
			dp = new int[2][n + 1];

			for (int i = 0; i < 2; i++) {
				int[] input = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();
				for (int j = 1; j < n + 1; j++) {
					map[i][j] = input[j - 1];
				}
			}
			// [0][j]을 골랐을 경우 인덱스 2부터 왼쪽 아래 대각선, 왼쪽 아래 대각선의 왼쪽이랑 비교
			// [1][j]를 골랐을 경우 인덱스 2부터 오른쪽 위 대각선, 오른쪽 위 대각선의 왼쪽이랑 비교
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			for (int j = 2; j < n + 1; j++) {
				dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + map[0][j];
				dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + map[1][j];
			}

			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}

		System.out.println(sb);
	}
}
