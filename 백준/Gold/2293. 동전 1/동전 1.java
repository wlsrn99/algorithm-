import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전의 종류
        int k = Integer.parseInt(st.nextToken()); // 목표 합계

        int[] coin = new int[n]; // 동전의 가치를 저장할 배열
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] memo = new int[k + 1]; // 메모이제이션 배열

        // 기저 사례 설정
        memo[0] = 1;

        // 각 동전의 가치를 하나씩 확인하며 메모이제이션 배열 갱신
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                memo[j] += memo[j - coin[i]];
            }
        }

        // 목표 합계가 되도록 하는 경우의 수 출력
        System.out.println(memo[k]);
    }
}
