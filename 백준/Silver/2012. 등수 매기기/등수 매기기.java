

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  A등으로 예상하였는데 실제 등수가 B등이 될 경우, 이 사람의 불만도는 A와 B의 차이 (|A - B|)로 수치화
 *  각 사람의 예상 등수가 주어졌을 때, 김 조교를 도와 이러한 불만도의 합을 최소로 하는 프로그램
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		// 500,000 x 500,000 = 250,000,000,000
		// long
		long result = 0;
		for (int rank = 1; rank <= n; rank++) {
			int expectation = pq.poll();
			int current = Math.abs(rank - expectation);

			result += current;
		}
		System.out.println(result);
	}
}
