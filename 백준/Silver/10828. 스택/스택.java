

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int size = input.length;
			if (size > 1) {
				stack.push(Integer.parseInt(input[1]));
			} else {
				switch (input[0]) {
					case "top":
						if (stack.isEmpty()) {
							sb.append(-1).append("\n");
							break;
						} else {
							sb.append(stack.peek()).append("\n");
							break;
						}

					case "size":
						sb.append(stack.size()).append("\n");
						break;

					case "pop":
						if (stack.isEmpty()) {
							sb.append(-1).append("\n");
							break;
						} else {
							sb.append(stack.pop()).append("\n");
							break;
						}

					case "empty":
						if (stack.isEmpty()) {
							sb.append(1).append("\n");
							break;
						} else {
							sb.append(0).append("\n");
							break;
						}
				}
			}
		}
		System.out.println(sb);
	}
}
