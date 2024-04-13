package 최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
# 요구사항
N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다
A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화
# 내 논리
dfs 로 시작 노드부터 깊이 탐색해서
5인 노드가 나오면 최솟값 갱신 후 재귀종료
-> 근데 제한 시간이 0.5초 이므로 안되겠지...
-> 다익스트라를 한 번 써보겠다

 */
public class Main {
    static int N; //도시의 갯수 -노드 갯수
    static int M; //버스 갯수 - 간선 갯수
    static boolean[] visited;
    static int[] dist;

    static ArrayList<ArrayList<CityCost>> nodeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        dist = new int[N+1];

        nodeList = new ArrayList<>();
        for(int i = 0; i < N + 1; i++){
            nodeList.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            String[] input = br.readLine().split(" ");
            int city1 = Integer.parseInt(input[0]);
            int city2 = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            nodeList.get(city1).add(new CityCost(city2, cost));
        }

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        //다익스트라시작
        dijkstra(start);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start){
        //비용을 기준으로 오름차순 으로 저장
        PriorityQueue<CityCost> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        // 시작 노드 넣기
        // 시작은 비용이 0
        pq.offer(new CityCost(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            CityCost current = pq.poll();
            if(visited[current.destination]){
                continue;
            }
            visited[current.destination] = true;

            for(CityCost next : nodeList.get(current.destination)){
                // 방문하지 않았고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧을 경우
                if(!visited[next.destination] && dist[next.destination] > current.cost + next.cost){
                    dist[next.destination] = current.cost + next.cost;
                    pq.offer(new CityCost(next.destination, dist[next.destination]));
                }
            }
        }
    }

    private static class CityCost{
        int destination;
        int cost;
        CityCost(int destination, int cost){

            this.destination = destination;
            this.cost = cost;
        }
    }
}
