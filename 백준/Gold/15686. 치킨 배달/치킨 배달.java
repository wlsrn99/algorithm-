

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static boolean[] visited;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		List<Coordinate> houses = new ArrayList<>();
		List<Coordinate> chickens = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int value = Integer.parseInt(input[j]);
				if (value == 1) {
					houses.add(new Coordinate(i, j));
				} else if (value == 2) {
					chickens.add(new Coordinate(i, j));
				}
			}
		}

		visited = new boolean[chickens.size()];

		combination(chickens, houses, 0, m);

		System.out.println(result);
	}

	private static void combination(List<Coordinate> chickens, List<Coordinate> houses, int start, int m) {
		if (m == 0) {
			result = Math.min(result, getCityChickenDistance(chickens, houses));
			return;
		}
		int size = chickens.size();

		for (int i = start; i < size; i++) {
			visited[i] = true;
			combination(chickens, houses, i + 1, m - 1);
			visited[i] = false;
		}
	}

	private static int getCityChickenDistance(List<Coordinate> chickens, List<Coordinate> houses) {
		int totalDistance = 0;
		int size = chickens.size();
		for (Coordinate house : houses) {
			int minDistance = Integer.MAX_VALUE;
			for (int i = 0; i < size; i++) {
				if (visited[i]) {
					int distance = Math.abs(house.x - chickens.get(i).x) + Math.abs(house.y - chickens.get(i).y);
					minDistance = Math.min(minDistance, distance);
				}
			}
			totalDistance += minDistance;
		}

		return totalDistance;
	}

	private static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
