

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분 -> 피타고라스
 * 직각 삼각형이 맞다면 "right"
 * 아니라면 "wrong"
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String inputs = br.readLine();

			if (inputs.equals("0 0 0")) {
				break;
			}

			int[] num = Arrays.stream(inputs.split(" "))
				.mapToInt(Integer::parseInt)
				.sorted()
				.toArray();

			if (num[0] * num[0] + num[1] * num[1] == num[2] * num[2]) {
				sb.append("right").append("\n");
			} else {
				sb.append("wrong").append("\n");
			}
		}

		System.out.println(sb);
	}
}
