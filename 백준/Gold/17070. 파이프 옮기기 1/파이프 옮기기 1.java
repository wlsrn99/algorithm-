import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] house;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0); // 시작 위치 (1,2), 가로 방향(0)

        System.out.println(count);
    }

    // direction: 0(가로), 1(세로), 2(대각선)
    private static void dfs(int x, int y, int direction) {
        if (x == N && y == N) {
            count++;
            return;
        }

        switch(direction) {
            case 0: // 가로
                if (y + 1 <= N && house[x][y+1] == 0) {
                    dfs(x, y+1, 0);
                }
                break;
            case 1: // 세로
                if (x + 1 <= N && house[x+1][y] == 0) {
                    dfs(x+1, y, 1);
                }
                break;
            case 2: // 대각선
                if (y + 1 <= N && house[x][y+1] == 0) {
                    dfs(x, y+1, 0);
                }
                if (x + 1 <= N && house[x+1][y] == 0) {
                    dfs(x+1, y, 1);
                }
                break;
        }

        // 대각선 이동 (모든 방향에서 가능)
        if (x + 1 <= N && y + 1 <= N && house[x+1][y] == 0 && house[x][y+1] == 0 && house[x+1][y+1] == 0) {
            dfs(x+1, y+1, 2);
        }
    }
}