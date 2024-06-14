

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  불만도의 합을 최소로 하는 프로그램 (|A - B|)
 *  각 사람이 제출한 예상 등수를 바탕으로 임의로 등수, 동석차 없이
 *  1 5 3 1 2
 *
 *  1 1 2 3 5 
 *  1 2 3 4 5 
 *
 *  정렬 후 i + 1와 비교, i + 1과 같지 않다면 불만도 합하기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		long sum = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != i + 1) {
				sum += Math.abs(arr[i] - (i + 1));
			}
		}
		System.out.println(sum);
	}
}
