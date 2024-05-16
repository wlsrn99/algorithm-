

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int num = 1;
		for (int i = 0; i < n; i++) {
			while (stack.isEmpty() || stack.peek() != arr[i]) {
				if (num > n) {
					System.out.println("NO");
					return;
				}
				stack.push(num++);
				sb.append("+\n");
			}
			stack.pop();
			sb.append("-\n");
		}

		System.out.println(sb);

	}
}
