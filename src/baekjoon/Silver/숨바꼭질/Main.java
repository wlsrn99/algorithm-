package 숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동
 */
public class Main {
    static int MAX = 100001; //N의 최댓값 + 1
    static boolean[] visited = new boolean[MAX];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == K) {
                    return time;
                }

                // X-1로 이동하는 경우
                if (current - 1 >= 0 && !visited[current - 1]) {
                    queue.offer(current - 1);
                    visited[current - 1] = true;
                }
                // X+1로 이동하는 경우
                if (current + 1 < MAX && !visited[current + 1]) {
                    queue.offer(current + 1);
                    visited[current + 1] = true;
                }
                // X*2로 이동하는 경우
                if (current * 2 < MAX && !visited[current * 2]) {
                    queue.offer(current * 2);
                    visited[current * 2] = true;
                }
            }
            //인덱스가 시간을 뜻하므로 ++
            time++;
        }

        return -1;
    }
}

