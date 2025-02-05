
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 집 N개가 수직선 위에 있다
 * 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치
 *
 * C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램
 *
 * 1 2 4 8 9
 * 0   0   0
 *
 * 1에서 9까지의 거리는 8
 * 3개의 최대 거리는 8/3 = 2.xx
 * -> 나누어 떨어질 수도 있으므로 크거나 같은 수
 *
 * 공유기의 이상적인 위치는
 * 1, 4, 7
 */
public class Main {
	static int n, m;
	static int[] houses;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		n = input[0];
		m = input[1];

		houses = new int[n];
		for (int i = 0; i < n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(houses);

		//인접한 공유기 사이의 최대 거리를 찾아야 한다
		int start = 1; //최소 거리
		int end = houses[n - 1] - houses[0] + 1; //최대 거리

		int result = upperBound(start, end);

		System.out.println(result - 1);
	}

	private static int upperBound(int start, int end) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (!canRouter(mid)) { //공유기 설치가 가능한지 여부
				//불가능 하면 더 작은 범위를 탐색
				end = mid;
			} else {
				//가능하면 더 큰 범위를 탐색
				start = mid + 1;
			}
		}
		return end;
	}

	private static boolean canRouter(int dist) {
		int count = 1;
		int current = houses[0];

		for (int i = 1; i < n; i++) {
			if (houses[i] - current >= dist) {
				count++;
				current = houses[i];
			}
		}

		return count >= m;
	}

}
