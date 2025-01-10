
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }

            int[] arr = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt).toArray();

            int n = arr[0];
            int count = 0;

            Queue<Integer> pq = new PriorityQueue<>();
            for (int i = 1; i <= n; i++) {
                if (arr[i] == 0) {
                    count++;
                } else {
                    pq.offer(arr[i]);
                }
            }

            StringBuilder s1 = new StringBuilder().append(pq.poll());
            StringBuilder s2 = new StringBuilder().append(pq.poll());

            // 0을 두 번째 자리부터 삽입
            while (count > 0) {
                if (s1.length() <= s2.length()) {
                    s1.append('0');
                } else {
                    s2.append('0');
                }
                count--;
            }

            // 나머지 숫자 삽입
            while (!pq.isEmpty()) {
                if (s1.length() <= s2.length()) {
                    s1.append(pq.poll());
                } else {
                    s2.append(pq.poll());
                }
            }

            long result = Long.parseLong(s1.toString()) + Long.parseLong(s2.toString());
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
