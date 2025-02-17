
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
 *
 * 현재 칸의 주변 $4$칸 중 청소되지 않은 빈 칸이 없는 경우,
 * 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
 *
 * 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
 *
 * 현재 칸의 주변 $4$칸 중 청소되지 않은 빈 칸이 있는 경우,
 * 반시계 방향으로 $90^\circ$ 회전한다.
 * 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
 * 1번으로 돌아간다.
 */
public class Main {
	static int[][] arr;

	// 0: 북, 1: 동, 2: 남, 3: 서
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int n, m;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		n = input[0];
		m = input[1];

		arr = new int[n][m];

		input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int r = input[0];
		int c = input[1];
		int d = input[2]; // 0: 북, 1: 동, 2: 남, 3: 서

		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		}

		doClean(r, c, d);
		System.out.println(count);
	}

	private static void doClean(int r, int c, int d) {
		if (arr[r][c] == 0) {
			count++;
			arr[r][c] = 2; 
		}

		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4; // 반시계 방향 회전
			int nx = r + dx[d];
			int ny = c + dy[d];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
				// 청소되지 않은 빈 칸이 있으면 이동 후 1번
				doClean(nx, ny, d);
				return;
			}
		}

		// 주변에 청소할 곳이 없는 경우 후진 시도
		int backX = r - dx[d];
		int backY = c - dy[d];

		if (backX >= 0 && backX < n && backY >= 0 && backY < m && arr[backX][backY] != 1) {
			// 후진 가능하면 후진
			doClean(backX, backY, d);
		}
	}
}
