package 회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

/*
# 요구사항
한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표
각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고
각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수
 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다
 회의의 시작시간과 끝나는 시간이 같을 수도 있다
# 내가 생각한 논리
tree 맵을 만들어 오름차순 정렬과 동시에 시작 시간을 key로, 벨류를 끝나는 시간으로 설정
시작시간이 같으면 끝나는 시간이 더 작은걸로 벨류에 집어넣음
-> 중복 허용이라 맵으로 풀면 안된다 ㅠㅠㅠ
생각해보면 끝나는 시간 기준으로 정렬하면 시작시간만 비교하면 된다
-> 2차원배열에 시작시간과 끝나는 시간 저장 후 정렬 후 비교
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int count = 0;

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            //시작시간
            arr[i][0] = Integer.parseInt(input[0]);
            //끝나는 시간
            arr[i][1] = Integer.parseInt(input[1]);
        }

        //끝나는 시간 기준 오름차순 정렬
        //끝나는 시간이 같은 경우, 시작 시간 기준 오름차순으로 정렬
        Arrays.sort(arr, (a1, a2) -> a1[1] == a2[1] ? a1[0] - a2[0] : a1[1] - a2[1]);

        //처음 시작 시간이 0일 수도 있으므로 -1로 초기 설정
        int end = -1;
        for(int i = 0; i < N; i++) {
            if(arr[i][0] >= end) { //이전 끝나는 시간보다 시작시간이 크거나 같다면
                end = arr[i][1];
                //이전 회의 종료
                count++;
            }
        }

        //출력
        System.out.println(count);
    }
}
