package 누울자리를찾아라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[][] condo = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String oneCondo = br.readLine();
            for(int j = 0; j < N; j++){
                if(oneCondo.charAt(j) != 'X'){
                    condo[i][j] = true;
                }
            }
        }
        //가로 개수
        int rowCount = 0;
        for(int i = 0; i < N; i++){
            int count = 0;
            for(int j = 0; j < N; j++){
                if(condo[i][j]){
                    count++;
                    if(count > 2){
                        continue;
                    }else if(count == 2){
                        rowCount++;
                    }
                }else{
                    count = 0;
                }
            }
        }
        // 세로 개수
        int columCount = 0;
        for(int i = 0; i < N; i++){
            int count = 0;
            for(int j = 0; j < N; j++){
                if(condo[j][i]){
                    count++;
                    if(count > 2){
                        continue;
                    }else if(count == 2){
                        columCount++;
                    }
                }else{
                    count = 0;
                }
            }
        }
        System.out.println(rowCount + " " + columCount);
    }
}
