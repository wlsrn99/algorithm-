

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n, m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		n = input[0];
		m = input[1];

		int[] arr = new int[m];
		findSequence(0, 1, arr);
		System.out.println(sb);
	}

	private static void findSequence(int idx, int first, int[] arr) {
		if (idx == m) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = first; i <= n; i++) {
			arr[idx] = i;
			findSequence(idx + 1, i, arr);
		}
	}
}