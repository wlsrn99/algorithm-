package 최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
# 요구사항
N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다
A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화
# 내 논리
dfs 로 시작 노드부터 깊이 탐색해서
5인 노드가 나오면 최솟값 갱신 후 재귀종료
-> 근데 시간초과...
다익스트라를 한 번 써보겠다
-> 또 시간초과가 떴다...
노드의 개수가 최대 1000개로 적으므로 인접 리스트 대신 인접 행렬을 사용하면 될 것 같다

 */
public class Main {
    static int N; // 도시의 갯수 - 노드 갯수
    static int M; // 버스 갯수 - 간선 갯수
    static boolean[] visited;
    static int[] dist;
    static int[][] matrix; // 인접 행렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        matrix = new int[N + 1][N + 1]; // 인접 행렬 초기화

        for (int i = 1; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE; // 최단 거리 배열 초기화
            for (int j = 1; j < N + 1; j++) {
                if (i != j) {
                    // 자기 자신으로의 거리는 0
                    // 연결되어 있지 않은 노드는 계산하면 안되므로 나머지는 무한대로 초기화
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int city1 = Integer.parseInt(input[0]);
            int city2 = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            // 인접 행렬에 거리 정보 저장
            matrix[city1][city2] = Math.min(matrix[city1][city2], cost);
        }

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        //다익스트라 시작
        dijkstra(start);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
        dist[start] = 0;
        // 비용 기준 오름차순 정렬
        PriorityQueue<CityCost> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new CityCost(start, 0));

        while (!pq.isEmpty()) {
            CityCost current = pq.poll();
            visited[current.destination] = true;

            for (int i = 1; i < N + 1; i++) {
                if (matrix[current.destination][i] != Integer.MAX_VALUE) {
                    //다음 위치로 가는데에 필요한 비용 계산
                    int nextCost = dist[current.destination] + matrix[current.destination][i];
                    if (!visited[i] && dist[i] > nextCost) { //방문하지 않았고, 비용이 원래 있던 비용보다 작으면 갱신
                        dist[i] = nextCost;
                        pq.offer(new CityCost(i, dist[i]));
                    }
                }
            }
        }
    }

    private static class CityCost {
        int destination;
        int cost;

        CityCost(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }
}