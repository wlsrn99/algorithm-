import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        // 풍선이 원형으로 놓여져있음 0번풍선 왼쪽이 N번풍선, N번풍선 오른쪽이 0번풍선
        // 종이에 적혀있는 인덱스에 따라 양쪽을 처리해줘야 할듯 -> Deque
        // 제일 먼저 터지는 풍선의 인덱스는 0

        // 이미 터진풍선은 빼고 이동 -> 터진 풍선은 delete시켜줘야함

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //풍선의 갯수
        String[] inputPaper = br.readLine().split(" ");
        // 풍선에 적힌 종이를 저장하는 배열
        int[] paper = new int[N];
        // 풍선의 인덱스를 저장하는 Deque
        Deque<Integer> balloonIdx = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            paper[i] = Integer.parseInt(inputPaper[i]);
            balloonIdx.offerLast(i);
        }

        //+3 오른쪽인경우
        // 1 2 3 4

        // 2 3 4 1
        // 3 4 1 2

        //-3 왼쪽인 경우
        // 4 1 2

        // 2 4 1
        // 1 2 4
        // 4 1 2

        //원이라는거에 집중하면
        //오른쪽으로 이동하는 경우 -> 현재 적힌 숫자 만큼 맨 앞부터 하나씩 맨 뒤로 보내면 첫번째 숫자가 해당하는 숫자
        //왼쪽으로 이동하는 경우 -> 현재 적힌 숫자 -1 만큼 맨 뒤부터 맨앞으로 보내면 첫 번째 숫자가 해당하는 숫자
        StringBuilder sb = new StringBuilder();
       while (!balloonIdx.isEmpty()){
          int currentIdx = balloonIdx.pollFirst(); //풍선의 현재 인덱스
          int currentPaper = paper[currentIdx]; //현재 종이에 적힌 숫자

           sb.append(currentIdx + 1).append(" ");

           if(!balloonIdx.isEmpty()) {
               if (currentPaper > 0) { //오른쪽 이동
                   for (int i = 0; i < currentPaper-1; i++) {
                       balloonIdx.offerLast(balloonIdx.pollFirst());
                   }
               } else { //왼쪽이동
                   int currentPaperSize = Math.abs(currentPaper);
                   for (int i = 0; i < currentPaperSize; i++) {
                       balloonIdx.offerFirst(balloonIdx.pollLast());
                   }
               }
           }
       }
        System.out.println(sb);
    }
}
