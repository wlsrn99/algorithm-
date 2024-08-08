

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 회원들을 나이가 증가하는 순
 * 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Member> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.age == o2.age) {
				return o1.sequence - o2.sequence;
			} else {
				return o1.age - o2.age;
			}
		});
		for (int i = 1; i <= n; i++) {
			String[] input = br.readLine().split(" ");

			pq.add(new Member(Integer.parseInt(input[0]), input[1], i));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Member member = pq.poll();
			sb.append(member.age).append(" ").append(member.name).append("\n");
		}
		System.out.println(sb);
	}

	private static class Member {
		int age;
		String name;
		int sequence;

		public Member(int age, String name, int sequence) {
			this.age = age;
			this.name = name;
			this.sequence = sequence;
		}
	}
}
