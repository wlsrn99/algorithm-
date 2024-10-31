

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long a, b;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");

		a = Long.parseLong(input[0]);
		b = Long.parseLong(input[1]);

		if (solve()) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}

	private static boolean solve() {
		Queue<Long> queue = new LinkedList<>();
		queue.offer(a);
		while (!queue.isEmpty()) {
			count++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				long current = queue.poll();

				if (current == b) {
					return true;
				}

				if (current < b) {
					// 2를 곱할 경우
					long next = current * 2;
					if (next <= b) {
						queue.offer(next);
					}
					// 1을 수의 가장 오른쪽에 추가할 경우
					long next2 = current * 10 + 1;
					if (next2 <= b) {
						queue.offer(next2);
					}
				}
			}
		}
		return false;
	}
}