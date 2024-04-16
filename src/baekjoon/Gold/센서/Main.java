package 센서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
고속도로는 평면상의 직선
센서들은 이 직선 위의 한 기점인 원점으로부터의 정수 거리의 위치에 놓여 있다
각 센서의 좌표는 정수 하나로 표현된다.
수신 가능영역의 거리의 합의 최솟값
수신 가능영역의 길이는 0 이상이며 모든 센서의 좌표가 다를 필요는 없다.

1 3 6 6 7 9

1 3 / 6 6 7 9

3 6
7 8
10 12
14 15
18 20
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensor = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        //좌표 순 -> 오름차순으로 정렬
        Arrays.sort(sensor);

        //인접한 센서의 거리 차이 배열
        int[] cost = new int[N-1];
        for(int i = 0; i < N-1; i++){
            cost[i] = sensor[i+1] - sensor[i];
        }

        // 거리 차이 작은 순서대로 정렬
        Arrays.sort(cost);

        int sum = 0;
        // N-1 = 인접한 센서 거리 차이의 개수
        // k-1 = 구분선의 개수
        // 골라야하는 수신 가능 영역 개수 = (센서 거리 차이의 개수) - (구분 선의 개수)
        for(int i = 0; i < (N-1) - (K-1); i++){
            sum += cost[i];
        }
        System.out.println(sum);
        /*
        시험 때 못풀었다가 다시 보니까 저번에도 못풀어서 블로그 포스팅 봤던
        행복 유치원과 비슷해서 그대로 썼습니다
        저는 바보입니다...
         */
    }
}
