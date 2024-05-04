

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr, ((o1, o2) -> o2 - o1));

		int w = arr[0];

		for (int i = 1; i < n; i++) {
			w = Math.max(w, arr[i] * (i + 1));
		}

		System.out.println(w);
	}
}
