package 나무자르기;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
# 요구 사항 정리
상근이는 나무 M미터가 필요하다
높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다.
그 다음, 한 줄에 연속해있는 나무를 모두 절단해버린다. 따라서, 높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다
적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값

# 내가 생각한 논리
나무의 배열을 내림차순으로 정렬시킨다
end포인트를 정해서
첫 인덱스부터 end까지 end의 높이만큼 벤 나무의 값이 M미터보다 크거나 같으면 그 구간만 생각하면 된다
**** 시간초과가 났다
오름차순으로 정렬한 뒤 이진탐색을 이용해서 범위를 다시 정한다
구간 안에서 설정한 높이로 나무를 잘랐을 때 얻을 수 있는 나무의 길이를 구한다
-> 나무의 길이가 M보다 크면 설정한 높이를 더 높게 설정하고
-> 나무의 길이가 M보다 작으면 낮게 설정한다
-> 같으면 반환한다
높이는 최대 1,000,000,000이므로 높이의 합은 long으로 설정해야한다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNM = br.readLine().split(" ");
        int N = Integer.parseInt(inputNM[0]);
        int M = Integer.parseInt(inputNM[1]);

        String[] inputTree = br.readLine().split(" ");
        int[] tree = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(inputTree[i]);
        }

        Arrays.sort(tree);
        // 처음은 가장 큰 나무의 높이를 기준으로 설정해야 하기 때문에
        // 첫 시작을 0, end를 가장 큰 나무로 설정
        long start = 0;
        long end = tree[N - 1];

        while (start <= end) {
            // 현재 구간에서 높이로 설정되는 값
            // 이 값은 배열안의 값이 아니라 오름차순으로 정렬된 수
            long currentMid = (start + end) / 2;
            // 현재 구간에서 절단된 나무의 길이 총합
            long currentSum = 0;

            // 중간값으로 나무를 절단하여 길이를 합한다
            for (int i = 0; i < N; i++) {
                if (tree[i] > currentMid) {
                    currentSum += tree[i] - currentMid;
                }
            }
            // 길이의 합이 M과 같거나 크다면 설정한 최소 높이를 높인다
            if (currentSum >= M) {
                start = currentMid + 1;
            } else { // 작으면 설정한 최대 높이를 낮춘다
                end = currentMid - 1;
            }
        }

        System.out.println(end);
    }
}