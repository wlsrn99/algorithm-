package 리모컨;
/*
    # 요구사항
    버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고,
     -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

     이동하려고 하는 채널은 N
     어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램
     이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)
     # 내가 생각한 논리
     경우의수는
     1. +랑 -버튼만 눌렀을 경우
     -> 현재 채널과 이동하려는 체널을 뺀 값의 절댓값
     2. 채널버튼만 눌렀을 경우
     -> 이동하려는 체널의 자릿수
     3. 채널버튼과 +와 -버튼을 함께 눌렀을 경우
     -> 최대한 이동한 체널의 자릿수 + 이동하려는 채널에서 최대한 비슷하게 이동한 값을 뺀 값
     4. 안눌러도 될 경우
     -> 0
     */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static boolean[] button = new boolean[10];
    static int current = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //채널 관련
        String inputChannel = br.readLine();
        int channel = Integer.parseInt(inputChannel);

        //버튼 관련
        int M = Integer.parseInt(br.readLine());
        if(0 < M ) { //문제에서 M이 0이면 입력을 아예 안한다
            String[] crash = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                button[Integer.parseInt(crash[i])] = true;
            }
        }

        if (channel == current) {//안눌러도 될 경우
            System.out.println(0);
        } else {
            System.out.println(doMixButton(channel));
        }
    }
    // 채널을 구할 수 있는 모든 경우를 완전 탐색
    private static int doMixButton(
            int targetChannel
    ) {
        //최소 누른 횟수
        //초기값은 100에서 + 또는 - 버튼을 누르는 횟수
        int minPress = Math.abs(targetChannel - current);

        // 0부터 1000000까지 모든 채널에 대해 탐색
        for (int i = 0; i <= 1000000; i++) {
            String strChannel = String.valueOf(i);

            // 채널에 사용된 숫자 중에 고장난 버튼이 있는지 확인
            boolean hasBrokenButton = false;
            for (char c : strChannel.toCharArray()) {
                if (button[c - '0']) {
                    hasBrokenButton = true;
                    break;
                }
            }

            // 고장난 버튼이 없는 채널 중에서 목표 채널에 가장 가까운 채널
            if (!hasBrokenButton) {
                int press = Math.abs(targetChannel - i) + strChannel.length(); // 이동한 채널과 목표 채널까지 누른 버튼의 수
                minPress = Math.min(minPress, press);
            }
        }

        return minPress;
    }

}
