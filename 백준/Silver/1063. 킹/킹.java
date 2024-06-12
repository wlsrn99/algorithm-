

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 8 * 8 2차원 배열을 만들어서 킹의위치, 돌의 위치 저장
 * 각 명령어 -> switch case
 * dx, dy 배열
 * -----------------
 * 너무 지저분해져서 char활용
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		String king = input[0];
		String stone = input[1];
		int n = Integer.parseInt(input[2]);

		int[] kingIdx = {king.charAt(0) - 'A', king.charAt(1) - '1'};
		int[] stoneIdx = {stone.charAt(0) - 'A', stone.charAt(1) - '1'};

		for (int i = 0; i < n; i++) {
			String command = br.readLine();

			int[] newKing = move(kingIdx, command);
			if (isExistence(newKing)) {
				continue; // 킹이 체스판 밖으로 나가면 무시
			}

			if (newKing[0] == stoneIdx[0] && newKing[1] == stoneIdx[1]) {
				int[] newStone = move(stoneIdx, command);
				if (isExistence(newStone)) {
					continue; // 돌이 체스판 밖으로 나가면 무시
				}
				stoneIdx = newStone; // 돌 이동
			}
			//돌이 있을 경우 돌이 이동 가능해야 킹도 이동 가능
			kingIdx = newKing;
		}

		System.out.println((char)(kingIdx[0] + 'A') + "" + (char)(kingIdx[1] + '1'));
		System.out.println((char)(stoneIdx[0] + 'A') + "" + (char)(stoneIdx[1] + '1'));
	}

	private static boolean isExistence(int[] position) {
		return position[0] < 0 || position[0] > 7 || position[1] < 0 || position[1] > 7;
	}

	public static int[] move(int[] position, String command) {
		//체스판이 나갈 경우도 있으므로 clone
		int[] newPosition = position.clone();
		switch (command) {
			case "R": //한 칸 오른쪽
				newPosition[0]++;
				break;
			case "L": // 한 칸 왼쪽
				newPosition[0]--;
				break;
			case "B": // 한 칸 아래
				newPosition[1]--;
				break;
			case "T": // 한 칸 위
				newPosition[1]++;
				break;
			case "RT": //오른쪽 위 대각선
				newPosition[0]++;
				newPosition[1]++;
				break;
			case "LT": // 왼쪽 위 대각선
				newPosition[0]--;
				newPosition[1]++;
				break;
			case "RB": // 오른쪽 아래 대각선
				newPosition[0]++;
				newPosition[1]--;
				break;
			case "LB": //왼쪽 아래 대각선
				newPosition[0]--;
				newPosition[1]--;
				break;
		}
		return newPosition;
	}
}
