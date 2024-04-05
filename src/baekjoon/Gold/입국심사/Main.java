package 입국심사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

/*
# 요구사항 정리
상근이와 친구들은 총 M명 입국심사대는 총 N개 심사를 하는데 걸리는 시간은 사람마다 모두 다르다
k번 심사대에 앉아있는 심사관이 한 명을 심사를 하는데 드는 시간은 Tk
가장 처음에 모든 심사대는 비어있고, 심사를 할 준비를 모두 끝냈다.
한 심사대에서는 한 번에 한 사람만 심사를 할 수 있다
하지만 항상 이동을 해야 하는 것은 아니다. 더 빠른 심사대의 심사가 끝나길 기다린 다음에 그 곳으로 가서 심사를 받아도 된다.

# 내가 생각한 논리
일단 심사대를 오름차순으로 정렬시킨다
찾는 시간이 있고, 정렬시키니까 이진탐색을 써야하는데..
일단 마지막은 배열의 마지막요소 * 사람수
스타트는 0

찾아야 하는 시간
-> (시간 / 각 심사대의 소요시간)을 다 더한 값이 사람수로 딱 맞아 떨어지는 시간
-> 결국 M값을 찾아야 한다?
 // 심사대를 쓴 횟수가 딱 맞아 떨어지는 경우가 최소시간인줄 알았는데
 // 딱 안맞아 떨어지는 경우가 정답인게 있었다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNM = br.readLine().split(" ");
        int N = Integer.parseInt(inputNM[0]);
        long M = Long.parseLong(inputNM[1]);

        int[] judgeTable = new int[N];
        for(int i = 0; i< N; i++){
            judgeTable[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(judgeTable);

        long start = 0;
        // 배열의 마지막 * 사람 수 = 제일 오래걸리는 시간
        long end = judgeTable[N-1] * M;
        long result = end;

        while(start<=end){
            // 현재 전체 소요 시간
            long currentMid = (start + end) / 2;

            // 심사대를 쓴 횟수
            long judgeNumSum = 0;
            for(int i = 0; i < N; i++){
                judgeNumSum += currentMid / judgeTable[i];
                if (judgeNumSum >= M || judgeTable[i] > currentMid) break;
            }
            // 심사대를 쓴 횟수와 총 인원 비교
            if(judgeNumSum >= M){
                end = currentMid - 1; // 현재 시간을 줄여야 함
                result = Math.min(result, currentMid);
            } else {
                start = currentMid + 1; // 현재 시간을 늘려야 함
            }

        }
        System.out.println(result);
    }
}
