package 행렬덧셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] procession1 = new int[N][M];
        int[][] procession2 = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] inputArr = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                procession1[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        for(int i = 0; i < N; i++){
            String[] inputArr = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                procession2[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(procession1[i][j] + procession2[i][j])
                        .append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
