

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다.
합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.
전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때,
남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오

1 8
3 9
4 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++){
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < 2; j++){
                arr[i][j] = input[j];
            }
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        int[] memo = new int[N];
        Arrays.fill(memo, 1);

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                // 최대한 겹치지 않게 설치 가능한 개수를 구하는 로직 
                // 현재 end전깃줄이 이전 전깃줄보다 값이 크다면 겹치지 않게 설치가 가능하다 
                if(arr[j][1] < arr[i][1]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        int maxLen = Arrays.stream(memo).max().getAsInt();

        int result = N - maxLen;
        System.out.println(result);
    }
}
