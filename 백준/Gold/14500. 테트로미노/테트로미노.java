

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int max = 0;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
                checkTShape(i, j);
            }
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    private static void checkTShape(int x, int y) {
        // ㅜ
        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x+1][y+1]);
        }
        // ㅗ
        if (x > 0 && y + 2 < m) {
            max = Math.max(max, arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x-1][y+1]);
        }
        // ㅏ
        if (x + 2 < n && y + 1 < m) {
            max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x+2][y] + arr[x+1][y+1]);
        }
        // ㅓ
        if (x + 2 < n && y > 0) {
            max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x+2][y] + arr[x+1][y-1]);
        }
    }
}