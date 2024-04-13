package 가장긴감소하는부분수열;

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
            for(int j = 0; j < i; j++){ //배열의 인덱스 i에서 끝나는 가장 긴 부분수열을 구하는 로직
                if(arr[i] < arr[j]){ // 왼쪽에 있는 값이 더 작으면 감소하는 부분수열이 될 수 있음
                    memo[i] = Math.max(memo[i],memo[j] + 1); // 부분수열 개수에 끝나는 인덱스가 i인 경우를 하나씩 추가
                }
            }
        }
        int answer = Arrays.stream(memo).max().getAsInt();
        System.out.println(answer);

    }
}
