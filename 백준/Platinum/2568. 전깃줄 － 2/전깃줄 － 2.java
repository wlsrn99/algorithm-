import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
	private static final int SIZE = 500_000;

	private static class Node {
		int a;
		int b;

		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Function<String, Integer> stoi = Integer::parseInt;
		int n = stoi.apply(br.readLine());
		Node[] input = new Node[n];
		int[] lis = new int[n];
		int[] prev = new int[SIZE + 1];
		boolean[] used = new boolean[SIZE + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi.apply(st.nextToken());
			int b = stoi.apply(st.nextToken());
			input[i] = new Node(a, b);
		}
		Arrays.sort(input, (o1, o2) -> {
			return o1.a - o2.a;
		});
		int size = 0;
		for (int i = 0; i < n; i++) {
			int b = input[i].b;
			int index = Arrays.binarySearch(lis, 0, size, b);
			index = -index - 1;
			lis[index] = b;
			if (index > 0) {
				prev[b] = lis[index - 1];
			}
			if (index == size) {
				size++;
			}
		}
		System.out.println(n - size);
		int index = lis[size - 1];
		while (index > 0) {
			//            System.out.println(index);
			used[index] = true;
			index = prev[index];
		}
		for (int i = 0; i < n; i++) {
			if (!used[input[i].b]) {
				System.out.println(input[i].a);
			}
		}
	}
}