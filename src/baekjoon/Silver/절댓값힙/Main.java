package 절댓값힙;
/*
# 요구사항정리
배열에 정수 x (x ≠ 0)를 넣는다.
배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작

첫째 줄에 연산의 개수 N(1≤N≤100,000)
N개의 줄에는 연산에 대한 정보를 나타내는 정수 x
 x가 0이 아니라면 배열에 x라는 값 추가
 x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력

#처리해야할 조건
1.절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력후 제거
2.만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우 0 출력

# 내가생각한논리
처음엔 절댓값으로 바꿔서 배열에 넣을 생각을 했는데 출력을 -로 해야하므로
음수, 양수 나눠서 배열에 저장하는게 좋겠다고 생각이 든다
음수일경우 제일 큰 값이 절댓값이 작다
-> 최대 힙
양수일 경우 제일 작은 값이 절댓값이 작다
-> 최소 힙
이렇게 두 개의 힙을 만들어서 peek로 복사한 뒤 비교하고
절댓값이 더 작은 곳의 힙에서 poll하면 될거같다
-> 절댓값이 만약 똑같은 경우는 음수 힙 출력
-> 두 개의 힙이 비어있는 경우는 0 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 음수인 경우를 저장할 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        // 양수인 경우를 저장할 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int inputNum = Integer.parseInt(br.readLine());
            if(inputNum < 0){
                maxHeap.offer(inputNum);
            }else if(inputNum > 0){
                minHeap.offer(inputNum);
            }else{
                if(minHeap.isEmpty() && !maxHeap.isEmpty()){ // 최소 힙만 비어있는 경우
                    System.out.println(maxHeap.poll());
                }else if(maxHeap.isEmpty() && !minHeap.isEmpty()){// 최대 힙만 비어있는 경우
                    System.out.println(minHeap.poll());
                }else if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                    if (Math.abs(maxHeap.peek()) <= minHeap.peek()) {
                        System.out.println(maxHeap.poll());
                    }else{
                        System.out.println(minHeap.poll());
                    }
                }else{ // 힙이 비어있거나 inputNum이 0일때
                    System.out.println(0);
                }
            }
        }
    }
}
