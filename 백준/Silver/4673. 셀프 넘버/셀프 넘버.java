

/**
 * 크기가 10000인 방문배열을 생성
 * 방문을 안한 숫자 모두 출력
 */
public class Main {
	static boolean[] visited;

	public static void main(String[] args) {
		visited = new boolean[10001];
		for (int i = 1; i < 10001; i++) {
			calculate(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 10001; i++) {
			if (!visited[i]) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb);
	}

	private static void calculate(int i) {
		int result = i;
		while (i > 0) {
			int num = i % 10;
			i = i / 10;
			result += num;
		}
		if (result < 10001) {
			visited[result] = true;
		}

	}
}
