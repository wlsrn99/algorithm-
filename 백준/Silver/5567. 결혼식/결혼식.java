
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 자신의 친구와 친구의 친구
 * 상근 - 친구 - 친구친구
 *
 * 상근이의 동기는 모두 N명이고, 이 학생들의 학번은 모두 1부터 N까지이다
 * 상근이의 학번은 1이다
 */
public class Main {
	static List<List<Integer>> nodeList = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //상근이의 동기 수
		int m = Integer.parseInt(br.readLine()); //리스트의 길이

		visited = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 1; i <= m; i++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

			int v1 = input[0];
			int v2 = input[1];
			nodeList.get(v1).add(v2);
			nodeList.get(v2).add(v1);
		}

		// List<Integer> friend = nodeList.get(1);
		// Set<Integer> invitation = new HashSet<>();
		//
		// for (Integer i : friend) {
		// 	List<Integer> friendOfFriend = nodeList.get(i);
		// 	for (Integer j : friendOfFriend) {
		// 		invitation.add(j);
		// 	}
		// }
		//
		// invitation.remove(1);
		// System.out.println(invitation.size());

		System.out.println(bfs());
	}

	private static int bfs() {
		visited[1] = true;
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		for (Integer i : nodeList.get(1)) {
			queue.add(i);
			visited[i] = true;
			count++;
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (Integer i : nodeList.get(current)) {
				if (!visited[i]) {
					visited[i] = true;
					count++;
				}
			}
		}

		return count;
	}
}
