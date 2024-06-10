import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 더이상 간선을 따라 이동할 수 없는 경우 -> list.get의 길이가 0일 때
 * dfs를 사용해서 길이가 0인 경우 방문했는지 비교
 */
public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
	static int[] sIdx;
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		visited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int node1 = Integer.parseInt(input[0]);
			int node2 = Integer.parseInt(input[1]);

			nodeList.get(node1).add(node2);
		}
		int s = Integer.parseInt(br.readLine());
		sIdx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		dfs(1);
		String result = check ? "yes" : "Yes";
		System.out.println(result);
	}

	private static void dfs(int start) {
		if (check) {
			return;
		}

		visited[start] = true;
		if (nodeList.get(start).isEmpty()) {
			boolean existence = true;
			for (int idx : sIdx) {
				if (visited[idx]) {
					existence = false;
					break;
				}
			}

			if (existence) {
				check = true;
			}
		} else {
			for (int next : nodeList.get(start)) {
				visited[next] = true;
				dfs(next);
				visited[next] = false;
			}
		}
	}
}
