

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int count;
	static int n, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		n = input[0];
		r = input[1];
		c = input[2];

		int size = (int)Math.pow(2, n);

		z(0, 0, size);

		System.out.println(count);
	}

	public static void z(int i, int j, int size) {
		if (size == 1) { //종료조건
			return;
		}

		int half = size / 2;

		if (r < i + half && c < j + half) { //1사분면에 위치
			z(i, j, half);
		} else if (r < i + half && j + half <= c) { //2사분면에 위치
			count += size * size / 4;
			z(i, j + half, half);
		} else if (i + half <= r && c < j + half) { //3사분면에 위치
			count += size * size / 4 * 2;
			z(i + half, j, half);
		} else { //4사분면에 위치
			count += size * size / 4 * 3;
			z(i + half, j + half, half);
		}
	}
}
