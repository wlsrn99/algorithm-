import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 사진틀의 개수
		int N = Integer.parseInt(br.readLine());
		// 총 추천 횟수
		int goodNum = Integer.parseInt(br.readLine());
		// 추천받은 학생들
		int[] goodStudents = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		// 학생 번호 100까지
		int[] students = new int[101];

		List<Student> candidate = new ArrayList<>();

		for (int i = 0; i < goodNum; i++) {
			int student = goodStudents[i]; // 추천 학생 번호

			if (students[student] > 0) { // 이미 추천받은 경우
				students[student]++; // 추천 횟수 증가
				for (Student s : candidate) {
					if (s.num == student) {
						s.recommendation++; // 추천 횟수 증가
						break;
					}
				}
			} else { // 추천을 처음 받은 경우
				if (candidate.size() >= N) { // 사진틀이 가득 찬 경우
					Collections.sort(candidate, (o1, o2) -> {
						if (o1.recommendation == o2.recommendation) {// 추천 수가 같은 경우
							return o1.idx - o2.idx; // 인덱스 오름순
						} else if (o1.recommendation < o2.recommendation) { // 추천 수가 작은경우
							return -1; // 현재 학생을 앞으로 이동
						} else {
							return 1; // 현재 학생을 뒤로 이동
						}
					});

					int num = candidate.get(0).num;
					students[num] = 0; // 가장 추천 횟수가 적은 학생의 추천 정보 초기화
					candidate.remove(0);
				}
				candidate.add(new Student(student, 1, i)); // 새로운 학생 정보 추가
				students[student] = 1; // 학생의 추천 횟수 기록
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 101; i++) {
			if (students[i] != 0) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

	private static class Student {
		int num;
		int recommendation;
		int idx;

		public Student(int num, int recommendation, int idx) {
			this.num = num;
			this.recommendation = recommendation;
			this.idx = idx;
		}
	}
}
