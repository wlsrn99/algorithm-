

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Deque<Integer> deque = new ArrayDeque<>();

		// arr[i] = 0이면 큐, 1이면 스택
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		// 스택에 대해선 신경쓸 필요가 없으므로 큐 자료구조인 것만 저장
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(input[i]);
			if (arr[i] == 0) {
				deque.addLast(num);
			}
		}

		int M = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			deque.addFirst(Integer.parseInt(input[i]));
			sb.append(deque.pollLast()).append(" ");
		}
		
		System.out.print(sb);
	}
}
