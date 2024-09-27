

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 좌표 압축
 * 제일 작은 수가 0
 * 그 다음으로 큰 수가 1이 되는 형식
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int[] temp = Arrays.stream(input).sorted().toArray();
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i : temp) {
			if (!map.containsKey(i)) {
				map.put(i, count);
				count++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : input) {
			sb.append(map.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}
