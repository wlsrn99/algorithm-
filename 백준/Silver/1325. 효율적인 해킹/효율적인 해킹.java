
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static ArrayList<ArrayList<Integer>> hackingList = new ArrayList<>();
    static int[] count;//신뢰받고 있는 컴퓨터의 개수
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        m = input[1];
        count = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            hackingList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // a가 b를 신뢰 -> b를 통해 a를 해킹할 수 있음
            hackingList.get(input[1]).add(input[0]);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            bfs(i);
            max = Math.max(max, count[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (count[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : hackingList.get(current)) {
                if (!visited[next]) {
                    count[start]++;
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
