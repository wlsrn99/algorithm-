
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static List<List<Integer>> nodeList = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];

		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int num1 = input[0];
		int num2 = input[1];

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i <= n; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

			nodeList.get(input[0]).add(input[1]);
			nodeList.get(input[1]).add(input[0]);
		}

		System.out.println(bfs(num1, num2));
	}

	private static int bfs(int num1, int num2) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num1);
		visited[num1] = true;

		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				if (current == num2) {
					return count;
				}

				for (int next : nodeList.get(current)) {
					if (!visited[next]) {
						visited[next] = true;
						queue.add(next);
					}
				}
			}
			count++;
		}

		return -1;
	}
}
