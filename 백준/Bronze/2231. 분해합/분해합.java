

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int start = Math.max(1, N - 9 * String.valueOf(N).length());

        for (int i = start; i < N; i++) {
            int sum = i;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}