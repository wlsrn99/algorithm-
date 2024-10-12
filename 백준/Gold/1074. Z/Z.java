

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문
 */
public class Main {
	static int count;
	static int n, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		n = input[0];
		r = input[1];
		c = input[2];

		//4등분
		int size = (int)Math.pow(2, n);
		findTarget(0,0,size);
		
		System.out.println(count);
	}

	/**
	 * 2x2
	 *
	 * 1) r = 0 , c = 0 // 1사분면
	 * 0 + 1, 0 + 1
	 * r < 1 , c < 1
	 *
	 * 2) r = 0 , c = 1 // 2사분면
	 * 0 + 1,  0 + 1
	 * r < 1, c >= 1
	 *
	 * 3) r = 1 c = 0 //3사분면
	 * r >= 1, c < 1
	 *
	 *
	 */
	static void findTarget(int x, int y, int size) {
		if (size == 1) {
			return;
		}

		int half = size / 2;
		
		if (r < x + half && c < y + half) { //1사분면
			findTarget(x, y, half);
		} else if (r < x + half && y + half <= c) { //2사분면
			count += size * size / 4;
			findTarget(x, y + half, half);
		} else if (x + half <= r && c < y + half) { //3사분면
			count += size * size / 4 * 2;
			findTarget(x + half, y, half);
		} else { //4사분면
			count += size * size / 4 * 3;
			findTarget(x + half, y + half, half);
		}
	}
}
