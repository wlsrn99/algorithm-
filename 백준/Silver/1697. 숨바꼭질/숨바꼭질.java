

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동
 */

public class Main {
	static int MAX = 100001;
	static boolean[] visited = new boolean[MAX];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int n = input[0]; //수빈
		int k = input[1]; //동생

		System.out.println(bfs(n, k));
	}

	static int bfs(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		visited[n] = true;

		int time = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) { //현재 큐에 있는 요소들을 전부 확인하기
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
				if (current + 1 < MAX && !visited[current + 1]) {
					queue.offer(current + 1);
					visited[current + 1] = true;
				}
				// X*2로 이동하는 경우
				if (current * 2 < MAX && !visited[current * 2]) {
					queue.offer(current * 2);
					visited[current * 2] = true;
				}
			}
			time++;
		}

		return -1;
	}
}

