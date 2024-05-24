

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

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
