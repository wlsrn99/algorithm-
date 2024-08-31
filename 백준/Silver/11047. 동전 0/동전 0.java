

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = input[0]; // 동전의 종류
		int k = input[1]; // 가치의 합

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		for (int i = n-1; i >= 0; i--) {
			if (k >= arr[i]) {
				count += k / arr[i];
				k %= arr[i];
			}
			if (k == 0) break;
		}

		System.out.println(count);
	}
}