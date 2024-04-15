package A와B_2;

import java.io.*;

public class Main {
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String T = br.readLine();

        if(makeS(T)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    private static boolean makeS(String t) {
        int len = t.length();

        if (len == S.length()) {
            if (t.equals(S)) {
                return true;
            }
            return false;
        }

        if (t.endsWith("A")) {
            if(makeS(t.substring(0, len - 1))){
                return true;
            }
        }

        if (t.startsWith("B")) {
            if(makeS(new StringBuilder(t).deleteCharAt(0).reverse().toString())){
                return true;
            }
        }

        return false;
    }
}