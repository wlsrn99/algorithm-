
/**
 * 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. -> 우선순위 큐
 * 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력 -> 음수 출력
 *
 * x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if (abs1 < abs2) { //절댓값이 작은 경우
				return -1; //앞에 배치
			} else if (abs1 == abs2) { //절댓값이 같은경우
				return o1 - o2; // 오름차순
			} else {
				return 1; // 뒤에 배치
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				pq.offer(x);
			}
		}
		System.out.println(sb);
	}
}
