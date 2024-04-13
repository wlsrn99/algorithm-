package 동전1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
#요구 사항
n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다
그 경우의 수를 구하시오
사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우

첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다
# 내가 생각한 논리
저번 문제들은 메모이제이션의 크기가 주어져있었는데 이번 문제는 크기가 주어져있지 않다
자료구조를 메모이제이션으로 써야할 거 같다
k초과인 경우가 되면 안되므로 최대 힙을 사용한 우선순위 큐를 쓰는게 좋을 것 같다
-> k면 cnt를 증가시키고
-> k초과면 없애고
-> k미만이면 큐에 다시 넣는 식으로 하면 되지않을까
-> 시간초과
아니었다.. k의 최대 가치는 10000이다
-> 크기가 10000인 메모이제이션 배열 생성?
크기가 k+1인 메모이제이션 배열 생성
메모이제이션 배열 k번째에 경우의 수가 저장되도록 로직을 짜야한다

//로직은 맞는거같은데 구현을 어떻게해야할지 진짜 도저히 모르겠어서 블로그 봤습니다 허허
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        //경우의 수를 저장하는 메모이제이션
        int[] memo = new int[k + 1];
        //초기값 설정
        memo[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j < k + 1; j++) {// arr[i]동전을 골랐을 때
                // arr[i]가 들어가는 모든 합의 경우에 경우의수 증가
                memo[j] += memo[j - arr[i]];
            }
        }

        System.out.println(memo[k]);

    }
}
