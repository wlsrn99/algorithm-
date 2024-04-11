package 마법사상어와비바라기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
# 요구사항
비바라기를 크기가 N×N인 격자에서 연습하려고 한다.
격자의 각 칸에는 바구니가 하나 있고, 바구니는 칸 전체를 차지한다. 바구니에 저장할 수 있는 물의 양에는 제한이 없다
(r, c)는 격자의 r행 c열에 있는 바구니를 의미하고, A[r][c]는 (r, c)에 있는 바구니에 저장되어 있는 물의 양을 의미한다.
격자의 가장 왼쪽 윗 칸은 (1, 1)
가장 오른쪽 아랫 칸은 (N, N)
N번 행의 아래에는 1번 행이, 1번 행의 위에는 N번 행이 있고, 1번 열의 왼쪽에는 N번 열이, N번 열의 오른쪽에는 1번 열이 있다

비바라기를 시전하면 (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다
이제 구름에 이동을 M번 명령하려고 한다. i번째 이동 명령은 방향 di과 거리 si로 이루어져 있다.
방향은 총 8개의 방향이 있으며, 8개의 정수로 표현한다. 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙ 이다. 이동을 명령하면 다음이 순서대로 진행된다.

1.모든 구름이 di 방향으로 si칸 이동한다.
2.각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
3.구름이 모두 사라진다.
4.2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
    이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
    예를 들어, (N, 2)에서 인접한 대각선 칸은 (N-1, 1), (N-1, 3)이고, (N, N)에서 인접한 대각선 칸은 (N-1, N-1)뿐이다.
5.바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.

M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합

//구름이 이동해야함 -> 인덱스가 넘어가도 괜찮다라는 로직 따로 처리해줘야함
//이동하면 구름에서 비가 내려서 구름이 있는 칸의 벨류가 1증가함
//구름이 모두 사라진다 -> 구름이 있던 자리들 visited ture처리 해야함
//구름이 있던 자리들에 물복사 버그 마법을 시전 -> 인덱스가 넘어가면 안되는 로직 따로 처리해줘야함
//viseted가 false인 칸들중에 물의 양이 2이상인 모든 칸에 구름이 생긴다 그리고 벨류는 -2가된다
 */
public class Main {
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j =0; j < N; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }


    }
}
