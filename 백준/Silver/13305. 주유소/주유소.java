

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
# 요구사항
어떤 나라에 N개의 도시가 있다. 이 도시들은 일직선 도로 위에 있다.
편의상 일직선을 수평 방향으로 두자. 제일 왼쪽의 도시에서 제일 오른쪽의 도시로 자동차를 이용하여 이동하려고 한다.
인접한 두 도시 사이의 도로들은 서로 길이가 다를 수 있다. 도로 길이의 단위는 km를 사용한다.
기름통의 크기는 무제한

각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램

첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)

다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수
다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수
제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다. 리터당 가격은 1 이상 1,000,000,000 이하의 자연수
# 내가 생각한 논리
현재 도시가 다음 도시보다 리터당 가격이 작으면 유지
현재 도시가 다음 도시보다 리터당 가격이 커질때까지 거리를 더해주고 가격 x 거리를 해준다음 거리 0으로 초기화
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 도시의 개수
        int N = Integer.parseInt(br.readLine());
        // 도로의 길이 배열 N-1개
        int[] road = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        // 주유소의 리터당 가격 배열 N개
        int[] gasCost = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        long costSum = 0;
        int minCost = gasCost[0]; // 첫 번째 도시의 주유소 가격을 최소 비용으로 초기화

        // 현재 도시에서 다음 도시로 이동할 때의 최소 비용을 계산
        for (int i = 0; i < N - 1; i++) {
            costSum += (long) minCost * road[i];
            // 다음 도시의 주유소 가격이 현재 최소 비용보다 작으면 갱신
            if (gasCost[i + 1] < minCost) {
                minCost = gasCost[i + 1];
            }
        }
        System.out.println(costSum);
    }
}
