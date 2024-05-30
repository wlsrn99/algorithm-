

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	/**
	 *
	 * 파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘 -> 확장자를 키, 갯수를 벨류로 가지는 맵
	 * 보기 편하게 확장자들을 사전 순으로 정렬해 줘 -> Tree map
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Map<String, Integer> extension = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			String[] file = br.readLine().split("\\."); // 이스케이프 문자 사용
            
            // 같은확장자가 들어오면 value 1씩 증가
			extension.put(file[1], extension.getOrDefault(file[1], 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		for (String key : extension.keySet()) {
			sb.append(key).append(" ").append(extension.get(key)).append("\n");
		}
		System.out.print(sb);
	}
}
