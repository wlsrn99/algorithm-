

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *  작업 X을 끝내기 위해서 먼저 해야하는 작업의 개수
 *  만약 6을 처리해야한다면
 *  1 -> 6
 *  2 -> 4 -> 6
 *  이렇게 두 개 가 될수도있다
 *
 *  단방향 그래프를 거꾸로 바꾸면 start를 구하려는 target으로 설정할 수 있다
 *
 *
 *
 */
public class Main {
	static int[] visited;
	static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); //작업할 개수
		int m = Integer.parseInt(input[1]); //작업 순서 정보

		visited = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int node1 = Integer.parseInt(input[0]);
			int node2 = Integer.parseInt(input[1]);

			nodeList.get(node2).add(node1);
		}

		int start = Integer.parseInt(br.readLine());
		dfs(start);
		System.out.println(count - 1);
	}

	public static void dfs(int start) {
		visited[start] = count++;

		for (int next : nodeList.get(start)) {
			if (visited[next] == 0) {
				dfs(next);
			}
		}
	}
}
