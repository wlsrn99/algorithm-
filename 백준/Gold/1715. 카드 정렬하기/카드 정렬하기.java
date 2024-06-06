

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 *  (10 + 20) + (30 + 40) -> 오름차순 정렬, 우선순위 큐
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int sum = 0;
		while (pq.size() != 1) {
			int num = pq.poll() + pq.poll();

			pq.offer(num);
			sum += num;
		}

		System.out.println(sum);
	}
}
