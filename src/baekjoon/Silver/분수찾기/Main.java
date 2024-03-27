package 분수찾기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // (0,0)                1
        // 오른쪽  // 1 (1,0)       2
        // 왼쪽 아래 대각선 // 1 (0,1)     3
        // 아래쪽  // 1 (0,2)          4
        // 오른쪽 위 대각선 // 2 (1,1), (2,0)      5,6

        // 오른쪽 // 1  (3,0)  7
        // 왼쪽아래 대각선 // 3 (2,1), (1,2), (0,3) 8,9,10
        // 아래쪽 // 1 (0,4) 11
        // 오른쪽 위 대각선 // 4 (1,3), (2,2),(3,1),(4,0) 12,13,14,15


        // 경우의수 싸이클이 + 4씩증가
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        num -= 1; //num이 1일때 처리
        System.out.println(findFraction(num));
    }

    private static String findFraction(int num) {
        if (num == 0) {
            return "1/1";
        } else {
            int right = 1;
            int leftBottom = 1;
            int bottom = 1;
            int rightTop = 2;
            int x = 0;
            int y = 0;

            int cases = 0;
            boolean run = true;
            while (run) {
                switch (cases) { //오른쪽
                    case 0: {
                        x++;
                        num -= right;
                        if(num == 0){
                            run = false;
                        }
                        cases = 1;
                        break;
                    }
                    case 1: {//왼쪽 아래 대각선
                        for(int i = 0; i < leftBottom; i++){
                            x--;
                            y++;
                            num--;
                            if(num == 0){
                                run = false;
                                break;
                            }
                        }
                        leftBottom += 2;
                        cases = 2;
                        break;
                    }
                    case 2: { //아래쪽
                        y++;
                        num -= bottom;
                        if(num == 0){
                            run = false;
                        }
                        cases = 3;
                        break;
                    }
                    case 3: { // 오른쪽 위 대각선
                        for(int i = 0; i < rightTop; i++){
                            x++;
                            y--;
                            num--;
                            if(num == 0){
                                run = false;
                                break;
                            }
                        }
                        rightTop += 2;
                        cases = 0;
                        break;
                    }
                }
            }
          return (y+1) + "/" + (x+1);
        }
}
}
