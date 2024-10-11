

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 가로와 세로로만 움직이기
 * 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다. 입력에서 2는 단 한개
 * 각 지점에서 목표지점까지의 거리
 *
 */
public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<List<Integer>> nodeList = new ArrayList<>();
	static int[][] distance;
	static Coordinate start;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		n = input[0];
		m = input[1];
		distance = new int[n][m];
		for (int i = 0; i < n; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < m; j++) {
				if (input[j] == 2) {
					start = new Coordinate(i, j);
				}
				nodeList.get(i).add(input[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			Arrays.fill(distance[i], -1);
		}
		bfs();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (nodeList.get(i).get(j) == 0) {
					sb.append(0).append(" ");
				} else {
					sb.append(distance[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void bfs() {
		Queue<Coordinate> queue = new LinkedList<>();
		queue.offer(start);
		distance[start.x][start.y] = 0;

		while (!queue.isEmpty()) {
			Coordinate current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
					nodeList.get(nx).get(ny) == 1 && distance[nx][ny] == -1) {
					queue.offer(new Coordinate(nx, ny));
					distance[nx][ny] = distance[current.x][current.y] + 1;
				}
			}
		}
	}

	private static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
