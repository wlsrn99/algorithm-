
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 5 7 3 7 13 7 14 17 11 16
 * 5 7 7 7 13 13 14 17 17 17
 * -> 가중치를 미리 더한 뒤 바꾸면 오름차순이 된다
 */
public class Main {
	static int[] holes;
	static int[] acorns;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		holes = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int q = Integer.parseInt(br.readLine());
		acorns = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			holes[i] += i;
			if (!map.containsKey(holes[i])) {
				map.put(holes[i], i + 1); //인덱스를 저장
			}
		}

		for (int i = 1; i < n; i++) {
			if (holes[i - 1] >= holes[i]) { //전에 있는 구멍이 현재 구멍보다 크거나 같다면
				holes[i] = holes[i - 1];// 전에 있는 구멍 크기로 바꾸기
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			int idx = binarySearch(0, n - 1, acorns[i]);
			int key = holes[idx];
			sb.append(map.get(key)).append(" ");
		}
		System.out.println(sb);
	}

	static int binarySearch(int start, int end, int target) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (holes[mid] >= target) {
				end = mid; //더 작은 부분 탐색
			} else {
				start = mid + 1; //더 큰 부분 탐색
			}
		}
		return end;
	}

}
