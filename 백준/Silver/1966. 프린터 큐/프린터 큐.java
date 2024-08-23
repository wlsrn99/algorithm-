

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인
 * 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치
 *
 * 뒤에 재배치 -> 덱 활용
 */
public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

			int n = input[0]; // 문서의 개수
			int m = input[1]; // 몇 번째로 인쇄되었는지 궁금한 문서의 인덱스

			int[] document = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

			Deque<Integer> deque = new ArrayDeque<>();
			for (int j = 0; j < n; j++) {
				deque.offerLast(j); //문서의 인덱스를 저장
			}
			
			// 프린터기 실행
			doPrinter(deque, document, m);
		}
		System.out.println(sb);
	}

	private static void doPrinter(Deque<Integer> deque, int[] document, int m) {
		int count = 0;
		while (!deque.isEmpty()) {
			int current = deque.pollFirst();
			boolean check = false;

			for (int idx : deque) {
				if (document[current] < document[idx]) {
					check = true;
					deque.offerLast(current);
					break;
				}
			}

			if (!check) {
				// 인쇄 순서 증가
				count++;
				if (current == m) {
					sb.append(count).append("\n");
					break;
				}
			}
		}
	}
}
