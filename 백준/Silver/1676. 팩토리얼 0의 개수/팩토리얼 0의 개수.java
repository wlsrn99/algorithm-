

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1 2 3 4 5 6 7 8 9
 * 5 * 연산을 해야 0이 나온다
 * 3!은 3*2*1 0
 * 5!은 5*4*3*2*1 120 1 -> 2^3*3*4*5
 * 6!은 720 1 2^4* ~
 * 7!은 49140 1
 * ~
 * 10! 은 10 * ~
 * 2 * 5 하나당 0이 생긴다
 * 근데 2의 개수가 5보다 더 많음
 * -> 5의 개수
 *
 * 틀림
 * 5의 거듭제곱도 생각해야한다
 * 범위가 500까지므로 25, 125 포함
 *
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int count = 0;

		int num = 5;
		while (true) {
			if (n / num > 0) {
				count += n / num;
				num *= 5;
			} else {
				break;
			}
		}

		System.out.println(count);
	}

}
