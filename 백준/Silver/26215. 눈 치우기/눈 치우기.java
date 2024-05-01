

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int size = input.length;

		PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
		for (int i = 0; i < size; i++) {
			pq.offer(input[i]);
		}

		int count = 0;

		while (!pq.isEmpty()) {
			if (count > 1440) {
				break;
			}
			if (pq.size() >= 2) {
				int num1 = pq.poll();
				int num2 = pq.poll();

				if (--num1 > 0) {
					pq.offer(num1);
				}

				if (--num2 > 0) {
					pq.offer(num2);
				}
				count++;
			} else {
				int num1 = pq.poll();

				if (--num1 > 0) {
					pq.offer(num1);
				}
				count++;
			}
		}

		if (count <= 1440) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}
}
