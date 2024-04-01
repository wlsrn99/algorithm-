package 최댓값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int max = 0;
        int row = 0;
        int colum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            String[] inputNums = br.readLine().split(" ");
            for(int j = 0; j < 9; j++){
                int inputNum = Integer.parseInt(inputNums[j]);
                if(inputNum > max){
                    max = inputNum;
                    row = j;
                    colum = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max)
                .append("\n")
                .append(colum + 1)
                .append(" ")
                .append(row + 1);
        System.out.println(sb);
    }
}
