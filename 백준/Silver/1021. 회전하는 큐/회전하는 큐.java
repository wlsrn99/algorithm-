

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 양방향 순환 큐 -> 덱
 * 첫 번째 원소를 뽑아낸다 -> pollFirst
 * 왼쪽으로 한 칸 이동시킨다 -> pollFirst - offerLast
 * 오른쪽으로 한 칸 이동시킨다 -> pollLast - offerFirst
 *
 * 2번, 3번 연산의 최솟값
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); //큐의 크기
		int m = Integer.parseInt(input[1]); //뽑아내려고 하는 수의 개수

		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			deque.offerLast(i);
		}

		int count = 0; //2번,3번 연산의 최솟값
		for (int i = 0; i < m; i++) {
			/**
			 * 
			 * 왼쪽부터 오른쪽으로 가면 오름차순, 오른쪽부터 왼쪽으로가면 내림차순
			 * 1 99          10
			 * 5 4           10
			 * 오름차순으로 찾을건지, 내림차순으로 찾을건지 결정해야 함
			 *
			 *
			 **/
			int index = 0;
			int target = nums[i];
			// deque 내에서의 인덱스 찾기
			for (Integer num : deque) {
				if (num == target) {
					break;
				}
				index++;
			}

			// 더 가까운 방향으로 찾기
			if (index < deque.size() - index) {
				while (deque.peekFirst() != target) {
					deque.offerLast(deque.pollFirst());
					count++;
				}
			} else {
				while (deque.peekFirst() != target) {
					deque.offerFirst(deque.pollLast());
					count++;
				}
			}
			deque.pollFirst(); // target 제거
		}
		System.out.println(count);

	}

}

