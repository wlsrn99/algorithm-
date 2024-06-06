

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");

        int[] arrN = new int[N];
        for(int i = 0; i< N; i++){
            arrN[i] = Integer.parseInt(input[i]);
        }

        //배열 정렬
        Arrays.sort(arrN);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< M; i++){
            int num = Integer.parseInt(input2[i]);

            int start = 0;
            int end = N-1;
            boolean result = false;

            while(start <= end){
                int currentMid = (start + end)/2;

                if(arrN[currentMid] < num){
                    start = currentMid + 1;
                }else if(arrN[currentMid] > num){
                    end = currentMid - 1;
                }else{
                    result = true;
                    break;
                }
            }

            if(result){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}

