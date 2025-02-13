
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] days;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		n = input[0];
		m = input[1];

		days = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			days[i] = Integer.parseInt(br.readLine());
		}

		int start = Arrays.stream(days).min().getAsInt();
		int end = Arrays.stream(days).sum();

		int result = lowerBound(start, end, m);
		System.out.println(result);
	}

	//하한
	static int lowerBound(int start, int end, int target) {
		int result = end + 1; // 안전성을 위해 범위 밖 값으로 초기화
		while (start <= end) {
			int mid = (start + end) / 2;
			if (isCount(mid, target)) { // m보다 작거나 같을 경우 인출 금액이 크다는 의미이므로 더 작은 범위를 탐색해야한다
				result = mid; // 결과 갱신
				end = mid - 1; // 왼쪽 범위 탐색
			} else {
				start = mid + 1; // 오른쪽 범위 탐색
			}
		}
		return result; // target 이상인 첫 번째 위치 반환
	}

	private static boolean isCount(int price, int target) {
		int count = 1;
		int current = price;
		for (int i = 1; i <= n; i++) {
			if (current >= days[i]) {
				current -= days[i];
			} else {
				count++;
				current = price;
				current -= days[i];
			}

			if (current < 0) {
				//금액을 더 높여야 하므로 false
				return false;
			}
		}

		return target >= count;
	}
}
