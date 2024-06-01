

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/**
	 * 크로아티아 알파벳
	 * 문자 2개를 하나의 알파벳 -> 하나로 치환, replaceAll
	 *
	 * c=, c-, dz=, d-, lj, nj, s=, z=
	 *
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		String replacedInput = input.replaceAll("(c=|c-|dz=|d-|s=|lj|nj|z=)", "x");

		System.out.println(replacedInput.length());
	}
}
