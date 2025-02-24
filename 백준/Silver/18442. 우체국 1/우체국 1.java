
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int V, P;
	static long L;
	static long[] villages;
	static long[] posthouses;
	static long min = Long.MAX_VALUE;
	static long[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		V = Integer.parseInt(input[0]); // 마을 개수
		P = Integer.parseInt(input[1]); // 우체국 개수
		L = Long.parseLong(input[2]);   // 큰 길의 둘레

		villages = Arrays.stream(br.readLine().split(" "))
			.mapToLong(Long::parseLong)
			.toArray();

		posthouses = new long[P];
		result = new long[P];

		combination(0, 0);

		System.out.println(min);
		Arrays.sort(result);
		for (long location : result) {
			System.out.print(location + " ");
		}
	}

	static void combination(int start, int depth) {
		if (depth == P) {
			calculate();
			return;
		}

		for (int i = start; i < V; i++) {
			posthouses[depth] = villages[i];
			combination(i + 1, depth + 1);
		}
	}

	static void calculate() {
		long totalDist = 0;
		for (long village : villages) {
			long minDist = Long.MAX_VALUE;
			for (long office : posthouses) {
				long dist = Math.min(Math.abs(village - office), L - Math.abs(village - office));
				minDist = Math.min(minDist, dist);
			}
			totalDist += minDist;
		}

		if (totalDist < min) {
			min = totalDist;
			System.arraycopy(posthouses, 0, result, 0, P);
		}
	}
}
