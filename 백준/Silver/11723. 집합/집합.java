

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
 * remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
 * check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
 * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
 * all: S를 {1, 2, ..., 20} 으로 바꾼다.
 * empty: S를 공집합으로 바꾼다
 *
 * set 사용하면 될 것 같다
 */
public class Main {
	static StringBuilder sb = new StringBuilder();
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int m = Integer.parseInt(br.readLine());

		
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			int x = 0;
			if (input.length > 1) {
				x = Integer.parseInt(input[1]);
			}
			doCalculation(input, x);
		}
		System.out.println(sb);
	}

	private static void doCalculation(String[] input, int x) {
		switch (input[0]) {
			case "add": // S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
				if (!set.contains(x)) {
					set.add(x);
				}
				break;
			case "remove": // S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
				if (set.contains(x)) {
					set.remove(x);
				}
				break;
			case "check": // S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
				if (set.contains(x)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "toggle": // S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
				if (set.contains(x)) {
					set.remove(x);
				} else {
					set.add(x);
				}
				break;
			case "all": // S를 {1, 2, ..., 20} 으로 바꾼다.
				set.clear();
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
				break;
			case "empty": // S를 공집합으로 바꾼다
				set.clear();
				break;
		}
	}
}
