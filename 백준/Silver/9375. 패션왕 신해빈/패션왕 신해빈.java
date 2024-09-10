
/**
 * 알몸만 아니면 되는거니까, 존재 하는 의상 종류는 입는경우 안입는 경우의 수가 추가된다
 * 따라서 경우의 수는 (각 종류의 개수 + 1) * (각 종류의 개수 +1) ``` 이런 식
 * 이 경우의 수에서 알몸인 경우 -1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				String[] s = br.readLine().split(" ");
				String key = s[1];
				map.put(key, map.getOrDefault(key, 1) + 1);
			}

			int multi = 1;
			for (int value : map.values()) {
				multi *= value;
			}
			sb.append(multi - 1).append("\n");
		}
		System.out.println(sb);
	}
}

