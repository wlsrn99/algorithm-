

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 점의 개수 N 선분의 개수 M
 * 존재하는 점의 갯수를 반환하는 이분탐색 메소드를 만들기
 * 점의 개수를 저장하는 배열 -> static선언
 * 이분탐색 메소드에 선분의 양 끝 점을 start end 파라미터로 전달
 * 선분의 갯수만큼 for문 돌려서 결과 반환
 *
 * -> 시간 초과
 * 점의 개수를 정렬,
 * start를 찾기 위해 점 배열의 길이만큼 이분탐색 진행, start가 없을 수도 있으므로
 * 이분탐색의 하한을 찾기 -> start보다 크거나같고 제일 작은 숫자
 * end를 찾기 위해 점 배열의 길이만큼 이분탐색 진행, 마찬가지로 end가 없을 수도 있으므로
 * 이분탐색의 상한을 찾기 -> end보다 작거나같고 제일 큰 숫자
 *
 *
 *
 */
public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); // 점의 개수
		int m = Integer.parseInt(input[1]); // 선분의 개수

		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);

			int count = findRange(start, end);
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static int findRange(int start, int end) {
		int left = findLowerBound(start);
		int right = findUpperBound(end) - 1; // upper bound 수정

		return right - left + 1;
	}

	private static int findUpperBound(int target) {
		int lo = 0;
		int hi = arr.length;

		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {

			int mid = (lo + hi) / 2; // 중간위치를 구한다.

			// key값이 중간 위치의 값보다 작을 경우
			if (target < arr[mid]) {
				hi = mid;
			}
			// 중복원소의 경우 else에서 처리된다.
			else {
				lo = mid + 1;
			}
		}
		return lo;
	}

	private static int findLowerBound(int target) {
		int lo = 0;
		int hi = arr.length;

		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {

			int mid = (lo + hi) / 2;

			/*
			 *  target 값이 중간 위치의 값보다 작거나 같을 경우
			 *
			 *  (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
			 */
			if (target <= arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}

		}
		return lo;
	}

}
