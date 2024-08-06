

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}

		StringBuilder sb = new StringBuilder();
		for (int result : set) {
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

}
