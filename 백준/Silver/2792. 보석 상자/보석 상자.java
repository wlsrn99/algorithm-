
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 장 선생님은 모든 보석을 N명의 학생들에게 나누어 주려고 한다.
 * 이때, 보석을 받지 못하는 학생이 있어도 된다.
 * 하지만, 학생은 항상 같은 색상의 보석만 가져간다
 *
 * 한 아이가 너무 많은 보석을 가져가게 되면, 다른 아이들이 질투를 한다
 * 질투심은 가장 많은 보석을 가져간 학생이 가지고 있는 보석의 개수
 * 질투심이 최소가 되게 보석을 나누어 주려고 한다
 * -------------------------------------------
 * 우선순위 큐 사용해서
 * 내림차순으로 놓은 뒤
 * 빼고 2로 나눈다
 * 홀수인 경우 2로 나눈 값과 +1을 한 값을 다시 넣어주고
 * 짝수인 경우 2로 나눈 값을 두 번 넣어준다
 *
 * 우선순위 큐의 길이가 아이들의 수와 같아지면 종료 -> 1,000,000,000 10억개 최악인경우 5억번 반복한다고치면.. 1초가 넘을거같은데
 *
 * --------------------------------------------
 * 알고리즘 분류 보니 또분탐색이네
 *
 * 이분탐색 관점으로 보면
 * 질투심을 기준으로 해야할듯
 * 질투심의 최댓값은 입력값중 최댓값이고 최솟값은 1
 *
 * 보석의 개수를 설정한 질투심보다 작거나 같을 때 까지 빼주는 것을 카운트
 * 두 가지 경우가 나오게 되는데
 * 1) 카운트 개수가 학생 수보다 많을경우
 * 설정한 질투심이 작다는 의미 이므로 최솟값을 증가시키기 -> start = mid + 1
 * 2) 카운트 개수가 학생 수보다 작거나 같을 경우
 * 조건을 만족한다는 의미 -> 최대한 같을 경우로 생각해야 한다 -> end = mid
 */
public class Main {
	static int[] colors;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		n = input[0]; // 아이들의 수
		m = input[1]; // 색상의 수

		colors = new int[m];
		for (int i = 0; i < m; i++) {
			colors[i] = Integer.parseInt(br.readLine());
		}

		int start = 1;
		int end = Arrays.stream(colors).max().getAsInt();

		System.out.println(upperbound(start, end));
	}

	//상한
	static int upperbound(int start, int end) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (isDistributable(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

	/**
	 * @param jealousy : 임의로 설정한 질투심
	 * @return
	 */
	private static boolean isDistributable(int jealousy) {
		int count = 0;

		for (int i = 0; i < m; i++) {
			int current = colors[i];
			while (current > jealousy) { //현재 값이 질투심보다 크면 질투심만큼 빼줘야 함
				current -= jealousy;
				count++;
			}
			//마지막으로 남은 보석을 가지게 되는 학생 카운트
			count++;
		}

		return count <= n; //최종 count가 작거나 같으면 조건 충족
	}
}
