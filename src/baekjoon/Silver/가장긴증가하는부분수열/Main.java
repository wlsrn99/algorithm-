package 가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        //부분수열의 길이를 저장하는 배열 생성
        int[] memo = new int[N];
        memo[0] = 1;

        for(int i = 1; i < N; i++){
            memo[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){ //이 경우에 부분수열이 될 수 있음
                //memo[j] + 1이 memo[i]보다 크다는 것은 이전에 계산한 부분 수열의 길이에 현재 위치 i를 추가하여 더 긴 증가하는 부분 수열을 만들 수 있다는 것을 의미
                //이 경우, memo[i] 값을 memo[j] + 1로 업데이트하여 현재 위치 i까지의 최장 증가하는 부분 수열의 길이를 업데이트
                //
                //만약 memo[j] + 1이 memo[i]보다 작거나 같다면, 이는 이전에 계산한 부분 수열의 길이에 현재 위치 i를 추가하여 더 긴 증가하는 부분 수열을 만들 수 없다는 것을 의미
                //따라서 memo[i] 값은 변경되지 않고 이전 값으로 유지
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        int answer = Arrays.stream(memo).max().getAsInt();
        System.out.println(answer);
    }
}
