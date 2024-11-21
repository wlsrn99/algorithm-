

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 최대한 적은 종류의 비행기를 타고 국가들을 이동
 * 상근이가 가장 적은 종류의 비행기를 타고 모든 국가들을 여행할 수 있도록
 *
 * 상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < t; test_case++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
			int n = input[0];//국가의 수
			int m = input[1];//비행기의 종류

			List<ArrayList<Integer>> nodeList = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				nodeList.add(new ArrayList<>());
			}

			for (int i = 0; i < m; i++) {
				input = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();

				// int v1 = input[0];
				// int v2 = input[1];
				//
				// nodeList.get(v1).add(v2);
				// nodeList.get(v2).add(v1);
			}

			System.out.println(n - 1);

		}
	}
}
