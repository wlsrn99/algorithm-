

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
# 요구사항
시간제한:0.5초 , 메모리 128로 다 작아서 효율적인 프로그래밍 필요
RGB거리에는 집이 N개 있다
거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다
아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값
1. N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
2. i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
# 내가 생각한 논리

memo[i][j]는 i번째 집을 j색으로 칠할 때의 최소 비용이라고 생각하면
-> 각 색상별로 i번째 집을 칠할 때의 최소 비용은
-> 이전 집까지의 다른 색을 칠했을 때 최소 비용과 현재 집을 해당 색으로 칠하는 비용을 더한 값

N-1까지 도달했을 때, 이 중에서 가장 작은 값

 */
public class Main {
    static int[] memo = new int[3]; // 비용을 저장하는 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] memo = new int[N][3];
        memo[0][0] = arr[0][0];
        memo[0][1] = arr[0][1];
        memo[0][2] = arr[0][2];

        for(int i = 1; i < N; i++){
            // 현재 색깔을 고르고 칠했을 때의 최소 비용은
            // 이전에 다른 색깔을 골랐을 때의 최소 비용에 현재 색깔을 칠했을 때다
            memo[i][0] = Math.min(memo[i - 1][1], memo[i - 1][2]) + arr[i][0];
            memo[i][1] = Math.min(memo[i - 1][0], memo[i - 1][2]) + arr[i][1];
            memo[i][2] = Math.min(memo[i - 1][1], memo[i - 1][0]) + arr[i][2];
        }


        System.out.println(Arrays.stream(memo[N-1]).min().getAsInt());
    }

}
