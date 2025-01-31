
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 아침에 자기가 기록해 놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다
 * 사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다
 *
 * 4 2 3
 * 큰수부터 거꾸로
 * 덱을 활용해서 주어진 갯수에 맞게 오른쪽에 수를 삽입
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = n - 1; i >= 0; i--) {

			Deque<Integer> temp = new ArrayDeque<>();

			while (deque.size() > input[i]) {
				temp.addLast(deque.pollLast());
			}

			deque.addLast(i + 1);

			while (!temp.isEmpty()) {
				deque.addLast(temp.pollLast());
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			sb.append(deque.pollFirst()).append(" ");
		}
		System.out.println(sb);
	}
}
