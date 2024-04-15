package 택배배송;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
가는 길에 만나는 모든 소들에게 맛있는 여물을 줘야 합니다. 물론 현서는 구두쇠라서 최소한의 소들을 만나면서 지나가고 싶습니다.
농부 현서에게는 지도가 있습니다. N (1 <= N <= 50,000) 개의 헛간과, 소들의 길인 M (1 <= M <= 50,000) 개의 양방향 길이 그려져 있고, 각각의 길은 C_i (0 <= C_i <= 1,000) 마리의 소가 있습니다.
소들의 길은 두 개의 떨어진 헛간인 A_i 와 B_i (1 <= A_i <= N; 1 <= B_i <= N; A_i != B_i)를 잇습니다. 두 개의 헛간은 하나 이상의 길로 연결되어 있을 수도 있습니다.
농부 현서는 헛간 1에 있고 농부 찬홍이는 헛간 N에 있습니다

 */
public class Main {
    static List<ArrayList<DestinationInfo>> nodeList; // 헛간 그래프
    static boolean[] visited; // 방문
    static int[] dist; // 비용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int N = input[0]; //헛간의 갯수 - 노드의 갯수
        int M = input[1]; // 소들의 길 - 간선의 갯수

        nodeList = new ArrayList<>();
        for(int i = 0; i < N + 1; i++){
            nodeList.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        // dist배열 모두 최대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < M; i++){
            input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            //양방향이므로 둘다 넣어준다
            nodeList.get(input[0]).add(new DestinationInfo(input[1], input[2]));
            nodeList.get(input[1]).add(new DestinationInfo(input[0], input[2]));
        }
        dijkstra(1);

        System.out.println(dist[N]);
    }

    private static void dijkstra(int start){
        dist[start] = 0;
        // 비용이 낮은 순으로 오름차순 정렬
        PriorityQueue<DestinationInfo> pq = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        pq.offer(new DestinationInfo(start, 0));

        while(!pq.isEmpty()){
            int current = pq.poll().destination;

            if(visited[current]){
                continue;
            }

            visited[current] = true;

            for(DestinationInfo next: nodeList.get(current)){
                if(dist[next.destination] > dist[current] + next.cost){
                    dist[next.destination] = dist[current] + next.cost;

                    pq.offer(new DestinationInfo(next.destination,dist[next.destination] ));
                }
            }
        }
    }

    private static class DestinationInfo{
        int destination;
        int cost;
        DestinationInfo(int destination, int cost){
            this.destination = destination;
            this.cost = cost;
        }
    }
}
