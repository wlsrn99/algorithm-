

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
나무 판자는 크기 1의 너비를 가졌고, 양수의 길이를 가지고 있다
기훈이 방은 직사각형 모양,방 안에는 벽과 평행한 모양의 정사각형으로 나누어져 있다

이제 ‘-’와 ‘|’로 이루어진 바닥 장식 모양이 주어진다. 만약 두 개의 ‘-’가 인접해 있고, 같은 행에 있다면, 두 개는 같은 나무 판자
두 개의 ‘|’가 인접해 있고, 같은 열에 있다면, 두 개는 같은 나무 판자이다.
 */
public class Main {
	static String[][] arr;
	static boolean[][] visited;

	static int count;

	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		// 세로
		n = input[0];
		// 가로
		m = input[1];

		arr = new String[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String[] input2 = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = input2[j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					count++;
					if (arr[i][j].equals("-")) {
						rowDfs(i, j);
					} else {
						columDfs(i, j);
					}
				}
			}
		}

		System.out.println(count);
	}

	private static void rowDfs(int i, int j) {
		if (j == m) {
			return;
		}

		if (!arr[i][j].equals("-")) {
			return;
		}
			
		visited[i][j] = true;
		rowDfs(i, j + 1);
	}

	private static void columDfs(int i, int j) {
		if (i == n) {
			return;
		}

		if (arr[i][j].equals("-")) {
			return;
		}

		visited[i][j] = true;
		columDfs(i + 1, j);
	}
}
