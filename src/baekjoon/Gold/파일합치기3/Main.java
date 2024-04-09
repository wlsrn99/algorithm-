package 파일합치기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 첫 행에는 소설을 구성하는 장의 수를 나타내는 양의 정수 K (3 ≤ K ≤ 1,000,000)
 두 번째 행에는 1장부터 K장까지 수록한 파일의 크기를 나타내는 양의 정수 K개가 주어진다. 파일의 크기는 10,000을 초과하지 않는다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split(" ");
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int j = 0; j < K; j++){
                pq.offer(Long.parseLong(input[j]));
            }
            long sum = 0;
            //비워질때까지 작은 것부터 하나씩 합쳐주기
            while(!pq.isEmpty()){
                long file1 = pq.poll();
                long file2 = pq.poll();

                long newFile = file1 + file2;
                sum += newFile;
                // 마지막 두 개 합칠 때 처리
                if(!pq.isEmpty()) {
                    pq.offer(newFile);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
