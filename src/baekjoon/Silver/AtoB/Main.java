package AtoB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int count = 1;
        while (A != B){
            if(B < A){
                System.out.println(-1);
                System.exit(0);
            }
            if(B % 10 == 1){
                B /= 10;
            }else if (B % 2 == 0){
                B /= 2;
            }else{
                System.out.println(-1);
                System.exit(0);
            }
            count++;
        }
        System.out.println(count);
    }
}
