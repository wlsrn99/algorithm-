

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			String[] input = br.readLine().split(" ");

			if (input.length == 2) {
				if (input[0].equals("push_back")) {
					deque.offerLast(Integer.parseInt(input[1]));
				} else {
					deque.offerFirst(Integer.parseInt(input[1]));
				}
			} else {
				if (input[0].equals("empty")) {
					if (deque.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
				} else if (input[0].equals("size")) {
					sb.append(deque.size()).append("\n");
				} else {
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						switch (input[0]) {
							case "pop_front":
								sb.append(deque.pollFirst()).append("\n");
								break;
							case "pop_back":
								sb.append(deque.pollLast()).append("\n");
								break;
							case "front":
								sb.append(deque.peekFirst()).append("\n");
								break;
							case "back":
								sb.append(deque.peekLast()).append("\n");
								break;
						}
					}
				}
			}
		}

		System.out.println(sb);
	}
}
