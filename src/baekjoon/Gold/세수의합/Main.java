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
세수의합이 집합에 존재하는 지 확인할때 k를 key 로하는 map이 있으면 빠르게 확인이 가능할거같다
-> 인덱스의 벨류를 key로하고 인덱스를 value에 저장 하는 map을 생성
-> 그럼 value를 오름차순또는 내림차순으로 정렬된 배열도 생성
배열에서 1개또는 2개또는 3개의 값을 꺼낸뒤 더해서 map에 넣었을 때 있는 경우를 구해야 한다
선택을 어떤식으로 해야할까
-> 첫 번째 수로 2번째로 큰 수 하나 선택해서 3개 더하기 시도
-> 두 번째 수로 제일 작은 수 하나 선택해서 3개 더하기 시도
-> 없으면 (찾는 수 - 첫번째 수 - 두번째 수)가 map에 있는지 넣어보기
이런식으로 하면 되지 않을까
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

        // k값을 찾기 위한 set 생성
        Arrays.sort(arr);
        Collections.sort(sumList);
        System.out.println(findK(N, sumList, arr));

    }
    private static int findK(int N, List<Integer> sumList, int[] arr){
        // 최대를 찾으므로 N-1인덱스부터 시작
        for(int i = N - 1; i >= 0; i--){
            for(int xy : sumList){
                int resultIdx = Arrays.binarySearch(arr, xy + arr[i]);
                if(resultIdx >= 0){
                    return arr[resultIdx];
                }
            }
        }
        return -1;
    }
}
