

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	/**
	 *  X라는 정수가 존재하는지 알아내는 프로그램
	 *  배열, target의 위치 -> 이분탐색
	 *
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arrN = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		
		int m = Integer.parseInt(br.readLine());
		int[] arrM = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		
		Arrays.sort(arrN);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int num = arrM[i];

			int result = Arrays.binarySearch(arrN, num) >= 0 ? 1 : 0;
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}

