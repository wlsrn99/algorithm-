

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다
 * 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지
 * 1
 * 234567 6개 거리 1
 * 8 ~ 19 12개 거리 2
 * 19 ~ 37 18개 거리 3
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		// 처음 시작지점 1 카운트
		input -= 1;
		// 같은 깊이에 있는숫자는 모두 거리가 같음
		int dapth = 1;
		
		int count = 1;
		while (input > 0) { // 0보다 클 경우에만 깊이 증가가 가능
			input -= dapth * 6;
			
			//깊이 증가 
			dapth++;
			// 거리 증가
			count++;
		}
		System.out.println(count);
	}
}
