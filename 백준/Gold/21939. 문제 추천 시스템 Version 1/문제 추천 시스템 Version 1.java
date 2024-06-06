

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	// 난이도를 키로, 해당 난이도의 문제 번호들을 값으로 가지는 TreeMap
	static TreeMap<Integer, TreeSet<Integer>> difficultyMap = new TreeMap<>();
	// 문제 번호를 키로, 해당 문제의 난이도를 값으로 가지는 HashMap
	static HashMap<Integer, Integer> problemDifficulty = new HashMap<>();

	/**
	 * 새로운 문제를 추가하는 메서드.
	 * @param P 문제 번호
	 * @param L 문제의 난이도
	 */
	public static void add(int P, int L) {
		// 해당 난이도가 없으면 새로운 TreeSet을 생성해 추가
		difficultyMap.putIfAbsent(L, new TreeSet<>());
		// 해당 난이도의 TreeSet에 문제 번호 추가
		difficultyMap.get(L).add(P);
		// 문제 번호와 난이도 매핑 추가
		problemDifficulty.put(P, L);
	}

	/**
	 * 해결된 문제를 제거하는 메서드
	 * @param P 해결된 문제 번호
	 */
	public static void remove(int P) {
		// 문제 번호로 난이도를 찾음
		int L = problemDifficulty.get(P);
		// 해당 난이도의 TreeSet에서 문제 번호 제거
		difficultyMap.get(L).remove(P);
		// 해당 난이도의 문제가 모두 제거되었다면 난이도 삭제
		if (difficultyMap.get(L).isEmpty()) {
			difficultyMap.remove(L);
		}
		// 문제 번호와 난이도 매핑 제거
		problemDifficulty.remove(P);
	}

	/**
	 * 추천 문제를 반환하는 메서드
	 * @param x 추천 기준 (1: 가장 어려운 문제, 그 외: 가장 쉬운 문제)
	 * @return 추천 문제 번호
	 */
	public static int recommend(int x) {
		if (x == 1) {
			// 가장 어려운 난이도의 문제 중 가장 높은 번호의 문제 반환
			int maxDiff = difficultyMap.lastKey();
			return difficultyMap.get(maxDiff).last();
		} else {
			// 가장 쉬운 난이도의 문제 중 가장 낮은 번호의 문제 반환
			int minDiff = difficultyMap.firstKey();
			return difficultyMap.get(minDiff).first();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int P = Integer.parseInt(input[0]);
			int L = Integer.parseInt(input[1]);
			add(P, L);
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			String command = input[0];
			if ("add".equals(command)) {
				int P = Integer.parseInt(input[1]);
				int L = Integer.parseInt(input[2]);
				add(P, L);
			} else if ("recommend".equals(command)) {
				int x = Integer.parseInt(input[1]);
				sb.append(recommend(x)).append('\n');
			} else if ("solved".equals(command)) {
				int P = Integer.parseInt(input[1]);
				remove(P);
			}
		}

		System.out.print(sb);
	}
}
