

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		//할 일의 개수
		int n = input[0];
		// 일을 처리했을 때 감소하는 중요도
		int m = input[1];
		// 완료한 것으로 간주하는 중요도의 최댓값
		int k = input[2];

		//만족감
		int y = 0;
		// 걸리는 날의 수
		int count = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
		for (int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int p = pq.poll();
			// 만족감 구하기
			int result = y / 2 + p;
			y = result;
			sb.append(result).append("\n");
			// 중요도 하락
			p -= m;

			if (p > k) {
				pq.offer(p);
			}

			count++;
		}

		System.out.println(count);
		System.out.println(sb);
	}
}
