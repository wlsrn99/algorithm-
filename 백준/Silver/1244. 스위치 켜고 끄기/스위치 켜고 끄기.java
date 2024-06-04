import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        // 남학생 -  배수의 상태 !()
        // 여학생 - 좌우가 대칭(상태가 같음)이면서 가장 많은 스위치를 포함하는 구간 !() 이 구간은 항상 홀수
        // 한줄에 20개씩 출력
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int switchNum = Integer.parseInt(br.readLine()); // 스위치 개수
            int[] switches = new int[switchNum];
            String[] switchStatus = br.readLine().split(" "); // 스위치 상태 
            for (int i = 0; i < switchNum; i++)
                switches[i] = Integer.parseInt(switchStatus[i]);

            int studentNum = Integer.parseInt(br.readLine()); 
            for (int i = 0; i < studentNum; i++) {
                String[] studentInfo = br.readLine().split(" ");
                int gender = Integer.parseInt(studentInfo[0]);
                int number = Integer.parseInt(studentInfo[1]);

                // 남학생
                if (gender == 1) {
                    for (int j = 0; j < switchNum; j++) 
                        if ((j + 1) % number == 0)
                            switches[j] = switches[j] == 0 ? 1 : 0;
                }
                // 여학생
                else {
                    switches[number - 1] = switches[number - 1] == 0 ? 1 : 0;
                    for (int j = 1; j < switchNum / 2; j++) {
                        if (number - 1 + j >= switchNum || number - 1 - j < 0)
                            break;
                        if (switches[number - 1 - j] == switches[number - 1 + j]) {
                            switches[number - 1 - j] = switches[number - 1 - j] == 0 ? 1 : 0;
                            switches[number - 1 + j] = switches[number - 1 + j] == 0 ? 1 : 0;
                        } else
                            break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < switchNum; i++) {
                sb.append(switches[i]).append(" ");
                if ((i + 1) % 20 == 0)
                    sb.append("\n");
            }
            System.out.println(sb);
        }
}

