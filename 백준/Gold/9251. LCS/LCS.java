

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();

		int len1 = str1.length;
		int len2 = str2.length;

		int[][] dp = new int[len1 + 1][len2 + 1]; // str1의 i번째 문자까지와 str2의 j번째 문자까지의 LCS 길이를 저장한 배열

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1; //이전 LCS 길이에 1을 더하기
				} else {
					//첫 번째 문자열에서 현재 문자를 제외하고 이전까지의 LCS 길이와
					//두 번째 문자열에서 현재 문자를 제외하고 이전까지의 LCS 길이 중에서
					//긴 것을 선택
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[len1][len2]);
	}
}