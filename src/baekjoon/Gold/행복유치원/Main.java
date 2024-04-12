package 행복유치원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
 비용은 조에서 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이
 -> 최소가 되려면 가장 키가 큰 원생을 우선으로 빼야 한다
 -> 왼쪽에 있는 원생이 오른쪽보다 크지 않다? - 중복이 가능 할 수도, queue를 써야되나
 -> 내림차순 우선순위 큐를 사용하는게 좋을거 같다

1 3 5 6 9 10
1 3 5 40 70 400 9000
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        input = br.readLine().split(" ");
        int first = 0;
        for(int i = 0; i < N; i++){
            if(i == 0){
                first = Integer.parseInt(input[i]);
            }else {
                pq.offer(Integer.parseInt(input[i]));
            }
        }

        for(int i = 0; i < K-1; i++){
            pq.poll();
        }

        int end = pq.poll();
        System.out.println(end-first);

    }
}
