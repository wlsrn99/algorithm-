

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 어떤 문제의 난이도는 그 문제를 푼 사람들이 제출한 난이도 의견을 바탕으로 결정
 *
 * 아직 아무 의견이 없다면 문제의 난이도는 0으로 결정한다.
 * 의견이 하나 이상 있다면, 문제의 난이도는 모든 사람의 난이도 의견의 30% 절사평균으로 결정한다
 *
 * 제일 높은 난이도와 제일 낮은 난이도
 * 모든 난이도 의견은 1 이상 30 이하
 *
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			dq.add(pq.poll());
		}

		int num = (int)Math.round(n * 0.15);
		for (int i = 0; i < num; i++) {
			dq.pollFirst();
			dq.pollLast();
		}

		double size = dq.size();
		double sum = 0;
		while (!dq.isEmpty()) {
			sum += dq.poll();
		}

		int avg = (int)Math.round(sum / size);
		System.out.println(avg);
	}
}
