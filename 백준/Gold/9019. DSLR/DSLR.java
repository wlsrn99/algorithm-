

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다.
 * 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
 *
 * S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다.
 * n이 0 이라면 9999 가 대신 레지스터에 저장된다.
 *
 * L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다.
 * 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
 *
 * R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다.
 * 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
 *
 * A에서 B로 변환하기 위해 필요한 최소한의 명령어 나열을 출력
 */
public class Main {
	static int MAX = 9999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

			int first = input[0];
			int last = input[1];

			sb.append(bfs(first, last)).append("\n");
		}
		System.out.println(sb);
	}

	private static String bfs(int first, int last) {
		boolean[] visited = new boolean[MAX + 1];
		String[] command = new String[MAX + 1];
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(first);
		visited[first] = true;
		command[first] = "";

		String result = "";
		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == last) {
				result = command[current];
				break;
			}

			int d = D(current);
			int s = S(current);
			int l = L(current);
			int r = R(current);

			if (!visited[d]) {
				queue.offer(d);
				visited[d] = true;
				command[d] = command[current] + "D";
			}
			if (!visited[s]) {
				queue.offer(s);
				visited[s] = true;
				command[s] = command[current] + "S";
			}
			if (!visited[l]) {
				queue.offer(l);
				visited[l] = true;
				command[l] = command[current] + "L";
			}
			if (!visited[r]) {
				queue.offer(r);
				visited[r] = true;
				command[r] = command[current] + "R";
			}
		}
		return result;
	}

	private static int D(int n) {
		int result = n * 2;
		if (result > MAX) {
			result %= 10000;
		}
		return result;
	}

	private static int S(int n) {
		int result = n - 1;
		if (n == 0) {
			result = MAX;
		}
		return result;
	}

	private static int L(int n) {
		int d1 = n / 1000;
		n %= 1000;
		int d2 = n / 100;
		n %= 100;
		int d3 = n / 10;
		n %= 10;
		int d4 = n;
		String result = d2 + "" + d3 + "" + d4 + "" + d1;
		return Integer.parseInt(result);
	}

	private static int R(int n) {
		int d1 = n / 1000;
		n %= 1000;
		int d2 = n / 100;
		n %= 100;
		int d3 = n / 10;
		n %= 10;
		int d4 = n;
		String result = d4 + "" + d1 + "" + d2 + "" + d3;
		return Integer.parseInt(result);
	}
}
