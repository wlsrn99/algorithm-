
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int x, len;
	static char[] xArr;
	static boolean[] visited;
	static int MAX = 1000000;
	static int min = MAX;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		x = Integer.parseInt(input);
		xArr = input.toCharArray();
		len = xArr.length;
		visited = new boolean[len];

		char[] num = new char[len];
		dfs(num, 0);
		System.out.println(min == MAX ? 0 : min);
	}

	private static void dfs(char[] num, int depth) {
		if (depth == len) {
			int result = Integer.parseInt(String.valueOf(num));
			if (x < result) {
				min = Math.min(min, result);
			}
			return;
		}

		for (int i = 0; i < len; i++) {
			if (!visited[i]) {
				visited[i] = true;
				num[depth] = xArr[i];
				dfs(num, depth + 1);
				visited[i] = false;
			}
		}
	}
}
