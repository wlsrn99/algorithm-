package 행복유치원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
# 요구 사항
 N명의 원생들을 키 순서대로 일렬로 줄 세우고
 총 K개의 조로 나누려고 한다.
 각 조에는 원생이 적어도 한 명
 같은 조에 속한 원생들은 서로 인접해 있어야 한다. 조별로 인원수가 같을 필요는 없다
 조마다 티셔츠를 맞추는 비용은 조에서 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이만큼 든다
 K개의 조에 대해 티셔츠 만드는 비용의 합을 최소로 하고 싶어한다.

  유치원에 있는 원생의 수를 나타내는 자연수 N(1 ≤ N ≤ 300,000)
  조의 개수를 나타내는 자연수 K(1 ≤ K ≤ N)
  원생들의 키를 나타내는 N개의 자연수 원생의 키는 10^9를 넘지 않는 자연수
 # 내가 생각한 논리
 유치원생들의 키 차이가 최소가 되는 조건
 인접한 키 차이를 모두 구해서 오름차순으로 정렬한 뒤 고르면 된다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); //원생의 수
        int K = Integer.parseInt(input[1]); //조의 개수

        input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i <N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        //인접한 원생의 키차이 배열
        int[] cost = new int[N-1];
        for(int i = 0; i < N-1; i++){
            cost[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(cost);

        int sum = 0;
        // N-1 = 키 차이의 개수
        // k-1 = 구분선의 개수
        // 골라야하는 키차이 개수 = (키차이의 개수) - (구분 선의 개수)
        for(int i = 0; i < (N-1)- (K-1); i++){
            sum += cost[i];
        }
        System.out.println(sum);

    }
}
