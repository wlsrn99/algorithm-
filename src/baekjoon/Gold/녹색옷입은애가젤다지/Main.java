package 녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
#요구사항
링크는 지금 도둑루피만 가득한 N x N 크기의 동굴의 제일 왼쪽 위에 있다
[0][0]번 칸
제일 오른쪽 아래 칸인 [N-1][N-1]까지 이동해야 한다
링크는 잃는 금액을 최소로 하여 동굴 건너편까지 이동해야 하며, 한 번에 상하좌우 인접한 곳으로 1칸씩 이동
# 내가 생각한 논리
다익스트라로 [0][0]에서 [N-1][N-1]까지 이동
 */
public class Main {
    static boolean[] visited;
    static int[][] dist;
    static ArrayList<ArrayList<CaveInfo>> nodeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


    }
    private class CaveInfo{
        int destination;
        int rupee;
        CaveInfo(int destination, int rupee){
            this.destination = destination;
            this.rupee = rupee;
        }
    }
}
