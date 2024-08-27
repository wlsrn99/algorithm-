

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
		for (int i = 0; i < n; i++) { //pop을 n번 진행해야 수열을 만들 수 있음 
			while (stack.isEmpty() || stack.peek() != arr[i]) {
				if (num > n) { //현재 push할 숫자가 n보다 크다면 만들 수 없음
					System.out.println("NO");
					return;
				}
				stack.push(num++);
				sb.append("+").append("\n");
			}
			stack.pop();
			sb.append("-").append("\n");
		}

		System.out.println(sb);

	}
}
