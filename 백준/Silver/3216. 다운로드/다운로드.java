
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 7초 기다렸을 때
 *
 * 1) 2초,1초 다운가능
 * 남은시간 1초 / 동영상 시간 3초
 * 저장시간 4초
 *
 * 2) 2초 후 3초 영상 다운가능
 *
 * 남은시간 1초, 동영상 시간 1초 소모 3초영상 다운완료
 * 저장 시간 5초
 *
 * 3) 4초 후 2초 영상 다운 가능
 * 동영상 시간 4초 소모 2초 영상 다운 완료
 * 저장 시간 3초
 */
public class Main {
	static private class Piece {
		int length;
		int time;

		public Piece(int length, int time) {
			this.length = length;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[2];
		Queue<Piece> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			queue.add(new Piece(input[0], input[1]));
		}

		int startTime = queue.peek().time;
		int storage = startTime;
		int time = 0;
		while (!queue.isEmpty()) {
			if (storage >= queue.peek().time) {
				Piece current = queue.poll();
				storage -= current.time;
				storage += current.length;
			} else {
				storage++;
				time++;
			}
		}

		System.out.println(startTime + time);
	}
}
