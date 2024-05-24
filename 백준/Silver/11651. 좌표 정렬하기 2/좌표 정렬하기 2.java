

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Coordinate> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.y != o2.y) {
				return o1.y - o2.y;
			} else {
				return o1.x - o2.x;
			}
		});
		for (int i = 0; i < n; i++) {
			int[] intput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			pq.offer(new Coordinate(intput[0], intput[1]));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Coordinate coordinate = pq.poll();
			sb.append(coordinate.x).append(" ").append(coordinate.y).append("\n");
		}
		System.out.println(sb);
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
