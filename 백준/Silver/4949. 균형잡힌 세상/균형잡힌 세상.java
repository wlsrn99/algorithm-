

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 짝을 이루어야 한다 ( [ ] ( ) )
 * So when I die (the [first] I will see in (heaven) is a score list).
 * 후입 선출 -> 스택
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();

			if (input.equals(".")) {
				break;
			}

			Stack<Character> stack = new Stack<>();
			int len = input.length();
			boolean check = true;

			for (int i = 0; i < len; i++) {
				char c = input.charAt(i);

				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')' || c == ']') {

					if (stack.isEmpty()) {
						check = false;
						break;
					}

					if (c == ')' && stack.peek() == '(') {
						stack.pop();
					} else if (c == ']' && stack.peek() == '[') {
						stack.pop();
					}else {
						check = false;
						break;
					}
				}
			}

			if (stack.isEmpty() && check) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}

		System.out.println(sb);
	}
}
