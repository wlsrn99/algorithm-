
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, S;
	static int[] arr;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);

		arr = new int[N];
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		dfs(0, 0);

		// 합이 0인 경우 공집합도 포함되므로 count에서 1을 빼줍니다
		if (S == 0) {
			count--;
		}

		System.out.println(count);
	}

	public static void dfs(int depth, int sum) {
		if (depth == N) {
			if (sum == S) {
				count++;
			}
			return;
		}

		// 현재 수를 포함하는 경우
		dfs(depth + 1, sum + arr[depth]);
		// 현재 수를 포함하지 않는 경우
		dfs(depth + 1, sum);
	}
}
