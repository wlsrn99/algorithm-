package IOIOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //P의 순서를 나타내는 정수 N
        //문자열의 길이  M
        //I와 O로만 이루어진 문자열 S

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long M = Long.parseLong(br.readLine());
        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append("I");
        while(N > 0){
            sb.append("OI");
            N--;
        }

        String word = sb.toString();
        int count = 0;
        int check = S.indexOf(word);

        while(check != -1){
            count++;
            check = S.indexOf(word, check + 1);
        }
        System.out.println(count);
    }
}
