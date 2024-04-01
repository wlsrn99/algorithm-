package 배열돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int R;
    static String temp1;
    static String temp2;

    static StringBuilder sb = new StringBuilder();

    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        arr = new String [N][M];
        for(int i = 0; i < N; i++){
            String inputArr = br.readLine();
            String[] inputRow = inputArr.split(" ");
            for(int j = 0; j < M; j++){
                arr[i][j] = inputRow[j];
            }
        }
        int loopNum = Math.min(N,M) / 2; //루프가 도는 횟수
        rotateArray(loopNum);
        System.out.println(sb);

    }

    private static void rotateArray(int loopNum){
        if(R == 0){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }


        for(int s = 0; s < loopNum; s++) {
            temp1 = arr[s][s];
            //아래로 가는 경우
            for (int i = s; i < (N - 1) - s; i++) { //시작지점  i+1, j+1 // 끝나는 횟수 -2
                downSwap(i, 0+s);
            }
            //오른쪽으로 가는 경우
            for (int j = s; j < (M - 1) - s; j++) { //시작지점 i-1, j+1
                rightSwap(N - 1 - s, j);
            }
            //위쪽으로 가는 경우
            for (int i = N - 1- s; i > s; i--) { //시작지점 i-1, j-1
                upSwap(i, M - 1 - s);
            }
            // 왼쪽으로 가는 경우
            for (int j = M - 1 - s; j > s; j--) { //시적지점 i+1, j-1
                leftSwap(0 + s, j);
            }
        }
        R--;
        rotateArray(loopNum);
    }

    private static void downSwap(int i, int j){
        temp2 = arr[i+1][j];
        arr[i+1][j] = temp1;
        temp1 = temp2;
    }
    private static void rightSwap(int i, int j){
        temp2 = arr[i][j+1];
        arr[i][j+1] = temp1;
        temp1 = temp2;
    }
    private static void upSwap(int i, int j){
        temp2 = arr[i-1][j];
        arr[i-1][j] = temp1;
        temp1 = temp2;
    }
    private static void leftSwap(int i, int j){
        temp2 = arr[i][j-1];
        arr[i][j-1] = temp1;
        temp1 = temp2;
    }

}
