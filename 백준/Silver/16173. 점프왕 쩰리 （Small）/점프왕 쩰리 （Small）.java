

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
메모리 제한 128 MB
‘쩰리’가 이동 가능한 방향은 오른쪽과 아래
‘쩰리’가 가장 오른쪽, 가장 아래 칸에 도달하는 순간, 그 즉시 ‘쩰리’의 승리
‘쩰리’가 한 번에 이동할 수 있는 칸의 수는, 현재 밟고 있는 칸에 쓰여 있는 수 만큼 초과나 그 미만으로 이동할 수 없다

 */
public class Main {
	static int[][] arr;
	static boolean[][] visited;

	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 1; j < n + 1; j++) {
				arr[i][j] = input[j - 1];
			}
		}
		//시작지점 (1,1)
		visited[1][1] = true;
		dfs(1, 1, arr[1][1]);

		if (visited[n][n]) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}

	private static void dfs(int i, int j, int jump) {
		if (isPossibleColumn(i + jump)) {
			if (!visited[i + jump][j]) {
				visited[i + jump][j] = true;
				dfs(i + jump, j, arr[i + jump][j]);
			}
		}

		if (isPossibleRow(j + jump)) {
			if (!visited[i][j + jump]) {
				visited[i][j + jump] = true;
				dfs(i, j + jump, arr[i][j + jump]);
			}
		}

	}

	private static boolean isPossibleColumn(int columnIdx) {
		if (columnIdx < n + 1) {
			return true;
		}
		return false;
	}

	private static boolean isPossibleRow(int rowIdx) {
		if (rowIdx < n + 1) {
			return true;
		}
		return false;
	}

}
