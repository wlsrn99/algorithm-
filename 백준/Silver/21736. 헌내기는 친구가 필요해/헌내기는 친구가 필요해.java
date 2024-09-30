

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static List<List<String>> nodeList = new ArrayList<>();
	static boolean[][] visited;
	static int count = 0;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		n = input[0];
		m = input[1];
		for (int i = 0; i < n; i++) {
			nodeList.add(new ArrayList<>());
		}
		visited = new boolean[n][m];

		int y = 0;
		int x = 0;
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				if (str[j].equals("I")) {
					y = i;
					x = j;
				}
				nodeList.get(i).add(str[j]);
			}
		}

		bfs(y, x);
		System.out.println(count == 0 ? "TT" : count);
	}

	private static void bfs(int y, int x) {
		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(new Coordinate(y, x));
		visited[y][x] = true;
		while (!queue.isEmpty()) {
			Coordinate coordinate = queue.poll();
			if (nodeList.get(coordinate.y).get(coordinate.x).equals("P")) {
				count++;
			}
			for (int i = 0; i < 4; i++) {
				int newY = coordinate.y + dx[i];
				int newX = coordinate.x + dy[i];
				if (newY < n && newX < m && newX >= 0 && newY >= 0 && !visited[newY][newX] && !nodeList.get(newY)
					.get(newX)
					.equals("X")) {
					queue.add(new Coordinate(newY, newX));
					visited[newY][newX] = true;
				}
			}
		}
	}

	private static class Coordinate {
		int x;
		int y;

		public Coordinate(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
