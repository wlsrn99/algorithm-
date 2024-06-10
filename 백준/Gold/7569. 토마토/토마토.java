/**
 *  위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토
 *  dx배열과 dy배열 생성해서 bfs로 0인 애들 기준으로 해서 익은토마토가 있으면 1로 익게만들고
 *  두번 반복했는데도 익지 않는 경우가 안되는경우?
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, H;
	static int[][][] box;
	static boolean[][][] visited;
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[H][N][M];
		visited = new boolean[H][N][M];

		Queue<int[]> queue = new ArrayDeque<>();

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					box[h][n][m] = Integer.parseInt(st.nextToken());
					if (box[h][n][m] == 1) {
						queue.add(new int[]{h, n, m});
						visited[h][n][m] = true;
					}
				}
			}
		}

		int days = bfs(queue);

		if (isAll()) {
			System.out.println(days);
		} else {
			System.out.println(-1);
		}
	}

	private static int bfs(Queue<int[]> queue) {
		int days = -1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] current = queue.poll();
				int z = current[0];
				int y = current[1];
				int x = current[2];

				for (int d = 0; d < 6; d++) {
					int nz = z + dz[d];
					int ny = y + dy[d];
					int nx = x + dx[d];

					if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[nz][ny][nx] && box[nz][ny][nx] == 0) {
						queue.add(new int[]{nz, ny, nx});
						visited[nz][ny][nx] = true;
						box[nz][ny][nx] = 1;
					}
				}
			}
			days++;
		}

		return days;
	}

	private static boolean isAll() {
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (box[h][n][m] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

