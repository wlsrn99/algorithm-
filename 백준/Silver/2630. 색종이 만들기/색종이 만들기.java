

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  N은 2, 4, 8, 16, 32, 64, 128 중 하나
 * 하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1
 *
 *
 */
public class Main {
	static int[][] arr;
	static int white;
	static int blue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		calculate(0, 0, n);
		System.out.println(white + "\n" + blue);
	}

	private static void calculate(int x, int y, int len) {
		int sum = 0;
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				sum += arr[i][j];
			}
		}

		if (sum == 0) {
			white++;
		} else if (sum == len * len) {
			blue++;
		} else if (len > 1) {
			int n = len / 2;
			calculate(x, y, n); //1사분면
			calculate(x, y + n, n); //2사분면
			calculate(x + n, y, n); //3사분면
			calculate(x + n, y + n, n); //4사분면
		}
	}
}
