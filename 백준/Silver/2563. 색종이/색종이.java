

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		boolean[][] visited = new boolean[100][100];

		int[] input = new int[2];
		for (int i = 0; i < n; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int column = input[0]; column < input[0] + 10; column++) {
				for (int row = input[1]; row < input[1] + 10; row++) {
					visited[column][row] = true;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (visited[i][j]) {
					sum++;
				}
			}
		}
		System.out.println(sum);

	}
}
