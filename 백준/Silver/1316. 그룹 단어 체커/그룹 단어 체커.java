

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split("");
			if (arr.length == 1) {
				count++;
			} else {
				if (calcuate(arr)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static boolean calcuate(String[] arr) {
		String temp = arr[0];
		int size = arr.length;
		List<String> list = new ArrayList<>();

		for (int i = 1; i < size; i++) {

			for (String s : list) {
				if (s.equals(arr[i])) {
					return false;
				}
			}

			if (!temp.equals(arr[i])) {
				list.add(temp);
				temp = arr[i];
			}
		}
		return true;
	}
}
