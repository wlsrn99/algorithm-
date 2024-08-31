

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 동전의 종류
        int k = Integer.parseInt(input[1]); // 가치의 합

        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 동전을 내림차순으로 정렬
        Arrays.sort(coins, Collections.reverseOrder());

        int count = 0;
        for (int coin : coins) {
            if (k >= coin) {
                count += k / coin;
                k %= coin;
            }
            if (k == 0) break;
        }

        System.out.println(count);
    }
}