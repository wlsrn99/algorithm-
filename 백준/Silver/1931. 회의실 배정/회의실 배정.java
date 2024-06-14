

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 끝나는 시간 기준으로 정렬하면 시작시간만 비교하면 된다
 * 끝나는 시간이 같을 경우 시작시간이 작은것 부터
 * 끝나는 시간과 시작시간이 같은 경우도 생각
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Meeting> pq = new PriorityQueue<>(((o1, o2) -> {
			if (o1.end != o2.end) {
				return o1.end - o2.end;
			} else {
				return o1.start - o2.start;
			}
		}));
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			pq.offer(new Meeting(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}

		int count = 1;
		Meeting current = pq.poll();
		while (!pq.isEmpty()) {
			Meeting next = pq.poll();
			if (next.end == current.end) {
				if (next.start == next.end) {
					count++;
					current = next;
				}
			} else {
				if (current.end <= next.start) {
					count++;
					current = next;
				}
			}
		}
		System.out.println(count);

	}

	private static class Meeting {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
