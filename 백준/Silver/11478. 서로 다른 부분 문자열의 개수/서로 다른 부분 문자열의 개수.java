

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	/**
	 *
	 * 연속하는 부분 문자열 -> 처음과 끝을 정하고 그 사이에 있는 문자들
	 * 서로 다른 것 -> set
	 *
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		System.out.println(calculateSectionArrayCount(S));
	}

	private static int calculateSectionArrayCount(String s) {
		Set<String> set = new HashSet<>();
		int size = s.length();
		for (int i = 1; i <= size; i++) {
			int start = 0; //처음 지점
			int end = i; //끝나는 지점
			while (start < end) {
				set.add(s.substring(start, end));
				start++;
			}
		}
		return set.size();
	}
}
