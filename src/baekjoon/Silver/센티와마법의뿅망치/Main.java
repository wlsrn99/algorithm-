package 센티와마법의뿅망치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
# 요구사항
이 뿅망치에 맞은 사람의 키가 ⌊ 뿅망치에 맞은 사람의 키 / 2 ⌋로 변하는 마법 도구
하지만 마법의 뿅망치는 횟수 제한
바로 매번 가장 키가 큰 거인 가운데 하나를 때리는 것
거인의 나라의 모든 거인이 센티보다 키가 작도록 할 수 있을까
# 나의 논리
현재 센티보다 큰 거인의 키를 저장하는 자료구조가 필요하다
입력받을때 센티보다 큰 경우 자료구조에 넣고 가장 큰 거인부터 뿅망치로 때려야하므로
내림차순으로 정렬되어 있으면 좋다 -> 우선순위 큐 , 최대 힙

힙이 비워질때까지 꺼내서 /2를 하고 count변수를 하나 만들어서
주어진 횟수보다 더 많이 때리게 되는 경우는 탐색을 중단하고 NO를 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 센티 제외 인구수
        int N = Integer.parseInt(input[0]);
        // 센티의 키
        int H = Integer.parseInt(input[1]);
        // 뿅망치 횟수
        int T = Integer.parseInt(input[2]);

        //거인들의 키 저장
        PriorityQueue<Integer> biggerHeight = new PriorityQueue<>((a,b) -> (b-a));

        for(int i = 0; i < N; i++){
            int oneHeight = Integer.parseInt(br.readLine());
                biggerHeight.offer(oneHeight);
        }
            int count = 0;
            while (T > 0 && !biggerHeight.isEmpty()) {
                if(biggerHeight.peek() < H || biggerHeight.peek() == 1){
                    break;
                }else{
                    int giant = biggerHeight.poll();
                    biggerHeight.offer(giant/2);
                    T--;
                    count++;
                }
            }
            if(biggerHeight.peek() < H){
                System.out.println("YES");
                System.out.println(count);
            }else{
                System.out.println("NO");
                System.out.println(biggerHeight.peek());
            }
        }
}
