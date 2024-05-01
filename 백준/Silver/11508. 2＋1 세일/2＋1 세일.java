

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] cost = new Integer[n];

		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(cost, (o1, o2) -> o2 - o1);
		
		int result = 0;
		for(int i = 0; i < n; i++){
			if(i % 3 == 2){
				continue;
			}
			result += cost[i];
		}

		System.out.println(result);
	}
}
