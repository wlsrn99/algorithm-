
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  안테나로부터 모든 집까지의 거리의 총 합이 최소가 되도록
 *  안테나는 집이 위치한 곳에만 설치할 수 있고, 논리적으로 동일한 위치에 여러 개의 집이 존재하는 것이 가능
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] houses = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
			.sorted().toArray();

		int idx = (n - 1) / 2;

		System.out.println(houses[idx]);
	}
}
