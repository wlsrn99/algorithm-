package PuyoPuyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
필드에 여러 가지 색깔의 뿌요를 놓는다. 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.
뿌요를 놓고 난 후, 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다.
아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데, 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다

연쇄가 몇 번 연속으로 일어날지 계산

총 12개의 줄에 필드의 정보가 주어지며,
각 줄에는 6개의 문자가 있다.
.은 빈공간이고 .이 아닌것은 각각의 색깔의 뿌요를 나타낸다
R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다

 */
public class Main {
    static char[][] board = new char[12][6];
    static boolean[][] visited = new boolean[12][6];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i <12; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j <6; j++){
                board[i][j] = input[j];
            }
        }
        int chain = 0; // 연쇄 횟수
        while (true) {
            boolean found = false;
            // 모든 뿌요에 대해 BFS를 수행하여 터뜨릴 수 있는 뿌요 그룹을 찾음
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (board[i][j] != '.' && !visited[i][j]) {
                        List<Pair> popped = bfs(i, j, board[i][j]);
                        if (popped.size() >= 4) {
                            found = true;
                            for (Pair p : popped) {
                                board[p.x][p.y] = '.';
                            }
                        }
                    }
                }
            }
            if (!found) break; // 더 이상 터뜨릴 뿌요가 없으면 종료
            chain++; // 연쇄 횟수 증가
            // 뿌요 떨어뜨리기
            // row기준으로 한줄씩 처리
            for (int j = 0; j < 6; j++) {
                List<Character> colors = new ArrayList<>();
                for (int i = 11; i >= 0; i--) {
                    if (board[i][j] != '.') {
                        colors.add(board[i][j]);
                        board[i][j] = '.';
                    }
                }
                int idx = 11;
                for (char color : colors) {
                    board[idx--][j] = color;
                }
            }
            // 방문 여부 초기화
            for (int i = 0; i < 12; i++) {
                Arrays.fill(visited[i], false);
            }
        }

        System.out.println(chain);
    }

    static List<Pair> bfs(int x, int y, char color) {
        List<Pair> popped = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(x, y));
        visited[x][y] = true;
        popped.add(new Pair(x, y));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];
                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visited[nx][ny] && board[nx][ny] == color) {
                    queue.offer(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    popped.add(new Pair(nx, ny));
                }
            }
        }
        return popped;
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
