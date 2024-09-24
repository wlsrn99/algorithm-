

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 배열에 자연수 x를 넣는다.
 * 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
 *
 * x가 자연수라면 배열에 x라는 값을 넣기
 *  x가 0이라면 배열에서 가장 큰 값을 출력
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (maxHeap.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(maxHeap.poll()).append("\n");
				}
			} else {
				maxHeap.add(x);
			}
		}
		System.out.println(sb);
	}
}
