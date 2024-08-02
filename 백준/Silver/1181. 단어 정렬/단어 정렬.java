

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * 길이가 짧은 것부터
 * 길이가 같으면 사전 순으로
 * 단, 중복된 단어는 하나만 남기고 제거해야 한다
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<String> treeSet = new TreeSet<>((o1, o2) -> {
			int len1 = o1.length();
			int len2 = o2.length();
			if (len1 != len2) {
				return len1 - len2;
			} else {
				return o1.compareTo(o2);
			}
		});

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			treeSet.add(str);
		}

		StringBuilder sb = new StringBuilder();
		for (String s : treeSet) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}
