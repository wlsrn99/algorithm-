

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (minHeap.isEmpty()) {
					sb.append("0").append("\n");
				} else {
					sb.append(minHeap.poll()).append("\n");
				}
			} else {
				minHeap.add(num);
			}
		}
		System.out.println(sb);
	}
}
