

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동
 */
public class Main {
	static int max = 100001;
	static boolean[] visited = new boolean[max];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		System.out.println(bfs(n, k));
	}

	static int bfs(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		visited[n] = true;

		int time = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int current = queue.poll();

				if (current == k) {
					return time;
				}

				// X-1로 이동하는 경우
				if (current - 1 >= 0 && !visited[current - 1]) {
					queue.offer(current - 1);
					visited[current - 1] = true;
				}
				// X+1로 이동하는 경우
				if (current + 1 < max && !visited[current + 1]) {
					queue.offer(current + 1);
					visited[current + 1] = true;
				}
				// X*2로 이동하는 경우
				if (current * 2 < max && !visited[current * 2]) {
					queue.offer(current * 2);
					visited[current * 2] = true;
				}
			}

			time++;
		}

		return -1;
	}
}

