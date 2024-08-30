

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
	/**
	 * 듣도 보도 못한 사람의 명단
	 *
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int n = input[0]; //듣도 못한 사람 수
		int m = input[1]; //보도 못한 사람 수

		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		List<String> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String current = br.readLine();
			if (set.contains(current)) {
				list.add(current);
			}
		}
		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");

		for (String s : list) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);

	}

}
