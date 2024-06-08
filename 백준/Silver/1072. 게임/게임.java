

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
# 요구사항 정리
게임 횟수 : X
이긴 게임 : Y (Z%)
Z는 형택이의 승률이고, 소수점은 버린다.

# 내가 생각한 논리
승률 (z) = y / x * 100
게임을 최소 몇판 해야 z가 변하는가?
판수(num) -> (y + num) / (x+num) * 100 의 값이 소수점을 버렸을때 첫번째로 큰 경우
-> 즉 승률이 z+1일 경우
z + 1 = (y + num) / (x+num) * 100
-> (x+num) * (z+1) = (y + num) * 100
->num * (z+1-100) + (x*z+x) = 100 * y
->num * (z + 1 -100) = 100 * y - (x*z+x)
->num = {100*y - ( x * z + x)} / (z-99)
-> 절대 변하지 않을 경우 -> z가 100 , 99일 경우
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        double x = Double.parseDouble(input[0]);
        double y = Double.parseDouble(input[1]);

        int z = (int)(y * 100 / x);

        int num = -1;
        if(z < 99){
            // 소수점이 나오면 실제 횟수가 될수 없으므로 1올림 해줘야 한다
            num = (int) Math.ceil((100 * y - x * (z + 1)) / (double) (z - 99));
        }

        System.out.println(num);
    }
}
