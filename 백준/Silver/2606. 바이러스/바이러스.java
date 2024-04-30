

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static List<ArrayList<Integer>> nodeList;
	static boolean[] visited;

	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int bridge = Integer.parseInt(br.readLine());

		visited = new boolean[n + 1];
		nodeList = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < bridge; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			nodeList.get(input[0]).add(input[1]);
			nodeList.get(input[1]).add(input[0]);
		}

		bfs();

		System.out.println(count);
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			for (int current : nodeList.get(queue.poll())) {
				if (!visited[current]) {
					visited[current] = true;
					queue.offer(current);
					count++;
				}
			}
		}
	}
}
