

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 괄호를 적절히 쳐서 이 식의 값을 최소
 * -> -가 나오면 다음 -가 나올때 까지 괄호
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");

        long result = 0;
        for (int i = 0; i < input.length; i++) {
            int[] nums = Arrays.stream(input[i].split("\\+"))
                .mapToInt(Integer::parseInt).toArray();

            long sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        System.out.println(result);
    }
}