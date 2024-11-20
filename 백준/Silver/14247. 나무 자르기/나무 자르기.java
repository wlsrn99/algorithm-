

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 영선이는 하루에 한 나무씩
 * n일 산에 오르며 나무를 잘라갈 것이다 -> 하루에 하나씩
 *
 * 나무들이 밤만 되면 매우 빠른 속도로 자라는데, 그 자라는 길이는 나무마다 다르다
 *
 * 나무의 처음 길이와 하루에 자라는 양이 주어졌을 때, 영선이가 얻을 수 있는 최대 나무양
 */
public class Main {
	private static class Tree {
		int idx;
		int len;
		int plus;

		public Tree(int idx, int len, int plus) {
			this.idx = idx;
			this.len = len;
			this.plus = plus;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] trees = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] plus = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		Queue<Tree> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.plus));
		for (int i = 0; i < n; i++) {
			pq.add(new Tree(i, trees[i], plus[i]));
		}

		long sum = 0;
		for (int day = 0; day < n; day++) {
			Tree current = pq.poll();
			sum += current.len + (long)current.plus * day;
		}

		System.out.println(sum);
	}
}