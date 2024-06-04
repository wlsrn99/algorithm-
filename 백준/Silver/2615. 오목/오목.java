

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[][] checkerboard;

	static int[] dx = {0, 1, 1, -1};
	static int[] dy = {1, 0, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		checkerboard = new String[19][19];
		for (int i = 0; i < 19; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 19; j++) {
				checkerboard[i][j] = input[j];
			}
		}

		int result = 0;
		int row = 0;
		int column = 0;
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (checkerboard[i][j].equals("1") || checkerboard[i][j].equals("2")) {
					for (int k = 0; k < 4; k++) {
						if (checkDirection(i, j, dx[k], dy[k])) {
							result = Integer.parseInt(checkerboard[i][j]);
							row = j;
							column = i;

							sb.append(result)
								.append("\n")
								.append(column + 1)
								.append(" ")
								.append(row + 1);
							System.out.println(sb);
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
	}

	private static boolean checkDirection(int x, int y, int dx, int dy) {
		String color = checkerboard[x][y];
		int count = 1;

		int nx = x + dx;
		int ny = y + dy;
		while (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && checkerboard[nx][ny].equals(color)) {
			count++;
			nx += dx;
			ny += dy;
		}

		if (count == 5) {
			// 앞쪽 확인
			if (x - dx >= 0 && x - dx < 19 && y - dy >= 0 && y - dy < 19 && checkerboard[x - dx][y - dy].equals(
				color)) {
				return false;
			}
			// 뒤쪽 확인
			if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && checkerboard[nx][ny].equals(color)) {
				return false;
			}
			return true;
		}
		return false;
	}
}
