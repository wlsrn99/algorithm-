package ATM;
/*
# 요구 사항 정리
ATM앞에 N명의 사람들이 줄을 서있다 사람은 1번부터 N번까지 번호가 매겨져 있으며
 i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분

 # 내가 생각한 논리
 걸리는 시간이 작은 사람을 우선으로 처음으로 둔다음 더하면 되지않을까
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputPerson = br.readLine().split(" ");
        int[] person = new int[N];

        for(int i = 0; i < N; i++){
            person[i] = Integer.parseInt(inputPerson[i]);
        }

        Arrays.sort(person);
        int sum = 0;
        int resultSum = 0;
        for(int i = 0; i< N; i++){
            sum = sum + person[i];
            resultSum += sum;
        }
        System.out.println(resultSum);
    }
}
