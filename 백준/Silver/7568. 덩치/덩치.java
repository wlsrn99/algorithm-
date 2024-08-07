

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<Size> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

			list.add(new Size(input[0], input[1]));
		}

		int[] ranks = new int[n];
		for (int i = 0; i < n; i++) {
			int rank = 1;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (list.get(i).weight < list.get(j).weight &&
						list.get(i).height < list.get(j).height) {
						rank++;
					}
				}
			}
			ranks[i] = rank;
		}

		StringBuilder sb = new StringBuilder();
		for (int rank : ranks) {
			sb.append(rank).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

	private static class Size {
		int weight;
		int height;

		public Size(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	}
}