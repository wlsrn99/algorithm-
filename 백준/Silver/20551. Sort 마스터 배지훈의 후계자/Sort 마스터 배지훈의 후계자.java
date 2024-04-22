

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] A = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int size = A.length - 1;


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int D = Integer.parseInt(br.readLine());

            int lower = lowerBound(A,D);
            if(A[lower] == D){
                sb.append(lower).append("\n");
            }else{
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);

    }

    private static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length-1;

        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {

            int mid = (lo + hi) / 2; // 중간위치를 구한다.

            /*
             *  key 값이 중간 위치의 값보다 작거나 같을 경우
             *
             *  (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
             */
            if (key <= arr[mid]) {
                hi = mid;
            }

            else {
                lo = mid + 1;
            }

        }
        return lo;
    }
}
