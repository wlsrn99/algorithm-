

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] arr = new int[input[0]];
		int value = input[1];
		int idx = 0;
		for (int i = 0; i < input[0]; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (value / arr[i] != 0) {
				idx = i;
			}
		}

		int count = 0;
		for (int i = idx; i >= 0; i--) {
			if (value == 0) {
				break;
			}

			if (value / arr[i] == 0) {
				continue;
			}

			count += value / arr[i];
			value %= arr[i];
		}

		System.out.println(count);
	}
}
