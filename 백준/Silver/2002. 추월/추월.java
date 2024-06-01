

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 * 추월하는 차
		 * 처음 들어올때 차량별 인덱스를 저장하고
		 * 나간 순서대로 차량별 처음 인덱스를 저장
		 * -> 저장된 인덱스가 오른쪽에 위치한 숫자들보다 클 때 추월이라고 판단
		 *         ZG508OK  0
		 *         PU305A   1
		 *         RI604B   2
		 *         ZG206A   3
		 *         ZG232ZF
		 *         PU305A   1  0
		 *         ZG232ZF  4  1
		 *         ZG206A   3  2
		 *         ZG508OK  0  3
		 *         RI604B   2  4
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> inCars = new HashMap<>();
		// 처음 들어오는 순서를 저장
		for (int i = 0; i < n; i++) {
			inCars.put(br.readLine(), i);
		}

		int[] outCars = new int[n];
		//나간순서대로 차량의 처음 들어왔던 순서를 저장
		for (int i = 0; i < n; i++) {
			outCars[i] = inCars.get(br.readLine());
		}

		int count = 0;
		// 현재 인덱스가 다음 인덱스들 보다 크다면 추월
		for (int current = 0; current < n; current++) {
			for (int next = current + 1; next < n; next++) {
				if (outCars[current] > outCars[next]) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
