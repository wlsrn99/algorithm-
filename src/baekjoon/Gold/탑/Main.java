package 탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 진행방향은 왼쪽에서 오른쪽
        // 왼쪽방향으로만 신호를 보냄
        // 왼쪽에 있는 탑의 높이가 오른쪽에 있는 탑의 높이보다 커야 수신가능

        // 마지막에 들어간 것을 꺼내서 앞에 있는 것과 비교 -> 후입선출이므로 stack사용하면 되지않을까

        // 위 논리는 시간복잡도가 너무 많이 나온다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //stack에 인덱스를 저장 후 비교가 완료되면 빼는 방식이 좋을 거 같다
        String[] inputHeights = br.readLine().split(" ");
        // 높이를 저장하는 배열
        int[] topHeights = new int[N];
        //인덱스를 저장하는 reception
        Stack<Integer> topIdx = new Stack<>();
        for(int i = 0; i < N; i++){
            topHeights[i] = Integer.parseInt(inputHeights[i]);
            topIdx.push(i);
        }
        StringBuilder sb = new StringBuilder();

        // 왼쪽부터 오른쪽으로 읽는 방법이 있었다
        // 왼쪽부터 높이가 길다면 인덱스 저장해놓는 스택 생성
        Stack<Integer> reception = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!reception.isEmpty() && topHeights[reception.peek()] <= topHeights[i]) {
                reception.pop();
            }

            if (reception.isEmpty()) {
                sb.append("0").append(" ");
            } else {
                sb.append((reception.peek() + 1)).append(" ");
            }
            // 현재 인덱스 저장
            // 왼쪽에 있는 탑의 높이가 오른쪽의 높이보다 작을경우에 빼도 되는 이유는
            // 어차피 가까운인덱스 순이기때문에 오른쪽에 있는 값을 저장하면  논리가 가능하다
            reception.push(i);

        }
        System.out.println(sb);

    }

}
