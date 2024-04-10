package 부분수열의합;
/*
# 요구사항
N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수
 (1 ≤ N ≤ 20, |S| ≤ 1,000,000)
# 내가 생각한 논리
부분 수열이고 부분수열의 크기가 양수일 뿐 정해지지 않았다
투포인터를 사용하면 될 것 같다
-> 틀렸다 연속이란 단어가 안붙었으므로 투포인터로 풀면 틀린다...
합을 구하는 문제이므로 순서는 중요하지 않으니까
-> 조합으로 풀면 될거같다
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, S;
    static int[] arr;
    static int count = 0; //합의 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        arr = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        //방문 확인 배열 생성
        boolean[] visited = new boolean[N];

        // 조합 수행
        for (int r = 1; r <= N; r++) {
            combination(arr, visited,0, r);
        }

        System.out.println(count);
    }

    // 조합 수행
    private static void combination(
            int[] arr,
            boolean[] visited,
            int start,
            int r
    ){
        // 다 뽑았을경우 재귀 종료
        if(r == 0){
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(visited[i]){
                    sum += arr[i];
                }
            }
            if(sum == S){
                count++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }
}
