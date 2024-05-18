

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < k; i++) {
			int input = Integer.parseInt(br.readLine());

			if (input == 0) {
				stack.pop();
			} else {
				stack.push(input);
			}
		}

		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}

		System.out.println(sum);
	}
}
