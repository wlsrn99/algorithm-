package 프린터큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        // 첫째 줄 테스트 케이스의 개수 - 테스트 케이스만큼 반복
        // 둘째 줄 문서의 개수 N, 찾을 문서가 현재 큐에서 몇 번째에 놓여있는지 나타내는 M
        // 셋째 줄 N개 문서의 중요도

        // 양쪽을 처리 해줘야하니 Deque를 활용해야할듯
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testNum; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            // 중요도와 인덱스를 활용해야하므로 저장 하는 곳이 필요

            // 문서의 인덱스에 따른 중요도를 저장하는 배열
            int[] priorities = new int[N];
            // 문서의 인덱스를 저장하는 Deque
            Deque<Integer> indexes = new ArrayDeque<>();

            String[] inputPriority = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(inputPriority[j]);
                priorities[j] = priority;
                indexes.offerLast(j);
            }

            int count = 0;
            while (!indexes.isEmpty()) {
                int currentIndex = indexes.pollFirst(); // 현재 문서의 인덱스
                int currentPriority = priorities[currentIndex]; // 현재 문서의 중요도

                boolean isHighPriority = true;
                for (int index : indexes) {
                    if (priorities[index] > currentPriority) {
                        isHighPriority = false;
                        break;
                    }
                }

                if (isHighPriority) { // 맨 앞 문서보다 중요도가 높은 문서가 뒤쪽에 없을 때
                    count++;
                    if (currentIndex == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    indexes.offerLast(currentIndex); // 있으면 다시 Deque 맨 뒤에 추가
                }
            }
        }
    }
}
