

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			if (input.equals("0")) {
				if (pq.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				int[] inputArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
				int size = inputArr.length;
				for (int j = 1; j < size; j++) {
					pq.offer(inputArr[j]);
				}
			}
		}

		System.out.println(sb);

	}
}
