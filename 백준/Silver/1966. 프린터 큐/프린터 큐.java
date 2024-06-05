

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testNum; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            int[] priorities = new int[N]; // 문서의 중요도를 저장할 배열
            Deque<Integer> indexes = new ArrayDeque<>(); // 문서의 인덱스를 저장할 Deque
            String[] priorityStr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(priorityStr[j]);
                priorities[j] = priority;
                indexes.add(j); // 인덱스를 Deque에 추가
            }

            int count = 0;
            while (!indexes.isEmpty()) {
                int currentIndex = indexes.poll(); // 현재 문서의 인덱스를 가져옴
                int currentPriority = priorities[currentIndex]; // 현재 문서의 중요도를 가져옴

                boolean isHighestPriority = true;
                for (int index : indexes) {
                    if (priorities[index] > currentPriority) {
                        isHighestPriority = false;
                        break;
                    }
                }

                if (isHighestPriority) {
                    count++;
                    if (currentIndex == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    indexes.add(currentIndex); // 다시 Deque에 추가하여 순서를 유지
                }
            }
        }
    }
}
