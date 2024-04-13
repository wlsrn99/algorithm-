package 부녀회장이될테야;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
“a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다”
아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정
1호부터 있으며 0층의 i호에는 i명이 산다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int k = Integer.parseInt(br.readLine()); //층 colum
            int n = Integer.parseInt(br.readLine()); //호 row

            int[][] memo = new int[k+1][n+1];
            for(int i = 1; i < n+1; i++){
                memo[0][i] = i;
            }


            for(int i = 1; i < k+1; i++){
                for(int j = 1; j < n+1; j++){
                    memo[i][j] = Math.max(memo[i][j], memo[i][j-1]) + memo[i-1][j];
                }
            }

            System.out.println(memo[k][n]);
        }
    }
}
