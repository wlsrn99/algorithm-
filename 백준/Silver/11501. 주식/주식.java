
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * 1. 현재 주가보다 다음날 주가가 오른다면 산다
 * 2. 현재 주가와 다음날 주가가 같다면 다음 주가를 확인한다
 * 3. 현재 주가보다 다음날 주가가 내려간다면 팔거나 아무것도안한다
 *
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] stock = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
			long sum = 0;
			int max = 0;

			for (int i = n - 1; i >= 0; i--) {
				if (stock[i] > max) {
					max = stock[i];
				} else {
					sum += max - stock[i];
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
