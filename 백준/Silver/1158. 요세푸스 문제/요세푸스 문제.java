

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		int k = input[1];

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (!queue.isEmpty()) {
			count++;
			if (count == k) {
				sb.append(queue.poll()).append(", ");
				count = 0;
			} else {
				queue.offer(queue.poll());
			}
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}
}
