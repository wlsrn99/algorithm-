import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10]; // 과일 종류는 1부터 9까지
        int start = 0, types = 0, maxLength = 0;

        for (int end = 0; end < N; end++) {
            if (count[fruits[end]] == 0) types++;
            count[fruits[end]]++;

            while (types > 2) {
                count[fruits[start]]--;
                if (count[fruits[start]] == 0) types--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        System.out.println(maxLength);
    }
}