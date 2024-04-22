
/*
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)
둘째 줄에는 숫자 카드에 적혀있는 정수
-10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
두 숫자 카드에 같은 수가 적혀있는 경우는 없다

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다
넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수
 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(input1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            int start = 0;
            boolean check = true;
            int end = input1.length - 1;
            while(start <= end){
                int mid = (end + start) / 2;
                if(input1[mid] < input2[i]){
                    start = mid + 1;
                }else if(input1[mid] > input2[i]){
                    end = mid - 1;
                }else if(input1[mid] == input2[i]){
                    sb.append(1).append(" ");
                    check = false;
                    break;
                }
            }
            if (check){
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);

    }
}
