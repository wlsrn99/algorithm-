package 오목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] checkerboard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        checkerboard = new String[19][19];
        for(int i = 0; i < 19; i++){
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 19; j++){
                checkerboard[i][j] = input[j];
            }
        }

        //가로 j + 1
        //세로 i + 1
        //오른쪽 아래 대각선 i + 1, j + 1
        //오른쪽 위 대각선
        //여섯알 이상이 연속적으로 놓인 경우는 이긴 것이 아님
        int result = 0;
        int row = 0;
        int colum = 0;
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                if(checkerboard[i][j].equals("1") || checkerboard[i][j].equals("2")){
                    //가로일경우
                    if(checkWidth(i,j)){
                        result = Integer.parseInt(checkerboard[i][j]);
                        row = j;
                        colum = i;
                        break;
                    }
                    //세로일경우
                    if(checkLength(i,j)){
                        result = Integer.parseInt(checkerboard[i][j]);
                        row = j;
                        colum = i;
                        break;
                    }
                    //오른쪽 대각선일경우
                    if(checkDiagonal(i,j)){
                        result = Integer.parseInt(checkerboard[i][j]);
                        row = j;
                        colum = i;
                        break;
                    }
                    //왼쪽 대각선일경우
                    if(checkDiagonal2(i,j)){
                        result = Integer.parseInt(checkerboard[i][j]);
                        row = j;
                        colum = i;
                        break;
                    }
                }
            }
            if(result != 0){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(result != 0) {
            sb.append(result)
                    .append("\n")
                    .append(colum + 1)
                    .append(" ")
                    .append(row + 1);
        }else{
            sb.append(0);
        }
        System.out.println(sb);
    }
    //가로
    private static boolean checkWidth(int i, int j){
        int count = 1;
        for(int idx = 1; idx < 19- j; idx++){
            if(j + idx > 18){
                break;
            }
            if(checkerboard[i][j].equals(checkerboard[i][j + idx])){
                count++;
            }else{
                break;
            }
        }
        if(count == 5){
            //맨 왼쪽 옆이 6목인지 확인
            if((j-1) >= 0 && checkerboard[i][j-1].equals(checkerboard[i][j])){
                return false;
            }
            return true;
        }else{
            return false;
        }
    }

    //세로
    private static boolean checkLength (int i, int j){
        int count = 1;
        for(int idx = 1; idx < 19- i; idx++){
            if(i + idx > 18){
                break;
            }
            if(checkerboard[i][j].equals(checkerboard[i+idx][j])){
                count++;
            }else{
                break;
            }
        }
        if(count == 5){
            //맨 위쪽 한칸 위 가 6목인지 확인
            if((i-1) >= 0 && checkerboard[i-1][j].equals(checkerboard[i][j])){
                return false;
            }
            return true;
        }else{
            return false;
        }
    }
    //오른쪽 아래 대각선
    private static boolean checkDiagonal (int i, int j){
        int count = 1;
        int max = Math.max(i,j);
        for(int idx = 1; idx < 19-max; idx++){
            if (i + idx > 18 || j + idx > 18) { //인덱스가 범위를 벗어날 경우
                break;
            }
            if(checkerboard[i][j].equals(checkerboard[i+idx][j+idx])){
                count++;
            }else{
                break;
            }
        }
        if(count == 5){
            //맨 왼쪽 위 대각선이 6목인지 확인
            if((i-1) >= 0 && (j-1) >= 0&&checkerboard[i-1][j-1].equals(checkerboard[i][j])){
                return false;
            }
            //대각선 양끝에 인덱스가 존재하는지 확인
            if(i+5 > 18 && i-5 < 0){
                return false;
            }
            return true;
        }else{
            return false;
        }
    }
    //오른쪽 위 대각선
    private static boolean checkDiagonal2 (int i, int j){
        int count = 1;

        for(int idx = 1; idx <= i; idx++){
            if (j + idx > 18 || i - idx < 0) { //인덱스가 범위를 벗어날 경우
                break;
            }
            if(checkerboard[i - idx][j + idx].equals(checkerboard[i][j])){
                count++;
            }else{
                break;
            }
        }
        if(count == 5){
            //왼쪽 아래가 6목인지 확인
            if((i+1) <= 18 && (j-1) >= 0&&checkerboard[i+1][j-1].equals(checkerboard[i][j])){
                return false;
            }
            //대각선 양 끝에 인덱스가 존재하는지 확인
            if(i-5 < 0 && i + 5 > 18){
                return false;
            }
            return true;
        }else{
            return false;
        }
    }

}
