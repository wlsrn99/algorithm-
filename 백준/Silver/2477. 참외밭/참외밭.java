

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 결국 넓이를 구해야 하는 문제
 * 넓이 = 큰 직사각형 - 작은 직사각형
 *
 * 가로방향 -> 1, 2
 * 세로방향 -> 3, 4
 *
 * 큰 직사각형 = 가로, 세로 중에 제일 큰 길이
 *
 * 4 2 3 1 3 1
 * 2 3 1 3 1 4
 * 3 1 3 1 4 2
 *
 * 작은 직사각형 길이 = 큰 길이 인덱스 + 3
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		int widthMax = 0;
		int heightMax = 0;

		int widthIdx = 0;
		int heightIdx = 0;

		int[] direction = new int[6];
		int[] len = new int[6];

		for (int i = 0; i < 6; i++) {
			String[] input = br.readLine().split(" ");
			direction[i] = Integer.parseInt(input[0]);
			len[i] = Integer.parseInt(input[1]);
			if (direction[i] == 1 || direction[i] == 2) {
				if (widthMax < len[i]) {
					widthMax = len[i];
					widthIdx = i;
				}
			} else {
				if (heightMax < len[i]) {
					heightMax = len[i];
					heightIdx = i;
				}
			}
		}

		int maxArea = widthMax * heightMax;
		widthIdx += 3;
		heightIdx += 3;

		int minArea = len[widthIdx % 6] * len[heightIdx % 6];
		System.out.println((maxArea - minArea) * k);

	}

}
