

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
			if (o1.x != o2.x) {
				return o1.x - o2.x;
			} else {
				return o1.y - o2.y;
			}
		});

		for (int i = 0; i < n; i++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
			pq.offer(new Coordinate(input[0], input[1]));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Coordinate current = pq.poll();
			sb.append(current.x).append(" ").append(current.y).append(" ").append("\n");
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
