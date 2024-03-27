package 문자열반복;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int R = sc.nextInt();
            String S = sc.next();
            System.out.println(newString(S, R));
        }
    }

    private static String newString(String s, int r){
        String P = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < r; j++){
                P += s.charAt(i);
            }
        }
        return P;
    }
}