

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double[] score = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		double max = Arrays.stream(score).max().getAsDouble();

		double avg = Arrays.stream(score)
			.map(o -> o / max * 100)
			.average()
			.getAsDouble();

		System.out.println(avg);
	}

}
