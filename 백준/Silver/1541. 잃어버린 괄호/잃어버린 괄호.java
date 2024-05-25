

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 * -가 나오면 다음 -가 나올때 까지 괄호
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("-");
		List<String> list = new ArrayList<>();

		for (String s : input) {
			list.add(s);
		}

		int size = list.size();

		long sum = 0;
		for (int i = 0; i < size; i++) {
			int[] numArr = Arrays.stream(list.get(i).split("\\+")).mapToInt(Integer::parseInt).toArray();

			if (i == 0) {
				for (int num : numArr) {
					sum += num;
				}
			} else {
				for (int num : numArr) {
					sum -= num;
				}
			}
		}

		System.out.println(sum);
	}
}
