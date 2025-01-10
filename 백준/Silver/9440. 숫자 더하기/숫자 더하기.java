
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;

            int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = arr[0];
            
            PriorityQueue<Integer> nonZero = new PriorityQueue<>();
            int zeroCount = 0;

            for (int i = 1; i <= n; i++) {
                if (arr[i] == 0) zeroCount++;
                else nonZero.offer(arr[i]);
            }

            StringBuilder s1 = new StringBuilder().append(nonZero.poll());
            StringBuilder s2 = new StringBuilder().append(nonZero.poll());

            // 0을 두 번째 자리부터 삽입
            while (zeroCount > 0) {
                if (s1.length() <= s2.length()) s1.append('0');
                else s2.append('0');
                zeroCount--;
            }

            // 나머지 숫자 삽입
            while (!nonZero.isEmpty()) {
                if (s1.length() <= s2.length()) s1.append(nonZero.poll());
                else s2.append(nonZero.poll());
            }

            long result = Long.parseLong(s1.toString()) + Long.parseLong(s2.toString());
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
