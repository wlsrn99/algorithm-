

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 *
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다
 * N은 홀수이다.
 * 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다
 * 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
 *
 * 산술평균
 * 중앙값 -> 입력받은 값들을 배열로 저장한 뒤 오름차순 정렬 후 0부터 N-1의 중간 인덱스
 * 최빈값 -> 정렬된 배열을 순서대로 HashMap에 넣고 등장횟수를 저장함 그리고 최대횟수를 변수에 저장해 놓고,
 *         순서대로 value값을 순회하면서 최대로 나온 숫자가 어떤건지 찾는데 여러개일 경우를 처리해줘야하므로,
 *         여러개일 경우에는 두번째 값을 받아오는 로직을 만들기 -> boolean으로 하면 될거같음
 * 범위 -> 정렬된 배열의 N-1번째 인덱스와 0번째 인덱스의 뺄셈
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		StringBuilder sb = new StringBuilder();
		//산술 평균
        int avg = (int)Math.round((double)sum / n);
        sb.append(avg).append("\n");

		//중앙값
		Arrays.sort(arr);
		int mid = (n - 1) / 2;
		sb.append(arr[mid]).append("\n");

		//최빈값
        int maxCountValue = getMaxCountValue(arr);
        sb.append(maxCountValue).append("\n");

		//범위
		sb.append(arr[n - 1] - arr[0]).append("\n");

		System.out.println(sb);
	}

    private static int getMaxCountValue(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        int maxCount = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxCount = Math.max(maxCount, map.get(num));
        }
        int maxCountValue = 0;
        boolean second = false;
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                maxCountValue = key;
                if (second) { //두번째로 작은 수면 더이상 탐색할 필요 없음
                    break;
                } else {
                    second = true;
                }
            }
        }
        return maxCountValue;
    }
}
