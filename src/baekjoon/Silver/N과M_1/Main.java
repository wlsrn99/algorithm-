package N과M_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 주어진 자연수 범위
    static int M; // 수열 길이
    static int[] selectedSequence; // 선택된 수열을 저장
    static boolean[] check; // 숫자가 선택되었는지 여부를 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        selectedSequence = new int[M]; // 수열의 길이만큼 배열 생성
        check = new boolean[N + 1]; // 숫자를 인덱스로 활용하기위해 N+1로 생성

        StringBuilder sb = new StringBuilder();
        findSequence(0, sb); // 순열을 찾는 재귀 함수 호출
        System.out.println(sb);
    }

    static void findSequence(int selectedIdx, StringBuilder sb) {
        if (selectedIdx == M) { // 수열의 길이만큼 수를 선택했을 때
            for (int i = 0; i < M; i++) {
                sb.append(selectedSequence[i]).append(" "); // 선택된 수열 추가
            }
            sb.append("\n");
            return; // 재귀 종료
        }

        for (int i = 1; i <= N; i++) { // 1부터 N까지의 숫자에 대해
            if (!check[i]) { // 아직 선택되지 않은 숫자인 경우
                check[i] = true; // 해당 숫자를 선택했다고 표시
                selectedSequence[selectedIdx] = i; // 선택된 숫자를 수열에 추가
                findSequence(selectedIdx + 1, sb); // 다음 숫자를 선택하기 위해 재귀 호출
                check[i] = false; // 재귀가 종료되면 해당 숫자를 다시 선택 가능하도록 해제
            }

        }
    }
}
