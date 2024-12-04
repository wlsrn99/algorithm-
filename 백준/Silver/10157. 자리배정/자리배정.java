
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int c = input[0]; // 가로
		int r = input[1]; // 세로

		int num = Integer.parseInt(br.readLine());

		if (num > c * r) {
			System.out.println(0);
			return;
		}

		int[] dx = {1, 0, -1, 0}; // 상, 우, 하, 좌
		int[] dy = {0, 1, 0, -1};
		int x = 1;
		int y = 1;
		int direction = 0;

		boolean[][] visited = new boolean[r + 1][c + 1];
		visited[1][1] = true;

		for (int i = 1; i < num; i++) {
			int nx = x + dx[direction];
			int ny = y + dy[direction];

			if (nx < 1 || nx > r || ny < 1 || ny > c || visited[nx][ny]) {
				direction = (direction + 1) % 4;
				nx = x + dx[direction];
				ny = y + dy[direction];
			}

			x = nx;
			y = ny;
			visited[x][y] = true;
		}

		System.out.println(y + " " + x);
	}
}