package N과M_2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;

    static int[] selectedSequence;

    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        selectedSequence = new int[M];
        check = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        findSequence(0, sb);
        System.out.println(sb);

    }
    static void findSequence(int selectedIdx, StringBuilder sb){
        if(selectedIdx == M){
            for(int i = 0; i < M; i++){
                sb.append(selectedSequence[i])
                        .append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!check[i]){
                check[i] = true;
                selectedSequence[selectedIdx] = i;
                findSequence(selectedIdx + 1, sb);
                for(int j = i + 1; j <= N; j++){// 왼쪽에 있는 수가 오른쪽에 있는 수 보다 작은 조건
                    check[j] = false; // 재귀가 종료되면 해당 숫자를 다시 선택 가능하도록 해제
                }
            }
        }


    }
}
