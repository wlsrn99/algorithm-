

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 0.5 초 (추가 시간 없음)
 * 시간제한이 빡세다 -> 배열 구성 x
 * 방향: 왼쪽 아래 방향 대각선, 오른쪽 위 방향 대각선
 * 각 대각선당 행의 개수 1 -> 2 -> 3 -> 4 -> 5
 * 홀수 = 오른쪽 , 짝수 = 왼쪽
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		int count = 1;

		while (num - count > 0) {
			num -= count;
			count++;
		}

		int molecule = 0;
		int denominator = 0;
		num--;

		if (count % 2 == 0) {
			molecule = 1 + num;
			denominator = count - num;

		} else {
			molecule = count - num;
			denominator = 1 + num;
		}

		System.out.println(molecule + "/" + denominator);
	}
}
