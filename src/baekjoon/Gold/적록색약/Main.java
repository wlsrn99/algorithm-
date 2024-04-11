package 적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
# 요구사항
적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데,
구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다

# 내가 생각한 논리
인접한 영역의 정의가 상하좌우 이므로
첫 시작 노드를 임의로 잡고 그 시작 노드의 상하좌우를 DFS또는 BFS로 체크해주고
첫 시작 노드와 상하좌우 노드중 하나가 같을 경우 시작 노드를 그 노드로 바꿔주고 그걸 기준으로 위랑 같은 방식으로 해줘서-> 재귀
영역을 중복없이 체크한 뒤
그 개수를 세면 될 것 같다
 */
public class Main {
    static int N; // 그림의 길이
    static char[][] picture; // 그림 배열
    static boolean[][] visited; // 탐색 여부 체크
    static int[] dx = {1, 0, 0, -1}; //상하좌우
    static int[] dy = {0, 1, -1, 0};//상하좌우
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        visited = new boolean[N][N];

        // 그림에 색상 정보 담기
        for(int i = 0; i <N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                picture[i][j] = input[j];
            }
        }

        //정상인 사람이 볼 때
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }
        // 정상인 사람이 보는 색 영역의 갯수
        int normal = count;
        // 적록색약인 사람의 경우를 체크하기위해 초기화
        count = 0;
        visited = new boolean[N][N];

        // 초록색을 다른 색으로 변경
        for(int i =0; i < N; i++){
            for(int j = 0; j<N; j++){
                if(picture[i][j] == 'G'){
                    picture[i][j] = 'R';
                }
            }
        }

        // 적록색약인 사람이 볼 때
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        // 적록색약인 사람이 보는 색 영역의 갯수
        int disabledPerson = count;

        System.out.println(normal + " " + disabledPerson);
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        char R = picture[i][j]; // 첫 시작 노드
        for(int k = 0; k < 4; k++){
            int newX = i + dx[k];
            int newY = j + dy[k];
            // 새로운 x,y인덱스가 존재하는 인덱스이고,
            // 인접한 상하좌우 노드가 방문한 적이 없고,
            // 첫 시작 노드와 값이 같을 경우
            if(checkCurrentLocation(newX, newY) && picture[newX][newY] == picture[i][j]){
                //bfs에 넣어서 방문 체크 해줘서
                //같은 영역으로 처리
                dfs(newX, newY);
            }
        }
    }

    private static boolean checkCurrentLocation(int x, int y){
        //x, y의 값이 -가 될 때
        //x, y의 값이 N보다 커질 때
        //이미 방문한 노드일 때
        if(x < 0 || x >= N || y < 0 || y >= N){
            return false;
        }
        if(visited[x][y]){
            return false;
        }
        return true;
    }
}
