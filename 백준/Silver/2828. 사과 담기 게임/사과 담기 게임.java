

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *   2   2
 * 1   3   5
 *   q
 * 1 2 3 4 5
 *
 * 1 + 1 + 2 + 2
 *
 * 1 + 1 + 1 + 1
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = input[0];
		int m = input[1];

		// 사과 개수
		int num = Integer.parseInt(br.readLine());

		int start = 1;
		int end = m;

		int distance = 0;
		for (int i = 0; i < num; i++) {
			int apple = Integer.parseInt(br.readLine());
			if (start > apple) {
				distance += start - apple;
				end -= start - apple;
				start = apple;
			}else if(end < apple){
				distance += apple - end;
				start += apple - end;
				end = apple;
			}
		}

		System.out.println(distance);
	}
}
