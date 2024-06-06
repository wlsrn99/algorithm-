import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            String[] rowInput = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(rowInput[j]);
                if (maxHeap.size() < N || num > maxHeap.peek()) {
                    maxHeap.offer(num);
                    if (maxHeap.size() > N) {
                        maxHeap.poll(); // N개를 유지하기 위해 큐에서 작은 수 제거
                    }
                }
            }
        }

        System.out.println(maxHeap.poll());
    }
}
