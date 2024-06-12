

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 폭탄이 있는 칸은 3초가 지난 후에 폭발
 * 폭발한 이후에는 폭탄이 있던 칸이 파괴되어 빈 칸, 인접한 네 칸도 함께 파괴
 * 탄이 폭발했을 때, 인접한 칸에 폭탄이 있는 경우에는 인접한 폭탄은 폭발 없이 파괴된다. 따라서, 연쇄 반응은 없다
 *
 * 1. 가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
 * 2. 다음 1초 동안 봄버맨은 아무것도 하지 않는다.
 * 3. 다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 즉, 모든 칸은 폭탄을 가지고 있게 된다. 폭탄은 모두 동시에 설치했다고 가정한다.
 * 4. 1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
 * 5. 3과 4를 반복한다.
 *
 * boolean 2차원배열
 * 폭탄이 있는 칸 true, 없는 칸 false
 *
 * 폭탄이 터지면  (i+1, j), (i-1, j), (i, j+1), (i, j-1) false
 */
public class Main {
	static boolean[][] arr;
	static int[][] time;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int r = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);
		int n = Integer.parseInt(input[2]);

		arr = new boolean[r][c];
		time = new int[r][c];

		for (int i = 0; i < r; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < c; j++) {
				if (input[j].equals("O")) {
					//1번
					arr[i][j] = true;
					//2번 1초동안 아무것도 하지 않는다
					time[i][j]++;
				}
			}
		}
		//1초 감소
		n--;

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1) {
				calculate3(r, c);
			} else {
				claculate4(r, c);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j]) {
					sb.append("O");
				} else {
					sb.append(".");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void calculate3(int r, int c) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!arr[i][j]) {
					//3번 폭탄 없는 칸에 폭탄 설치
					arr[i][j] = true;
				} else {
					//3번에서 1초를 사용, 시간 증가
					time[i][j]++;
				}
			}
		}
	}

	private static void claculate4(int r, int c) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				time[i][j]++;
			}
		}
		//4번 1초가 지난 후 폭발 시키기
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (time[i][j] == 3) {
					time[i][j] = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
							if (time[nx][ny] != 3) { //여기 조건 체크를 잘 못했어요
								time[nx][ny] = 0;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (time[i][j] == 0) {
					arr[i][j] = false;
				}
			}
		}

	}
}
