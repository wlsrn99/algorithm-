

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 첫 징검다리는 점프해서 아무 것이나 밟을 수 있다
 * 밟을 수 있는 징검다리의 최대 갯수 -> 두번째 징검다리 start는 항상 1로 시작
 * 이전에 점프한 거리보다 1이상 긴거리를 점프해야하니까..
 * 1 3 6 10 15 21
 * 1 1 + 2 1+2+3 1+2+3+4
 * -> n * (n + 1) / 2
 *
 *
 * start = 1 end = N
 * 이분탐색해서 n * (n + 1) / 2을 충족하는 하한 값을 찾는다
 *
 *
 */
public class Main {
	static long n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			n = Long.parseLong(br.readLine());

			long result = lowerbound(1, (long)Math.sqrt(2 * n) + 1);
			//해당 값이 유요한지 검사
			if (result * (result + 1) / 2 > n) {
				result -= 1;
			}
			System.out.println(result);
		}
	}

	static long lowerbound(long start, long end) {
		while (start < end) {
			long mid = start + (end - start) / 2;
			if (isImPossible(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}

	private static boolean isImPossible(long mid) {
		// mid개의 징검다리를 건널 때 필요한 최소 징검다리의 수를 계산
		long min = mid * (mid + 1) / 2;

		// 필요한 징검다리의 수가 주어진 징검다리의 수보다 많으면 건널 수 없음
		return min >= n;
	}
}
