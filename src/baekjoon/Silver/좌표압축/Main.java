package 좌표압축;
/*
# 요구 사항
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다
Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력
# 제한
1 ≤ N ≤ 1,000,000
-10^9 ≤ Xi ≤ 10^9
# 내가 생각한 논리
여기서 말하는 좌표 압축 = 제일 작은 수의 좌표가 0, 그 다음 큰수가 1, 그 다음 큰 수가 2
오름차순으로 정렬한 뒤 제일 작은수를 저장해야한다
-> 근데 출력할때를 고려하면 원래 배열의 순서는 유지해야한다
-> 배열의 벨류를 key로 가지고있고 넣었을 때 그에 해당하는 순서를 value로 반환해주는 Map이 있으면 좋을거같다
-> 배열을 리스트에 저장하고 오름차순으로 정렬한 뒤에 map에 그에 맞는 순서를 저장해서 처리해주면 될거같다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        // 정렬된 배열 -> 중복한 값은 좌표 순서가 똑같으므로 TreeSet
        // -> 제출 했지만 성능이 너무 떨어져서 똑같은 배열을 하나 더 만드는 걸로 수정
        //원래의 배열
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        //정렬할 배열
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        // 배열의 벨류를 키값으로, 순서를 벨류로 가지는 -> 수정된 좌표를 가지고있는 Map생성
        Map<Integer, Integer> coordinate = new HashMap<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!coordinate.containsKey(sortedArr[i])) { //중복 방지
                coordinate.put(sortedArr[i], count++);
            }
        }

        //배열의 벨류를 넣었을때 해당하는 좌표 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(coordinate.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}
