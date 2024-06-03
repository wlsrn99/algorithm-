

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, R; // N: 배열의 행 개수, M: 배열의 열 개수, R: 회전 수
    static String[][] arr; // 입력받은 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        arr = new String[N][M];
        for (int i = 0; i < N; i++) {
            String inputArr = br.readLine();
            String[] inputRow = inputArr.split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = inputRow[j]; // 입력받은 값을 배열에 저장
            }
        }

        for (int r = 0; r < R; r++) {
            rotateArray(); // R번 회전 수행
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" "); // 회전 후 배열 값을 StringBuilder에 저장
            }
            sb.append("\n"); // 한 행이 끝나면 개행 문자 추가
        }
        System.out.println(sb); // 최종 결과 출력
    }

    private static void rotateArray() {
        int minLength = Math.min(N, M) / 2; // 회전 횟수를 결정하는 값 (행과 열 중 작은 값의 절반)
        for (int i = 0; i < minLength; i++) { // 회전 횟수만큼 반복
            int startRow = i, endRow = N - 1 - i; // 회전할 영역의 시작 행과 끝 행
            int startCol = i, endCol = M - 1 - i; // 회전할 영역의 시작 열과 끝 열

            String temp = arr[startRow][startCol]; // 회전할 영역의 첫 번째 값을 임시 변수에 저장

            // 왼쪽에서 오른쪽으로 회전
            for (int j = startCol; j < endCol; j++) {
                arr[startRow][j] = arr[startRow][j + 1];
            }

            // 위에서 아래로 회전
            for (int j = startRow; j < endRow; j++) {
                arr[j][endCol] = arr[j + 1][endCol];
            }

            // 오른쪽에서 왼쪽으로 회전
            for (int j = endCol; j > startCol; j--) {
                arr[endRow][j] = arr[endRow][j - 1];
            }

            // 아래에서 위로 회전
            for (int j = endRow; j > startRow; j--) {
                arr[j][startCol] = arr[j - 1][startCol];
            }

            // 임시 변수에 저장된 값을 회전 후 빈 자리에 넣기
            arr[startRow + 1][startCol] = temp;
        }
    }
}