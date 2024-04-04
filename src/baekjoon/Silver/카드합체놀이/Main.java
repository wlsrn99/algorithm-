package 카드합체놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
#요구 사항 정리
아기 석환이는 자연수가 쓰여진 카드를 n장 갖고 있다
처음에 i번 카드엔 ai가 쓰여있다. 카드 합체 놀이는 이 카드들을 합체하며 노는 놀이
    1. x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산한다. (x ≠ y)
    2. 계산한 값을 x번 카드와 y번 카드 두 장 모두에 덮어 쓴다.
이 카드 합체를 총 m번 하면 놀이가 끝
n장의 카드에 쓰여있는 수를 모두 더한 값이 이 놀이의 점수
이 점수를 가장 작게 만드는 것이 놀이의 목표

첫 번째 줄에 카드의 개수를 나타내는 수 n(2 ≤ n ≤ 1,000)과 카드 합체를 몇 번 하는지를 나타내는 수 m(0 ≤ m ≤ 15×n)
두 번째 줄에 맨 처음 카드의 상태를 나타내는 n개의 자연수 a1, a2, …, an

#내가 생각한 논리
일단 n개의 카드들은 작은 순서대로 정렬되어있어야 연산이 편할거같다
-> 먼저 최소 힙으로 정렬한다고 가정
x번 카드와 y번카드를 고른뒤 더하고 x,y모두 값이 변하므로 두 개를 빼고 두 개 추가시켜야함
-> 최소 힙에서 첫번째를 먼저 미리 빼놓고 변수에 저장
-> 두번째를 빼서 변수와 더하고 다시 변수에 저장
-> 이 변수를 다시 힙에 두 번 넣는다
그리고 힙 안에 들어있는 모든 숫자를 더하면 답이 나오지 않을까
#수정한 부분
(1 ≤ ai ≤ 1,000,000)이므로 카드 부분을 long형으로 바꿨다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 카드의 총 개수
        int m = Integer.parseInt(input[1]); // 합체 개수

        String[] input2 = br.readLine().split(" ");
        //카드를 저장할 최소 힙
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            minHeap.offer(Long.parseLong(input2[i]));
        }

        for(int i = 0; i < m; i++){
            //현재 힙에서 제일 작은 수
            long currentCard = minHeap.poll();
            //현재 힙에서 두번째로 작은 수
            long currentCard2 = minHeap.poll();
            long currentSum = currentCard + currentCard2;
            // x,y 두 개의 카드가 바뀌므로 두개 똑같은 값 다시 저장
            for(int j = 0; j < 2; j++){
                minHeap.offer(currentSum);
            }
        }
        long resultSum = 0;
        for(long result : minHeap){
            resultSum += result;
        }
        System.out.println(resultSum);
    }
}
