package 알고리즘수업_깊이우선탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
# 요구사항
N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다.
정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다. 정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력
인접 정점은 오름차순으로 방문
# 내가 생각한 논리
위에 주어진 요구사항에 맞게 그래프와 dfs구현
메모리 초과가 떴음 -> 그래프를 배열로 구현해서 그런거라 예상
-> 리스트로 재구현
 */
public class Main {
    static int count = 0; // 방문 순서
    static ArrayList<ArrayList<Integer>> graph; // 인접리스트
    static int[] visited; // 방문 순서 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 정점의 수
        int M = Integer.parseInt(input[1]); // 간선의 수
        int R = Integer.parseInt(input[2]); // 시작 정점

        visited = new int[N+1];

        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            //입력받은 간선 정보 무방향 그래프 생성
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 오름차순 정렬
        int size = graph.size();
        for(int i=1; i< size; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 시작
        dfs(R);

        // 순서 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i< visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int R) {
        // Stack<Integer> stack = new Stack<>();
        // stack.push(R);
        visited[R] = ++count; // 방문횟수 저장

        //재귀로 구현
        for(int next : graph.get(R)) {
            if(visited[next] == 0) {
                dfs(next);
            }
        }

        /* 스택으로 어떻게 하는지 모르겠네요..
        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            for (int next : graph.get(vertex)) {
                if (visited[next] == 0) {
                    stack.push(next);
                    visited[next] = ++count;
                    //다음 인접 노드 방문하기 위해 break
                    break;
                }
            }
        }
        */
    }
}
