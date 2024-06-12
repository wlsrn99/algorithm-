

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 처음 단어의 길이가 1일때 2일때 ... length() - 2일때
 * 두번째 단어의 길이가 i + 1
 * 세번째 단어는 나머지
 *
 *
 */
public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int size = input.length;

		String str1 = "";
		List<String> list = new ArrayList<>();
		for (int i = 0; i < size - 2; i++) {
			str1 += "" + input[i];
			String str2 = "";
			for (int j = i + 1; j < size - 1; j++) {
				str2 += "" + input[j];
				String str3 = "";
				for (int k = j + 1; k < size; k++) {
					str3 += "" + input[k];
				}
				list.add(calculate(str1, str2, str3));
			}
		}

		Collections.sort(list);
		System.out.println(list.get(0));
	}

	private static String calculate(String str1, String str2, String str3) {
		String reStr1 = sb.append(str1).reverse().toString();
		sb.setLength(0);
		String reStr2 = sb.append(str2).reverse().toString();
		sb.setLength(0);
		String reStr3 = sb.append(str3).reverse().toString();
		sb.setLength(0);

		return reStr1 + reStr2 + reStr3;
	}
}
