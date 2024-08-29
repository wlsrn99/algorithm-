

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  N이랑 내가 맞춰야 하는 문제의 개수 M
 *  N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		int m = input[1];

		Map<String, Integer> numMap = new HashMap<>();
		String[] nameArr = new String[n + 1];

		for (int i = 1; i <= n; i++) {
			String name = br.readLine();

			numMap.put(name, i);
			nameArr[i] = name;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String condition = br.readLine();

			// "일부 포켓몬은 마지막 문자만 대문자일 수도 있어" 라는 조건이 있는데 일단 통과가 되네요
			// isDist라는 메서드를 사용해서 숫자인지 문자인지 파악할 수 있다고 하네요
			// if (condition.charAt(0) >= 'A') { // 포켓몬의 이름은 모두 영어
			if (!Character.isDigit(condition.charAt(0))) { //숫자면 true 문자면 false
				int num = numMap.get(condition);
				sb.append(num).append("\n");
			} else {
				int idx = Integer.parseInt(condition);
				sb.append(nameArr[idx]).append("\n");
			}
		}

		System.out.println(sb);
	}
}
