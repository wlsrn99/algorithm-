package 백준2007년;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(weekDay(x,y));
    }

    private static String weekDay(int x, int y){
        int day = 0;
        int result = 0;

        // 1월부터 x-1월까지의 일수를 누적
        for (int i = 1; i < x; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                    day += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    day += 30;
                    break;
                case 2:
                    day += 28;
                    break;
            }
        }

        result = (day + y) % 7;

        switch (result){
            case 0:
                return "SUN";
            case 1:
                return "MON";
            case 2:
                return "TUE";
            case 3:
                return "WED";
            case 4:
                return "THU";
            case 5:
                return "FRI";
            default:
                return "SAT";
        }
    }
}
