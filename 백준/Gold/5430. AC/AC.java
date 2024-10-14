

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Deque<Integer> dq = new ArrayDeque<>();

			// 빈 배열이 아닐 경우
			if (n > 0) {
				String[] numbers = s.substring(1, s.length() - 1).split(",");
				for (String num : numbers) {
					dq.offer(Integer.parseInt(num));
				}
			}

			boolean isReverse = false;
			boolean isError = false;
			for (char c : p) {
				if (c == 'R') {
					isReverse = !isReverse;
				} else {
					if (dq.isEmpty()) {
						isError = true;
						break;
					}
					if (isReverse) {
						dq.pollLast();
					} else {
						dq.pollFirst();
					}
				}
			}

			if (isError) {
				sb.append("error\n");
			} else {
				sb.append("[");
				if (!dq.isEmpty()) {
					if (isReverse) {
						sb.append(dq.pollLast());
						while (!dq.isEmpty()) {
							sb.append(",").append(dq.pollLast());
						}
					} else {
						sb.append(dq.pollFirst());
						while (!dq.isEmpty()) {
							sb.append(",").append(dq.pollFirst());
						}
					}
				}
				sb.append("]\n");
			}
		}
		System.out.print(sb);
	}
}