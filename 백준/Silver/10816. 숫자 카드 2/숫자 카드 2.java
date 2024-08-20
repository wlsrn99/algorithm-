

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] nCard = br.readLine().split(" ");
		int M = Integer.parseInt(br.readLine());
		String[] mCard = br.readLine().split(" ");

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(nCard[i], map.getOrDefault(nCard[i], 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		for (String key : mCard) {
			Integer sangGeunCardValue = map.get(key);

			if (sangGeunCardValue != null) {
				sb.append(sangGeunCardValue).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}

		System.out.println(sb);
	}
}
