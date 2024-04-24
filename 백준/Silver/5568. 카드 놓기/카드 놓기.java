

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Set<String> resultSet = new HashSet<>();
	static int[] arr;

	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 상근이가 바닥에 놓은 카드  n(4 ≤ n ≤ 10)장
		n = Integer.parseInt(br.readLine());

		// 상근이가 선택한 카드의 갯수  k(2 ≤ k ≤ 4)장
		k = Integer.parseInt(br.readLine());

		// 카드에 적혀있는 수
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] comArr = new int[k];

		doCombination(0, k, 0, comArr);
		System.out.println(resultSet.size());
	}

	private static void doCombination(int idx, int r, int target, int[] comArr) {
		if (r == 0) {
			//순열 메서드 실행
			doPermutation(comArr, 0);
		} else if (target == n) {
			return;
		} else {
			comArr[idx] = arr[target];
			doCombination(idx + 1, r - 1, target + 1, comArr);
			doCombination(idx, r, target + 1, comArr);
		}

	}

	private static void doPermutation(int[] comArr, int startIdx) {
		if (startIdx == k - 1) {
			String setNum = "";
			for (int item : comArr) {
				setNum += item;
			}
			resultSet.add(setNum);
		}

		for (int i = startIdx; i < k; i++) {
			swap(comArr, startIdx, i);
			doPermutation(comArr, startIdx + 1);
			swap(comArr, startIdx, i);
		}
	}

	private static void swap(int[] comArr, int n1, int n2) {
		int temp = comArr[n1];
		comArr[n1] = comArr[n2];
		comArr[n2] = temp;
	}
}
