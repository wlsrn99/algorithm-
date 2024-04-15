package 소수최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> primes = new HashSet<>();
        for(int i = 0; i < N; i++){
            if(isPrime(input[i])){
                primes.add(input[i]);
            }
        }

        long result = 1;
        if(primes.isEmpty()){
            System.out.println(-1);
        }else{
            for(int p : primes){
                result *= p;
            }
            System.out.println(result);
        }

    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }

        // num/2까지 하니까 시간초과나서
        // 제곱근까지만 반복
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
