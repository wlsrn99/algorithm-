

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Set<String> set = new TreeSet<>(((o1, o2) -> {
			if (o1.length() != o2.length()) {
				return o1.length() - o2.length();
			} else {
				return o1.compareTo(o2);
			}
		}));

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		StringBuilder sb = new StringBuilder();
		for (String s : set) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);

	}
}
