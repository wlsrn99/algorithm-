package N번째큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/*
   #요구사항 정리
   N * N 표에 수 N^2개 채워져 있고, 모든 수는 한 칸 위에 있는 수보다 크다 -> 트리구조?
   N번째 큰 수를 찾는 프로그램을 작성
   (1 ≤ N ≤ 1,500)이라서 이중for문 괜찮을거같다
   메모리 제한이 낮디 -> 공간복잡도를 보겠다는 의미

   #생각한 풀이 논리
   모든 수가 한칸 위에 있는 수보다 크니까 아래쪽으로 갈 수록 N번째로 비교할 우선순위가 커진다
   우선순위 큐를 사용하면 될거같은데
   제일 큰수부터 N번째를 찾는 방법과, 개수를 N으로 지정하고 제일 작은 수를 찾는 방법이 있을거같다
   각각 최대힙,최소힙을 이용하는 방법이지 않을까
    */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //최소 힙을 이용하는 방법 -> 메모리를 많이 줄일 수 있다, 최대 힙이랑 속도는 별 차이 없다
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            String[] rowInput = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(rowInput[j]);
                // 힙의 크키는 N으로 유지해야하므로 작으면 더 넣어준다
                // 힙에서 처음 꺼낸 값은 현재 힙의 최솟값이므로 이거보다 크면 힙에 넣어준다
                if(minHeap.size() < N || minHeap.peek() < num){
                    minHeap.offer(num);
                    //힙의 크기 N으로 유지하고 현재 최솟값을 빼면서 N번째 큰 값을 갱신한다
                    if(minHeap.size() > N){
                        minHeap.poll();
                    }
                }
            }
        }
        System.out.println(minHeap.poll());

        /* 최대 힙을 이용하는 방법 - 통과는 했는데 메모리랑 속도가 좀 떨어진다
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // 최대 힙

        for(int i = 0; i < N; i++){
            String[] rowInput = br.readLine().split(" ");
            // 큰 수 순서로 전부 힙에 저장
            for(int j = 0; j < N; j++){
                maxHeap.offer(Integer.parseInt(rowInput[j]));
            }
        }

        for(int i = 0; i < N-1; i++){
            maxHeap.poll();
        }

        System.out.println(maxHeap.poll());
         */
    }
}
