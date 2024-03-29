package 인사성밝은곰곰이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        br.readLine();//첫 입력 ENTER 버리기
        Set<String> userNames = new HashSet<>();
        int sum = 0;
        for(int i = 0; i < N-1; i++){
            String userName = br.readLine();
            if(userName.equals("ENTER")){
                sum += userNames.size();
                userNames.clear();
            }else {
                userNames.add(userName);
            }
        }
        sum += userNames.size();
        System.out.println(sum);
    }
}
