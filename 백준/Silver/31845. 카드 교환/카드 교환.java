

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = input[0];
		int m = input[1];

		int[] score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		PriorityQueue<Card> pq = new PriorityQueue<>((o1, o2) -> o2.score - o1.score);
		for (int i = 1; i <= n; i++) {
			pq.offer(new Card(i, score[i - 1]));
		}

		Deque<Card> deque = new ArrayDeque<>();
		while (!pq.isEmpty()) {
			deque.offer(pq.poll());
		}

		int sum = 0;
		int count = 0;
		while (!deque.isEmpty()) {
			if (deque.peekFirst().score >= 0 && deque.size() >= 2) {
				// 가져오기
				sum += deque.pollFirst().score;
				// 제일 작은 값 주기
				deque.pollLast();
			} else {
				if (deque.peekFirst().score >= 0) {
					//가져오기
					sum += deque.pollFirst().score;
				} else {
					// 더미 주고받으면서 턴을 계속 소비
					break;
				}
			}

			count++;
			if (count == m) {
				break;
			}
		}

		System.out.println(sum);
	}

	private static class Card {
		int num;
		int score;

		public Card(int num, int score) {
			this.num = num;
			this.score = score;
		}
	}
}
