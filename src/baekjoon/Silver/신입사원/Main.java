package 신입사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N + 1];
            for(int n = 0; n < N; n++){
                String[] input = br.readLine().split(" ");
                int documentRank = Integer.parseInt(input[0]);
                int interviewRank = Integer.parseInt(input[1]);

                rank[documentRank] = interviewRank;
            }
            int count = 1;
            int standard = rank[1];
            for(int i = 2; i < N+1; i++){
                if(rank[i] < standard){
                    count++;
                    standard = rank[i];
                }
            }

            System.out.println(count);
        }
    }
}
