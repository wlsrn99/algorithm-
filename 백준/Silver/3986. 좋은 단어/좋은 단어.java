

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int count = 0;
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			int size = input.length;
			Stack<String> stack = new Stack<>();
			for (int j = 0; j < size; j++) {
				if (stack.isEmpty()) {
					stack.push(input[j]);
				} else {
					if (stack.peek().equals(input[j])) {
						stack.pop();
					} else {
						stack.push(input[j]);
					}
				}
			}

			if (stack.isEmpty()) {
				count++;
			}
		}

		System.out.println(count);
	}
}
