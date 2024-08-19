

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다 -> 스택
 * 이렇게 모든 수를 받아 적은 후 그 수의 합
 */
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
