package 패션왕신해빈;
/*
# 요구사항 정리
해빈이는 한번 입었던 옷들의 조합을 절대 다시 입지 않는다
테스트 케이스는 최대 100이다
첫째 줄에 해빈이가 가진 의상의 수(0<= n <= 30)이 주어진다
n개 줄에 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다, 같은 종류의 의상은 하나만 입을 수 있다
같은 이름을 가진 의상은 존재하지 않는다

# 생각한 풀이 논리
알몸만 아니면 되는거니까, 존재 하는 의상 종류는 입는경우 안입는 경우의 수가 추가된다
따라서 경우의 수는 (각 종류의 개수 + 1) * (각 종류의 개수 +1) ``` 이런 식으로 될 것이다
하지만 이 경우는 알몸인 경우도 포함되어있으므로 알몸인 경우 -1을 해주도록하자
자료구조로 Map을 사용해서 의상 종류를 키로 놓고 개수를 벨류로 놓으면,
가지고 있는 각 의상 종류들의 개수에 쉽게 접근 할 수 있을거같다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < testNum; i++){
            int costumeNum = Integer.parseInt(br.readLine());
            HashMap<String, Integer> costumeType = new HashMap<>();
            for(int j = 0; j < costumeNum; j++){
                String[] oneCostumeType = br.readLine().split(" ");
                //필요한건 1번째 인덱스에 있는 의상의 종류
                //똑같은 종류가 나오면 개수를 담당하는 벨류를 증가시킨다
                costumeType.put(oneCostumeType[1], costumeType.getOrDefault(oneCostumeType[1], 0) + 1);
            }
            // 맵을 순회해서 각 (벨류 + 1)들을 곱해준다
            int caseNum = 1;
            for(String key : costumeType.keySet()){
                caseNum *= (costumeType.get(key) + 1);
            }

            // 알몸인경우 -1을 해준다
            System.out.println(caseNum - 1);
        }
    }
}
