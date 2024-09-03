

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 비밀번호를 찾아주는 프로그램
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int n = input[0]; // 저장된 사이트의 주소 수
		int m = input[1]; // 비밀번호를 찾으려는 사이트의 주소 수

		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String[] input2 = br.readLine().split(" ");
			map.put(input2[0], input2[1]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			sb.append(map.get(br.readLine())).append("\n");
		}

		System.out.println(sb);
	}
}
