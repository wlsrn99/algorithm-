

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Subin {
	int position;
	int time;

	public Subin(int position, int time) {
		this.position = position;
		this.time = time;
	}
}

public class Main {
	static int max = 100000;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		int k = input[1];

		visited = new boolean[max + 1];
		bfs(n, k);

		System.out.println(min);
	}

	private static void bfs(int n, int k) {
		Queue<Subin> queue = new LinkedList<>();
		queue.add(new Subin(n, 0));

		while (!queue.isEmpty()) {
			Subin current = queue.poll();
			int position = current.position;
			int time = current.time;

			visited[position] = true;

			if (position == k) {
				min = Math.min(min, time);
				continue;
			}

			if (position * 2 <= max && !visited[position * 2]) {
				queue.offer(new Subin(position * 2, time));
			}

			if (position + 1 <= max && !visited[position + 1]) {
				queue.offer(new Subin(position + 1, time + 1));
			}

			if (position - 1 >= 0 && !visited[position - 1]) {
				queue.offer(new Subin(position - 1, time + 1));
			}
		}
	}
}