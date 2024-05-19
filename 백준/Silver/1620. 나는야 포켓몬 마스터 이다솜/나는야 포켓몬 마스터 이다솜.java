

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 *  N이랑 내가 맞춰야 하는 문제의 개수 M이 주어져.
		 *  N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		int m = input[1];

		Map<String, Integer> nameMap = new HashMap<>();
		Map<Integer, String> numMap = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String name = br.readLine();

			nameMap.put(name, i);
			numMap.put(i, name);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String condition = br.readLine();

			if (condition.charAt(0) >= 65) {
				sb.append(nameMap.get(condition)).append("\n");
			} else {
				sb.append(numMap.get(Integer.parseInt(condition))).append("\n");
			}
		}

		System.out.println(sb);
	}
}
