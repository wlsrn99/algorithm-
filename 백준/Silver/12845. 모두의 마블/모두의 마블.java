

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 카드는 인접한 카드여야 한다.
 * 업그레이드 된 카드 A의 레벨은 변하지 않는다.
 *
 * 카드 합성을 할 때마다 두 카드 레벨의 합만큼 골드를 받는다
 *
 *
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int max = Arrays.stream(input).max().getAsInt();
		int idx = 0;
		for (int i = 0; i < n; i++) {
			if (input[i] == max) {
				idx = i;
				break;
			}
		}

		int sum = 0;
		for (int i = 0; i < idx; i++) {
			sum += input[i] + max;
		}

		if (idx < n) {
			for (int i = idx + 1; i < n; i++) {
				sum += input[i] + max;
			}
		}

		System.out.println(sum);
	}
}
