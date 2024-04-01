package 체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        boolean[][] color = new boolean[N][M];

        for(int i =0; i < N; i++){
            String board = br.readLine();
            for(int j = 0; j < M; j++){
                if(board.charAt(j) == 'W'){
                    color[i][j] = true;
                }
            }
        }
        int min = 64;
        int x = M - 7;
        int y = N - 7;

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                min = Math.min(min,calculateMin(color,i,j));
            }
        }
        System.out.println(min);
    }
    private static int calculateMin(boolean[][] color, int y, int x){
        int chessX = x + 8;
        int chessY = y + 8;
        int count = 0;

        boolean oneChessBoard = true;
        for(int i = y; i < chessY; i++){
            for(int j = x; j < chessX; j++){
                if(color[i][j] != oneChessBoard){
                    count++;
                }
                oneChessBoard = !oneChessBoard;
            }
            oneChessBoard = !oneChessBoard; //짝수이므로 열이 끝나면 한 번 더 바꿈
        }
        return Math.min(count, 64-count);
    }
}
