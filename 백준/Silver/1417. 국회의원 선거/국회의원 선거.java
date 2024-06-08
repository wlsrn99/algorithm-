

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	/**
	 *
	 * 다솜이는 기호 1번
	 * 투표수를 하나씩 가져올때마다 다솜이는 증가하고 다른 후보는 감소하므로,
	 * 우선순위큐로 1씩 비교하면서 다솜이보다 투표수가 많거나 같은지 확인
	 *
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int dasom = Integer.parseInt(br.readLine());
		int count = 0;
		if (n != 1) {
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
			for (int i = 0; i < n - 1; i++) {
				pq.add(Integer.parseInt(br.readLine()));
			}

			while (pq.peek() >= dasom) {
				int current = pq.poll();
				pq.offer(--current);
				dasom++;
				count++;
			}
		}
		System.out.println(count);

	}
}
