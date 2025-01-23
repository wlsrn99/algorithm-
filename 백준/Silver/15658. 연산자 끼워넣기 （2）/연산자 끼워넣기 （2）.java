

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다.
 * 또, 나눗셈은 정수 나눗셈으로 몫만 취한다. 음수를 양수로 나눌 때는
 * 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다
 *
 *  N(2 ≤ N ≤ 11), (1 ≤ Ai ≤ 100)
 *  범위가 적으니 그냥 완전 탐색 하면 될거같음
 */
public class Main {
	static int n;
	static int[] numbers;
	static int[] operators = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		numbers = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		operators = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		dfs(numbers[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int current, int depth) {
		if (depth == n) {
			max = Math.max(max, current);
			min = Math.min(min, current);
			return;
		}

		if (operators[0] > 0) {
			operators[0]--;
			dfs(current + numbers[depth], depth + 1);
			operators[0]++;
		}
		if (operators[1] > 0) {
			operators[1]--;
			dfs(current - numbers[depth], depth + 1);
			operators[1]++;
		}
		if (operators[2] > 0) {
			operators[2]--;
			dfs(current * numbers[depth], depth + 1);
			operators[2]++;
		}
		if (operators[3] > 0) {
			operators[3]--;
			dfs(current / numbers[depth], depth + 1);
			operators[3]++;
		}
	}
}
