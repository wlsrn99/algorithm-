

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N; // 도시의 갯수 - 노드 갯수
    static int M; // 버스 갯수 - 간선 갯수
    static boolean[] visited;
    static int[] dist;
    static int[][] adjMatrix; // 인접 행렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        adjMatrix = new int[N + 1][N + 1]; // 인접 행렬 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    adjMatrix[i][j] = Integer.MAX_VALUE; // 자기 자신으로의 가중치는 0, 나머지는 무한대로 초기화
                }
            }
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int city1 = Integer.parseInt(input[0]);
            int city2 = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            // 인접 행렬에 가중치 정보 저장
            adjMatrix[city1][city2] = Math.min(adjMatrix[city1][city2], cost);
        }

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        dijkstra(start);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE; // 최단 거리 배열 초기화
        }
        dist[start] = 0;

        PriorityQueue<CityCost> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new CityCost(start, 0));

        while (!pq.isEmpty()) {
            CityCost current = pq.poll();
            visited[current.destination] = true;

            for (int i = 1; i <= N; i++) {
                if (adjMatrix[current.destination][i] != Integer.MAX_VALUE) {
                    int nextCost = dist[current.destination] + adjMatrix[current.destination][i];
                    if (!visited[i] && dist[i] > nextCost) {
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
