
/**
 * 알몸만 아니면 되는거니까, 존재 하는 의상 종류는 입는경우 안입는 경우의 수가 추가된다
 * 따라서 경우의 수는 (각 종류의 개수 + 1) * (각 종류의 개수 +1) ``` 이런 식으로 될 것이다
 * 하지만 이 경우는 알몸인 경우도 포함되어있으므로 알몸인 경우 -1을 해주도록하자
 * Map을 사용해서 의상 종류를 키로 놓고 개수를 벨류로 놓으면,
 * 가지고 있는 각 의상 종류들의 개수에 쉽게 접근 할 수 있을거같다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int costumeNum = Integer.parseInt(br.readLine());
			HashMap<String, Integer> costumeType = new HashMap<>();
			for (int j = 0; j < costumeNum; j++) {
				String[] oneCostumeType = br.readLine().split(" ");
				//필요한건 1번째 인덱스에 있는 의상의 종류
				//똑같은 종류가 나오면 개수를 담당하는 벨류를 증가시킨다
				costumeType.put(oneCostumeType[1], costumeType.getOrDefault(oneCostumeType[1], 0) + 1);
			}
			// 맵을 순회해서 각 (벨류 + 1)들을 곱해준다
			int caseNum = 1;
			for (Integer value : costumeType.values()) {
				caseNum *= (value + 1);
			}

			// 알몸인경우 -1을 해준다
			System.out.println(caseNum - 1);
		}
	}
}
