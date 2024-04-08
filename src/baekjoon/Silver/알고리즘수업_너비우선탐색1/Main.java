package 알고리즘수업_너비우선탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
# 요구사항
N개의 정점과 M개의 간선으로 구성된 무방향 그래프
정점 R에서 시작하여 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서
 */
public class Main {
    static int count = 0; // 방문 순서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 정점의 수
        int M = Integer.parseInt(input[1]); // 간선의 수
        int R = Integer.parseInt(input[2]); // 시작 정점

        ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
        int[] visited = new int[N+1]; //방문 순서 저장

        for(int i = 0; i < N+1; i++){
            nodeList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            // 입력받은 간선 정보 무방향 그래프 생성
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            nodeList.get(v).add(u);
            nodeList.get(u).add(v);
        }

        // 오름차순 정렬
        int size = nodeList.size();
        for(int i=1; i< size; i++) {
            Collections.sort(nodeList.get(i));
        }
        //bfs시작
        bfs(nodeList, visited, R);

        StringBuilder sb = new StringBuilder();

        // 순서 출력
        for(int i = 1; i < N+1; i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
    private static void bfs(
            ArrayList<ArrayList<Integer>> nodeList,
            int[] visited,
            int start
            ){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = ++count; // 시작 정점을 방문했다고 표시, 방문 순서 저장

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            int size = nodeList.get(vertex).size();
            // 현재 정점과 인접한 모든 정점을 확인
            for (int next : nodeList.get(vertex)) {
                // 인접하고 아직 방문하지 않은 정점이 있다면
                if (visited[next] == 0) {
                    visited[next] = ++count; // 해당 정점을 방문했다고 표시
                    queue.offer(next); // 큐에 추가
                }
            }
        }

    }
}
