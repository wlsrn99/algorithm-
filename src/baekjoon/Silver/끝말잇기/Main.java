package 끝말잇기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        int count = -1;
        Set<String> duplication = new HashSet<>();

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            if (words[i].equals("?")) {
                count = i;
            } else {
                duplication.add(words[i]);
            }
        }
        int M = Integer.parseInt(br.readLine());
        String[] candidateWords = new String[M];

        for (int i = 0; i < M; i++) {
            String word = br.readLine();
            if (N == 1) {
                System.out.println(word);
                break;
            }
            ;
            if (duplication.contains(word)) {
                continue;
            }
            if (count == 0) { //처음 ?
                if (words[count + 1].charAt(0) == word.charAt(word.length() - 1)) {
                    System.out.println(word);
                    break;
                }
            } else if (count == N - 1) {// 마지막 ?
                if (words[count - 1].charAt(words[count - 1].length() - 1) == word.charAt(0)) {
                    System.out.println(word);
                    break;
                }
            } else { // 중간 ?
                if (words[count + 1].charAt(0) == word.charAt(word.length() - 1)
                        && words[count - 1].charAt(words[count - 1].length() - 1) == word.charAt(0)) {
                    System.out.println(word);
                    break;
                }
            }
        }
    }
}
