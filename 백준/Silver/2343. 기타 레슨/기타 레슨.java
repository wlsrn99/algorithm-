
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		int m = input[1];

		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int start = Arrays.stream(arr).max().getAsInt(); // 최소 크기
		int end = Arrays.stream(arr).sum(); // 최대 크기

		int result = upperbound(start, end, m);
		System.out.println(result);
	}

	static int upperbound(int start, int end, int target) {
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			if (countBluRay(mid) <= target) { //블루레이의 크기가 구하려는 값보다 작거나 같을때
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

	static int countBluRay(int size) {
		int count = 1;
		int sum = 0;
		for (int lesson : arr) {
			if (sum + lesson > size) {
				count++;
				sum = lesson;
			} else {
				sum += lesson;
			}
		}
		return count;
	}
}
