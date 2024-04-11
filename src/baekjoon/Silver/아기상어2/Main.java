package 아기상어2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
# 요구사항
N×M 크기의 공간에 아기 상어 여러 마리가 있다.
공간은 1×1 크기의 정사각형 칸으로 나누어져 있다
어떤 칸의 안전 거리는 그 칸과 가장 거리가 가까운 아기 상어와의 거리
두 칸의 거리는 하나의 칸에서 다른 칸으로 가기 위해서 지나야 하는 칸의 수
이동은 인접한 8방향(대각선 포함)이 가능
# 내가 생각한 논리
부모 노드부터 시작해서 갈 수 있는 모든 방향으로 깊이 탐색을 시작 -> dfs
거리는 모두 1로 같으므로 1번의 탐색이 끝날 때 count를 증가시키고 count를 비교시켜서 최댓값을 구하면 될 것 같다
아니면 깊이를 이용하면 될 것 같다
-> 생각을 잘못했다 bfs로 푸는 문제였다

 */
public class Main {
    static int[][] arr; //상어칸

    static int N,M;
    static int[] dx = {1,0,-1,0,1,-1,1,-1};
    static int[] dy = {0,1,0,-1,1,1,-1,-1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];


        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                //상어 있는 부분 -1로 바꿔주기
                int shark = Integer.parseInt(input[j]);
                if(shark == 1){
                    shark = -1;
                }
                arr[i][j] = shark;
            }
        }
        for(int i = 0; i <N; i++){
            for(int j = 0; j < M; j++){
                // 아기상어가 있을때 bfs의 시작노드가 될 수 있다
                if(arr[i][j] == -1){
                    bfs(j,i);
                }
            }
        }
        for(int i = 0; i <N; i++){
            for(int j = 0; j < M; j++) {
                max = Math.max(max,arr[i][j]);
            }
        }
        System.out.println(max);
    }
    private static void bfs(int x, int y) {
        Queue<OneSquare> queue = new LinkedList<>();
        queue.offer(new OneSquare(x,y,0));
        boolean[][] visited = new boolean[N][M];
        visited[y][x] = true;
        int min = y;

        while (!queue.isEmpty()) {
            OneSquare oneSquare = queue.poll();
            x = oneSquare.x;
            y = oneSquare.y;
            int distance = oneSquare.distance;
            for (int direction = 0; direction < 8; direction++) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (checkCurrentLocation(nx,ny,visited)) {
                    if (arr[ny][nx] == -1) {
                        visited[ny][nx] = true;
                        continue;
                    }else {
                        visited[ny][nx] = true;
                        if(arr[ny][nx] == 0 || arr[ny][nx] > distance+1){
                            arr[ny][nx] = distance + 1;
                        }
                        queue.offer(new OneSquare(nx, ny, distance + 1));

                    }
                }
            }
        }

    }


    // x,y값이 인덱스에 들어갈 수 있는 값인지 확인
    private static boolean checkCurrentLocation(int x, int y, boolean[][] visited){
        // x,y값이 배열의 범위를 벗어나는 경우
        if(x < 0 || x >= M || y < 0 || y >= N){
            return false;
        }
        // 이미 방문한 노드인 경우
        if(visited[y][x]){
            return false;
        }
        return true;
    }

    private static class OneSquare{
        int x;
        int y;
        int distance;
        OneSquare(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

}
