

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
	static HashMap<String, Integer> map;
	static ArrayList<ArrayList<Integer>> nodeList;

	static boolean[] visited;
	// 고유한 번호를 부여
	static int num = 0;
	// 최대 사이클 길이를 저장
	static int chainCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = 1;
		while (true) {
			// 테스트 케이스 입력
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			// 데이터 초기화
			map = new HashMap<>();
			nodeList = new ArrayList<>();

			chainCount = 0;

			List<Coordinate> coordinate = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				String a = input[0];
				String b = input[1];

				// 이름에 고유한 번호 부여
				if (!map.containsKey(a))
					map.put(a, ++num);
				if (!map.containsKey(b))
					map.put(b, ++num);

				int x = map.get(a);
				int y = map.get(b);
				coordinate.add(new Coordinate(x, y));
			}

			for (int i = 0; i < num + 1; i++) {
				nodeList.add(new ArrayList<>());
			}

			visited = new boolean[num + 1];

			for (Coordinate node : coordinate) {
				nodeList.get(node.x).add(node.y);
			}

			for (int i = 1; i <= num; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}

			// 결과 출력
			sb.append(testCase++ + " " + chainCount + "\n");
		}

		System.out.print(sb);
	}

	public static void dfs(int idx) {
		visited[idx] = true;
		for (int next : nodeList.get(idx)) {
			if (visited[next]) {
				// 이미 방문한 노드를 만나면 체인이 존재하므로 증가
				chainCount++;
				continue;
			}
			dfs(next);
		}
	}

	private static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}