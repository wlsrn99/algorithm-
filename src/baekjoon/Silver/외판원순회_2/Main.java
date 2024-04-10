package 외판원순회_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
# 요구사항
1번부터 N번까지 번호가 매겨져 있는 도시들이 있고, 도시들 사이에는 길이 있다.
(길이 없을 수도 있다) 이제 한 외판원이 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로
 단, 한 번 갔던 도시로는 다시 갈 수 없다. (맨 마지막에 여행을 출발했던 도시로 돌아오는 것은 예외)
 W[i][j]는 도시 i에서 도시 j로 가기 위한 비용을 나타낸다. 비용은 대칭적이지 않다. 즉, W[i][j] 는 W[j][i]와 다를 수 있다.
 모든 도시간의 비용은 양의 정수이다. W[i][i]는 항상 0이다. 경우에 따라서 도시 i에서 도시 j로 갈 수 없는 경우도 있으며 이럴 경우 W[i][j]=0
# 내가 생각한 논리
1. 한 번 갔던 도시로는 다시 갈 수 없으므로 boolean방문 배열이 필요하다

W[i][j]는 도시 i에서 j로 가기 위한 비용을 나타낸다에 주목해보면
i에서 j로 가는 도시를 N - 1 번 고르고 마지막에는 j가 0이어야한다

깊이가 N - 1인 dfs나 조합을 사용하면 될거같다
 */
public class Main {
    static int[][] city;
    static int N;
    static int min = Integer.MAX_VALUE; //최소 비용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        city = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                city[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[] visited = new boolean[N];
        // 첫 도시 방문 처리
        visited[0] = true;
        //dfs시작
        dfs(visited, 0, 0,0);

        System.out.println(min);
    }

    private static void dfs(boolean[] visited,
                            int depth,
                            int idx,
                            int sum
                            ){
        if(depth == N-1){
            if(city[idx][0] != 0) { //마지막 도시에서 처음 도시로 갈 수 있는 경우 체크
                sum += city[idx][0];
                min = Math.min(min, sum);
            }
            return;
        }

        for(int i = 1; i < N; i++){
            if(!visited[i] && city[idx][i] != 0) { // 방문하지 않았고, 다음 도시로 갈 수 있는 경우
                visited[i] = true;
                dfs(visited, depth+1 ,i, sum + city[idx][i]);
                visited[i] = false;
            }
        }

    }
}
