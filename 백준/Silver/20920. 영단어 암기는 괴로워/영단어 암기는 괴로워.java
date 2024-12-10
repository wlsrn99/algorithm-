
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 자주 나오는 단어일수록 앞에 배치한다.
 * 해당 단어의 길이가 길수록 앞에 배치한다.
 * 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		int m = input[1];

		Map<String, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			if (word.length() >= m) {
				hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
			}
		}

		Queue<Order> pq = new PriorityQueue<>(((o1, o2) -> {
			if (o1.num != o2.num) { // 자주 나오는 단어일수록
				return o2.num - o1.num;
			} else if (o1.len != o2.len) { //해당 단어의 길이가 길수록
				return o2.len - o1.len;
			} else {
				return o1.word.compareTo(o2.word); // 알파벳 사전 순으로 앞에 있는 단어일수록
			}
		}));

		for (String s : hashMap.keySet()) {
			pq.add(new Order(hashMap.get(s), s.length(), s));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll().word).append("\n");
		}

		System.out.println(sb);
	}

	// 자주 나오는 단어일수록 앞에 배치한다.
	// 해당 단어의 길이가 길수록 앞에 배치한다.
	// 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
	static private class Order {
		int num;
		int len;
		String word;

		public Order(int num, int len, String word) {
			this.num = num;
			this.len = len;
			this.word = word;
		}
	}
}
