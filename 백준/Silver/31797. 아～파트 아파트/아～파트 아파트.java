

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		int m = input[1];

		int resultLayer = n % (m * 2);

		PriorityQueue<Hand> pq = new PriorityQueue<>(((o1, o2) -> o1.sequence - o2.sequence));
		for (int i = 1; i < m + 1; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < 2; j++) {
				pq.offer(new Hand(i, input[j]));
			}
		}

		for (int i = 0; i < resultLayer - 1; i++) {
			pq.poll();
		}

		Hand result = pq.poll();

		System.out.println(result.number);
	}

	private static class Hand {
		int number; // 사람 번호
		int sequence; // 손 순서

		public Hand(int number, int sequence) {
			this.number = number;
			this.sequence = sequence;
		}
	}
}
