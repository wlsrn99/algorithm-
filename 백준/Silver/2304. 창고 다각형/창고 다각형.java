

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
# 요구사항 정리
N 개의 막대 기둥이 일렬로 세워져 있다. 기둥들의 폭은 모두 1 m이며 높이는 다를 수 있다.
지붕은 수평 부분과 수직 부분으로 구성되며, 모두 연결되어야 한다.
지붕의 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 한다.
지붕의 수직 부분은 반드시 어떤 기둥의 옆면과 닿아야 한다.
지붕의 가장자리는 땅에 닿아야 한다.
비가 올 때 물이 고이지 않도록 지붕의 어떤 부분도 오목하게 들어간 부분이 없어야 한다.

창고 다각형의 면적이 가장 작은 창고를 만들기

# 내가 생각한 논리
다각형의 면적은 어떻게 구하는게 좋을까
-> 직사각형으로 쪼개면

-> 쪼갠 직사각형의 높이 = 작은 인덱스의 높이
-> 쪼갠 직사각형의 밑번 = 작은 인덱스의 높이보다 첫번째로 큰 높이의 인덱스 - 작은 인덱스

-> 마지막경우
    -> 작은 인덱스의 높이가 더 큰 경우 두개의 직사각형의 넓이
    첫번째 직사각형
    -> 밑변 = 1
    -> 높이 = 작은 인덱스의 높이
    두번째 직사각형
    -> 밑변 = 큰 인덱스 - 작은인덱스
    -> 높이 = 큰 인덱스의 높이

    -> 작은 인덱스의 높이가 더 작은 경우 두개의 직사각형의 넓이
    첫번째 직사각형
    -> 밑변 = 큰인덱스 - 작은인덱스
    -> 높이 = 작은 인덱스의 높이
    두번째 직사각형
    -> 밑변 = 1
    -> 높이 = 큰 인덱스의 높이

-> 이 직사각형의 넓이들을 모두 합하면 면적을 구할 수 있지 않을까
비교횟수 = N - 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] pillar = new int [N][2];
        int maxHeight = 0;

        for(int i = 0; i < N;  i++){
            String[] input = br.readLine().split(" ");
            pillar[i][0] = Integer.parseInt(input[0]);
            pillar[i][1] = Integer.parseInt(input[1]);

            maxHeight = Math.max(pillar[i][1], maxHeight);
        }

        //x좌표 순서로 정렬
        Arrays.sort(pillar, (o1,o2) ->{
            return o1[0] - o2[0];
        });

        //가장 큰 기둥 중 제일 왼쪽에 있는 기둥
        int start = 0;
        for(int i = 0; i<N; i++) {
            if(pillar[i][1]==maxHeight) start = i;
        }

        //제일 높은 기둥부분은 따로 더해줘야 하기 때문에 제일 처음에 넣기
        int sum = maxHeight;

        //제일 첫 기둥
        int prevX = pillar[0][0];
        int prevH = pillar[0][1];

        //왼쪽 탐색
        for(int i = 0; i<=start; i++) {
            //이전 기둥보다 큰 기둥이 나타나면 넓이 구하기
            if(pillar[i][1] >= prevH) {
                sum += (pillar[i][0]-prevX)*prevH;
                //현재 기둥 정보 갱신
                prevX = pillar[i][0];
                prevH = pillar[i][1];
            }
        }

        //마지막 기둥
        prevX = pillar[N-1][0];
        prevH = pillar[N-1][1];

        //오른쪽 탐색
        for(int i = N-1; i>=start; i--) {
            //이전 기둥보다 큰 기둥이 나타나면 넓이 구하기
            if(pillar[i][1] >= prevH) {
                sum += (prevX - pillar[i][0])*prevH;
                //현재 기둥 정보 갱신
                prevX = pillar[i][0];
                prevH = pillar[i][1];
            }
        }

        System.out.println(sum);

    }
}
