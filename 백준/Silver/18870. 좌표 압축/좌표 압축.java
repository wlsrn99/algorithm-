
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 제일 작은 값 -> 0
 * 오름차순 정렬시키고 map으로 배열의 벨류를 키로, 순서를 벨류로 가지는 맵 생성
 * 원래의 배열 루프 돌려서 sb에 저장 후 출력
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		//treeSet으로 했다가 메모리를 너무 잡아먹는 것 같아서 배열로 수정
		int[] sortedArr = Arrays.stream(arr).sorted().toArray();

		int coordinate = 0;
		// 수정된 좌표를 가지고있는 Map
		Map<Integer, Integer> map = new HashMap<>();
		for (int value : sortedArr) {
			if (!map.containsKey(value)) { //중복 방지
				map.put(value, coordinate++);
			}
		}

		StringBuilder sb = new StringBuilder();
		//배열의 벨류를 넣었을때 해당하는 좌표 출력
		for (int value : arr) {
			sb.append(map.get(value)).append(" ");
		}
		System.out.println(sb);
	}
}
