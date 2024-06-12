import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        // 두 번째 입력
        arr = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // DFS 수행
        dfs(0, 0);

        // 합이 S가 되는 부분 수열의 개수 출력
        if (S == 0) // 합이 0인 경우 공집합도 포함되므로 count에서 1을 빼줍니다.
            count--;
        System.out.println(count);
    }

    // DFS로 부분 수열 생성하여 합이 S가 되는 경우 count 증가
    public static void dfs(int depth, int sum) {
        // 부분 수열의 합이 S와 같은 경우 count 증가
        if (depth == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        // 현재 수를 포함하는 경우
        dfs(depth + 1, sum + arr[depth]);
        // 현재 수를 포함하지 않는 경우
        dfs(depth + 1, sum);
    }
}
