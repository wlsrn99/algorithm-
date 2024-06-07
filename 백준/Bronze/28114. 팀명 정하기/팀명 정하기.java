

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 1.세 참가자의 입학 연도를 100으로 나눈 나머지를 오름차순으로 정렬해서 이어 붙인 문자열
 * 2.세 참가자 중 성씨를 영문으로 표기했을 때의 첫 글자를 백준 온라인 저지에서 해결한 문제가 많은 사람부터 차례대로 나열한 문자열
 *
 * 1. 입학연도를 100으로 나눈 배열을 따로 만들어서 오름차순 정렬 후 이어 붙이기
 * 2. 참가자의 이름, 백준 해결한 문제를 필드로 가지는 클래스를 만들고 내림차순 우선순위 큐를 만들어서 charAt(0)으로 이름 이어붙이기
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Info> pq2 = new PriorityQueue<>((o1, o2) -> o2.problem - o1.problem);
		for (int i = 0; i < 3; i++) {
			String[] input = br.readLine().split(" ");

			int problem = Integer.parseInt(input[0]);
			int year = Integer.parseInt(input[1]);
			String name = input[2];

			pq1.offer(year % 100);
			pq2.offer(new Info(problem, name.charAt(0)));
		}

		String result1 = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			result1 += pq1.poll();
			sb.append(pq2.poll().lastName);
		}

		System.out.println(result1 + "\n" + sb);
	}

	private static class Info {
		int problem;
		char lastName;

		public Info(int problem, char lastName) {
			this.problem = problem;
			this.lastName = lastName;
		}
	}
}
