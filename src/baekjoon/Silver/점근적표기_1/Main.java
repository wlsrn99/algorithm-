package 점근적표기_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 입력 받는거 a1,a0, c, n0
    // a1 * n + a0 <= c * n
    // a0 <= n(c - a1) n0보다 크거나 같은 조건에 대하여 만족

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        String[] aArr = a.split(" ");
        int a1 = Integer.parseInt(aArr[0]);
        int a0 = Integer.parseInt(aArr[1]);

        int result = 1;
        for(int i = n; i <= 100; i++){
            if(a0 > i * (c-a1)){
                result = 0;
                break;
            }
        }

        System.out.println(result);



    }
}
