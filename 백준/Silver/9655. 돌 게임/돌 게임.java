

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 게임은 상근이가 먼저 시작한다
 *
 * 상근이가1개 창영이가 1개 반복
 * n-3번째에 돌을 가져간 사람이 상근이면 창영이가 승리
 * n-3번째에 돌을 가져간 사람이 창영이면 상근이가 승리
 */
public class Main {
	static char[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 1){
			System.out.println("SK");
		}else if(n == 2){
			System.out.println("CY");
		}else{
			n -= 2; // n-2번째에 돌을 가져간 사람이 승리

			dp = new char[n + 1];
			// 첫 시작이 상근이로 고정되어 있으므로 초기값 창영이로 설정
			dp[0] = 'c';
			for (int i = 1; i < n + 1; i++) {
				dp[i] = dp[i - 1] == 's' ? 'c' : 's';
			}
			System.out.println(dp[n] == 's' ? "SK" : "CY");
		}

	}
}
