package 서로다른부분문자열의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        System.out.println(calculateSectionArrayCount(S));
    }
    private static int calculateSectionArrayCount(String s){
        Set<String> sectionArr = new HashSet<>();
        for(int i =0; i < s.length(); i++){
            int start = 0;
            int end = i;
            while(start <= end){
                StringBuilder sb = new StringBuilder();
                for(int j = start; j <= end; j++) {
                    sb.append(s.charAt(j));
                }
                sectionArr.add(String.valueOf(sb));
                start++;
            }
        }
        return sectionArr.size();
    }
}
