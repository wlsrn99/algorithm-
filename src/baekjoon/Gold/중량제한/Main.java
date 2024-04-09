package 중량제한;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
N(2 ≤ N ≤ 10,000)개의 섬
한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값

첫째 줄에 N, M(1 ≤ M ≤ 100,000)이 주어진다.
다음 M개의 줄에는 다리에 대한 정보를 나타내는 세 정수 A, B(1 ≤ A, B ≤ N), C(1 ≤ C ≤ 1,000,000,000)가 주어진다.
모든 다리는 양방향
서로 같은 두 섬 사이에 여러 개의 다리가 있을 수도 있음

마지막 줄에는 공장이 위치해 있는 섬의 번호를 나타내는 서로 다른 두 정수
 */
public class Main {

    static ArrayList<ArrayList<Bridge>> nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        nodeList = new ArrayList<>();

        for(int i = 0; i < N+1; i++){
            nodeList.add(new ArrayList<>());
        }

        int maxWeight = 0;
        int minWeight = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            maxWeight = Math.max(maxWeight, w);
            minWeight = Math.min(minWeight, w);

            nodeList.get(u).add(new Bridge(v,w));
            nodeList.get(v).add(new Bridge(u,w));
        }

        input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        int left = minWeight;
        int right = maxWeight;
        int result = 0;

        // 무게 기준으로 이분탐색 시작
        while (left <= right){
            int currentMid = (right + left) / 2;
            //bfs로 탐색이 가능하다면 무게를 늘려준다
            if(bfs(currentMid, start,end,N)){
                result = currentMid;
                left = currentMid + 1;
                //불가능하다면 무게를 줄여준다
            }else {
                right = currentMid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean bfs(
            int mid,
            int start,
            int end,
            int N
            )
    {
        //탐색할때마다 방문한 섬들 초기화
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            //목적지 도착
            if(vertex == end){
                return true;
            }

            for (Bridge next : nodeList.get(vertex)) {
                //방문하지 않은 섬이고 연결된 다리가 현재 무게를 견딜 수 있을 때
                if(!visited[next.destination] && next.weight >= mid){
                    visited[next.destination] = true;
                    queue.offer(next.destination);
                }

            }

        }
        return false;
    }
    // 다리에 연결된 섬과 견딜 수 있는 무게
    private static class Bridge {
        int destination;
        int weight;

        Bridge(int destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }
    }

    }

