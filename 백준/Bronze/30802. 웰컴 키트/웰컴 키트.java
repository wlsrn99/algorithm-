import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 참가자들에게 티셔츠 한 장과 펜 한 자루가 포함된 웰컴 키트
 * S, M, L, XL, XXL, 그리고 XXXL의 6가지 사이즈
 * 티셔츠는 같은 사이즈의 T장 묶음으로만 주문 가능
 *
 * 티셔츠는 남아도 되지만 부족해서는 안 되고 신청한 사이즈대로 나눠주어야 합니다.
 * 펜은 정확히 참가자 수만큼 준비해야 합니다
 *
 * 티셔츠를 T장씩 최소 몇 묶음 주문하는지
 * 펜을 P 자루씩 최대 몇 묶음 주문할 수 있고, 그 때 펜을 한 자루씩 몇 개 주문하는지
 *
 */
public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//참가자의 수
		int n = Integer.parseInt(br.readLine());
		// 티셔츠 사이즈별 신청자의 수
		int[] arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		// 티셔츠의 묶음 수
		int t = input[0];
		// 펜의 묶음 수
		int p = input[1];

		int tNum = 0; // 티셔츠를 T장씩 최소 몇 묶음

		for (int i : arr) {
			int sum = 0;
			int count = 0;
			while (i > sum) {
				sum += t;
				count++;
			}
			tNum += count;
		}
		sb.append(tNum).append("\n");

		// 펜을 p자루씩 최대 몇 묶음
		int pNum = 0;
		while (n >= p) {
			n -= p;
			pNum++;
		}
		sb.append(pNum).append(" ").append(n);
		System.out.println(sb);
	}
}