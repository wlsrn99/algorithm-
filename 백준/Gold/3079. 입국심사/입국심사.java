import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 상근이와 친구들 M명이 심사를 하는데 걸리는 시간이 각기 다른, N개의 입국심사대에서 심사를 받는다.
2. 먼저 심사가 끝나는 대로 다음 사람이 심사를 받을 수 있다.
3. 모두 심사를 마치는데 걸리는 최소 시간을 구하라.

# 풀이 논리 #
1. 위의 요구사항대로 최소 시간을 구하려면 이분 탐색을 이용해야 한다. 이분 탐색을 대입하는 논리는 아래와 같다.
1-1. 총 심사 시간을 탐색 대상으로 초점을 맞추고 이분 탐색하면서, 최소 심사 시간을 찾는다. 
1-2. 탐색 중에 총 심사 시간동안 요구사항 1, 2번대로 심사가 이루어질 때 심사받을 수 있는 사람 수가 M명보다 적으면 
모두가 심사받는 것이 불가능한 것이므로 low = mid + 1로 최신화한 후 다음 탐색을 이어간다.
1-3. 반대로 M명보다 많으면 더 적은 시간 동안에 M명이 심사 받을 수 있는 것이다. 따라서 high = mid - 1로 최신화한 후 다음 탐색을 이어간다.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 심사대 개수
        int M = Integer.parseInt(st.nextToken()); // 상근이와 친구들의 총 사람 수

        long[] arr = new long[N]; // 심사대 정보를 저장하는 배열
        long maxTime = 0; // 심사대 중 가장 오래 걸리는 시간
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, arr[i]);
        }
        long maxResult = M * maxTime; // 심사 시간의 최대 값
        long answer = maxResult; // 심사시간의 최솟값, 최댓값과 비교해 더 작은 값으로 최신화를 반복하기 위해 maxResult를 넣는다.
        Arrays.sort(arr);

        // 이분 탐색 시작
        long low = 0;
        long high = maxResult;
        while (low <= high) {
            long mid = (low + high) / 2;
            long totalPeople = 0; // 해당 시간동안 심사받을 수 있는 사람 수

            // 1. totalPeople을 연산하는 로직
            for (long time : arr) { // 1-1. 각 심사대에서
                // 1-4. 정렬된 시간값을 꺼내서 연산하는 중에
                // 1-4. 이번 심사대의 심사 시간이 확인 중인 총 심사 시간보다 크거나
                // 1-4. 심사대를 다 쓰지 않아도 심사 받을 수 있는 인원이 M명 보다 크면 바로 반복문을 탈출한다.
                if (totalPeople >= M || time > mid) break;

                long eachCnt = mid / time; // 1-2. 해당 시간동안 심사받을 수 있는 사람수를 세어서
                totalPeople += eachCnt; // 1-3. 더 해준다.
            }

            // 풀이 논리 1번 로직
            if (totalPeople >= M) {
                high = mid - 1;
                answer = Math.min(answer, mid);
            } else low = mid + 1;
        }
        System.out.print(answer);
    }
}