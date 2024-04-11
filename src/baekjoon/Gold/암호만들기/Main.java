package 암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;

public class Main {
    static int L,C;
    static String[] alphabet;
    static String[] password;
    static StringBuilder answer = new StringBuilder();
    static Set<String> moms = Set.of("a","e","i","o","u");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        alphabet = br.readLine().split(" ");


        Arrays.sort(alphabet);

        password = new String[L+1];

        combination(0, L,0,0);

        System.out.println(answer);
    }

    private static void combination(
            int start,
            int r,
            int momCount,
            int sonCount
    ){
        if(r == 0){
            if(momCount >= 1 && sonCount >= 2){
                int size = password.length;
                for(int i = 0; i < size; i++){
                    if(password[i] != null) {
                        answer.append(password[i]);
                    }
                }
                answer.append("\n");
            }
            return;
        }

        for(int i =start; i < C; i++){
            String curChar = alphabet[i];
            password[L - r] = curChar;

            if(moms.contains(curChar)){
                combination(i+1, r-1, momCount + 1, sonCount);
            }else{
                combination(i+1,r-1,momCount,sonCount+1);
            }
        }
    }
}
