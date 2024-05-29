

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	/**
	 * 금메달 수가 더 많은 나라
	 * 금메달 수가 같으면, 은메달 수가 더 많은 나라
	 * 금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라
	 * 다 같으면 공동 순위
	 *
	 * 한 국가의 등수는 (자신보다 더 잘한 나라 수) + 1
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		int rank = 1;
		int gold = 0;
		int silver = 0;
		int bronze = 0;

		Country[] countries = new Country[n];
		for (int i = 0; i < n; i++) {
			int[] detail = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			countries[i] = new Country(detail[0], detail[1], detail[2], detail[3]);

			if (detail[0] == k) {
				gold = detail[1];
				silver = detail[2];
				bronze = detail[3];
			}
		}

		for (Country country : countries) {
			if (country.gold > gold) {
				rank++;
				continue;
			} else if (country.silver > silver && country.gold == gold) {
				rank++;
				continue;
			} else if (country.bronze > bronze && country.silver == silver) {
				rank++;
				continue;
			}
		}

		System.out.println(rank);

	}

	private static class Country {
		int num;
		int gold;
		int silver;
		int bronze;

		public Country(int num, int gold, int silver, int bronze) {
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
	}
}
