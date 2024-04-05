package 세수의합;
/*
# 요구사항 정리
집합 U가 있다. 이 중에서 적당히 세 수를 골랐을 때
세 수의 합 d도 U안에 포함되는 경우
가장 큰 d

#제한
U는 집합이 되므로 입력되는 두 수가 같아서는 안 된다
U의 원소는 200,000,000보다 작거나 같은 자연수
답이 항상 존재하는 경우만 입력
x번째 수, y번째 수, z번째 수를 더해서 k번째 수를 만들었다라고 하자
x, y, z, k가 서로 같아도 된다.
N(5 ≤ N ≤ 1,000)개의 자연수들로 이루어진 집합 U -> 경우의수 1000^3 -> long

#내가 생각한 논리
세수의 합이 가장 큰 K를 찾아야 하므로 먼저 저장하는 것을 오름차순 또는 내림차순으로 정렬해야하지않을까
x + y + z = k를
x + y = k - z로 바꿔보자
그렇다면 x + y 배열을 만들어서  k - z가 포함되어있는지 보면 된다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        //요소 2개를 골라서 합한 모든 경우를 저장하는 배열 생성 (중복해서 2개 더한거 포함)
        List<Integer> sumList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sumList.add(arr[i] + arr[j]);
            }
        }

        Arrays.sort(arr);
        Collections.sort(sumList);
        System.out.println(findK(N, sumList, arr));

    }
    private static int findK(int N, List<Integer> sumList, int[] arr){
        // 최대를 찾으므로 N-1인덱스부터 시작
        for(int i = N - 1; i >= 0; i--){
            for(int j = N - 1; j >= 0; j--){
                if(Collections.binarySearch(sumList, (arr[i] - arr[j])) >= 0){
                    return arr[i];
                }
            }
        }
        return -1;
    }
}
