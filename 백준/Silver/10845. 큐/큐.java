

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			if (input.length > 1) {
				deque.offer(Integer.parseInt(input[1]));
			} else {
				switch (input[0]) {
					case "front":
						if (deque.isEmpty()) {
							sb.append(-1).append("\n");
						} else {
							sb.append(deque.peekFirst()).append("\n");
						}
						break;

					case "back":
						if (deque.isEmpty()) {
							sb.append(-1).append("\n");
						} else {
							sb.append(deque.peekLast()).append("\n");
						}
						break;

					case "pop":
						if (deque.isEmpty()) {
							sb.append(-1).append("\n");
						} else {
							sb.append(deque.pollFirst()).append("\n");
						}
						break;

					case "size":
						sb.append(deque.size()).append("\n");
						break;

					case "empty":
						if (deque.isEmpty()) {
							sb.append(1).append("\n");
						} else {
							sb.append(0).append("\n");
						}
				}
			}
		}
		System.out.println(sb);
	}
}
