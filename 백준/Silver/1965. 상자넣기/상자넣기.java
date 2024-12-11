
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 앞에 있는 상자의 크기가 뒤에 있는 상자의 크기보다 작으면
 * 앞에 있는 상자를 뒤에 있는 상자 안에 넣을 수가 있다
 * 한 번에 넣을 수 있는 최대의 상자 개수
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] box = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int[] dp = new int[n];
		Arrays.fill(dp, 1); //자기 자신의 갯수 1
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (box[j] < box[i]) { //현재 상자가 현재 이전 상자보다 크다면
					dp[i] = Math.max(dp[i], dp[j] + 1); //(현재 상자까지의 dp값), (현재 이전 상자까지의 dp값 + 1)중 더 큰 값을 선택해서 넣기
				}
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}
}
