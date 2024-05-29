import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] digitCount = new int[10]; // 각 숫자(0~9)의 등장 횟수를 저장할 배열
		int currentDigit = 1; // 현재 자릿수 (1의 자리, 10의 자리, ...)
		int start = 1; // 시작 숫자

		while (start <= n) {
			// n의 끝자리를 9로 만들기
			while (n % 10 != 9 && start <= n) {
				countDigits(n, digitCount, currentDigit); // 감소시킨 n에서도 자릿수 개수 증가
				n--; // n을 감소시키며 끝자리를 9로 만듦
			}

			if (n < start) {
				break;
			}

			// start의 끝자리를 0으로 만들기
			while (start % 10 != 0 && start <= n) {
				countDigits(start, digitCount, currentDigit); // start에서도 자릿수 개수 증가
				start++; // start를 증가시키며 끝자리를 0으로 만듦
			}
			
			start = 1;
			n /= 10; //다음 자릿수로 이동

			for (int i = 0; i < 10; i++) { // 반복되는 자릿수 개수를 더해줌
				digitCount[i] += n * currentDigit;
			}
			currentDigit *= 10; // 다음 자릿수로 넘어가기 위해 10을 곱함
		}

		for (int i = 0; i < 10; i++) { // 출력
			System.out.print(digitCount[i] + " ");
		}
	}

	// 파라미터로 받은 x를 10으로 나누며 자리수를 나눠 digitCount 배열에 더함
	public static void countDigits(int x, int[] digitCount, int currentDigit) {
		while (x > 0) {
			digitCount[x % 10] += currentDigit; // 현재 자릿수에 해당하는 숫자의 개수 증가
			x /= 10; // 다음 자릿수로 이동
		}
	}
}