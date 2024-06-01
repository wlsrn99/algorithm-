

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int size = Integer.parseInt(br.readLine());

		String inputString = br.readLine();

		int patternCount = 0; // IOI 패턴 개수
		int continuity = 0; // 연속된 문자 개수
		char prev = 'O'; // 초기 이전 문자 O로 설정

		for (int i = 0; i < size; i++) {
			char current = inputString.charAt(i); // 현재 문자

			// 현재 문자와 이전 문자가 다르면 연속된 문자 개수 증가
			if (prev != current) {
				continuity++;
			} else { // 현재 문자와 이전 문자가 같으면 연속된 문자 개수 초기화
				if (current == 'O') {
					continuity = 0;
				} else {
					continuity = 1;
				}
			}

			prev = current; // 이전 문자 업데이트

			// 연속된 문자 개수가 2N+1 이상이고 홀수이면 IOI
			if (continuity >= 2 * n + 1 && continuity % 2 != 0) {
				patternCount++;
			}
		}

		System.out.println(patternCount);
	}
}
