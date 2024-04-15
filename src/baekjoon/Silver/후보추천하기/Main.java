package 후보추천하기;
/*
# 요구사항
학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고,
-> 그 자리에 새롭게 추천받은 학생의 사진을 게시한다.
이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는
-> 그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀐다.

후보의 수 즉, 사진틀의 개수와 전체 학생의 추천 결과가 추천받은 순서대로 주어졌을 때, 최종 후보가 누구인지 결정

첫째 줄에는 사진틀의 개수 N이 주어진다. (1 ≤ N ≤ 20)
둘째 줄에는 전체 학생의 총 추천 횟수
셋째 줄에는 추천받은 학생을 나타내는 번호가 빈 칸을 사이에 두고 추천받은 순서대로 주어진다

총 추천 횟수는 1,000번 이하이며 학생을 나타내는 번호는 1부터 100까지의 자연수
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
        // 학생 번호 100까지 - 추천 횟수를 저장할 배열
        int[] students = new int[101];

        List<Student> candidate = new ArrayList<>();

        for (int i = 0; i < goodNum; i++) {
            int student = goodStudents[i]; // 추천 학생 번호

            if (students[student] > 0) { // 이미 추천받은 경우
                students[student]++;
                for (Student s : candidate) {
                    if (s.num == student) {
                        s.recommendation++;
                        break;
                    }
                }
            } else { // 추천을 처음 받은 경우
                if (candidate.size() >= N) { // 사진틀이 가득 찬 경우
                    Collections.sort(candidate, (o1, o2) -> {
                        if (o1.recommendation == o2.recommendation) {// 추천 수가 같은 경우
                            return o1.time - o2.time; // 인덱스 오름차순
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
                students[student] = 1;
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

    private static class Student{
        int num; // 학생 번호
        int recommendation; // 추천 수
        int time; // 인덱스

        public Student(int num, int recommendation, int time) {
            this.num = num;
            this.recommendation = recommendation;
            this.time = time;
        }
    }
}
